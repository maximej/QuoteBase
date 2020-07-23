/*
 * Ni aimer, ni haïr : voilà la moitié de toute sagesse.  
 * Ne rien dire et ne rien croire : voilà l'autre.
 */
package quotebase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.util.Date;
import sun.security.util.AbstractAlgorithmConstraints;

/**
 * JavaDoc de la classe Graphic
 *
 * @author cda413 --> Maxime J. Richard @ CDA1910.313
 */
public interface Graphic {

    static int LONGUEURTRAIT = 121;
    static String PREFIXETRAIT = "[X][>] ";
    static String SUFIXETRAIT = " [<][X]";
    static String SUCESS = "[>]";
    static String FAIL = "[X]";
    static String SYMBOL = "x";
    static String INTROBR = " ++ -- > ";
    static int PAUSE = 100;

    public static String donnerDate() {
        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        return shortDateFormat.format(new Date());
    }

    public static String imprimerHeure() {
        String heure = PREFIXETRAIT;
        DateFormat shortTimeFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT);
        //    System.out.println(shortTimeFormat.format(new Date()));
        heure += shortTimeFormat.format(new Date()) + "  ";
        while (heure.length() < LONGUEURTRAIT - SUFIXETRAIT.length()) {
            heure += SYMBOL;
        }
        heure += SUFIXETRAIT;
        // System.out.println(heure);

        return heure;
    }

    public static String imprimerHeure(int longueur) {
        String heure = PREFIXETRAIT;
        DateFormat shortTimeFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT);
        //    System.out.println(shortTimeFormat.format(new Date()));
        heure += shortTimeFormat.format(new Date()) + "  ";
        while (heure.length() < longueur - SUFIXETRAIT.length()) {
            heure += SYMBOL;
        }
        heure += SUFIXETRAIT;
        // System.out.println(heure);

        return heure;
    }

    /**
     * Imprime plusieurs traits
     *
     * @param i : c'est le nombre de traits que l'on veut
     */
    public static String imprimerTrait(int i) {
        String texte = "";
        for (int j = 0; j <= i; j++) {
            texte += imprimerTrait();
        }
        return texte;
    }

    /**
     * Imprime plusieurs traits d'une longueur choisie
     *
     * @param i : c'est la longueur que l'on veut pour le trait
     * @param j : c'est le nombre de traits que l'on veut
     */
    public static String imprimerTrait(int i, int j) {
        String texte = "";
        for (int k = 0; k <= j; k++) {
            String ligne  = PREFIXETRAIT;
            while (ligne.length() < i - SUFIXETRAIT.length()) {
                ligne += SYMBOL;
            }
            ligne += SUFIXETRAIT + "\n";
            texte += ligne;

        }
        System.out.print(texte);
        return texte;
    }

    /**
     * Imprime un trait de la longueur définie dans la classe Graphic
     */
    public static String imprimerTrait() {
        String texte = PREFIXETRAIT;
        while (texte.length() < LONGUEURTRAIT - SUFIXETRAIT.length()) {
            texte += SYMBOL;
        }
        texte += SUFIXETRAIT + "\n";
        System.out.print(texte);
        return texte;
    }

    public static String imprimerTraitBR() {
        String texte = PREFIXETRAIT;
        while (texte.length() < LONGUEURTRAIT - SUFIXETRAIT.length()) {
            texte += SYMBOL;
        }
        texte += SUFIXETRAIT + INTROBR;
        System.out.print(texte);

        return texte;
    }

    /**
     * JavaDoc de la classe imprimerTexte(int fail_sucess, int level, String
     * titre) int fail_sucess : 1 pour une réussite / 0 pour un succés - int
     * level : le niveau de l'érreur ou du succés - String titre : votre texte
     *
     * @param fail_sucess 1 pour une réussite / 0 pour un succés
     * @param level le niveau de l'érreur ou du succés
     * @param titre votre texte
     * @return Si les paramètres ne sont pas respectés la fonction imprime :
     * imprimerTexte(0, 2, "Erreur dans les argument de la fonction
     * imprimerTexte()"); imprimerTexte(0, 1, "0 pour une réussite / 1 pour un
     * succés - puis le niveau - votre texte"); et retourne un null sinon elle
     * retourne la ligne mise en forme
     */
    public static String imprimerTexte(int fail_sucess, int level, String titre) {
        String texte = PREFIXETRAIT;
        for (int i = 0; i < level; i++) {
            if (fail_sucess == 0) {
                texte += FAIL;
            } else if (fail_sucess == 1) {
                texte += SUCESS;
            } else {
                imprimerTexte(0, 2, "Erreur dans les argument de la fonction imprimerTexte()");
                imprimerTexte(0, 1, "0 pour une réussite / 1 pour un succés - puis le niveau - votre texte");
                return null;
            }
        }

        if (fail_sucess == 0) {
            texte += " ERREUR : ";

        } else if (fail_sucess == 1) {
            texte += " SUCCES : ";

        }

        texte += titre + "  ";
        while (texte.length() < LONGUEURTRAIT - SUFIXETRAIT.length()) {
            texte += SYMBOL;
        }
        texte += SUFIXETRAIT;
        //  System.out.println(texte);
        System.out.println(texte);

        return texte;

    }

    /**
     * @param fail_sucess 0 pour un symbole érreur, 1 pour un symbole réussite
     * @param longueur Texte à mettre en ligne
     */
    public static String imprimerTexte(int fail_sucess, String titre) {
        String texte = PREFIXETRAIT;
        if (fail_sucess == 0) {
            texte += FAIL;
            texte += " ERREUR : ";

        } else if (fail_sucess == 1) {
            texte += SUCESS;
            texte += " SUCCES : ";

        } else {
            imprimerTexte(0, 2, "Erreur dans les argument de la fonction imprimerTexte()");
            imprimerTexte(0, 1, "Entrez votre texte - 0 pour une réussite / 1 pour un succés");
            return null;
        }
        //       texte += " ERREUR : ";
        texte += titre + "  ";

        while (texte.length() < LONGUEURTRAIT - SUFIXETRAIT.length()) {
            texte += SYMBOL;
        }
        texte += SUFIXETRAIT;
        //  System.out.println(texte);
        System.out.println(texte);
        return texte;
    }

    public static String imprimerTexte(String titre) {
        String texte = PREFIXETRAIT;
        texte += titre + "  ";
        while (texte.length() < LONGUEURTRAIT - SUFIXETRAIT.length()) {
            texte += SYMBOL;
        }
        texte += SUFIXETRAIT;
        //  System.out.println(texte);
        System.out.println(texte);
        return texte;
    }

    public static String imprimerTexteBR(String titre) {
        String texte = PREFIXETRAIT;
        texte += titre + "  ";
        while (texte.length() < LONGUEURTRAIT - SUFIXETRAIT.length()) {
            texte += SYMBOL;
        }
        texte += SUFIXETRAIT + INTROBR;
        //  System.out.println(texte);
        System.out.print(texte);
        return texte;
    }

    public static void animerCadre(String texte) throws InterruptedException {
        String[] lines = texte.split(System.getProperty("line.separator"));
        for (String l : lines) {
            //     System.out.println(l);
            Thread.sleep(PAUSE);
        }
    }

    /**
     * JavaDoc de la classe encadrerTexte TO DO : Ajouter la detection de mot
     * avant retour à la ligne
     *
     * @param texte C'est le texte que l'on veut mettre dans un cadre
     * @param longueur C'est la taille du cadre avec les Suffixes et prefixes
     *
     */
    public static String encadrerTexte(String texte, int longueur) {
        StringBuilder cadre = new StringBuilder();

        int longueurDeLigne = longueur - (PREFIXETRAIT.length() + SUFIXETRAIT.length());
        //  cadre.append(imprimerTrait());
        int lignes = (int) texte.length() / longueurDeLigne;
        for (int i = 0; i < lignes + 1; i++) {
            int max = 0;
            String completion = "";
            if (longueurDeLigne * (i + 1) < texte.length()) {
                max = longueurDeLigne * (i + 1);
            } else {
                max = texte.length();
                completion += " ";
                for (int j = 0; j < (longueurDeLigne * (i + 1) - max - 1); j++) {
                    completion += SYMBOL;
                }

            }
            cadre.append(PREFIXETRAIT).append(texte.substring(longueurDeLigne * i, max)).append(completion).append(SUFIXETRAIT).append("\n");
        }
        cadre.append(imprimerTrait(longueur, 1));
        System.out.print(cadre.toString());
        return cadre.toString();
    }

    public static String encadrerTexte(String texte) {
        StringBuilder cadre = new StringBuilder();
        int longueurDeLigne = LONGUEURTRAIT - (PREFIXETRAIT.length() + SUFIXETRAIT.length());
        //  cadre.append(imprimerTrait());
        int lignes = (int) texte.length() / longueurDeLigne;
        for (int i = 0; i < lignes + 1; i++) {
            int max = 0;
            String completion = "";
            if (longueurDeLigne * (i + 1) < texte.length()) {
                max = longueurDeLigne * (i + 1);
            } else {
                max = texte.length();
                completion += " ";
                for (int j = 0; j < (longueurDeLigne * (i + 1) - max - 1); j++) {
                    completion += SYMBOL;
                }

            }
            cadre.append(PREFIXETRAIT).append(texte.substring(longueurDeLigne * i, max)).append(completion).append(SUFIXETRAIT).append("\n");
        }
        cadre.append(imprimerTrait());
        //     Thread.sleep(PAUSE);

        System.out.print(cadre.toString());
        return cadre.toString();
    }

    public static void imprimerTitre() {
        imprimerTrait();
        System.out.println(imprimerHeure(LONGUEURTRAIT));
        imprimerTrait();
        imprimerTexte("    ______    ____  ____    ______  ___________  _______      _______       __        ________  _______  ");
        imprimerTexte("   /    \" \\  (\"  _||_ \" |  /    \" \\(\"     _   \")/\"     \"|    |   _  \"\\     /\"\"\\      /\"       )/\"     \"| ");
        imprimerTexte("  // ____  \\ |   (  ) : | // ____  \\)__/  \\\\__/(: ______)    (. |_)  :)   /    \\    (:   \\___/(: ______) ");
        imprimerTexte(" /  /    )  )(:  |  | . )/  /    ) :)  \\\\_ /    \\/    |      |:     \\/   /' /\\  \\    \\___  \\   \\/    |   ");
        imprimerTexte("(: (____/ //  \\\\ \\__/ //(: (____/ //   |.  |    // ___)_     (|  _  \\\\  //  __'  \\    __/  \\\\  // ___)_  ");
        imprimerTexte(" \\         \\  /\\\\ __ //\\ \\        /    \\:  |   (:      \"|    |: |_)  :)/   /  \\\\  \\  /\" \\   :)(:      \"| ");
        imprimerTexte("  \\\"____/\\__\\(__________) \\\"_____/      \\__|    \\_______)    (_______/(___/    \\___)(_______/  \\_______) ");
        imprimerTrait();

    }
}
