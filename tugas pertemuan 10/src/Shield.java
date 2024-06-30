class Shield extends Item {
    private int damageBlock;

    public Shield(String name, String rank, double price, int damageBlock) {
        super(name, rank, price);
        this.damageBlock = damageBlock;
    }

    public void defense() {
        System.out.println("Damage Mitigated by " + damageBlock);
    }

    // Getters and Setters
    public int getDamageBlock() {
        return damageBlock;
    }

    public void setDamageBlock(int damageBlock) {
        this.damageBlock = damageBlock;
    }
}