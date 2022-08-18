import java.util.*;

public class Maximum_Product_SubArray {

	public static int maximumProduct(ArrayList<Integer> arr, int n) {
		// Write your code here.
		int totalProduct = Integer.MIN_VALUE;
		int total1 = 1;
		int total2 = 1;

		for (int i = 0; i < n; i++) {
			int temp = Math.max(arr.get(i), Math.max(total1 * arr.get(i), total2 * arr.get(i)));
			total2 = Math.min(arr.get(i), Math.min(total1 * arr.get(i), total2 * arr.get(i)));
			total1 = temp;

			totalProduct = Math.max(totalProduct, total1);
		}
		return totalProduct;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(sc.nextInt());
		}
		System.out.println("Maximim Subarray Product " + maximumProduct(arr, n));
	}
}