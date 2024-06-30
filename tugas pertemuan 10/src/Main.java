
public class Main {
    public static void main(String[] args) {
        Potion attackPotion = new Potion("Fire Potion", "A", 100, 10, 50, "Attack");
        Potion healPotion = new Potion("Healing Potion", "B", 80, 5, 30, "Heal");
        Sword sword = new Sword("Excalibur", "S", 200, 70);
        Shield shield = new Shield("Dragon Shield", "S", 150, 60);

        attackPotion.use("Attack");
        healPotion.use("Heal");
        sword.attack();
        shield.defense();
    }
}
