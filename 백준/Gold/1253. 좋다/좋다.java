import java.util.*;
import java.io.*;

// 좋다 (좋은수 찾기)
public class Main {

	static int n, count;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		for (int i = 0; i < n; i++) {
			int cur = arr[i];
			int x = 0;
			int y = n - 1;

			while(x < y) {
				if (arr[x] + arr[y] < cur) {
					x += 1;
				} else if (arr[x] + arr[y] > cur) {
					y -= 1;
				} else {
					if (x == i) {
						x += 1;
					} else if (y == i) {
						y -= 1;
					} else {
						count += 1;
						break;
					}
				}
			}
		}

		System.out.print(count);
	}
}