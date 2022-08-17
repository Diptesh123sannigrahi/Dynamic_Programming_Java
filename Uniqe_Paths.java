import java.util.* ;
import java.io.*; 
public class Uniqe_Paths {
	public static int result(int m,int n,int[][] dp){
		if(m==0 && n==0){
			return 1;
		}

		if(m<0 || n<0){
			return 0;
		}

		if(dp[m][n]!=-1){
			return dp[m][n];
		}

		int m_proc = result(m-1,n,dp);
		int n_proc = result(m,n-1,dp);

		return dp[m][n]=m_proc+n_proc;
	}

	public static int uniquePaths(int m, int n) {
		// Write your code here.
		int[][] dp = new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				dp[i][j]=-1;
			}
		}
		return result(m-1,n-1,dp);
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		System.out.println(uniquePaths(m,n));
	}
}