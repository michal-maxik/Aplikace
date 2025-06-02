import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Obsah> seznam = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int volba;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Přidat obsah (YouTube, Spotify)");
            System.out.println("2. Vypsat všechny youtube videa");
            System.out.println("3. Vypsat délku nejkratšího obsahu");
            System.out.println("4. Konec programu");
            System.out.print("Zadejte volbu: ");
            volba = sc.nextInt();
            sc.nextLine(); // odchytit enter

            switch (volba) {
                case 1:
                    System.out.print("Zadejte typ (youtube/spotify): ");
                    String typ = sc.nextLine().toLowerCase();

                    System.out.print("Zadejte název: ");
                    String nazev = sc.nextLine();

                    System.out.print("Zadejte délku (v minutách): ");
                    int delka = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Zadejte jméno autora/moderátora: ");
                    String jmeno = sc.nextLine();

                    if (typ.equals("youtube")) {
                        seznam.add(new YoutubeVideo(nazev, delka, jmeno));
                    } else if (typ.equals("spotify")) {
                        seznam.add(new SpotifyPodcast(nazev, delka, jmeno));
                    } else {
                        System.out.println("Neplatný typ!");
                    }
                    break;

                case 2:
                    System.out.println("\n--- YouTube videa ---");
                    for (Obsah o : seznam) {
                        if (o instanceof YoutubeVideo) {
                            System.out.println(o);
                        }
                    }
                    break;

                case 3:
                    if (seznam.isEmpty()) {
                        System.out.println("Seznam je prázdný.");
                    } else {
                        Obsah nejkratsi = seznam.get(0);
                        for (Obsah o : seznam) {
                            if (o.getDelka() < nejkratsi.getDelka()) {
                                nejkratsi = o;
                            }
                        }
                        System.out.println("Nejkratší obsah: " + nejkratsi + " (" + nejkratsi.getDelka() + " min)");
                    }
                    break;

                case 4:
                    System.out.println("Ukončuji program...");
                    break;

                default:
                    System.out.println("Neplatná volba!");
            }

        } while (volba != 4);

        sc.close();
    }
}
