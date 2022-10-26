package kg.geektech.game.players;

import kg.geektech.game.genaral.RPG_Game;

public class Hacker extends Hero{
    private int hackers_point = 10;
    public Hacker(int health, int damage, String name) {
        super(health, damage,  SuperAbility.HACKER_ABILITY, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if ((RPG_Game.getRoundNumber()%2)==0){
            int ind = RPG_Game.random.nextInt(heroes.length);
            boss.setHealth(boss.getHealth()-hackers_point);
            heroes[ind].setHealth(heroes[ind].getHealth()+hackers_point);
            System.out.println("Hacker gave to "+heroes[ind].getName()+" "+hackers_point);
        }

    }
}
