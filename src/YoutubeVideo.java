public class YoutubeVideo implements Obsah {
    private String nazev;
    private int delka;
    private String autor;

    public YoutubeVideo(String nazev, int delka, String autor) {
        this.nazev = nazev;
        this.delka = delka;
        this.autor = autor;
    }

    @Override
    public int getDelka() {
        return delka;
    }

    @Override
    public String toString() {
        return "YouTube video '" + nazev + "' od " + autor;
    }
}