import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int m;
	static int[] answer;
	static boolean[] visited;
	static ArrayList<Integer>[] adj;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		adj = new ArrayList[n + 1];
		answer = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			adj[s].add(e);
		}

		for (int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			bfs(i);
		}

		int max = 0;
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, answer[i]);
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			if (answer[i] == max) sb.append(i + " ");
		}
		System.out.println(sb);
	}

	static void bfs(int idx) {
		Queue<Integer> que = new LinkedList<>();
		que.add(idx);
		visited[idx] = true;

		while (!que.isEmpty()) {
			int cur = que.poll();
			for (int i : adj[cur]) {

				if (visited[i] == false) {
					visited[i] = true;
					answer[i] += 1;
					que.add(i);
				}
			}
		}
	}
}