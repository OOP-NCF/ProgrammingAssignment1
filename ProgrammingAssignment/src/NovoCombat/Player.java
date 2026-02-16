package NovoCombat;


    public class Player {
        public String name;
        public int health;
        public String weapon;
        public boolean hasShield;

        public Player(String name, int health, String weapon, boolean hasShield) {
            this.name = name;
            this.health = health;
            this.weapon = weapon;
            this.hasShield = hasShield;
        }
    }

