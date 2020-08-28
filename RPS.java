
import java.util.*;

public class RPS {
	// global(reachable) strings, which are used throughout the program in order to
	// explain the meaning of the integers that's being used for the game to work.
	public static final String Rock = "Rock";
	public static final String Paper = "Paper";
	public static final String Scissor = "Scissor";

	public static void main(String[] args) {
//List of array that stores integers
		List<Integer> scoreList = new ArrayList<Integer>(Arrays.asList(0, 0, 0));

		boolean run = true;

//while loop that runs on the terms of an booleans condition if it's true or false.
		while (run) {
//try/catch statement that catches exceptions which are not aligned with the user instructions & sends a message with instructions.
			try {
				println("\nChoose your move!:\nRock, by pressing: 1\nPaper, by pressing: 2 \nScissor, by pressing: 3");
//String variables, which are given the same value as the methods which carries the input information that'll be used to determine the outcome of the round played.
				String userChoise = getUserChoise();
				String computerChoise = getComputerChoise();
//if statement that sets the conditions of which move beats which.
//if one of the conditions is true a string gets printed with the info of who won & it also adds 1 integer to the winner's specific index.
//it also have a condition for occurrences where the same selection happens, this will print out that the round is a draw and add 1 integer to the tie index.
				if (userChoise.equals(computerChoise)) {
					println("It's a tie!");
					pointAdder(scoreList, 2);
				}

				else if (userChoise.equals(RPS.Paper) && computerChoise.equals(RPS.Scissor)) {
					println("computer Wins");

					pointAdder(scoreList, 0);
					System.out.println(scoreList.get(0));
				} else if (userChoise.equals(RPS.Scissor) && computerChoise.equals(RPS.Rock)) {
					println("computer Wins");
					pointAdder(scoreList, 0);
					System.out.println(scoreList.get(0));
				} else if (userChoise.equals(RPS.Rock) && computerChoise.equals(RPS.Paper)) {
					println("computer Wins");
					pointAdder(scoreList, 0);
					System.out.println(scoreList.get(0));
				} else if (userChoise.equals(RPS.Rock) && computerChoise.equals(RPS.Scissor)) {
					println("user Wins");
					pointAdder(scoreList, 1);
					System.out.println(scoreList.get(1));
				} else if (userChoise.equals(RPS.Paper) && computerChoise.equals(RPS.Rock)) {
					println("user Wins");
					pointAdder(scoreList, 1);
					System.out.println(scoreList.get(1));
				} else if (userChoise.equals(RPS.Scissor) && computerChoise.equals(RPS.Paper)) {
					println("user Wins");
					pointAdder(scoreList, 1);
					System.out.println(scoreList.get(1));
				}

			} catch (Exception e) {
				println("You have to choose a move by pressing: 1, 2 or 3.\nTry again!");
			}
			System.out.printf(
					"\nUser\t" + scoreList.get(1) + "\nComputer\t" + scoreList.get(0) + "\ntie\t" + scoreList.get(2));
			run = roof(scoreList);
		}

	}

//Method simply made to avoid having to write "System.out" every time i want to print out something.
	public static void println(String string) {
		System.out.println(string);
	}

//Method that checks if the computer or the user reaches 3 points by checking their index slots, it returns true if it does & false if it doesn't.
//The method is used for the while loops boolean, if it returns true the loop will stop, otherwise the loop will continue.
	public static boolean roof(List<Integer> playersList) {
		int computerCheck = playersList.get(0);
		int userCheck = playersList.get(1);
		if (computerCheck == 3 || userCheck == 3) {

			return false;

		}

		return true;

	}

//method that adds one integer value to an specific index slot in the List.
//The index slot gets selected by stating the index slot in the method's argument when the method gets called 
	public static void pointAdder(List<Integer> scoreList, int winnerindex) {
		Integer score = scoreList.get(winnerindex);
		score = score + 1;
		scoreList.set(winnerindex, score);
	}

//Method that randomize an integers value from 1 to 3, which then gets checked against an if statements conditions. 
//The chosen statement then gives an string a value which then returns a value for the method.
//The method then carries a selected "move" for the computer to be used for playing a round in the game.
	public static String getComputerChoise() {
		String CC;
		int slumpa = (int) (Math.random() * 3) + 1;
		if (slumpa == 1)
			CC = RPS.Rock;
		else if (slumpa == 2)
			CC = RPS.Paper;
		else
			CC = RPS.Scissor;

		println("Computer choosed\n" + CC);

		return CC;

	}

//Method that reads the input that's been sent by the user & translates the info into an integer. The integer gets checked against an if statements conditions.
//The chosen statement then gives an string a value which then returns a value for the method.
//The method then carries a selected "move" for the user to be used for playing a round in the game.
	public static String getUserChoise() {
		String UC = null;
		int UCI;
		Scanner reader = new Scanner(System.in);

		UCI = Integer.parseInt(reader.nextLine());
		if (UCI == 1)
			UC = "Rock";
		else if (UCI == 2)
			UC = "Paper";
		else if (UCI == 3)
			UC = "Scissor";
		println("User choosed\n" + UC);
		return UC;
	}

}