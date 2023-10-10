import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, 1, n + 1);

		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= m; i++) {
			int x = Integer.parseInt(st.nextToken());

			if (search(arr, 1, n, x)) System.out.println(1);
			else System.out.println(0);
		}
	}

	static boolean search(int[] A, int L, int R, int X) {

		while (L <= R) {
			int mid = (L + R) / 2;
			if (A[mid] < X) {
				L = mid + 1;
			} else if (A[mid] > X){
				R = mid - 1;
			} else {
				return true;
			}
		}
		return false;
	}
}