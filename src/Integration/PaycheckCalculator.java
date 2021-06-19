package Integration;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

// Justin Rubio

// This project is a combination of everything I have learned in COP 2006.

// The PaycheckCalculator is a program that can be used by payroll clerks to calculate wages and paycheck stubs for employees.

/*There are 8 primitive data types in Java:
 
 byte: The byte data type is an 8-bit signed two's complement integer.  
 		has a minimum value of -128 and a maximum value of 127 (inclusive). 
		The byte data type can be useful for saving memory in large arrays, where the memory savings actually matters.  

short: The short data type is a 16-bit signed two's complement integer. 
	has a minimum value of -32,768 and a maximum value of 32,767 (inclusive).  

int: By default, the int data type is a 32-bit signed two's complement integer, which has a minimum value of -231 and a maximum value of 231-1.  

long: The long data type is a 64-bit two's complement integer.  
	The signed long has a minimum value of -263 and a maximum value of 263-1.  
	
 float: The float data type is a single-precision 32-bit IEEE 754 floating point. 
	Its range of values is beyond the scope of this discussion, This data type should never be used for precise values, such as currency. 
	For that, you will need to use the java.math.BigDecimal class instead.  
	
double: Its range of values is beyond the scope of this discussion, but is specified in the Floating-Point Types, Formats, and Values section of the Java Language Specification. 
	For decimal values, this data type is generally the default choice.  
 	this data type should never be used for precise values, such as currency. 

boolean: The boolean data type has only two possible values: true and false. 
char: The char data type is a single 16-bit Unicode character.  	
*/

public class PaycheckCalculator {
	public static void main(String[] args) {
		// header^ argument^
		System.out.println(" Welcome to the Paycheck Calculator! ");
		Scanner scanner = new Scanner(System.in);

		// Reads input to find how much employee makes per hour.
		System.out.println("\nHow much is employee paid per hour: ");
		double hourlyWage = scanner.nextDouble();
		do {
			if (hourlyWage < 10 || hourlyWage > 500) {
				System.out.println(
						"Be realistic. No one here is paid that much. Wages are between 10 and 500 an hour. Try again.");
				System.out.println("Enter how much money are they paid per hour: ");
				hourlyWage = scanner.nextDouble();
			}
		} while (hourlyWage < 10 || hourlyWage > 500);

		// Reads input for totalHours worked by employee
		System.out.println("\nHours logged this week: ");
		double totalHours = scanner.nextDouble();
		do {
			if (totalHours == 0 || totalHours > 168) { // there are only 168 hours in a week
				// conditional OR operator^
				System.out.println("Hours worked this week must be between 0 and 168");
				System.out.println("Enter total hours worked this week: ");
				totalHours = scanner.nextDouble();
			}
		} while (totalHours == 0 || totalHours > 168);

		// Reads input for weeklySales amount
		System.out.println("\nTotal individual sales this week: ");
		double weeklySales = scanner.nextDouble();
		while (weeklySales == 0) {
			System.out.println("Go sell something, then come back and try again");
			weeklySales = scanner.nextDouble();
			if (weeklySales == 0) {
				System.out.println("Are you ignoring my program? Go sell something.");
				weeklySales = scanner.nextDouble();
				if (weeklySales == 0) {
					System.out.println("I can do this all day.");
					weeklySales = scanner.nextDouble();
					if (weeklySales == 0) {
						System.out.println(
								"Yes, I seriously nested 3 if-statements inside of a while loop. Just please sell something or you are fired.");
						weeklySales = scanner.nextDouble();
						if (weeklySales == 0) {
							System.out.println("Ok fine, maybe next week.");
							break;
							// break statement is here to break out of the loop early.
							// without this, the user would be arguing with the program forever until they
							// sold something.
						} else { // else statement is here to taunt the user after abusing them into making them
									// sell something
							System.out.println("Its about time.");
						}
					}
				}
			}
		}

		// commission
		final double COMMISSION;
		COMMISSION = 0.20 * weeklySales;

		// ^ Here final is used with a variable to define a constant that can only be
		// assigned once. // This will make it always contain the same value.

		// A variable can store information to be referenced and manipulated within a
		// program. // Scope means that a variable is only accessible in the method it
		// was defined.

		double total = totalsUsingMethods.totalIncomeFromHours(totalHours, hourlyWage) + COMMISSION; // method is called
																										// here

		// final calculations
		System.out.println("\nAmount of profit from commmission: $" + COMMISSION);
		System.out.println("Total Hours worked this week: " + (int) totalHours + " hours");
		// casted as an integer to display a more formal value
		System.out.println("Hourly wage: $" + hourlyWage);
		System.out.println("Employee's total income this week: $" + total);

		// Part 2 of the PayCheckCalculator
		System.out.println(
				"\nIf you continue to work with this company you're salary will gradually increase each week. ");
		System.out.println(
				"Would you like to see how much money you will have in the future with the data above? y or n: ");

		String usersAnswer = scanner.next();
		String yesOrNo = usersAnswer.equals("y") ? "Great!" : "Too bad, this is my project, you will stay and suffer.";

		// this is a ternary construct
		// the equalsTo() method makes sure that the strings equal each other.
		// == would be used to compare values on both sides, while equalTo() is used to
		// compare strings
		System.out.println(yesOrNo);

		System.out.println(
				"\nEnter '1' to print your future income for the next 10 weeks, if you continue working like this:");
	
		
		
	
		
			int usersAnswer2 = scanner.nextInt();
			while (usersAnswer2 != 1) {
				System.out.println(
						"ERROR: Enter '1' to print your future income for the next 10 weeks, if you continue working like this:");
				usersAnswer2 = scanner.nextInt();
			
			}

			System.out.println("Week:  Income:");
			// do/while loop

			// HGOGHEORHNOEUHVYOTORETO4VOUHTGOURNVMGDFVM,FNHBDHGGX LXJN
			do {
				double amount;
				double principal = total;
				double rate = .02;

				for (int week = 1; week <= 10; week++) { // for loop
					amount = principal * Math.pow(1 + rate, week); // math class used (math.pow)
					System.out.println(week + "      " + amount);
				}
				
				break;
			} while (usersAnswer2 == 1);
			
			
		
		
		
		
		int intTotal = (int) total;
		switch (intTotal) {
		case 0: // do more with this
			System.out.println("You will be broke, sad, and jobless if this happens again. Work harder.");
		default:
			System.out.println("\nKeep it up!");
		}

		System.out.println("\nIts not over yet! \nI hope you like gambling.");
		System.out.println("Enter a 'lucky number' to continue:");
		int usersAnswer3 = scanner.nextInt();
		// while loop
		while (usersAnswer3 == usersAnswer3) {
			System.out.println("Your gambling experience:");
			break;
		}

		Random random = new Random(); // random class
		int forcedGamble = random.nextInt(5) + 0;

		switch (forcedGamble) {
		case 0:
			System.out.println(
					"You put all the income you just made into one random stock one day. You wake up the next morning to a 50% profit!");
			break;
		case 1:
			System.out.println(
					"You and your friend bet all your weeks income on tonight's boxing match, and the guy you bet on won!");
			break;
		case 2:
			System.out.println(
					"You go to gamble your week's income in a game of poker. You're dealt a great hand everytime and barely even tried the whole night, causing you to tripple your profits!");
			break;
		case 3:
			System.out.println(
					"You put all the income you just made into one random stock one day. You wake up the next morning to a 100% decline... you should have waited for the dip.");
			break;
		case 4:
			System.out.println(
					"You and your friend bet all your weeks income on tonight's boxing match, and the guy you bet on got knocked out in the first round... you worked that whole week for nothing.");
			break;
		case 5:
			System.out.println(
					"You go to gamble your week's income in a game of poker. The sketchy people you played with were very annoyed of your bluffing, and they decide to rob you... be careful next time.");
			break;
		}
		System.out.println("You got case: " + forcedGamble);

		System.out.println(
				"\nWhatever case you got, good for you. \nBut you've just remembered you have to meet with a CoWorker to report your work to 'The Company'. ");

		System.out.println(
				"\nYour Co-Worker is a very hard working person who is known for setting an example for everyone else at 'The Company'.");

		System.out.println("\nWhat is the name of your Co-Worker: ");

		String coWorkerName = scanner.next();

		// Paycheck Calculator part 3
		employeeAtTheCompany coWorker = new employeeAtTheCompany();
		// object created from a class from a different file
		System.out.printf(coWorkerName + "'s Stats for the Week: \n" + coWorker.averageEmployeeStats());

		System.out.println("\nUh oh, " + coWorkerName + " wants to compare your stats with their's...");

		System.out.println("\n*you share your spreadsheet with " + coWorkerName + "*");

		System.out.println("\nYour Stats: ");

		// 1-Dimensional Array
		int spreadSheet[] = { (int) hourlyWage, (int) totalHours, (int) weeklySales };
		int sumOfTheSpreadSheet = 0;
		int locationOfSmallestValue = 0;

		for (int index = 0; index < spreadSheet.length; index++) {
			// System.out.println(index +"\t"+ spreadSheet[index]);
			// more detailed switch statement
			// formats the table for the array
			switch (index) {
			case 0:
				System.out.println("Hourly Wage:\t$ " + spreadSheet[index]);
				break;
			case 1:
				System.out.println("Total Hours:\t  " + spreadSheet[index]);
				break;
			case 2:
				System.out.println("Weekly Sales:\t$ " + spreadSheet[index]);
				break;
			}
		}
		// For integration project requirement purposes
		for (int index = 0; index < spreadSheet.length; index++) {
			sumOfTheSpreadSheet += spreadSheet[index];
			if (spreadSheet[index] < locationOfSmallestValue) {
				locationOfSmallestValue = index;
			}
		}
		// enhanced for loop
		for (int index : spreadSheet) {
			sumOfTheSpreadSheet += index;
		}
		System.out.println("Sum of the array = " + sumOfTheSpreadSheet + "\nIndex of the smallest Value = "
				+ locationOfSmallestValue);

		System.out.println("\n" + coWorkerName + " then uses an array to chart your data side by side.\n");
		System.out.println("Enter '1' to pull up results: ");
		int usersAnswer4 = scanner.nextInt();
		while (usersAnswer4 != 1) {
			System.out.println("ERROR: Enter '1' to pull up results:");
			usersAnswer4 = scanner.nextInt();
		}

		// Multidimensional Array
		int[][] comparedSpreadSheets = { { (int) hourlyWage, (int) totalHours, (int) weeklySales }, { 20, 40, 400 } };
		for (int row = 0; row < comparedSpreadSheets.length; row++) {
			for (int column = 0; column < comparedSpreadSheets[row].length; column++) {
				System.out.print(comparedSpreadSheets[row][column] + "\t");
			}
			System.out.println();
		}

		System.out.println("\n" + coWorkerName + " is proud of his useless array that compares your data with his.");

		System.out.println("Wait a second... \n" + coWorkerName + " looks like he's going crazy with his programming!");
		System.out.println("Enter '1' to see what " + coWorkerName + " is doing: ");

		int usersAnswer5 = scanner.nextInt();
		while (usersAnswer5 != 1) {
			System.out.println("ERROR: Enter '1' to see what " + coWorkerName + " is doing: ");
			usersAnswer5 = scanner.nextInt();
		}

		// import ArrayList
		// given type is integer
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add((int) hourlyWage);
		numbers.add((int) totalHours);
		numbers.add((int) weeklySales);

		System.out
				.println("\nNow he is using an ArrayList to print your same data for the 3rd time in a row!\n Look at "
						+ coWorkerName + " go!\n");
		for (Integer value : numbers) {
			System.out.println(value);
		}
		
		
		System.out.println("\n\nThe End.");

// Inheritance is when objects inherit each others attributes and fields.
		// Inheritance is very beneficial to reduce data redundancy
//Leading on from inheritance, Polymorphism is the ability for objects to be able to take on many forms. 
// a continue statement is used similarly to a break statement, but it is used to skip a value.
//operator precedence determines which operator is read first within a statement.
//static means belonging to the class, not a particular object 
// methods in driver classes must be static because no objects of the class
// are created
	}
}