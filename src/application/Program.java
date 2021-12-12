package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Inform the account data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		double balance = sc.nextDouble();
		System.out.println("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();

		Account acc = new Account(number, holder, balance, withdrawLimit);

		System.out.println();
		System.out.println("inform an amount to withdraw: ");
		double amount = sc.nextDouble();

		if (amount>acc.getWithdrawLimit()) {
			System.out.println("Withdraw error: the amount exceeds the withdraw limit");
		}
		else if (amount>acc.getBalance()){
			System.out.println("Withdraw error: insufficient balance");
		}
		else {
		acc.withdraw(amount);
		System.out.printf("New balance: %.2f%n", acc.getBalance());
		}
		sc.close();

	}

}
