import java.util.*;

public class Main {
	
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> que = new LinkedList<>();

		n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			que.add(i);
		}

		while (que.size() > 1) {
			que.remove();
			que.add(que.poll());
		}
		System.out.println(que.poll());
	}
}