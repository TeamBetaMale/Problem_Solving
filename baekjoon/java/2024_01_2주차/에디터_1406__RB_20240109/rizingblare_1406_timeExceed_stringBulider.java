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
        private StringBuilder sb;
        private int cursor;

        public MyEditor(String S) {
            this.sb = new StringBuilder();
            this.sb.append(S);
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
                if (cursor != sb.length()) {
                    cursor++;
                }
            }

            else if (cmd.equals("B")) {
                if (cursor != 0) {
                    delete();
                }
            }
        }

        public void print() {
            System.out.println(sb);
        }

        private void delete() {
            sb.delete(cursor-1, cursor);
            cursor--;
        }

        private void insert(char c) {
            sb.insert(cursor, c);
            cursor++;
        }
    }
}