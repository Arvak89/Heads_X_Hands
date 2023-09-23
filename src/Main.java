import characters.Monster;
import characters.Player;

public class Main {
    public static void main(String[] args) {
        Player player = new Player(15, 7, 25, new int[]{9, 13});
        Monster monster1 = new Monster(8, 4, 12, new int[]{4, 6});
        Monster monster2 = new Monster(12, 8, 19, new int[]{8, 10});

        for (int i = 0; i < 3; i++) {
            monster1.attackOnPlayer(player);
            monster2.attackOnPlayer(player);

            player.healMyself();

            player.attackOnMonster(monster2);
        }

        for (int i = 0; i < 2; i++) {
            monster1.attackOnPlayer(player);
            monster2.attackOnPlayer(player);

            player.healMyself();

            player.attackOnMonster(monster1);
        }

        System.out.println(monster1);
        System.out.println(monster2);
        System.out.println(player);
    }
}