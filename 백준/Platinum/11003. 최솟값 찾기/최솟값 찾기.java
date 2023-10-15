import java.util.*;
import java.io.*;

public class Main {
	
	static int n, l, min = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Deque<Node> deque = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			int now = Integer.parseInt(st.nextToken());
			// 새로운 값이 들어올 때마다 정렬 대신 현재 수보다 큰 값을 덱에서 제거해 시간 복잡도를 줄임

			while (!deque.isEmpty() && deque.getLast().value > now) {
				deque.removeLast();
			}
			deque.addLast(new Node(now, i));
			// 범위에서 벗어난 값은 덱에서 제거
			if (deque.getFirst().index <= i - l) {
				deque.removeFirst();
			}
			bw.write(deque.getFirst().value + " ");
		}
		bw.flush();
		bw.close();
	}

	static class Node {
		public int value;
		public int index;

		Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}
}