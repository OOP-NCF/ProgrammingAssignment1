package NovoPassword;

public class Account {
    private boolean isLocked;
    private int failedAttempts;

    public Account() {
        this.isLocked = false;
        this.failedAttempts = 0;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(int failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public void incrementFailedAttempts() {
        this.failedAttempts = this.failedAttempts + 1;
    }
}