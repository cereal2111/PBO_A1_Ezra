class Potion extends Item {
    private int duration;
    private int effectPoint;
    private String type;

    public Potion(String name, String rank, double price, int duration, int effectPoint, String type) {
        super(name, rank, price);
        this.duration = duration;
        this.effectPoint = effectPoint;
        this.type = type;
    }

    public void use(String input) {
        if ("Attack".equalsIgnoreCase(type)) {
            System.out.println("Damage dealt by " + effectPoint);
        } else if ("Heal".equalsIgnoreCase(type)) {
            System.out.println("Healed by " + effectPoint);
        } else {
            System.out.println("Invalid potion type");
        }
    }

    // Getters and Setters
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getEffectPoint() {
        return effectPoint;
    }

    public void setEffectPoint(int effectPoint) {
        this.effectPoint = effectPoint;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
