import java.io.*;
import java.util.*;

public class Main{
	static int n, m;
	static int[] dx = {-1, 1, 0, 0};  // 상하좌우
	static int[] dy = {0, 0, -1, 1};  // 상하좌우
	static int[][] box;
	static Queue<tomato> que;

	static class tomato {
		int x; // 세로
		int y; // 가로
		tomato(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		box = new int[n][m];
		que = new LinkedList<tomato>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());

				if (box[i][j] == 1) {
					// 익은 토마토 큐에 넣기	
					que.add(new tomato(i, j));
				}
			}
		}

		System.out.print(bfs());
	}

	private static int bfs()  {
		while (!que.isEmpty()) {
			tomato t = que.poll();

			int x = t.x;
			int y = t.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				// 범위 안에서
				if  (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					// 토마토 안익으면
					if (box[nx][ny] == 0) {
						// 익은 토마토 추가
						que.add(new tomato(nx, ny));

						// 익은 날짜를 얻기 위해 그 전 값에서 1증가
						box[nx][ny] = box[x][y] + 1;
					}
				}
			}
		}
		// 최대 날짜
		int result = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 토마토 안익었으면
				if (box[i][j] == 0) return -1;

				// 날짜 최대값 구하기
				result = Math.max(result, box[i][j]);
			}
		}
		// 토마토가 모두 익은 상태인 경우
		if (result == 1) 
			return 0;
		else 
			return result - 1;
	}

}