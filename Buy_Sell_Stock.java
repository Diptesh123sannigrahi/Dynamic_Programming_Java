import java.util.*;


public class Buy_Sell_Stock {

	public static int maximumProfit(ArrayList<Integer> prices) {
		// Write your code here.
		int n = prices.size();
		int min = prices.get(0);
		int maxProfit = 0;
		for (int i = 1; i < n; i++) {
			int profit = prices.get(i) - min;
			maxProfit = Math.max(profit, maxProfit);
			min = Math.min(prices.get(i), min);
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> prices = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			prices.add(sc.nextInt());
		}
		System.out.println(maximumProfit(prices));
	}
}