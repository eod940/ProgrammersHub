import java.util.*;
import java.io.*;

public class Main {
    static long a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        
        long n = gcd(a, b);
        
        for (int i = 0; i < n; i++) {
            sb.append("1");
        }
        bw.write(sb + "\n");
        bw.flush();
        bw.close();
    }
    
    static long gcd(long a, long b) {
        if (b != 0) {
            return gcd (b, a % b);
        } else {
            return a;
        }
    }
}