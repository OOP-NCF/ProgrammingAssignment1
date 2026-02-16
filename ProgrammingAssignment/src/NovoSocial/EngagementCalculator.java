package NovoSocial;

public class EngagementCalculator {

    public String classifyEngagement(int engagementScore) {
        String classification = "";

        if (engagementScore < 50) {
            classification = "Low";
        } else if (engagementScore >= 50 && engagementScore < 150) {
            classification = "Medium";
        } else {
            classification = "High";
        }

        return classification;
    }

    public int calculateAverageEngagement(int totalEngagement, int postCount) {
        int average = totalEngagement / postCount;
        return average;
    }
}
