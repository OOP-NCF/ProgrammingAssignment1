package NovoSocial;

public class Post {
    public int likes;
    public int comments;
    public boolean isReel;

    public Post(int likes, int comments, boolean isReel) {
        this.likes = likes;
        this.comments = comments;
        this.isReel = isReel;
    }

    public int calculateEngagement() {
        int engagement = likes + (comments * 2);

        if (isReel) {
            engagement = engagement + 10;
        }

        return engagement;
    }
}
