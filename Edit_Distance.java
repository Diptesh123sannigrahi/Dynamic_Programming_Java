import java.util.*;

public class Edit_Distance {

	public static int result(int slen, String s, int tlen, String t, int[][] dp) {
		if (slen == -1 && tlen == -1) {
			return 0;
		}

		if (slen == -1) {
			return tlen + 1;
		}

		if (tlen == -1) {
			return slen + 1;
		}

		if (dp[slen][tlen] != -1) {
			return dp[slen][tlen];
		}

		if (s.charAt(slen) == t.charAt(tlen)) {
			return dp[slen][tlen] = 0 + result(slen - 1, s, tlen - 1, t, dp);
		}

		int remove = result(slen - 1, s, tlen, t, dp);
		int replace = result(slen, s, tlen - 1, t, dp);
		int insert = result(slen - 1, s, tlen - 1, t, dp);

		return dp[slen][tlen] = 1 + Math.min(insert, Math.min(remove, replace));

	}

	public static int editDistance(String s, String t) {
		//Your code goes here
		int[][] dp = new int[s.length()][t.length()];
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < t.length(); j++) {
				dp[i][j] = -1;
			}
		}
		return result(s.length() - 1, s, t.length() - 1, t, dp);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String t = sc.nextLine();
		System.out.println("Distance: " + editDistance(s, t));
	}
}