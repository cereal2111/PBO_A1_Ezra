class HRStaff extends Employee {
    public HRStaff(String name, String dob, String id) {
        super(name, dob, id);
    }

    @Override
    protected void setSalary() {
        this.salary = 5000000;
    }
}

