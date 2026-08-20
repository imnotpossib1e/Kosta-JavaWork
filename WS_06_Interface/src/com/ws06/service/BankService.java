package com.ws06.service;

import com.ws06.dto.AccountDto;
import com.ws06.dto.UserDto;
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

}
