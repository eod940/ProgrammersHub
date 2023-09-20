import java.util.*;
import java.io.*;

public class Main {

	static int n, m, x1, y1, x2, y2;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n + 1][n + 1];
		int[][] brr = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				brr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] = arr[i][j - 1] + arr[i - 1][j] - arr[i - 1][j - 1] + brr[i][j];
			}
		}

		for (int i = 0; i < m; i++) {
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			sum = arr[x2][y2] - arr[x1 - 1][y2] - arr[x2][y1 -1] + arr[x1 - 1][y1 - 1];
			System.out.println(sum);
		}
	}
}