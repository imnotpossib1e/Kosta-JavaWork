package ex0821.controller;

import ex0821.dto.Profile;
import ex0821.exception.DuplicatedProfileException;
import ex0821.exception.PasswordException;
import ex0821.exception.SearchNotFoundException;
import ex0821.service.ProfileService;
import ex0821.service.ProfileServiceImpl;
import ex0821.view.FailView;
import ex0821.view.SuccessView;
import java.util.List;
import java.util.Scanner;

public class ProfileController {

    private ProfileService service = ProfileServiceImpl.getInstance();

    public void inputProfile(Profile profile) {
        try {
            service.inputProfile(profile);
            SuccessView.printMessage("등록되었습니다.");
        } catch (DuplicatedProfileException e) {
            FailView.printMessage(e.getMessage());
        }


    }

    public Profile searchProfile(String name, String password) {

        try {
            Profile profile = service.searchProfile(name, password);
            SuccessView.printSearchProfile(profile);
            return profile;
        } catch (PasswordException | SearchNotFoundException e) {
            FailView.printMessage(e.getMessage());
            return null;
        }
    }

    public void updateWeight(Profile profile, int weight) {

        try {
            service.updateWeight(profile, weight);
            SuccessView.printMessage("변경되었습니다.");
        } catch (PasswordException | SearchNotFoundException e) {
            FailView.printMessage(e.getMessage());
        }
    }

    public Profile updateSearchPassword(String name, String password) {
        try {
            Profile profile = service.searchProfile(name, password);
            SuccessView.printSearchPassword(profile);
            return profile;
        } catch (PasswordException | SearchNotFoundException e) {
            FailView.printMessage(e.getMessage());
            return null;
        }
    }

    public void updatePassword(Profile profile, String newPassword) {
        try {
            service.updatePassword(profile, newPassword);
            SuccessView.printMessage("비밀번호가 변경되었습니다.");
        } catch (PasswordException | SearchNotFoundException e) {
            FailView.printMessage(e.getMessage());
        }
    }
}
