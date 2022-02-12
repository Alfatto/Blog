import java.util.*;

public class Level1{
	public static int MaximumDiscount(int N, int[] price) {
		int result = 0;
		int numberOfDiscountPurchases = 3;

		Arrays.sort(price);

		int i;
		for (i = price.length; i > 0; ) {
			i -= numberOfDiscountPurchases;
			if (i >= 0) {
				result += price[i];
			}
		}
		return result;
	}
}