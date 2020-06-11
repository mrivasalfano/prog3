package ej3;

public class Activity implements Comparable<Activity>{
    private String resource;
    private int start;
    private int end;

    public Activity(String resource, int start, int end) {
        this.resource = resource;
        this.start = start;
        this.end = end;
    }

    public String getResource() {
        return resource;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public int compareTo(Activity o) {
        return this.getEnd() - o.getEnd();
    }
}
