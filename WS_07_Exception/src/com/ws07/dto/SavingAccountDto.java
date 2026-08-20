package com.ws07.dto;

public class SavingAccountDto extends AccountDto {

    private int transferFree;

    public SavingAccountDto() {

    }

    public SavingAccountDto(int accountSeq, String accountNumber, int balance, int userSeq,
        int transferFree) {
        super(accountSeq, accountNumber, balance, userSeq);
        this.transferFree = transferFree;
    }

    public int getTransferFree() {
        return transferFree;
    }

    public void setTransferFree(int transferFree) {
        this.transferFree = transferFree;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(super.toString());
        sb.append(transferFree);
        return sb.toString();
    }
}
