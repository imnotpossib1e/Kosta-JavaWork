package ex0806.ch06;

import java.util.Scanner;


class Account{
	private String accountNum;
	private String name;
	private int money;
	
	public Account() {
		
	}
	
	public Account(String accountNum, String name, int money) {
		this.accountNum = accountNum;
		this.name = name;
		this.money = money;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	
}

class BankApplication{
	static int cnt = 0;
	Scanner sc = new Scanner(System.in);
	Account account[] = new Account[100];
	
	public void inputAccount() {
		System.out.println("--------");
		System.out.println("계좌생성");
		System.out.println("--------");
		System.out.print("계좌번호: ");
		String accountNum = sc.nextLine();
		System.out.print("계좌주: ");
		String name = sc.nextLine();
		System.out.print("초기입금액: ");
   	 	int money = Integer.parseInt(sc.nextLine());
   	 	
   	 	if(cnt>100) {
   	 		System.out.println("계좌를 더이상 생성하실 수 없습니다.");
   	 		return;
   	 	}else {
   	 		account[cnt++] = new Account(accountNum, name, money);   	 		
   	 	}
	}
	
	public void selectAll() {
		System.out.println("--------");
		System.out.println("계좌 목록");
		System.out.println("--------");
		for(int i = 0; i<cnt; i++) {
			System.out.println(account[i].getAccountNum() + "\t\t" + account[i].getName() + "\t" + account[i].getMoney());
		}
	}
	
	public void inputMoney() {
		System.out.println("--------");
		System.out.println("예금");
		System.out.println("--------");
		System.out.print("계좌번호: ");
		String accountNum = sc.nextLine();
		System.out.print("예금액: ");
		int money = Integer.parseInt(sc.nextLine());
		
		Account account = this.searchAccount(accountNum);
		
		if(account!=null) {
			account.setMoney(account.getMoney() + money);
		}else {			
			System.out.println("해당하는 계좌번호가 없습니다.");
		}
		
	}
	
	public void withdrawalMoney() {
		System.out.println("--------");
		System.out.println("출금");
		System.out.println("--------");
		System.out.print("계좌번호: ");
		String accountNum = sc.nextLine();
		System.out.print("출금액: ");
		int money = Integer.parseInt(sc.nextLine());

		Account account = this.searchAccount(accountNum);
		
		if(account!=null) {
			account.setMoney(account.getMoney()-money);
		}else {			
			System.out.println("해당하는 계좌번호가 없습니다.");
		}
		
	}
	
	public Account searchAccount(String accountNum) {
		for(int i = 0; i<cnt; i++) {
			if(accountNum.equals(account[i].getAccountNum())) {
				return account[i];
			}
		}
		return null;
	}
	
}

class PrintMenu{
	public PrintMenu() {
		Scanner sc = new Scanner(System.in);
		BankApplication ba = new BankApplication();
		while(true){
	         System.out.println("-------------------------------------------------------------");
			 System.out.println("1.계좌생성     2.계좌목록      3.예금    4. 출금   5.종료");
			 System.out.println("-------------------------------------------------------------");

	         System.out.print("선택 > ");
			 int menuChoice = Integer.parseInt(sc.nextLine());

			 switch(menuChoice){
	             case 1 : 
					 ba.inputAccount(); break;
				 case 2 : 
				     ba.selectAll();
				      break;
				 case 3 : 
					 ba.inputMoney();
					 break;
				 case 4 : 
					 ba.withdrawalMoney() ;
					 break;
				 case 5:
					 System.out.println("프로그램 종료");
					 System.exit(0);
				 default: System.out.println("메뉴는 1~5만 입력해주세요.");

			 }//switch문

		  }//while문
	}
}



public class Problem20 {
	
	public static void main(String[] args) {
		new PrintMenu();

	}

}
