import java.util.*;
import java.io.*;

public class Main{
	static int a, b, c;
	static int[] sender = {0, 0, 1, 1, 2, 2};
	static int[] receiver = {1, 2, 0, 2, 0, 1};  // 6가지 이동 케이스 표현을 위한 배열
	static boolean[][] visited;  // A, B의 무게만 있으면 C의 무게가 고정되므로 2개만 체크
	static boolean[] answer;
	static int[] abc;  // 물의 현재 양 저장

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		abc = new int[3];
		abc[0] = Integer.parseInt(st.nextToken());
		abc[1] = Integer.parseInt(st.nextToken());
		abc[2] = Integer.parseInt(st.nextToken());
		visited = new boolean[201][201];
		answer = new boolean[201];

		bfs();
		for (int i = 0; i < answer.length; i++) {
			if (answer[i]) System.out.print(i + " ");
		}
	}

	static void bfs() {
		Queue<AB> que = new LinkedList<>();
		que.add(new AB(0, 0));
		visited[0][0] = true;
		answer[abc[2]] = true;

		while (!que.isEmpty()) {
			AB p = que.poll();
			int a = p.A;
			int b = p.B;
			int c = abc[2] - a - b;  // c는 전체 물의 양에서 a와 b를 뺀 것
			for (int k = 0; k < 6; k++) {  // AB, AC, BA, BC, CA, CB
				int[] next = {a, b, c};
				next[receiver[k]] += next[sender[k]];
				next[sender[k]] = 0;

				if (next[receiver[k]] > abc[receiver[k]]) {  // 물이 넘칠 때
					// 초과하는 만큼 다시 이전 물통에 넣어 줌
					next[sender[k]] = next[receiver[k]] - abc[receiver[k]];
					next[receiver[k]] = abc[receiver[k]];  // 대상 물통은 최대로 채움
				}

				if (!visited[next[0]][next[1]]) {  // A와 B의 물의 양을 이용해 방문 배열 체크
					visited[next[0]][next[1]] = true;
					que.add(new AB(next[0], next[1]));

					if (next[0] == 0) {  // A의 물의 양이 0일때 C의 물의 무게를 정답 변수에 저장
						answer[next[2]] = true;
					}
				}
			}
		}
	}

	static class AB {
		int A;
		int B;

		public AB(int A, int B) {
			this.A = A;
			this.B = B;
		}
	}
}