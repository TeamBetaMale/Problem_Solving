import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {

        String S = br.readLine();

        int M = Integer.parseInt(br.readLine());

        MyEditor editor = new MyEditor(S);

        for (int i = 0; i < M; i++) {
            String cmd = br.readLine();

            editor.getCommand(cmd);
        }

        editor.print();
    }


    private static class MyEditor {
        private final char[] chars;
        private int endpoint;
        private int cursor;

        public MyEditor(String S) {
            chars = new char[600001];
            for (int i = 0; i < S.length(); i++) {
                chars[i] = S.charAt(i);
            }
            endpoint = S.length();
            cursor = S.length();
        }


        public void getCommand(String cmd) {

            if (cmd.split(" ").length == 2) {
                insert(cmd.split(" ")[1].charAt(0));
            }

            else if (cmd.equals("L")) {
                if (cursor != 0){
                    cursor--;
                }
            }

            else if (cmd.equals("D")) {
                if (cursor != endpoint) {
                    cursor++;
                }
            }

            else if (cmd.equals("B")) {
                if (cursor != 0) {
                    delete();
                }
            }

//            printAll();
//            print();
        }

        public void print() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < endpoint; i++) {
                sb.append(chars[i]);
            }
            System.out.println(sb);
        }
//
//        private void printAll() {
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < 20; i++) {
//                sb.append(chars[i]);
//            }
//            System.out.println(sb);
//        }

        private void delete() {
            for (int i = cursor-1; i < endpoint; i++) {
                chars[i] = chars[i+1];
            }
            endpoint--;
            cursor--;
        }

        private void insert(char s) {
            for (int i = endpoint; i > cursor; i--) {
                chars[i] = chars[i-1];
            }
            chars[cursor] = s;
            endpoint++;
            cursor++;
        }
    }
}