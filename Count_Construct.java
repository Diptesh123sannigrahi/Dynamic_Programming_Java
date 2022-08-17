import java.util.*;

public class Count_Construct{

	public static int result(String[] arr,String target,HashMap<String,Integer> dp){
		if(target.length()==0){
			return 1;
		}

		if(dp.containsKey(target)){
			return dp.get(target);
		}

		int no_times = 0;
		for(int i=0;i<arr.length;i++){
			int n = target.length();
			if(arr[i].length()<=target.length() && arr[i].equals(target.substring(0,arr[i].length()))){
				no_times=result(arr,target.substring(arr[i].length(),n),dp)+no_times;
			
			}
		}

		dp.put(target,no_times);

		return dp.get(target);
	}

	public static int countConstruct(String[] arr,String target){
		HashMap<String,Integer> dp = new HashMap<>();
		return result(arr,target,dp);
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String target = sc.nextLine();
		String[] arr = sc.nextLine().split(" ");
		System.out.println(countConstruct(arr,target));
	}
}