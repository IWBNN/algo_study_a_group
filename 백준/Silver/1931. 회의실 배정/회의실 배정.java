import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Meeting[] meetings = new Meeting[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer( br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(start, end);
        }

        Arrays.sort(meetings, (a,b) -> {
            if (a.end == b.end) {
                return a.start - b.start;
            }
            return a.end - b.end;
        });

        int count = 0;
        int prevEnd = 0;

        for (Meeting meeting : meetings) {
            if (meeting.start >= prevEnd) {
                count++;
                prevEnd = meeting.end;
            }
        }
        System.out.println(count);
    }
}

class Meeting {
    int start;
    int end;

    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
