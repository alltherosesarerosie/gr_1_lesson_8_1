package kg.geektech.game.players;

public class Witcher extends Hero{
    public Witcher(int health, int damage, String name) {
        super(health, damage, SuperAbility.SAVE_ONE_LIFE, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (Hero hero:heroes) {
            if (hero.getHealth()==0 && hero!=this){
                hero.setHealth(this.getHealth());
                System.out.println("witcher save "+hero.getName()+", give him or her "+getHealth());
                this.setHealth(0);
                break;
            }
        }

    }
}
