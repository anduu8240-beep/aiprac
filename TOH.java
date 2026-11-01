
import java.util.*;

public class TowerOfHanoiSSS {

    static Set<String> visited = new HashSet<>();

    static boolean dfs(List<List<Integer>> state, List<List<Integer>> goal) {

        if (state.equals(goal)) {
            return true;
        }

        String key = state.toString();

        if (visited.contains(key)) {
            return false;
        }

        visited.add(key);

        for (int i = 0; i < 3; i++) {

            if (!state.get(i).isEmpty()) {

                int disk = state.get(i).get(state.get(i).size() - 1);

                for (int j = 0; j < 3; j++) {

                    if (i != j) {

                        if (state.get(j).isEmpty() ||
                            state.get(j).get(state.get(j).size() - 1) > disk) {

                            List<List<Integer>> newState = new ArrayList<>();

                            for (List<Integer> rod : state) {
                                newState.add(new ArrayList<>(rod));
                            }

                            newState.get(i).remove(newState.get(i).size() - 1);
                            newState.get(j).add(disk);

                            System.out.println(newState);

                            if (dfs(newState, goal)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of disks: ");
        int n = sc.nextInt();

        List<List<Integer>> start = new ArrayList<>();
        List<List<Integer>> goal = new ArrayList<>();

        List<Integer> source = new ArrayList<>();

        for (int i = n; i >= 1; i--) {
            source.add(i);
        }

        start.add(source);
        start.add(new ArrayList<>());
        start.add(new ArrayList<>());

        goal.add(new ArrayList<>());
        goal.add(new ArrayList<>());
        goal.add(new ArrayList<>(source));

        System.out.println("State Space Search:");

        if (dfs(start, goal)) {
            System.out.println("Goal State Reached!");
        } else {
            System.out.println("Goal State Not Reached!");
        }

        sc.close();
    }
}
