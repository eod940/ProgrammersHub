import java.util.*;

public class Main {

	static int t, a, b;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			a = sc.nextInt();
			b = sc.nextInt();

			System.out.println(a * b / gcd(a, b));
		}
	}

	static int gcd(int a, int b) {
		if (b != 0) {
			return gcd(b, a % b);
		} else {
			return a;
		}
	}
}