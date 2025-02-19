package RecursionStriver;
/*https://takeuforward.org/data-structure/rat-in-a-maze/*/
import java.util.*;

public class RatAndMaze {
    private static void solve(int i, int j, int[][] a, int n, ArrayList<String> ans, String move, int[][] vis) {
        // Base condition: Reached the destination (bottom-right corner)
        if (i == n - 1 && j == n - 1) {
            ans.add(move);
            return;
        }

        // Mark the cell as visited
        vis[i][j] = 1;

        // Move Down (D)
        if (i + 1 < n && vis[i + 1][j] == 0 && a[i + 1][j] == 1) {
            solve(i + 1, j, a, n, ans, move + "D", vis);
        }

        // Move Left (L)
        if (j - 1 >= 0 && vis[i][j - 1] == 0 && a[i][j - 1] == 1) {
            solve(i, j - 1, a, n, ans, move + "L", vis);
        }

        // Move Right (R)
        if (j + 1 < n && vis[i][j + 1] == 0 && a[i][j + 1] == 1) {
            solve(i, j + 1, a, n, ans, move + "R", vis);
        }

        // Move Up (U)
        if (i - 1 >= 0 && vis[i - 1][j] == 0 && a[i - 1][j] == 1) {
            solve(i - 1, j, a, n, ans, move + "U", vis);
        }

        // Backtrack and unmark the cell
        vis[i][j] = 0;
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        int[][] vis = new int[n][n];
        ArrayList<String> ans = new ArrayList<>();

        if (m[0][0] == 1) {
            solve(0, 0, m, n, ans, "", vis);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 1},
                {1, 1, 1, 1}
        };

        ArrayList<String> paths = findPath(maze, 4);
        System.out.println(paths);
    }
}
