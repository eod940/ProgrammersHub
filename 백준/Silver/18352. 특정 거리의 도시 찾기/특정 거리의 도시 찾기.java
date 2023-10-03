import java.util.*;

public class Main {
	static int n, m, k, x;
	static int[] visited;
	static List<Integer> answer;
	static ArrayList<Integer>[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();  // 노드의 수
		m = sc.nextInt();  // 엣지의 수
		k = sc.nextInt();  // 목표 거리
		x = sc.nextInt();  // 시작점
		arr = new ArrayList[n + 1];
		answer = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			arr[s].add(e);
		}

		visited = new int[n + 1];  // 방문 배열 초기화
		for (int i = 0; i <= n; i++) {
			visited[i] = -1;
		}

		bfs(x);
		for (int i = 0; i <= n; i++) {
			if (visited[i] == k) {
				answer.add(i);
			}
		}
		if (answer.isEmpty()) {
			System.out.println("-1");
		} else {
			Collections.sort(answer);
			for (int temp : answer) {
				System.out.println(temp);
			}
		}
	}

	static void bfs(int node) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(node);
		visited[node] += 1;

		while (!que.isEmpty()) {
			int cur = que.poll();
			for (int i : arr[cur]) {
				if (visited[i] == -1) {
					visited[i] = visited[cur] + 1;
					que.add(i);
				}
			}
		}
	}
}