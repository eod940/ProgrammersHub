import java.io.*;
import java.util.*;

public class Main {
	static int n, m, max;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(arr[i], max);
		}
		m = Integer.parseInt(br.readLine());

		int l = 0, r = max, ans = 0;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (determination(mid)) {
				ans = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		System.out.println(ans);
	}

	static boolean determination(int limit) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			if (arr[i] < limit)
				sum += arr[i];
			else 
				sum += limit;
		}
		return sum <= m;
	}
}