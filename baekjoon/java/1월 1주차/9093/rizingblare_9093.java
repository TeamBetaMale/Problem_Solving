import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            String[] strings = s.split(" ");

            for (String string : strings) {

                for (int j = 0; j < string.length(); j++) {
                    sb.append(string.charAt(string.length()-j-1));
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
    
}