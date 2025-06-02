public class SpotifyPodcast implements Obsah {
    private String nazev;
    private int delka;
    private String moderator;

    public SpotifyPodcast(String nazev, int delka, String moderator) {
        this.nazev = nazev;
        this.delka = delka;
        this.moderator = moderator;
    }

    @Override
    public int getDelka() {
        return delka;
    }

    @Override
    public String toString() {
        return "Spotify podcast '" + nazev + "' od " + moderator;
    }
}
