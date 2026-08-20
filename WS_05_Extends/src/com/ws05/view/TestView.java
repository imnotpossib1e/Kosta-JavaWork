package com.ws05.view;

import com.ws05.dto.AccountDto;
import com.ws05.dto.UserDto;
import com.ws05.service.BankService;
import java.util.List;

public class TestView {

    public static void main(String[] args) {
        System.out.println("***1. 고객 seq 100 에 해당하는 계좌정보 검색하기 *****");
        BankService service = new BankService();

        List<AccountDto> accountList = service.getAccountList(111);

        if (accountList == null) {
            System.out.println("회원의 계좌정보가 없습니다. ");
        } else {
            System.out.println("회원계좌개수 : " + accountList.size());
            for (AccountDto dto : accountList) {
                System.out.println(dto.getAccountSeq() + " , "
                                       + dto.getAccountNumber() + " , " + dto.getUserSeq());

            }
        }

        System.out.println("\n\n***2. userSeq에 300 해당하는 고객의 정보 *************");
        UserDto userDto = service.getUserDetail(333);//300 userSeq
        if (userDto != null) {
            System.out.println(userDto);

        } else {
            System.out.println("회원의 정보가 없습니다.");
        }

    }//메인끝

}// 클래스 끝





