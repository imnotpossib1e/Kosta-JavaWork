package com.ws05.service;

import com.ws05.dto.AccountDto;
import com.ws05.dto.InstallAccountDto;
import com.ws05.dto.LoanAccountDto;
import com.ws05.dto.SavingAccountDto;
import com.ws05.dto.UserDto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 고객과 계좌에 관련된 서비스
 * (Business Logic 을 처리하는 객체)
 *
 */

//자동 import 단축키 = ctrl + shift + 영문o
public class BankService {

    //final은 고정값= 값변경불가 (반드시 초기화 필수)
    final int ACCOUNT_SIZE = 10;
    /** 계좌 최대개수 */
    final int USER_SIZE = 5;
    /** 고객 최대개수 */


    int ACCOUNT_CURRENT_SIZE;
    /** 현재계좌의 개수 */
    int USER_CURRENT_SIZE;
    /** 현재 고객의 개수 */

    List<AccountDto> accountList;
    List<UserDto> userList;

    /**
     * 생성자에서 테스트를 위한 고객 및 계좌 객체를 생성하고 배열에 저장한다
     *
     */
    public BankService() {
        userList = new ArrayList<UserDto>();
        accountList = new ArrayList<AccountDto>();

        userList.add(new UserDto(111, "홍길동", "hong@gildong@com", "010-1111-1111", false));
        userList.add(new UserDto(222, "이길동", "lee@gildong@com", "010-2222-2222", true));
        userList.add(new UserDto(333, "삼길동", "sam@gildong@com", "010-3333-3333", false));

        accountList.add(new InstallAccountDto(20, "00200202002002", 1000, 111, 12, 10000));

        accountList.add(new SavingAccountDto(10, "00100101001001", 500, 111, 100));

        accountList.add(new LoanAccountDto(60, "00600606006006", 500, 333, "House"));
        accountList.add(new LoanAccountDto(30, "00300303003003", 0, 111, "Building"));

        accountList.add(new SavingAccountDto(70, "00700707007007", 500, 333, 200));

        accountList.add(new LoanAccountDto(50, "00500505005005", 200, 222, "Car"));
        accountList.add(new SavingAccountDto(40, "00400404004004", 1000, 222, 50));
    }

    /**
     * 특정 사용자의 계좌 목록을 배열로 리턴 하는 메소드를 작성한다
     */
    public List<AccountDto> getAccountList(int userSeq) {
        // TestView에서 고객 일련번호 400 받아옴
        // 일련번호로 AccountDto의 일련번호 검색해서 배열에 담기

        List<AccountDto> shallowCopy = new ArrayList<AccountDto>();
        int cnt = 0;
        int cnt2 = 0;
        for (AccountDto accountDto : accountList) {
            if (accountDto.getUserSeq() == userSeq) {
                shallowCopy.add(accountDto);
                cnt++;
            }
        }

        if (cnt == 0) {
            return null;
        } else {
            return shallowCopy;
        }
    }

    /**
     * 특정 사용자의 고객 정보를 리턴 하는 메소드를 작성한다
     *
     * @param : 고객의 sequence
     * @return : null이면 고객의정보없다
     **/
    public UserDto getUserDetail(int userSeq) {
        // 고객의 일련번호가 넘어온다
        for (UserDto userDto : userList) {
            if (userDto.getUserSeq() == userSeq) {
                return userDto;
            }
        }

        return null;
    }

    /**
     * 계좌 전체 목록 조회
     *
     * @return
     */
    public List<AccountDto> getAccountList() {
        return accountList;
    }

    /**
     * 잔액 기준 리스트
     */
    public List<AccountDto> getAccountListSortByBalance() {
        List<AccountDto> shallowList = new ArrayList<AccountDto>(this.accountList);
        Collections.sort(shallowList);

        return shallowList;
    }

    /**
     * 일련번호 기준 정렬한 모든 계좌 목록
     */
    public List<AccountDto> getAccountListSortByUserSeq() {
        List<AccountDto> shallowList = new ArrayList<AccountDto>(this.accountList);
        // Lambda식 사용
        Collections.sort(shallowList, (o1, o2) -> o1.getUserSeq() - o2.getUserSeq());
        return shallowList;
    }
}










