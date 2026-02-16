package NovoAttentionCheck;
import java.util.Scanner;
public class NeuroApp {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.println("====== NEUROSCIENCE REACTION & ATTENTION TEST ======");
        System.out.println("This test measures reaction time and attention lapses");
        System.out.println("=====================================================\n");

        System.out.print("Enter participant name: ");
        String participantName = scnr.nextLine();

        System.out.print("Enter participant age: ");
        int participantAge = scnr.nextInt();
        scnr.nextLine();

        Participant participant = new Participant(participantName, participantAge);

        System.out.println("\n========== TRIAL 1 ==========");
        System.out.print("Enter stimulus type (visual/audio): ");
        String stimulus1 = scnr.nextLine();
        System.out.print("Enter reaction time (ms): ");
        int reactionTime1 = scnr.nextInt();
        System.out.print("Was response correct? (true/false): ");
        boolean correct1 = scnr.nextBoolean();
        scnr.nextLine();
        Trial trial1 = new Trial(stimulus1, reactionTime1, correct1);

        System.out.println("\n========== TRIAL 2 ==========");
        System.out.print("Enter stimulus type (visual/audio): ");
        String stimulus2 = scnr.nextLine();
        System.out.print("Enter reaction time (ms): ");
        int reactionTime2 = scnr.nextInt();
        System.out.print("Was response correct? (true/false): ");
        boolean correct2 = scnr.nextBoolean();
        scnr.nextLine();
        Trial trial2 = new Trial(stimulus2, reactionTime2, correct2);

        System.out.println("\n========== TRIAL 3 ==========");
        System.out.print("Enter stimulus type (visual/audio): ");
        String stimulus3 = scnr.nextLine();
        System.out.print("Enter reaction time (ms): ");
        int reactionTime3 = scnr.nextInt();
        System.out.print("Was response correct? (true/false): ");
        boolean correct3 = scnr.nextBoolean();
        scnr.nextLine();
        Trial trial3 = new Trial(stimulus3, reactionTime3, correct3);

        Session session = new Session(participant, trial1, trial2, trial3);
        ReactionAnalyzer analyzer = new ReactionAnalyzer();

        printReport(session, analyzer, trial1, trial2, trial3, participantName);

        scnr.close();
    }

    public static void printReport(Session session, ReactionAnalyzer analyzer, Trial trial1, Trial trial2, Trial trial3, String participantName) {
        int avgReactionTime = session.computeAverageReactionTime();
        int attentionLapses = session.countAttentionLapses();

        System.out.println("\n====== FINAL REPORT ======");
        System.out.println("Participant: " + participantName);
        System.out.println("Average Reaction Time: " + avgReactionTime + "ms");
        System.out.println();

        System.out.println("--- TRIAL CLASSIFICATIONS ---");
        System.out.print("Trial 1: " + analyzer.classifyReactionTime(trial1.reactionTime));
        if (analyzer.isAttentionLapse(trial1.reactionTime, trial1.isCorrect)) {
            System.out.println(" (ATTENTION LAPSE)");
        } else {
            System.out.println();
        }

        System.out.print("Trial 2: " + analyzer.classifyReactionTime(trial2.reactionTime));
        if (analyzer.isAttentionLapse(trial2.reactionTime, trial2.isCorrect)) {
            System.out.println(" (ATTENTION LAPSE)");
        } else {
            System.out.println();
        }

        System.out.print("Trial 3: " + analyzer.classifyReactionTime(trial3.reactionTime));
        if (analyzer.isAttentionLapse(trial3.reactionTime, trial3.isCorrect)) {
            System.out.println(" (ATTENTION LAPSE)");
        } else {
            System.out.println();
        }

        System.out.println();
        System.out.println("Total Attention Lapses: " + attentionLapses);
        System.out.println();

        boolean passedSession = attentionLapses <= 1 && avgReactionTime < 450;

        if (passedSession) {
            System.out.println("SESSION RESULT: PASSED");
        } else {
            System.out.println("SESSION RESULT: FAILED");
        }

        System.out.println("==========================");
    }
}
