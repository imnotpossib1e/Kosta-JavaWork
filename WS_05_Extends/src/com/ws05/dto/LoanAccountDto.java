package com.ws05.dto;

public class LoanAccountDto extends AccountDto {

    private String mortgage;

    public LoanAccountDto() {

    }

    public LoanAccountDto(int accountSeq, String accountNumber, int balance, int userSeq,
        String mortgage) {
        super(accountSeq, accountNumber, balance, userSeq);
        this.mortgage = mortgage;
    }


    public String getMortgage() {
        return mortgage;
    }

    public void setMortgage(String mortgage) {
        this.mortgage = mortgage;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(super.toString());
        sb.append(mortgage);
        return sb.toString();
    }
}
