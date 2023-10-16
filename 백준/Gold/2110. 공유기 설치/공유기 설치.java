import java.io.*;
import java.util.*;

public class Main {
  static int c, n;
  static int[] arr;
    
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    arr = new int[n + 1];

    int max = Integer.MIN_VALUE;
    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      max = Math.max(max, arr[i]);
    }

    Arrays.sort(arr, 1, n + 1);

    int l = 1, r = max, ans = 0;
    while (l <= r) {
      int mid = (l + r) / 2;
      if (determination(mid)) {
        ans = mid;
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }

    System.out.println(ans);
  }

  static boolean determination(int d) {
    // d만큼의 거리 차이를 둔다면 c개 만큼의 공유기를 설치할 수 있는가?

    // 제일 왼쪽 집부터 가능한 많이 설치해보자
    // d만큼의 거리를 두면서 최대로 설치한 개수와 c를 비교하자.

    int cnt = 1, last = arr[1];
    for (int i = 2; i <= n; i++) {
      // 이번에 arr[i]에 설치가 가능한가?
      if (arr[i] - last >= d) {
        cnt += 1;
        last = arr[i];
      }
    }
    return cnt >= c;
  }
}