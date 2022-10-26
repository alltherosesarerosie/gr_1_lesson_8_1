package kg.geektech.game.players;

public class Golem extends Hero{

    public Golem(int health, int damage, String name) {
        super(health, damage, SuperAbility.TAKE_PART_OF_DAMAGE, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int i = 0;
        int savedPoints = boss.getDamage()/5;
        for (Hero hero: heroes) {
            if (hero!=this){
                hero.setHealth(hero.getHealth()+ savedPoints);
                this.setHealth(this.getHealth()-savedPoints);
                i+=savedPoints;
            }
        }
        System.out.println("Golem took "+i);
    }
}
