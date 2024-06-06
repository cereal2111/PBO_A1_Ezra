class Developer extends Employee {
    public Developer(String name, String dob, String id) {
        super(name, dob, id);
    }

    @Override
    protected void setSalary() {
        this.salary = 10000000;
    }
}
