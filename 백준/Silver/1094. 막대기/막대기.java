import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cm = Integer.parseInt(br.readLine());
        int stick = 64;
        int count = 0;
        while(cm != 0){
            if (cm < stick){
                stick = stick/2;
            }
            else{
                cm = cm - stick;
                count++;
                if(cm==0) {
                    break;
                }
            }
        }
        bw.write(count + "");
        bw.flush();
        bw.close();
    }
}
