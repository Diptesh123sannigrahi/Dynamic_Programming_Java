
import java.util.*;


public class Buy_Sell_Stock_III {

    // public static int result(int i, int buy, int t, ArrayList<Integer> prices, int[][][] dp) {
    //     if (i == prices.size()) {
    //         return 0;
    //     }

    //     if (t == 0) {
    //         return 0;
    //     }

    //     if (dp[i][buy][t] != -1) {
    //         return dp[i][buy][t];
    //     }

    //     int profit = 0;
    //     if (buy == 1) {
    //         profit = Math.max((-prices.get(i) + result(i + 1, 0, t, prices, dp)), (0 + result(i + 1, 1, t, prices, dp)));
    //     } else {
    //         profit = Math.max((prices.get(i) + result(i + 1, 1, t - 1, prices, dp)), (0 + result(i + 1, 0, t, prices, dp)));
    //     }

    //     return dp[i][buy][t] = profit;
    // }

    public static int maxProfit (ArrayList<Integer> prices, int n) {
        // Your code goes here.
        int[][][] dp = new int[n + 1][2][3];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                for (int k = 1; k <= 2; k++) {
                    if (j == 1) {
                        dp[i][j][k] = Math.max((-prices.get(i) + dp[i + 1][0][k]), (0 + dp[i + 1][1][k]));
                    } else {
                        dp[i][j][k] = Math.max((prices.get(i) + dp[i + 1][1][k - 1]), (0 + dp[i + 1][0][k]));
                    }
                }
            }
        }
        // return result(0, 1, 2, prices, dp);
        return dp[0][1][2];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> prices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            prices.add(sc.nextInt());
        }
        System.out.println(maxProfit(prices, n));
    }
}
