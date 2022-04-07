import java.util.Scanner;

public class Account {
	// Class variables
	
	String customerName;
	int customerID;
	double accountBalance;
	
	Account(String name, int id){
		customerName = name;
		customerID = id;
	}

	// Main menu function, this will access the other functions of the Account class.
	void showMenu() {
		Scanner sc = new Scanner(System.in); // Scanner to take user input.
		// Main menu welcome
		System.out.println("  ____               _   _    _____    ____       _____    _____    _____   _    _   _____   _   _    _____   _    _             \n"
				+ " |  _ \\      /\\     | \\ | |  / ____|  / __ \\     |  __ \\  |_   _|  / ____| | |  | | |_   _| | \\ | |  / ____| | |  | |     /\\     \n"
				+ " | |_) |    /  \\    |  \\| | | |      | |  | |    | |__) |   | |   | |      | |__| |   | |   |  \\| | | |      | |__| |    /  \\    \n"
				+ " |  _ <    / /\\ \\   | . ` | | |      | |  | |    |  ___/    | |   | |      |  __  |   | |   | . ` | | |      |  __  |   / /\\ \\   \n"
				+ " | |_) |  / ____ \\  | |\\  | | |____  | |__| |    | |       _| |_  | |____  | |  | |  _| |_  | |\\  | | |____  | |  | |  / ____ \\  \n"
				+ " |____/  /_/    \\_\\ |_| \\_|  \\_____|  \\____/     |_|      |_____|  \\_____| |_|  |_| |_____| |_| \\_|  \\_____| |_|  |_| /_/    \\_\\ \n"
				+ "                                                                                                                                 \n"
				+ "                                                                                                                                 ");
		
		System.out.println("Welcome to the Banco Pichincha Mobile Banking App, " + customerName);
		System.out.println("Your Mobile Banking ID is: " + customerID);
		lineBreaker();
		
		boolean flag = true;
		optionsMenu();
		String previousTransaction = "";
		while(flag ==true) {
		System.out.println("Enter an option");
		char option = sc.next().charAt(0);
		if(option == 'A') {
			lineBreaker2();
			checkBalance();
			lineBreaker2();
			lineBreaker();

		}
		else if (option == 'B') {
			System.out.println("Please enter the amount to deposit");
			int toDeposit = sc.nextInt();
			makeDeposit(toDeposit);
			lineBreaker2();
			System.out.println("Succesfully deposited " + "$" + toDeposit);
			lineBreaker2();
			lineBreaker();
			previousTransaction = "Your last transaction was: Deposited " + "$" + toDeposit;
			

		}
		else if(option == 'C') {
			System.out.println("Please enter the amount to withdraw");
			int toWithdraw = sc.nextInt();
			makeWithdrawal(toWithdraw);
			lineBreaker2();
			System.out.println("Succesfully withdrew " + "$" + toWithdraw);
			lineBreaker2();
			lineBreaker();
			previousTransaction = "Your last transaction was: Withdrew: " + "$" + toWithdraw;
		}
		else if (option == 'D') {
			lineBreaker2();
			System.out.println(previousTransaction);
			lineBreaker2();
			lineBreaker();
		}
		else if (option == 'E') {
			System.out.println("The current interest rate of Banco Pichincha is: 0.06%");
			System.out.println("Enter the number of years you plan to calculate the compound interest for");
			int rateYears = sc.nextInt();
			double calculatedInterest = (accountBalance)*(1+0.06*rateYears); 
			lineBreaker2();
			System.out.println("You will have " + "$" + calculatedInterest + " after " + rateYears + " years");
			lineBreaker2();
			lineBreaker();
			// A = P(1+rt)
			// P = initial principle balance
			// r = interest rate
			// n = number of times interest applied per time period
			// t = number of time periods elapsed

		}
		else if (option == 'F') {
			lineBreaker2();
			System.out.println("Thank you for using the Banco Pichincha Mobile Banking App");
			System.out.println("Closing App...");
			lineBreaker2();
			flag = false;
		}
	}
	}
	
	void optionsMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("What would you like to do today?");
		lineBreaker();
		System.out.println("A. Check balance\n"
				+ "B. Make deposit\n"
				+ "C. Make withdrawal \n"
				+ "D. View previous transaction\n"
				+ "E. Calculate interest\n"
				+ "F. Exit the application\n"
				+ "\n"
				+ "");
		
		lineBreaker();
	}

	// Ask BankingID
	void askBankingId() {
		int bankingPassword = 260204;
		System.out.println("Welcome to the Banco Pichincha Mobile Banking App");
		System.out.println("Please enter your Mobile Banking ID to continue");
		lineBreaker();
		Scanner sc = new Scanner(System.in);
		int userInputPassword = sc.nextInt();
		while (userInputPassword != bankingPassword) {
			System.out.println("Incorrect Mobile Banking ID. Please try again");
			userInputPassword = sc.nextInt();
		}
		System.out.println("Login successful");
		showMenu();		

	}
	// LineBreaker function
	void lineBreaker() {
		System.out.println("");
	}
	
	void lineBreaker2() {
		System.out.println("=================================================");
	}
	
	// Check balance function
	void checkBalance() {
		System.out.println("Your account balance is: " + "$" + accountBalance);
		
	}
	
	// Make deposit function
	void makeDeposit(int depositAmount) {
		lineBreaker();
		accountBalance = accountBalance + depositAmount;
	}
	
	// Make withdrawal function
	void makeWithdrawal(int withdrawalAmount) {
		lineBreaker();
		accountBalance = accountBalance - withdrawalAmount;
	}
}
