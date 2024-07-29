package Part1.Ch05.BOJ1931;

public class Meeting implements Comparable<Meeting>{
    private int start;
    private int end;
    private int term;

    public Meeting() {
    }

    public Meeting(int start, int end, int term) {
        this.start = start;
        this.end = end;
        this.term = term;
    }

    @Override
    public int compareTo(Meeting o) {
        if(end == o.end) // 끝나는 시간이 같으면
            return start - o.start;
        return end - o.end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getTerm() {
        return term;
    }
}
