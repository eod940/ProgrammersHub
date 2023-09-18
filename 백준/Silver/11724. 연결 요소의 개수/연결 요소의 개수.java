import java.util.*;
import java.io.*;

public class Main {

	static int n, m;
	static ArrayList<Integer>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		list = new ArrayList[n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			list[start].add(end);
			list[end].add(start);
		}

		int count = 0;
		for (int i = 1; i < n + 1; i++) {
			if (!visited[i]) {
				count += 1;
				dfs(i);
			}
		}

		System.out.println(count);
	}

	public static void dfs(int v) {
		if (visited[v]) {
			return;
		}

		visited[v] = true;
		for (int i : list[v]) {
			if (!visited[i]) {
				dfs(i);
			}
		}
	}
}