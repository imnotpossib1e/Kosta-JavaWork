package ex0821.service;

import ex0821.dto.Profile;
import ex0821.exception.DuplicatedProfileException;
import ex0821.exception.PasswordException;
import ex0821.exception.SearchNotFoundException;

public interface ProfileService {


    /**
     * 프로필 입력
     *
     * @param profile
     */
    public void inputProfile(Profile profile) throws DuplicatedProfileException;

    /**
     * 프로필 검색
     *
     * @param name
     * @param password
     * @throws PasswordException
     */
    public Profile searchProfile(String name, String password)
        throws PasswordException, SearchNotFoundException;


    /**
     * 몸무게 변경
     *
     * @param profile
     * @throws PasswordException
     */
    public Profile updateWeight(Profile profile, int weight)
        throws PasswordException, SearchNotFoundException;

    /**
     * 비밀번호 변경
     *
     * @param profile
     */
    public Profile updatePassword(Profile profile, String newPassword)
        throws PasswordException, SearchNotFoundException;
}
