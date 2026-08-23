package ex0821.service;

import ex0821.dto.Profile;
import ex0821.exception.DuplicatedProfileException;
import ex0821.exception.PasswordException;
import ex0821.exception.SearchNotFoundException;
import ex0821.view.FailView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Popup;

public class ProfileServiceImpl implements ProfileService {

    private static ProfileService instance = new ProfileServiceImpl();


    public static ProfileService getInstance() {
        return instance;
    }

    @Override
    public void inputProfile(Profile profile) throws DuplicatedProfileException {
        File file = new File(profile.getName() + ".txt");

        // 해당하는 이름의 파일이 존재하지 않으면 파일 생성
        if (!file.exists()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(profile.getName() + ".txt"))) {
                Profile p = new Profile(profile.getName(), profile.getWeight(),
                                        profile.getPassword());
                oos.writeObject(p);
            } catch (Exception e) {
                e.getMessage();
            }
        } else {
            throw new DuplicatedProfileException(profile.getName() + "은 이미 존재하는 프로필입니다.");
        }
    }

    /**
     * 프로필 검색
     *
     * @param name
     * @param password
     * @throws PasswordException
     */
    @Override
    public Profile searchProfile(String name, String password)
        throws PasswordException, SearchNotFoundException {
        File file = new File(name + ".txt");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(name + ".txt"))) {
                Profile p = (Profile) ois.readObject();

                if (p.getPassword().equals(password)) {
                    return p;
                } else {
                    throw new PasswordException("비밀번호가 일치하지 않습니다.");
                }
            } catch (PasswordException e) {
                throw e;
            } catch (Exception e) {
                e.getMessage();
                return null;
            }
        } else {
            throw new SearchNotFoundException(name + "은 존재하지 않습니다.");
        }


    }

    /**
     * 몸무게 변경
     *
     * @param profile
     * @param weight
     * @throws PasswordException
     */
    @Override
    public Profile updateWeight(Profile profile, int weight)
        throws PasswordException, SearchNotFoundException {

        try (ObjectOutputStream oos = new ObjectOutputStream(
            new FileOutputStream(profile.getName() + ".txt"))) {
            Profile newProfile = new Profile(profile.getName(), weight,
                                             profile.getPassword());
            oos.writeObject(newProfile);
            return newProfile;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }

    }

    /**
     * 비밀번호 변경
     *
     * @param profile
     * @param newPassword
     */
    @Override
    public Profile updatePassword(Profile profile, String newPassword)
        throws PasswordException, SearchNotFoundException {
        Profile p = searchProfile(profile.getName(), profile.getPassword());

        try (ObjectOutputStream oos = new ObjectOutputStream(
            new FileOutputStream(p.getName() + ".txt"))) {
            Profile newProfile = new Profile(profile.getName(), profile.getWeight(),
                                             newPassword);
            oos.writeObject(newProfile);
            return newProfile;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
}
