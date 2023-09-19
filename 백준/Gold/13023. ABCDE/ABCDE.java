import java.util.*;
import java.io.*;

public class Main {

	static int n, m;
	static boolean arrived;
	static boolean[] visited;
	static ArrayList<Integer>[] adj;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arrived = false;
		adj = new ArrayList[n];
		visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			adj[x].add(y);
			adj[y].add(x);
		}

		for (int i = 0; i < n; i++) {
			dfs(i, 1);
			if (arrived) break;
		}

		if (arrived) System.out.println("1");
		else System.out.println("0");
	}

	static void dfs(int x, int depth) {
		if (depth == 5 || arrived) {
			arrived = true;
			return;
		}

		visited[x] = true;

		for (int i : adj[x]) {
			if (!visited[i]) {
				dfs(i, depth + 1);
			}
		}
		visited[x] = false;
	}
}