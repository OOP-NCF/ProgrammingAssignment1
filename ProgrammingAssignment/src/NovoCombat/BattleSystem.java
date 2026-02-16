package NovoCombat;

public class BattleSystem {

    public int calculatePlayerDamage(String weaponName, String enemyType) {
        int damage = 10;

        if (weaponName.equals("Sword")) {
            damage = 12 + 5;
        } else if (weaponName.equals("Dagger")) {
            damage = 8;
        } else if (weaponName.equals("Axe")) {
            damage = 10;
        }

        if (enemyType.equals("Boss")) {
            damage = damage - 3;
        }

        return damage;
    }

    public int calculateEnemyDamage(String enemyType) {
        int damage = 10;

        if (enemyType.equals("Slime")) {
            damage = 5;
        } else if (enemyType.equals("Goblin")) {
            damage = 10;
        } else if (enemyType.equals("Boss")) {
            damage = 15;
        }

        return damage;
    }

    public String runBattle(String playerName, String weaponName, boolean hasShield, String enemyType, int playerHealth, int enemyHealth) {
        System.out.println("\n===== BATTLE START =====");

        // Player attacks
        int playerDamage = calculatePlayerDamage(weaponName, enemyType);
        enemyHealth -= playerDamage;
        System.out.println(playerName + " attacks with " + weaponName + " for " + playerDamage + " damage!");
        System.out.println(enemyType + " health: " + enemyHealth);

        // Enemy attacks
        int enemyDamage = calculateEnemyDamage(enemyType);
        int originalDamage = enemyDamage;
        System.out.println(enemyType + " base damage: " + originalDamage);

        if (hasShield) {
            enemyDamage = enemyDamage - 5;
            int shieldSaved = originalDamage - enemyDamage;
            System.out.println(enemyType + " attacks for " + originalDamage + " damage! Shield blocks " + shieldSaved + " damage!");
            System.out.println("Damage taken: " + enemyDamage);
        } else {
            System.out.println(enemyType + " attacks for " + enemyDamage + " damage!");
        }

        playerHealth -= enemyDamage;
        System.out.println(playerName + " health: " + playerHealth);

        System.out.println("===== ROUND END =====\n");

        // Determine result
        if (playerHealth > 0) {
            return "Victory";
        }
        else {
            return "Defeat";
        }
    }
}