import java.util.*;

public class Main {
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] plusGrp = str.split("-");

		for (int i = 0; i < plusGrp.length; i++) {
			int tmp = mySum(plusGrp[i]);
			if (i == 0)
				n += tmp;
			else 
				n -= tmp;
		}

		System.out.println(n);
	}

	static int mySum(String s) {
		int sum = 0;
		String tmp[] = s.split("[+]");
		for (int i = 0; i < tmp.length; i++) {
			sum += Integer.parseInt(tmp[i]);
		}
		return sum;
	}
}