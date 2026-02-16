package NovoAttentionCheck;

public class Session {

    private Participant participant;
    private Trial trial1;
    private Trial trial2;
    private Trial trial3;

    public Session(Participant participant, Trial trial1, Trial trial2, Trial trial3) {
        this.participant = participant;
        this.trial1 = trial1;
        this.trial2 = trial2;
        this.trial3 = trial3;
    }

    public int computeAverageReactionTime() {
        int total = trial1.reactionTime + trial2.reactionTime + trial3.reactionTime;
        int average = total / 3;
        return average;
    }

    public int countAttentionLapses() {
        ReactionAnalyzer analyzer = new ReactionAnalyzer();
        int lapseCount = 0;

        if (analyzer.isAttentionLapse(trial1.reactionTime, trial1.isCorrect)) {
            lapseCount = lapseCount + 1;
        }

        if (analyzer.isAttentionLapse(trial2.reactionTime, trial2.isCorrect)) {
            lapseCount = lapseCount + 1;
        }

        if (analyzer.isAttentionLapse(trial3.reactionTime, trial3.isCorrect)) {
            lapseCount = lapseCount + 1;
        }

        return lapseCount;
    }
}
