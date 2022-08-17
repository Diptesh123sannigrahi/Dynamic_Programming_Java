import java.util.*;

public class Max_Inc_SubSeqSum {

    public static int result(int ind,int prev,ArrayList<Integer> rack,int[][] dp){
        if(ind==rack.size()){
            return 0;
        }

        if(dp[ind][prev+1]!=-1){
            return dp[ind][prev+1];
        }

        int not_inc = 0+result(ind+1,prev,rack,dp);
        int inc = Integer.MIN_VALUE;
        if(prev==-1 || rack.get(ind)>rack.get(prev)){
            inc = rack.get(ind)+result(ind+1,ind,rack,dp);
        }

        return dp[ind][prev+1]=Math.max(not_inc,inc);
    }

    public static int maxIncreasingDumbbellsSum(ArrayList<Integer> rack, int n) {
        // Write your code here.
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return result(0,-1,rack,dp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> rack = new ArrayList<>();
        for(int i=0;i<n;i++){
            rack.add(sc.nextInt());
        }
        System.out.println("Maxmimum Increasing Subsequence sum: "+maxIncreasingDumbbellsSum(rack,n));
    }
}