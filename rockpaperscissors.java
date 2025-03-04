import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rps = {"rock", "paper", "scissors"};
        String computerMove, userMove;
        Random random = new Random();

        while (true) {
            System.out.println("Enter your move (rock, paper, scissors). To exit the game, type \"exit\": ");
            userMove = scanner.nextLine().toLowerCase();

            if (userMove.equals("exit")) {
                break;
            }

            if (!userMove.equals("rock") && !userMove.equals("paper") && !userMove.equals("scissors")) {
                System.out.println("Invalid move, please try again.");
                continue;
            }

            int computerMoveIndex = random.nextInt(3);
            computerMove = rps[computerMoveIndex];

            System.out.println("Computer move: " + computerMove);

            if (userMove.equals(computerMove)) {
                System.out.println("It's a tie!");
            } else if (userMove.equals("rock")) {
                if (computerMove.equals("scissors")) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lose!");
                }
            } else if (userMove.equals("paper")) {
                if (computerMove.equals("rock")) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lose!");
                }
            } else if (userMove.equals("scissors")) {
                if (computerMove.equals("paper")) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lose!");
                }
            }
        }

        scanner.close();
    }
}
