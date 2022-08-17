import java.util.*;

public class SubsetSum_eqToK{

	public static boolean result(int i, int k, int arr[], int[][] dp){
		if(k==0){
			return true;
		}

		if(i==arr.length-1){
			if(arr[i]==k){
				return true;
			}else{
				return false;
			}
		}

		if(dp[i][k]!=-1){
			if(dp[i][k]==1){
				return true;
			}

			if(dp[i][k]==0){
				return false;
			}
			
		}


		boolean take=false;
		if(arr[i]<=k){
			take = result(i+1,k-arr[i],arr,dp);
		}

		boolean not_take = result(i+1,k,arr,dp);

		if(not_take||take){
			dp[i][k]=1;
		}else{
			dp[i][k]=0;
		}

		return not_take||take;

	}

	public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        int[][] dp = new int[n][k+1];
        for(int i=0;i<n;i++){
        	for(int j=0;j<k+1;j++){
        		dp[i][j]=-1;
        	}
        }
        return result(0,k,arr,dp);
    }

    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int k = sc.nextInt();
    	int[] arr = new int[n];
    	for(int i=0;i<n;i++){
    		arr[i]=sc.nextInt();
    	}
    	System.out.println(subsetSumToK(n,k,arr));
    }
}

