/*
 * Project done with Oracle NetBeans
 * Distributed under Creative Commons 
 * By Maxime J.
 */

package simulacre;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;
import quotebase.Graphic;

/**
 * "Ni aimer ni haïr", voila la première la moitié de toute sagesse ; 
 * "Ne rien dire et ne rien croire", voilà l’autre moitié.
 * @author Maxime J. <maximejrichard at gmail.com>
 */
  public class MarkovModel {

        public final char NOCHARACTER = (char) 255;
        public String text;
        public int order;
        public HashMap<String, int[]> model;
        public Random generator;

        public MarkovModel(String text, int order) {
            this.text = text;
            this.order = order;
            generator = new Random();
            Graphic.imprimerTexte(1, "Making model...");
            populateModel();
            Graphic.imprimerTexte(1, "Model complete.");
        }

        private void populateModel() {
            model = new HashMap<>();
            String key;
            int[] charFreq;

            for (int i = 0; i < text.length() - order; i++) {
                key = text.substring(i, i + order);

                if (model.containsKey(key)) {
                    charFreq = model.get(key);
                } else {
                    // last index in array stores number of times key has been seen
                    // allows probability calculation without iterating through array
                    charFreq = new int[255];
                }

                if (text.charAt(i + order) > 254) {
                    System.out.println(text.charAt(i + order));
                }
                // maintain frequency count of the letters immediately following the substring
                charFreq[text.charAt(i + order)]++;

                // increment number of times key has been seen
                charFreq[128]++;

                model.put(key, charFreq);
            }
        }

        public int order() {
            return order;
        }

        public int getFrequency(String kgram) throws IllegalArgumentException {
            if (kgram.length() != order) {
                throw new IllegalArgumentException("kgram length must be same as order");
            }

            int[] value = model.get(kgram);

            if (value == null) {
                return 0;
            } else {
                return value[128];
            }
        }

        public int getFrequency(String kgram, char c) {
            if (kgram.length() != order) {
                throw new IllegalArgumentException("kgram length must be same as order");
            }

            int[] value = model.get(kgram);

            if (value == null) {
                return 0;
            } else {
                return value[(int) c];
            }
        }

        public char nextCharacter(String kgram) {
            if (kgram.length() != order) {
                throw new IllegalArgumentException("kgram length must be same as order");
            }

            int[] value = model.get(kgram);
            LinkedHashMap<Character, Integer> charsSeen = new LinkedHashMap<>();
            // helps to store a cumulative frequency distribution
            int accumulator = 0;

            // if kgram does not exist, no possible character can be returned
            if (value == null) {
                return NOCHARACTER;
            } else {
                for (int i = 0; i < 128; i++) {
                    if (value[i] != 0) {
                        charsSeen.put((char) i, value[i] + accumulator);
                        accumulator += value[i];
                    }
                }
            }

            // generate a random number in range [0, highest cumulative frequency]
            int rand = generator.nextInt(accumulator);

            // iterates through linkedhashmap in order
            for (char key : charsSeen.keySet()) {
                // if the random number is less than the cumulative frequency of the letter, return that letter
                // works since elements are iterated through in order each time
                // and cumulative frequency maintains probability of being chosen for each
                if (rand < charsSeen.get(key)) {
                    return (char) key;
                }
            }

            // never reached, here to satisfy eclipse's error message
            return NOCHARACTER;
        }

        public void setRandomSeed(long s) {
            generator = new Random(s);
        }
    }
