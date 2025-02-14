/* This rock paper scissors game takes input from players A and B and determines who the winner is. 
9 conditions for Win-Lose, Lose - Win, and TIES
Loop until correct input (STRING) and correct options "R", "P", "S" are selected.  
 */

import java.util.Scanner; // Input 
import java.util.regex.Pattern;

public class RockPaperScissors {
    public static void main(String[] args) {

        // Intialization Phase
        String userAChoice = "";
        String userBChoice = "";
        Scanner in = new Scanner(System.in);
        boolean correctChoiceRockA = userAChoice.equalsIgnoreCase("R"); // <-- Wanted to see if this would work it did
                                                                        // not
        boolean cycleComplete = false;

        int noLooping = 0;
        String playAgain = "";
        final int MAX_ATTEMPTS = 5;

        // Input & Error Checking

        // Grabbing UserA's Input
        do {
            boolean playerAValidInput = false;
            boolean playerBValidInput = false;

            do { // Loop until user inputs correct Var type (String) or badInput == 5.

                System.out.println("Hello, playerA please type (R)ock, (P)aper, or (S)cissors: ");

                if (in.hasNext()) {
                    userAChoice = in.nextLine();
                    if (userAChoice.equalsIgnoreCase("R") || userAChoice.equalsIgnoreCase("P")
                            || userAChoice.equalsIgnoreCase("S")) {
                        System.out.println("Valid input: " + userAChoice);
                        playerAValidInput = true;

                    } else { // ERROR Bad Input

                        System.out.println(
                                "Bad Input: '" + userAChoice + "'. Please enter a valid string character R, P, or S.");
                        noLooping++;

                        if (noLooping >= MAX_ATTEMPTS) {
                            System.out.println("Too many invalid attempts. EXITING");
                            return; // Exits after 5 errors
                        }
                        // Exit Code
                        if (playAgain.equalsIgnoreCase("N")) {
                            System.out.println("Thanks for playing");
                            return;
                        }
                    }
                }
            } while (!playerAValidInput);

            // PlayerB Input

            do {

                System.out.println("Hello, playerB please type (R)ock, (P)aper, or (S)cissors: ");

                if (in.hasNext()) {

                    userBChoice = in.nextLine();
                    if (userBChoice.equalsIgnoreCase("R") || userBChoice.equalsIgnoreCase("P")
                            || userBChoice.equalsIgnoreCase("S")) {
                        System.out.println("Valid input: " + userBChoice);
                        playerBValidInput = true;

                    } else { // ERROR Bad Input

                        System.out.println(
                                "Bad Input: '" + userBChoice + "'. Please enter a valid string character R, P, or S.");
                        noLooping++;

                        if (noLooping >= MAX_ATTEMPTS) {
                            System.out.println("Too many invalid attempts. EXITING");
                            return; // Exits after 5 errors
                        }
                        // Exit Condition
                        if (playAgain.equalsIgnoreCase("N"))
                            System.out.println("Thanks for playing");
                        return;
                    }

                    // PROCESSING PHASE

                    // TIE CONDITIONS

                    if (userAChoice.equalsIgnoreCase("R") && userBChoice.equalsIgnoreCase("R")) {
                        System.out.println("Rock vs Rock, It's a Tie!");
                        System.out.println("Would you like to play again: Y/N");
                        playAgain = in.nextLine();

                    } else if (userAChoice.equalsIgnoreCase("P") && userBChoice.equalsIgnoreCase("P")) {
                        System.out.println("Paper vs Paper, it's a Tie!");
                        System.out.println("Would you like to play again: Y/N");
                        playAgain = in.nextLine();

                    } else if (userAChoice.equalsIgnoreCase("S") && userBChoice.equalsIgnoreCase("S")) {
                        System.out.println("Scissors vs Scissors, It's a Tie!");
                        System.out.println("Would you like to play again: Y/N");
                        playAgain = in.nextLine();

                    }
                }

            } while (!playerBValidInput);
        } while (playAgain.equalsIgnoreCase("y"));
    }

}