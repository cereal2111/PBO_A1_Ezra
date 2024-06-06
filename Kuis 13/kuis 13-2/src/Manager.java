class Manager extends Employee {
    public Manager(String name, String dob, String id) {
        super(name, dob, id);
    }

    @Override
    protected void setSalary() {
        this.salary = 20000000;
    }
}
