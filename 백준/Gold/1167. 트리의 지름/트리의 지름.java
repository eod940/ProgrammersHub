import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int[] dist;
	static boolean[] visited;
	static ArrayList<Node>[] adj;
	
	static class Node {
		int node;
		int weight;

		Node(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dist = new int[n + 1];
		visited = new boolean[n + 1];
		adj = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			while (true) {
				int e = Integer.parseInt(st.nextToken());
				if (e == -1) break;
				int v = Integer.parseInt(st.nextToken());
				adj[s].add(new Node(e, v));
			}
		}

		bfs(1);
		int max = 1;
		for (int i = 2; i <= n; i++) {
			if (dist[max] < dist[i]) 
				max = i;
		}

		dist = new int [n + 1];
		visited = new boolean [n + 1];
		bfs(max);
		Arrays.sort(dist);

		System.out.println(dist[n]);
	}

	static void bfs(int idx) {
		Queue<Integer> que = new LinkedList<>();
		que.add(idx);
		visited[idx] = true;

		while (!que.isEmpty()) {
			int cur = que.poll();
			for (Node v : adj[cur]) {
				int node = v.node;
				int weight = v.weight;
				if (!visited[node]) {
					visited[node] = true;
					que.add(node);
					dist[node] = dist[cur] + weight;
				}
			}

		}
	}
}