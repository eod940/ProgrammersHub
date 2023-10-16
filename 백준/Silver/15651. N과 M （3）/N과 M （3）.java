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
			for (int i = 1; i <= m; i++)
				sb.append(selected[i]).append(" ");
			sb.append("\n");
		}
		else {
			for (int i = 1; i <= n; i++) {
				selected[k] = i;
				// k+1 ~ m 까지 모두 탐색하는 일을 해야함
				recur(k + 1);
				selected[k] = 0;
			}
		}
	}
}