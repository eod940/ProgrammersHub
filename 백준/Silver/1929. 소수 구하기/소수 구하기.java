import java.util.*;
import java.io.*;

public class Main{
	static int m, n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n + 1];
		
		for (int i = 2; i <= n; i++) {
			arr[i] = i;
		}

		for (int i = 2; i <= n / 2; i++) {
			if (arr[i] == 0) continue;

			for (int j = 2 * i; j <= n; j += i) {
				arr[j] = 0;
			}
		}

		// 출력
		for (int i = m; i <= n; i++) {
			if (arr[i] != 0) 
				System.out.println(arr[i]);
		}
	}
}