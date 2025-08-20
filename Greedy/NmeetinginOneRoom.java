import java.util.*;

class meeting {
    int start;
    int end;
    int pos;

    meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

public class Meeting {
    static void maxMeetings(int start[], int end[], int n) {
        ArrayList<meeting> meet = new ArrayList<>();

        for (int i = 0; i < n; i++)
            meet.add(new meeting(start[i], end[i], i + 1));

        // simpler comparator
        Collections.sort(meet, 
            Comparator.comparingInt((meeting m) -> m.end)
                      .thenComparingInt(m -> m.pos));

        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(meet.get(0).pos);
        int limit = meet.get(0).end;

        for (int i = 1; i < n; i++) {
            if (meet.get(i).start > limit) {
                answer.add(meet.get(i).pos);
                limit = meet.get(i).end;
            }
        }

        System.out.println("The order in which the meetings will be performed is ");
        for (int pos : answer) {
            System.out.print(pos + " ");
        }
    }

    public static void main(String args[]) {
        int n = 6;
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 5, 7, 9, 9};
        maxMeetings(start, end, n);
    }
}

===============================


  Time Complexity: O(n log n) (because of sorting)

Space Complexity: O(n) (for storing meetings & answer list)
