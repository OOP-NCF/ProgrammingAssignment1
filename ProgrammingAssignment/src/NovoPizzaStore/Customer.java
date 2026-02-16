package NovoPizzaStore;

public class Customer {


        private String name;
        private boolean rewardsMember;

        public Customer(String name, boolean rewardsMember) {
            this.name = name;
            this.rewardsMember = rewardsMember;
        }

        public String getName() {
            return name;
        }

        public boolean isRewardsMember() {
            return rewardsMember;
        }
    }

