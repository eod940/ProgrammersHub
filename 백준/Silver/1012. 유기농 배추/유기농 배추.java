import java.util.*;
import java.io.*;

public class Main {
	static int t, n, m, k;
	static int[][] field;
	static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			field = new int[n][m];
			visited = new boolean[n][m];

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				field[x][y] = 1;
			}

			int wCnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!visited[i][j] && field[i][j] == 1) {
						wCnt += 1;
						dfs(i, j);
					}
				}
			}
			System.out.println(wCnt);
		}
		
	}

	static void dfs(int x, int y) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
			if (visited[nx][ny]) continue;
			if (field[nx][ny] == 0) continue;
			dfs(nx, ny);
		}
	}
}