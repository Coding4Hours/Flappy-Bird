import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		startGame();
	}

	public static void startGame() {
		System.out.println("Welcome to Flappy Bird!");
		System.out.println("Press any key to make the bird flap its wings.");
		System.out.println("Avoid the obstacles and try to get the highest score!");
		Scanner scanner = new Scanner(System.in);
		int score = 0;
		while (true) {
			System.out.println("Press any key to flap the bird's wings...");
			scanner.nextLine();
			boolean isBirdAlive = simulateGame();
			if (isBirdAlive) {
				score++;
				System.out.println("Bird survived! Score: " + score);
			} else {
				System.out.println("Bird crashed! Game over. Final score: " + score);
				break;
			}
		}
		scanner.close();
	}

	public static boolean simulateGame() {
		return Math.random() < 0.5;
	}
}
