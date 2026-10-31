
import java.util.Stack;

public class BlocksWorld {

    public static void main(String[] args) {

        Stack<String> goal = new Stack<>();

        goal.push("A on Table");
        goal.push("B on A");
        goal.push("C on B");

        System.out.println("Goal Stack Planning");

        while (!goal.isEmpty()) {

            String action = goal.pop();

            System.out.println("Perform: " + action);
        }

        System.out.println("Goal Achieved!");
    }
}






