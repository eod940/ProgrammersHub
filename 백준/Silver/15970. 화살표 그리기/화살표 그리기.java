import java.util.*;
import java.io.*;


public class Main {

	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static Dot[] dots;

	static class Dot implements Comparable<Dot> {
		// loc: 위치, col = 색깔
		int loc, col;

		@Override
		public int compareTo(Dot other) {
			if (col != other.col) {
				return col - other.col;
			}
			return loc - other.loc;
		}
	}

	public static void main(String[] args) throws IOException {
		int answer = 0;
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dots = new Dot[N];

		for(int i = 0; i < N; i++) {
			dots[i] = new Dot();
			st = new StringTokenizer(br.readLine());
			dots[i].loc = Integer.parseInt(st.nextToken());
			dots[i].col = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(dots);

		for(int i = 0; i < N; i++) {
			int leftDist = toLeft(dots[i], i);
			int rightDist = toRight(dots[i], i);
			answer += Math.min(leftDist, rightDist);
		}

		System.out.println(answer);
	}

	static int toLeft(Dot curDot, int idx) {
		// curDot: 현재위치의 점
		// color인 점의 왼쪽으로 확인해서 최솟값 확인
		// 만약 왼쪽에 같은 color의 점이 없다면 MAX값 리턴
		if (idx == 0) return Integer.MAX_VALUE;
		if (curDot.col != dots[idx-1].col) return Integer.MAX_VALUE;
		return curDot.loc - dots[idx-1].loc;
	}

	static int toRight(Dot curDot, int idx) {
		// curDot: 현재 위치의 점
		// color인 점의 오른쪽으로 확인해서 최솟값 확인
		// 만약 왼쪽에 같은 color의 점이 없다면 MAX값 리턴
		if (idx == N - 1) return Integer.MAX_VALUE;
		if (curDot.col != dots[idx+1].col) return Integer.MAX_VALUE;
		return dots[idx+1].loc - curDot.loc;
	}
}