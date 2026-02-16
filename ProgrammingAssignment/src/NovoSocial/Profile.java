package NovoSocial;

public class Profile {
    public String username;
    public int followers;
    public boolean isVerified;

    public Profile(String username, int followers, boolean isVerified) {
        this.username = username;
        this.followers = followers;
        this.isVerified = isVerified;
    }
}

