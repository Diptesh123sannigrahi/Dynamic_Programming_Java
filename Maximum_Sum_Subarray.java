import java.util.*;


public class Maximum_Sum_Subarray {

	public static int maximumSum(ArrayList<Integer> arr, int n) {
		int[] dp=new int[n];
		dp[0]=arr.get(0);

		for(int i=1;i<n;i++){
			dp[i]=arr.get(i)+dp[i-1];
		    if(dp[i]<0){
		    	dp[i]=0;
		    }	
		}
		return dp[n-1];
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0;i<n;i++){
			arr.add(sc.nextInt());
		}
		System.out.println("Maximim Subarray Sum "+maximumSum(arr,n));		
	}


}