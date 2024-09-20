package global.goit.entity;

public class MaxSalaryWorker {
    private String name;
    private int salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name - " + name +
                ", salary - " + salary + "\n";
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
