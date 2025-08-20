import java.util.*;

class Meeting {
    int start, end, pos;
    Meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

public class MaxMeetings {

    static void maxMeetings(int[] start, int[] end) {
        int n = start.length;   // ✅ initialized inside

        List<Meeting> meet = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meet.add(new Meeting(start[i], end[i], i + 1));
        }

        // sort by end time, then by position
        Collections.sort(meet,
            Comparator.comparingInt((Meeting m) -> m.end)
                      .thenComparingInt(m -> m.pos));

        List<Integer> answer = new ArrayList<>();
        answer.add(meet.get(0).pos);
        int limit = meet.get(0).end;

        for (int i = 1; i < n; i++) {
            if (meet.get(i).start > limit) {
                limit = meet.get(i).end;
                answer.add(meet.get(i).pos);
            }
        }

        System.out.println("The order in which the meetings will be performed is:");
        for (int pos : answer) {
            System.out.print(pos + " ");
        }

        // ✅ print max meetings
        System.out.println("\nMax meetings = " + answer.size());
    }

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end   = {2, 4, 5, 7, 9, 9};
        maxMeetings(start, end);
    }
}
