import java.util.*;
import java.io.*;

public class Main {
	static int k;
	static boolean isEven;
	static boolean[] visited;
	static ArrayList<Integer>[] adj;
	static int[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());

		for (int t = 0; t < k; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			adj = new ArrayList[v + 1];
			visited = new boolean[v + 1];
			check = new int[v + 1];
			isEven = true;

			for (int i = 1; i <= v; i++) {
				adj[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				adj[start].add(end);
				adj[end].add(start);
			}
			// 주어진 그래프가 1개로 연결돼 있다는 보장이 없으므로 모든 노드에서 수행
			for (int i = 1; i <= v; i++) {
				if (isEven) dfs(i);
				else break;
			}
			if (isEven)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

	static void dfs(int node) {
		visited[node] = true;
		for (int i : adj[node]) {

			if (!visited[i]) {
				check[i] = (check[node] + 1) % 2;  // 인접노드는 같은 집합 x
				dfs(i);
			}
			// 이미 방문한 노드가 현재 노드와 같은 집합이면 x
			else if (check[node] == check[i]) {
				isEven = false;
			}
		}
	}
}