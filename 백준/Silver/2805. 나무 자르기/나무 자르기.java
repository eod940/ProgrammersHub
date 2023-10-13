import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long l = 0, r = 2000000000, ans = 0;
		while (l <= r) {
			long mid = (l + r) / 2;
			if (determination((int)mid)) {
				ans = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		System.out.println(ans);
	}

	static boolean determination(int h){
		long sum = 0;
		for (int i = 1; i <= n; i++) {
			if (arr[i] > h) {
				sum += arr[i] - h;
			}
		}
		return sum >= m;
	}
}