package characters;

import java.util.Arrays;

public class Monster {

    private int attack;

    private int defense;

    private final int[] damage = new int[2];

    private int health;

    public Monster(int attack, int defense, int health, int[] damage) {
        if (attack >= 1 && attack <= 30) this.attack = attack;
        else System.out.println("Атака должна быть от 1 до 30!");

        if (defense >= 1 && defense <= 30) this.defense = defense;
        else System.out.println("Защита должна быть от 1 до 30!");

        if (damage[1] > 0 && damage[0] > 0) {
            this.damage[0] = Math.min(damage[0], damage[1]);
            this.damage[1] = Math.max(damage[0], damage[1]);
        } else System.out.println("Урок должен быть больше 0!");

        if (health > 0) this.health = health;
        else System.out.println("Здоровье должно быть больше 0!");
    }

    public void attackOnPlayer(Player player) {
        if (isDead()) return;
        if (playerIsDead(player)) return;

        int modifierAttack = this.getAttack() - player.getDefense() - 1;

        if (modifierAttack < 1)
            modifierAttack = 1;

        while (modifierAttack != 0) {
            modifierAttack--;

            int cubeNumber = (int) (Math.random() * 6) + 1;

            if (cubeNumber == 5 || cubeNumber == 6) {
                int damageAttack = (int) (Math.random() * this.getDamage()[1] - this.getDamage()[0] + 1) + this.getDamage()[0];

                player.setHealth(player.getHealth() - damageAttack);

                break;
            }
        }

    }

    boolean isDead() {
        if (this.health < 1) {
            System.out.println("Этот монстр умер!");
            this.health = 0;
            return true;
        }
        return false;
    }

    boolean playerIsDead(Player player) {
        if (player.getHealth() < 1) {
            System.out.println("Этот игрок умер!");
            player.setHealth(0);
            return true;
        }
        return false;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int[] getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (isDead()) return;
        this.health = health;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "attack=" + attack +
                ", defense=" + defense +
                ", damage=" + Arrays.toString(damage) +
                ", health=" + health +
                '}';
    }

}
