import java.util.*;
import java.io.*;

public class Main {

	static int n, one, zero ,sum;
	static PriorityQueue<Integer> plusQue, minusQue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		plusQue = new PriorityQueue<>(Collections.reverseOrder());
		minusQue = new PriorityQueue<>();

		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int k = Integer.parseInt(br.readLine());

			if (k > 1) {
				plusQue.add(k);
			} else if (k == 1) {
				one += 1;
			} else if (k == 0) {
				zero += 1;
			} else {
				minusQue.add(k);
			}
		}

		while (plusQue.size() > 1) {
			int first = plusQue.remove();
			int second = plusQue.remove();
			sum += first * second;
		}

		if (!plusQue.isEmpty()) {
			sum += plusQue.remove();
		}

		while (minusQue.size() > 1) {
			int first = minusQue.remove();
			int second = minusQue.remove();
			sum += first * second;
		}

		if (!minusQue.isEmpty()) {
			if (zero == 0) {
				sum += minusQue.remove();
			}
		}

		sum += one;

		System.out.println(sum);
	}
}