package kg.geektech.game.players;

public class Berserk extends Hero {
    private int savedDamage;


    public Berserk(int health, int damage, String name) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT, name);
    }



    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        this.savedDamage= boss.getDamage()/5;
        this.setHealth(this.getHealth()+this.savedDamage);
        boss.setHealth(boss.getHealth()-this.savedDamage);
        System.out.println("Boss got Berserk's saved damage "+this.savedDamage);
    }
}
