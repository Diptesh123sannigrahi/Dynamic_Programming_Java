import java.util.*;

public class How_Sum{

	public static ArrayList<Integer> result(int target_sum,int[] arr,HashMap<Integer,ArrayList<Integer>> dp){
		if(dp.containsKey(target_sum)){
			return dp.get(target_sum);
		}

		if(target_sum==0){
			return new ArrayList<Integer>();
		}

		if(target_sum<0){
			return null;
		}

		ArrayList<Integer> list = null;
		for(int i=0;i<arr.length;i++){
			int res = target_sum-arr[i];
			ArrayList<Integer> ans = result(res,arr,dp);
			if(ans!=null){
				ArrayList<Integer> new_list=new ArrayList<>(ans);
				new_list.add(arr[i]);
				list=new_list;
			}
		}
		dp.put(target_sum,list);
		return dp.get(target_sum);
	}

	public static ArrayList<Integer> how_sum(int n,int target_sum,int[] arr){
		HashMap<Integer,ArrayList<Integer>> dp = new HashMap<>();
		if(result(target_sum,arr,dp)==null){
			return new ArrayList<>();
		}
		return result(target_sum,arr,dp);
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int target_sum = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		System.out.println(how_sum(n,target_sum,arr));
	}
}