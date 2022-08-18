import java.util.*;

public class Longest_ComSubSeq {

	public static int result(int slen, String s, int tlen, String t, int[][] dp) {
		if (slen == -1 || tlen == -1) {
			return 0;
		}

		if (dp[slen][tlen] != -1) {
			return dp[slen][tlen];
		}

		if (s.charAt(slen) == t.charAt(tlen)) {
			return dp[slen][tlen] = 1 + result(slen - 1, s, tlen - 1, t, dp);
		}

		return dp[slen][tlen] = Math.max(result(slen - 1, s, tlen, t, dp), result(slen, s, tlen - 1, t, dp));
	}

	public static int lcs(String s, String t) {
		//Your code goes here
		int[][] dp = new int[s.length()][t.length()];
		for (int i = 0; i < s.length(); i++) {
			Arrays.fill(dp[i], -1);
		}
		int lcsL = result(s.length() - 1, s, t.length() - 1, t, dp);
		return lcsL;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String t = sc.nextLine();
		System.out.println(lcs(s, t));
	}
}