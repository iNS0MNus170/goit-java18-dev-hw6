package global.goit.entity;

public class MaxProjectCountClient {
    private String name;
    private int projectCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name - " + name +
                ", projectCount - " + projectCount + "\n";
    }

    public void setProjectCount(int projectCount) {
        this.projectCount = projectCount;
    }
}

