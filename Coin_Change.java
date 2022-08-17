import java.util.*;

public class Coin_Change {

	public static long result(int i,int[] denominations,int value,long[][] dp){
		if(i==denominations.length | value<0){
			return 0;
		}

		if(value==0){
			return 1;
		}

		if(dp[i][value]!=-1){
			return dp[i][value];
		}

		long not_take = result(i+1,denominations,value,dp);
		long new_take = result(i,denominations,value-denominations[i],dp);

		return dp[i][value]=not_take+new_take;

	}

	public static long countWaysToMakeChange(int denominations[], int value){
        //write your code here
        long[][] dp = new long[denominations.length][value+1];
        for(int i=0;i<denominations.length;i++){
        	for(int j=0;j<value+1;j++){
        		dp[i][j]=-1;
        	}
        }
        return result(0,denominations,value,dp);			
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] denominations = new int[n];
		for(int i=0;i<n;i++){
			denominations[i]=sc.nextInt();
		}
		int value = sc.nextInt();
		System.out.println(countWaysToMakeChange(denominations,value));
	}
	
}