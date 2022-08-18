import java.util.*;

public class Uniqe_Paths_Maze {
    static int result(int n, int m, ArrayList<ArrayList<Integer>> mat, int[][] dp) {
        if (n == 0 && m == 0) {
            return 1;
        }

        if (n < 0 || m < 0) {
            return 0;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        int m_proc = 0;
        int n_proc = 0;

        if (m > 0 && n >= 0 && mat.get(n).get(m - 1) != -1) {
            m_proc = result(n, m - 1, mat, dp);
        }

        if (m >= 0 && n > 0 && mat.get(n - 1).get(m) != -1) {
            n_proc = result(n - 1, m, mat, dp);
        }

        return dp[m][n] = (m_proc + n_proc) % 1000000007;
    }

    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        // Write your code here.
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return result(n - 1, m - 1, mat, dp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> al = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                al.add(sc.nextInt());
            }
            mat.add(al);
        }
        System.out.println(mazeObstacles(n, m, mat));
    }

}