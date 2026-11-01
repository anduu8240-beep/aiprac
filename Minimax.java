
import java.util.Scanner;

public class Minimax {

    static char board[] = {'1','2','3','4','5','6','7','8','9'};

    static char computer = 'O';
    static char human = 'X';

    static void display() {
        System.out.println();
        for (int i = 0; i < 9; i++) {
            System.out.print(board[i] + " ");

            if (i % 3 == 2)
                System.out.println();
        }
    }

    static boolean win(char p) {

        int w[][] = {
            {0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}
        };

        for (int i = 0; i < 8; i++) {
            if (board[w[i][0]] == p &&
                board[w[i][1]] == p &&
                board[w[i][2]] == p)
                return true;
        }

        return false;
    }

    static boolean full() {
        for (int i = 0; i < 9; i++) {
            if (board[i] != 'X' && board[i] != 'O')
                return false;
        }
        return true;
    }

    static int minimax(boolean isMax) {

        if (win(computer))
            return 1;

        if (win(human))
            return -1;

        if (full())
            return 0;

        if (isMax) {

            int best = -100;

            for (int i = 0; i < 9; i++) {
                if (board[i] != 'X' && board[i] != 'O') {

                    char temp = board[i];
                    board[i] = computer;

                    int score = minimax(false);

                    board[i] = temp;

                    best = Math.max(best, score);
                }
            }

            return best;
        }

        else {

            int best = 100;

            for (int i = 0; i < 9; i++) {
                if (board[i] != 'X' && board[i] != 'O') {

                    char temp = board[i];
                    board[i] = human;

                    int score = minimax(true);

                    board[i] = temp;

                    best = Math.min(best, score);
                }
            }

            return best;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            display();

            System.out.print("Enter your position (1-9): ");
            int pos = sc.nextInt() - 1;

            if (pos < 0 || pos >= 9 ||
                board[pos] == 'X' || board[pos] == 'O') {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            board[pos] = human;

            if (win(human)) {
                display();
                System.out.println("You Win!");
                break;
            }

            if (full()) {
                display();
                System.out.println("Match Draw!");
                break;
            }

            int best = -100;
            int move = -1;

            for (int i = 0; i < 9; i++) {

                if (board[i] != 'X' && board[i] != 'O') {

                    char temp = board[i];
                    board[i] = computer;

                    int score = minimax(false);

                    board[i] = temp;

                    if (score > best) {
                        best = score;
                        move = i;
                    }
                }
            }

            board[move] = computer;

            System.out.println("Computer played!");

            if (win(computer)) {
                display();
                System.out.println("Computer Wins!");
                break;
            }

            if (full()) {
                display();
                System.out.println("Match Draw!");
                break;
            }
        }

        sc.close();
    }
}
