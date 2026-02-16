package NovoAttentionCheck;

public class Trial {

    public String stimulusType;
    public int reactionTime;
    public boolean isCorrect;

    public Trial(String stimulusType, int reactionTime, boolean isCorrect) {
        this.stimulusType = stimulusType;
        this.reactionTime = reactionTime;
        this.isCorrect = isCorrect;
    }
}
