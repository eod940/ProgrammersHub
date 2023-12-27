import java.util.*;
import java.io.*;

public class Main {

	static long N, MAX;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Long, Integer> map = new HashMap<>();
		N = Integer.parseInt(br.readLine());
		MAX = Long.MIN_VALUE;
		long answer = 0;


		for (int i = 0; i < N; i++) {
			long num = Long.parseLong(br.readLine());
			map.put(num, map.getOrDefault(num, 0) + 1);
			
			if (map.get(num) > MAX) {
				MAX = map.get(num);
				answer = num;
			} else if (map.get(num) == MAX) {
				answer = Math.min(answer, num);
			}
		}

		System.out.println(answer);
	}
}