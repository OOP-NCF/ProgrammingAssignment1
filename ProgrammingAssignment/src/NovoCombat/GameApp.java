package NovoCombat;
import java.util.Scanner;

import java.util.Scanner;

public class GameApp {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        int playerHealth = 15;

        System.out.println("=========== BATTLE SIMULATION ===========\n");

        System.out.print("Enter your player name: ");
        String playerName = scnr.nextLine();
        System.out.println("Initial Player Health : "+playerHealth);

        System.out.println("\nAvailable weapons:");
        System.out.println("1. Dagger (Base Damage: 8)");
        System.out.println("2. Sword (Base Damage: 12)");
        System.out.println("3. Axe (Base Damage: 10)");

        System.out.print("Enter weapon name: ");
        String weaponName = scnr.nextLine();

        System.out.print("Do you have a shield? (true/false): ");
        boolean hasShield = scnr.nextBoolean();
        scnr.nextLine();

        System.out.println("\nAvailable enemies:");
        System.out.println("1. Slime damage 5");
        System.out.println("2. Goblin damage 10 ");
        System.out.println("3. Boss damage 15");

        System.out.print("Enter enemy type: ");
        String enemyType = scnr.nextLine();


        int enemyHealth = 20;

        BattleSystem battle = new BattleSystem();
        String result = battle.runBattle(playerName, weaponName, hasShield, enemyType, playerHealth, enemyHealth);

        System.out.println("========== BATTLE RESULT ==========");
        System.out.println("Player: " + playerName);
        System.out.println("Enemy: " + enemyType);
        System.out.println("Result: " + result);
        System.out.println("====================================");

        scnr.close();
    }
}

