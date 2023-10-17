import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		selected = new int[m + 1];

		recur(1);

		System.out.println(sb);
	}

	static void recur(int k) {
		if (k == m + 1) {
			for (int i = 1; i <= m; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
		} else {
			int start = 1;
			if (k > 1) start = selected[k - 1];

			for (int i = start; i <= n; i++) {
				selected[k] = i;
				recur(k + 1);
				selected[k] = 0;
			}
		}
	}
}