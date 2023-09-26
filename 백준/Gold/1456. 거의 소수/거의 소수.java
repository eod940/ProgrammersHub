import java.util.*;
import java.io.*;

public class Main {
	static long a, b;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
		long[] arr = new long[10_000_001];  // 10^14 의 제곱근인 10^7 까지만

		for (int i = 2; i <= 10_000_000; i++) {
			arr[i] = i;
		}

		for (int i = 2; i <= Math.sqrt(10_000_001); i++) {
			if (arr[i] == 0) continue;

			for (int j = 2 * i; j < 10_000_001; j += i) {
				arr[j] = 0;
			}
		}

		int count = 0;
		for (int i = 2; i < 10_000_001; i++) {
			if (arr[i] != 0) {
				long temp = arr[i];
				while ((double) arr[i] <= (double) b / (double) temp) {
					if ((double) arr[i] >= (double) a / (double) temp) {
						count += 1;
					}
					temp *= arr[i];
				}
			}
		}

		System.out.println(count);
	}
}