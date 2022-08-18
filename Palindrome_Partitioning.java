import java.util.*;

public class Palindrome_Partitioning {

	public static boolean isPalindrome(String str) {
		int n = str.length();
		for (int i = 0; i < n; i++) {
			if (i < n / 2) {
				if (str.charAt(i) != str.charAt(n - i - 1)) {
					return false;
				}
			}
		}
		return true;
	}

	public static int result(int i, int n, String str, int[] dp) {
		if (i == n) {
			return 0;
		}

		if (dp[i] != -1) {
			return dp[i];
		}

		int take = 10000000;
		for (int j = i; j < n; j++) {
			String sub_str = str.substring(i, j + 1);
			if (isPalindrome(sub_str)) {
				take = Math.min(1 + result(j + 1, n, str, dp), take);
			}
		}

		return dp[i] = take;
	}

	public static int palindromePartitioning(String str) {
		// Write your code here
		int[] dp = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			dp[i] = -1;
		}
		return result(0, str.length(), str, dp) - 1;
	}

	// public static int palindromePartitioning(String str) {
	//     // Tabulation Method
	//     int n = str.length();
	// 	int[] dp = new int[n+1];
	// 	dp[n]=0;
	// 	for(int i=n-1;i>=0;i--){
	// 		int min_cost = 100000000;
	// 		for(int j=i;j<n;j++){
	// 			String sub_str = str.substring(i,j+1);
	// 			if(isPalindrome(sub_str)){
	// 				int cost = 1+dp[j+1];
	// 				min_cost=Math.min(cost,min_cost);
	// 			}
	// 		}
	// 		dp[i]=min_cost;
	// 	}
	// 	return dp[0]-1;
	// }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(palindromePartitioning(str));
	}
}