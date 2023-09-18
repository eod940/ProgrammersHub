import java.util.*;
import java.io.*;

public class Main {

	static int n, m, start;
	static boolean[] visited;
	static ArrayList<Integer>[] list;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		list = new ArrayList[n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			list[x].add(y);
			list[y].add(x);
		}

		for (int i = 1; i <= n; i++) {
			Collections.sort(list[i]);
		}

		dfs(start);
		sb.append("\n");
		for (int i = 1; i <= n; i++) visited[i] = false;
		bfs(start);

		System.out.print(sb);
	}

	static void bfs(int x) {
		Queue<Integer> que = new LinkedList<>();

		que.add(x);
		visited[x] = true;

		while (!que.isEmpty()) {
			x = que.poll();
			sb.append(x).append(" ");

			for (int y : list[x]) {
				if (visited[y]) continue;
				que.add(y);
				visited[y] = true;
			}
		}

	}

	static void dfs(int x) {
		visited[x] = true;
		sb.append(x).append(" ");

		for (int y : list[x]) {
			if (visited[y]) continue;
			dfs(y);
		}

	}
}