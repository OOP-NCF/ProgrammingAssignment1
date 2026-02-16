package NovoPassword;

public class LoginManager {
    private User user;
    private Account account;
    private String correctUsername = "admin";
    private String correctPassword = "java123";

    public LoginManager(User user, Account account) {
        this.user = user;
        this.account = account;
    }

    public boolean validateCredentials(String inputUsername, String inputPassword) {
        if (account.isLocked()) {
            return false;
        }

        if (inputUsername.equals(correctUsername) && inputPassword.equals(correctPassword)) {
            return true;
        } else {
            account.incrementFailedAttempts();
            if (account.getFailedAttempts() >= 3) {
                account.setLocked(true);
            }
            return false;
        }
    }

    public boolean isAccountLocked() {
        return account.isLocked();
    }

    public int getFailedAttempts() {
        return account.getFailedAttempts();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
