package NovoAttentionCheck;

public class ReactionAnalyzer {
    public String classifyReactionTime(int reactionTime) {
        if (reactionTime < 200) {
            return "Fast";
        } else if (reactionTime >= 200 && reactionTime <= 400) {
            return "Normal";
        } else {
            return "Slow";
        }
    }

    public boolean isAttentionLapse(int reactionTime, boolean isCorrect) {
        if (!isCorrect) {
            return true;
        }

        if (reactionTime > 600) {
            return true;
        }

        return false;
    }
}
