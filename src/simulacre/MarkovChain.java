/*
 * Project done with Oracle NetBeans
 * Distributed under Creative Commons 
 * By Maxime J.
 */
package simulacre;

/**
 * "Ni aimer ni haïr", voila la première la moitié de toute sagesse ; "Ne rien
 * dire et ne rien croire", voilà l’autre moitié.
 *
 * @author Maxime J. <maximejrichard at gmail.com>
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.io.*;
import java.util.*;
import quotebase.Graphic;

public class MarkovChain {

    private static Random r = new Random();

    public static String markov(String corpus, int keySize, int outputSize) throws IOException {
        if (keySize < 1) {
            throw new IllegalArgumentException("Key size can't be less than 1");
        }
//        Path path = Paths.get(filePath);
//        byte[] bytes = Files.readAllBytes(path);
//        
//        

        String[] words = corpus.split(" ");
        if (outputSize < keySize || outputSize >= words.length) {
            throw new IllegalArgumentException("Output size is out of range");
        }
        Map<String, List<String>> dict = new HashMap<>();

        for (int i = 0; i < (words.length - keySize); ++i) {
            StringBuilder key = new StringBuilder(words[i]);
            for (int j = i + 1; j < i + keySize; ++j) {
                key.append(' ').append(words[j]);
            }
            String value = (i + keySize < words.length) ? words[i + keySize] : "";
            if (!dict.containsKey(key.toString())) {
                ArrayList<String> list = new ArrayList<>();
                list.add(value);
                dict.put(key.toString(), list);
            } else {
                dict.get(key.toString()).add(value);
            }
        }

        int n = 0;
        int rn = r.nextInt(dict.size());
        String prefix = (String) dict.keySet().toArray()[rn];
        List<String> output = new ArrayList<>(Arrays.asList(prefix.split(" ")));

        while (true) {
            List<String> suffix = dict.get(prefix);
            if (suffix.size() == 1) {
                if (Objects.equals(suffix.get(0), "")) {
                    return output.stream().reduce("", (a, b) -> a + " " + b);
                }
                output.add(suffix.get(0));
            } else {
                rn = r.nextInt(suffix.size());
                output.add(suffix.get(rn));
            }
            if (output.size() >= outputSize) {
                return output.stream().limit(outputSize).reduce("", (a, b) -> a + " " + b);
            }
            n++;
            prefix = output.stream().skip(n).limit(keySize).reduce("", (a, b) -> a + " " + b).trim();
        }
    }

    /**
     * @param args when used with three arguments, the first represents the
     * k-order of the Markov objects. The second represents the number of
     * characters to print out. The third represents the file to be read.
     *
     * When used with two arguments, the first represents the k-order of the
     * Markov objects, and the second represents the file to be read. The
     * generated text will be the same number of characters as the original
     * file.
     */
    public static String markovDanF(String[] args) {
        int k = 0;
        int M = 0;
//	String file = "";
        String corpus = "";
        StringBuilder text = new StringBuilder();

        if (args.length == 3) {
            k = Integer.parseInt(args[0]);
            M = Integer.parseInt(args[1]);
//	    file = args[2];
            corpus = args[2];
        } else if (args.length == 2) {
            k = Integer.parseInt(args[0]);
//	    file = args[1];
            corpus = args[1];

        } else {
            System.out.println("\n" + "Usage: java TextGenerator k M file");
            System.out.println("where k is the markov order, M is the number");
            System.out.println("of characters to be printed, and file is the");
            System.out.println("name of the file to print from. M may be left out." + "\n");
            System.exit(1);
        }

//	FileReader reader = null;
//	try {
//	    reader = new FileReader(file);
//	} catch (FileNotFoundException e) {
//	    System.out.println("File not found.");
//	    e.printStackTrace();
//	}
        simulacre.MyHashMap<String, Markov> hash = new simulacre.MyHashMap<String, Markov>();

//	Character next = null;
//	try {
//	    next = (char) reader.read();
//	} catch (IOException e1) {
//	    System.out.println("IOException in stepping through the file");
//	    e1.printStackTrace();
//	}
//
//	StringBuilder origFileBuffer = new StringBuilder();
//	while (Character.isDefined(next)) {
//	    Character.toString(next);
//	    origFileBuffer.append(next);
//	    try {
//		next = (char) reader.read();
//	    } catch (IOException e) {
//		System.out.println("IOException in stepping through the file");
//		e.printStackTrace();
//	    }
//
//	}
        String origFile = corpus;

//	String origFile = origFileBuffer.toString();
        String firstSub = origFile.substring(0, k);
        for (int i = 0; i < origFile.length() - k; i++) {
            String sub = origFile.substring(i, i + k);
            Character suffix = origFile.charAt(i + k);

            if (hash.containsKey(sub)) {
                Markov marvin = hash.get(sub);
                marvin.add(suffix);
                hash.put(sub, marvin);
            } else {
                Markov marvin = new Markov(sub, suffix);
                hash.put(sub, marvin);
            }
        }
        if (M == 0) {
            M = origFile.length();
        }
        for (int i = k; i < M; i++) {
            if (i == k) {
                text.append(firstSub);
                if (text.length() > k) {
                    i = text.length();
                }
            }
            String sub = text.substring((i - k), (i));
            Markov tmp = hash.get(sub);
            if (tmp != null) {
                Character nextChar = tmp.random();
                text.append(nextChar);
            } else {
                i = k - 1;
            }
        }
        if (hash.size() < 100) {
            Iterator<String> keys = hash.keys();
            while (keys.hasNext()) {
                String hashKey = keys.next();
                Markov hashValue = hash.get(hashKey);
                System.out.print(hashValue.count() + " " + hashKey + ":");
                for (Map.Entry<Character, Integer> entry : hashValue.getMap().entrySet()) {
                    char suffix = entry.getKey();
                    int frequencyCount = entry.getValue();
                    System.out.print(" " + frequencyCount + " " + suffix);
                }
                System.out.println();
            }
        }
                    Graphic.imprimerTexte(1, text.toString().substring(0, Math.min(M, text.length())));
        return text.toString().substring(0, Math.min(M, text.length()));
    }
}

//    public static void main(String[] args) throws IOException {
//        System.out.println(markov("alice_oz.txt", 3, 200));
//    }

