package NovoSocial;
import java.util.Scanner;

public class NovoSocial {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        EngagementCalculator calculator = new EngagementCalculator();

        System.out.println("========== INSTAGRAM PROFILE ANALYZER ==========\n");

        System.out.print("Enter username: ");
        String username = scnr.nextLine();

        System.out.print("Enter follower count: ");
        int followers = scnr.nextInt();

        System.out.print("Is account verified? (true/false): ");
        boolean isVerified = scnr.nextBoolean();
        scnr.nextLine();

        Profile profile = new Profile(username, followers, isVerified);

        int totalEngagement = 0;
        int postCount = 0;
        boolean addMorePosts = true;

        System.out.println("\n========== ADD POSTS ==========");

        while (addMorePosts) {
            System.out.print("Enter number of likes: ");
            int likes = scnr.nextInt();

            System.out.print("Enter number of comments: ");
            int comments = scnr.nextInt();

            System.out.print("Is this a reel? (true/false): ");
            boolean isReel = scnr.nextBoolean();
            scnr.nextLine();

            Post post = new Post(likes, comments, isReel);
            int engagement = post.calculateEngagement();
            String engagementType = calculator.classifyEngagement(engagement);

            System.out.println("Post engagement: " + engagement + " (" + engagementType + ")\n");

            totalEngagement = totalEngagement + engagement;
            postCount = postCount + 1;

            System.out.print("Add another post? (true/false): ");
            addMorePosts = scnr.nextBoolean();
            scnr.nextLine();
        }

        int averageEngagement = calculator.calculateAverageEngagement(totalEngagement, postCount);
        String accountType = classifyAccount(followers, averageEngagement);

        System.out.println("\n========== ACCOUNT REPORT ==========");
        System.out.println("Username: " + profile.username);
        System.out.println("Followers: " + profile.followers);
        System.out.println("Verified: " + profile.isVerified);
        System.out.println("Total Posts: " + postCount);
        System.out.println("Average Engagement: " + averageEngagement);
        System.out.println("Account Type: " + accountType);
        System.out.println("====================================");

        scnr.close();
    }

    public static String classifyAccount(int followers, int averageEngagement) {
        String accountType = "";

        if (followers >= 10000 && averageEngagement >= 100) {
            accountType = "Influencer";
        } else if (followers >= 1000 && averageEngagement >= 50) {
            accountType = "Stable";
        } else {
            accountType = "Growing";
        }

        return accountType;
    }
}
