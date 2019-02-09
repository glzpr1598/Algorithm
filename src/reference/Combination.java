package reference;

public class Combination {
	static int[] data = {1, 2, 3, 4, 5};
	static int n = data.length;
	static int r = 3;
	static int[] comb = new int[r];

	public static void main(String[] args) {
		combination(n, r);
	}

	public static void combination(int n, int r) {
		if (r == 0) {
			process();
			return;
		} else if (n < r) {
			return;
		} else {
			comb[r - 1] = data[n - 1];
			// nCr = n-1Cr-1 + n-1Cr
			combination(n - 1, r - 1);
			combination(n - 1, r);
		}
	}

	private static void process() {
		for (int i = 0; i < r; i++) {
			System.out.print(comb[i]);
		}
		System.out.println();
	}
}
