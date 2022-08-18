import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* Not so good approach */

public class All_Construct {

	public static List<List<String>> result(String[] arr, String target, HashMap<String, List<List<String>>> dp) {
		if (target.length() == 0) {
			List<List<String>> baseCase = new ArrayList<>();
			baseCase.add(new ArrayList<>());
			return baseCase;
		}
		if (dp.containsKey(target)) {
			return dp.get(target);
		}

		List<List<String>> all = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			int n = target.length();
			String word = arr[i];
			if (arr[i].length() <= target.length() && arr[i].equals(target.substring(0, arr[i].length()))) {
				List<List<String>> ans = result(arr, target.substring(arr[i].length(), n), dp);
				List<List<String>> new_list = ans
				                              .stream()
				                              .peek(way -> way.add(0, word))
				                              .collect(Collectors.toList());;

				all = Stream.concat(all.stream(), new_list.stream()).collect(Collectors.toList());
			}
		}

		dp.put(target, all);

		return dp.get(target);
	}

	public static List<List<String>> allConstruct(String[] arr, String target) {
		HashMap<String, List<List<String>>> dp = new HashMap<>();
		return result(arr, target, dp);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String target = sc.nextLine();
		String[] arr = sc.nextLine().split(" ");
		System.out.println(allConstruct(arr, target));
	}
}