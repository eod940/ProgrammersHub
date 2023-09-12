import java.util.*;
import java.io.*;

public class Main {

	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pQue = new PriorityQueue<>((o1, o2) -> {
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);

			if (abs1 != abs2) 
				return abs1 - abs2;  // 일반적인 오름차순 (음수, 0 = 그대로 / 양수 = 자리 변)
			else 
				return o1 > o2 ? 1 : -1;
		});

		for (int i = 0; i < n; i++) {
			int req = Integer.parseInt(br.readLine());

			if (req != 0) {
				pQue.add(req);
			} else {
				if (!pQue.isEmpty()) 
					System.out.println(pQue.poll());
				else 
					System.out.println("0");
			}
		}
	}
}