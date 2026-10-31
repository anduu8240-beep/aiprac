
import java.util.*;

public class RobotBFS {

    static int[][] grid = {
        {0, 0, 0, 1, 0},
        {1, 1, 0, 1, 0},
        {0, 0, 0, 0, 0},
        {0, 1, 1, 1, 0},
        {0, 0, 0, 0, 0}
    };

    static int rows = 5;
    static int cols = 5;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static void bfs(int sr, int sc, int gr, int gc) {

        Queue<int[]> q = new LinkedList<>();

        boolean[][] visited = new boolean[rows][cols];

        int[][] parent = new int[rows * cols][2];

        for (int i = 0; i < rows * cols; i++) {
            parent[i][0] = -1;
        }

        q.add(new int[]{sr, sc});
        visited[sr][sc] = true;

        while (!q.isEmpty()) {

            int[] current = q.poll();

            int r = current[0];
            int c = current[1];

            if (r == gr && c == gc) {

                System.out.println("Path Found!");

                printPath(parent, sr, sc, gr, gc);
                return;
            }

            for (int i = 0; i < 4; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < rows &&
                    nc >= 0 && nc < cols &&
                    grid[nr][nc] == 0 &&
                    !visited[nr][nc]) {

                    visited[nr][nc] = true;

                    q.add(new int[]{nr, nc});

                    int currentIndex = r * cols + c;
                    int nextIndex = nr * cols + nc;

                    parent[nextIndex][0] = r;
                    parent[nextIndex][1] = c;
                }
            }
        }

        System.out.println("No Path Found!");
    }

    static void printPath(int[][] parent,
                          int sr, int sc,
                          int gr, int gc) {

        Stack<int[]> path = new Stack<>();

        int r = gr;
        int c = gc;

        while (r != sr || c != sc) {

            path.push(new int[]{r, c});

            int pr = parent[r * cols + c][0];
            int pc = parent[r * cols + c][1];

            r = pr;
            c = pc;
        }

        path.push(new int[]{sr, sc});

        while (!path.isEmpty()) {

            int[] p = path.pop();

            System.out.println("(" + p[0] + ", " + p[1] + ")");
        }
    }

    public static void main(String[] args) {

        int startRow = 0;
        int startCol = 0;

        int goalRow = 4;
        int goalCol = 4;

        bfs(startRow, startCol, goalRow, goalCol);
    }
}
