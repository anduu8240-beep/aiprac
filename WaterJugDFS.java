
import java.util.*;

public class WaterJugDFS {

    static int capacityA = 4;
    static int capacityB = 3;
    static int target = 2;

    static HashSet<String> visited = new HashSet<>();

    static boolean dfs(int a, int b) {

        String state = a + "," + b;

        if (visited.contains(state))
            return false;

        visited.add(state);

        System.out.println("Jug A: " + a + "  Jug B: " + b);

        // Check goal
        if (a == target || b == target) {
            System.out.println("Goal Reached!");
            return true;
        }

        // 1. Fill Jug A
        if (dfs(capacityA, b))
            return true;

        // 2. Fill Jug B
        if (dfs(a, capacityB))
            return true;

        // 3. Empty Jug A
        if (dfs(0, b))
            return true;

        // 4. Empty Jug B
        if (dfs(a, 0))
            return true;

        // 5. Pour Jug A into Jug B
        int pour = Math.min(a, capacityB - b);

        if (dfs(a - pour, b + pour))
            return true;

        // 6. Pour Jug B into Jug A
        pour = Math.min(b, capacityA - a);

        if (dfs(a + pour, b - pour))
            return true;

        return false;
    }

    public static void main(String[] args) {

        System.out.println("Water Jug Problem using DFS");

        if (!dfs(0, 0)) {
            System.out.println("Solution Not Found!");
        }
    }
}
