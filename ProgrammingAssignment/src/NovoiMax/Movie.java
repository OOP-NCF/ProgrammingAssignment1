package NovoiMax;

public class Movie {

    private String title;
    private boolean matinee;

    public Movie(String title, boolean matinee) {
        this.title = title;
        this.matinee = matinee;
    }

    public String getTitle() {
        return title;
    }

    public boolean isMatinee() {
        return matinee;
    }
}
