import java.util.*;
import java.io.*;

public class Main {
	static int k, n, max;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		max = Integer.MAX_VALUE;
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[k + 1];

		for (int i = 1; i <= k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}

		long l = 1;
		long r = max, ans = 0;
		while (l <= r) {
			long mid = (l + r) / 2;
			if (determination(mid)) {
				ans = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		System.out.println(ans);
	}

	static boolean determination(long len) {
		// len 만큼의 길이로 랜선들을 잘랐을 때, N 개 만큼의 랜선을 얻을 수 있는가?
		long sum = 0;
		for (int i = 1; i <= k; i++) 
			sum += arr[i] / len;
		return sum >= n;
	}
}