
import java.util.Scanner;

public class Chatbot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input;

        System.out.println("Chatbot: Hello! I am JavaBot.");
        System.out.println("Chatbot: Type 'bye' to exit.");

        while (true) {

            System.out.print("You: ");
            input = sc.nextLine().toLowerCase();

            if (input.contains("hello") || input.contains("hi")) {

                System.out.println("Chatbot: Hello! How can I help you?");

            }
            else if (input.contains("how are you")) {

                System.out.println("Chatbot: I am fine! What about you?");

            }
            else if (input.contains("your name")) {

                System.out.println("Chatbot: My name is JavaBot.");

            }
            else if (input.contains("what is ai")) {

                System.out.println("Chatbot: AI means Artificial Intelligence.");

            }
            else if (input.contains("thank")) {

                System.out.println("Chatbot: You're welcome!");

            }
            else if (input.contains("bye")) {

                System.out.println("Chatbot: Goodbye! Have a nice day!");
                break;

            }
            else {

                System.out.println("Chatbot: Sorry, I don't understand.");

            }
        }

        sc.close();
    }
}
