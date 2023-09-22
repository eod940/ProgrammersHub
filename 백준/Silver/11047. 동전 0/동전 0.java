import java.io.*;
import java.util.*;

public class Main {

	static int n, k, count;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = n - 1; i > -1; i--) {
			if (arr[i] <= k) {
				count += (k / arr[i]);
				k %= arr[i];
			}
		}

		System.out.println(count);
	}
}