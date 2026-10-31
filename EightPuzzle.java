
import java.util.*;

public class EightPuzzle {

    static int[] goal = {1,2,3,4,5,6,7,8,0};

    // Calculate Manhattan Distance
    static int heuristic(int[] a) {
        int h = 0;

        for (int i = 0; i < 9; i++) {
            if (a[i] != 0) {
                int r = i / 3;
                int c = i % 3;

                int gr = (a[i] - 1) / 3;
                int gc = (a[i] - 1) % 3;

                h += Math.abs(r - gr) + Math.abs(c - gc);
            }
        }

        return h;
    }

    // Display puzzle
    static void display(int[] a) {
        for (int i = 0; i < 9; i++) {
            System.out.print(a[i] + " ");

            if (i % 3 == 2)
                System.out.println();
        }
        System.out.println();
    }

    // A* Search
    static void solve(int[] start) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(
                a[9] + a[10], b[9] + b[10]
            )
        );

        Set<String> visited = new HashSet<>();

        int[] first = new int[11];

        System.arraycopy(start, 0, first, 0, 9);

        first[9] = 0;              // g value
        first[10] = heuristic(start); // h value

        pq.add(first);

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int[] state = Arrays.copyOf(current, 9);

            String key = Arrays.toString(state);

            if (visited.contains(key))
                continue;

            visited.add(key);

            // Check goal
            if (Arrays.equals(state, goal)) {
                System.out.println("Goal Reached!");
                display(state);
                return;
            }

            // Find blank space
            int zero = 0;

            for (int i = 0; i < 9; i++) {
                if (state[i] == 0) {
                    zero = i;
                    break;
                }
            }

            int row = zero / 3;
            int col = zero % 3;

            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};

            // Generate next states
            for (int i = 0; i < 4; i++) {

                int nr = row + dr[i];
                int nc = col + dc[i];

                if (nr >= 0 && nr < 3 &&
                    nc >= 0 && nc < 3) {

                    int pos = nr * 3 + nc;

                    int[] next = new int[11];

                    System.arraycopy(state, 0, next, 0, 9);

                    // Swap blank space
                    next[zero] = next[pos];
                    next[pos] = 0;

                    next[9] = current[9] + 1;
                    next[10] = heuristic(next);

                    if (!visited.contains(
                        Arrays.toString(
                            Arrays.copyOf(next, 9)
                        ))) {
                        pq.add(next);
                    }
                }
            }
        }

        System.out.println("No Solution!");
    }

    public static void main(String[] args) {

        int[] start = {
            1, 2, 3,
            4, 0, 6,
            7, 5, 8
        };

        solve(start);
    }
}
