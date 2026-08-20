package com.ws07.service;

import com.ws07.dto.AccountDto;
import com.ws07.dto.UserDto;
import com.ws07.exception.BalanceLackException;
import com.ws07.exception.UserAccountNotFoundException;
import java.util.List;

public interface BankService {

    /**
     * 특정 사용자의 계좌 목록을 배열로 리턴 하는 메소드를 작성한다
     */
    List<AccountDto> getAccountList(int userSeq);

    /**
     * 특정 사용자의 고객 정보를 리턴 하는 메소드를 작성한다
     *
     * @param : 고객의 sequence
     * @return : null이면 고객의정보없다
     **/
    UserDto getUserDetail(int userSeq);

    /**
     * 계좌 전체 목록 조회
     *
     * @return
     */
    List<AccountDto> getAccountList();

    /**
     * 잔액 기준 리스트
     */
    List<AccountDto> getAccountListSortByBalance();


    /**
     * 일련번호 기준 정렬한 모든 계좌 목록
     */
    List<AccountDto> getAccountListSortByUserSeq();

    /**
     * 고객의 일련번호와 계좌 일련번호를 입력받아 계좌 정보 리턴
     * 계좌 없는 경우 에러 처리
     */
    AccountDto getUserAccount(int userSeq, int accountSeq) throws UserAccountNotFoundException;

    /**
     * 고객의 일련번호, 계좌 일련번호, 출금금액 입력받아 출금 처리
     * 부몾하면 에러 발생
     */
    int withdraw(int userSeq, int accountSeq, int amount)
        throws BalanceLackException, UserAccountNotFoundException;


}
