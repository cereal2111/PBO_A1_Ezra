class Sword extends Item {
    private int damage;

    public Sword(String name, String rank, double price, int damage) {
        super(name, rank, price);
        this.damage = damage;
    }

    public void attack() {
        System.out.println("Damage dealt by " + damage);
    }

    // Getters and Setters
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}