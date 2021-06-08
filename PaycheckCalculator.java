package Integration;

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
		System.out.println("How much is employee paid per hour: ");
		double hourlyWage = scanner.nextDouble();
		if (hourlyWage < 10) { // hourly wage is set to be more than the minimum wage to prevent false input //
			// parameter^
			System.out.println(
					"Error. This amount is below minimum wage, you are either getting robbed of your efforts, or try agin.");
			System.out.println("Enter how much are they paid per hour: ");
			hourlyWage = scanner.nextDouble(); // nested if statement
			if (hourlyWage > 500) {
				System.out.println("Be realistic. No one here is paid that much, try again.");
				System.out.println("Enter how much money are they paid per hour: ");
				hourlyWage = scanner.nextDouble();
			}
		}
		// Reads input for totalHours worked by employee
		System.out.println("Hours logged this week: ");
		double totalHours = scanner.nextDouble();
		if (totalHours <= 0 || totalHours >= 168) { // there are only 168 hours in a week
			// conditional OR operator^
			System.out.println("Hours worked this week must be between 0 and 168");
			System.out.println("Enter total hours worked this week: ");
			totalHours = scanner.nextDouble();
		}

		// Reads input for weeklySales amount
		System.out.println("Total individual sales this week: ");
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
						} else { // else statement is here to taunt the user after abusing them into making them sell something
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
		System.out.println("Amount of profit from commmission: " + COMMISSION);
		System.out.println("Total Hours worked this week: " + totalHours);
		System.out.println("Hourly wage: " + hourlyWage);
		System.out.println("Employee's total income this week: " + total);

		// Part 2 of the PayCheckCalculator
		System.out
				.println("If you continue to work with this company you're salary will gradually increase each week. ");
		System.out.println(
				"Would you like to see how much money you will have in the future with the data above? yes or no: ");

		String usersAnswer = scanner.next();
		String yesOrNo = usersAnswer.equals("yes") ? "Great!"
				: "Too bad, this is my project, you will stay and suffer.";// this is a ternary construct
		// the equalsTo() method makes sure that the strings equal each other.
		// == would be used to compare values on both sides, while equalTo() is used to compare strings
		System.out.println(yesOrNo);

		System.out.println(
				"Enter '1' to print your future income for the next 10 weeks, if you continue working like this:");
		int usersAnswer2 = scanner.nextInt();
		while (usersAnswer2 != 1) {
			System.out.println(
					"ERROR: Enter '1' to print your future income for the next 10 weeks, if you continue working like this:");
			usersAnswer2 = scanner.nextInt();
		}
		System.out.println("Week:  Income:");
		// do/while loop
		do {
			double amount;
			double principal = total;
			double rate = .02;

			for (int week = 1; week <= 10; week++) { //for loop
				amount = principal * Math.pow(1 + rate, week); //math class used (math.pow)
				System.out.println(week + "      " + amount);
			}
			break;
		} while (usersAnswer2 == 1);

		int intTotal = (int) total;
		switch (intTotal) {
		case 0: //do more with this
			System.out.println("You will be broke, sad, and jobless if this happens again. Work harder.");
		default:
			System.out.println("You made money this week. Keep it up!");
		}

		System.out.println("Its not over yet! I hope you like gambling.");
		System.out.println("Enter '1' to continue:");
		int usersAnswer3 = scanner.nextInt();
		//while loop
		while (usersAnswer3 == 1) {
			System.out.println("Your gambling experiance:");
			break;
		}

		Random random = new Random(); //random class
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
		System.out.println(forcedGamble);
	}
}
// a continue statement is used similarly to a break statement, but it is used to skip a value.
//operator precedence determines which operator is read first within a statement.
//static means belonging to the class, not a particular object 
// methods in driver classes must be static because no objects of the class
// are created
