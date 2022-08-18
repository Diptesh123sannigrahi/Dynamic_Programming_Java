import java.util.*;

public class Can_Construct {

	public static Boolean result(String[] arr, String target, HashMap<String, Boolean> dp) {
		if (target.length() == 0) {
			return true;
		}

		if (dp.containsKey(target)) {
			return dp.get(target);
		}

		Boolean res = false;
		for (int i = 0; i < arr.length; i++) {
			int n = target.length();
			if (arr[i].length() <= target.length() && arr[i].equals(target.substring(0, arr[i].length()))) {
				res = result(arr, target.substring(arr[i].length(), n), dp) || res;
			}
		}

		dp.put(target, res);

		return dp.get(target);
	}

	public static Boolean canConstruct(String[] arr, String target) {
		HashMap<String, Boolean> dp = new HashMap<>();
		return result(arr, target, dp);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String target = sc.nextLine();
		String[] arr = sc.nextLine().split(" ");
		System.out.println(canConstruct(arr, target));
	}
}