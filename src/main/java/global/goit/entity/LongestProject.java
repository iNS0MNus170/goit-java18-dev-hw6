package global.goit.entity;

public class LongestProject {
    private String name;
    private int monthCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name - " + name +
                ", monthCount - " + monthCount + "\n";
    }

    public void setMonthCount(int monthCount) {
        this.monthCount = monthCount;
    }
}
