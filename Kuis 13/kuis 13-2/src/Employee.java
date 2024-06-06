abstract class Employee {
    protected String name;
    protected String dob;
    protected String id;
    protected double salary;

    public Employee(String name, String dob, String id) {
        this.name = name;
        this.dob = dob;
        this.id = id;
        setSalary();
    }

    public static String[] getDepartment() {
        return new String[]{"Product", "Human Resources"};
    }

    protected abstract void setSalary();

    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, DOB: %s, Salary: %.2f", id, name, dob, salary);
    }
}


