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
// Generates text based on an input string using the Markov Model outlined in Claude Shannon's seminal paper
// A Mathematical Theory of Communication. The basic idea is that the next character printed to the console follows
// a probability distributio given by the probability of that character following a string of length 'order' (kgram)
// in the input text. This kgram is the string of length order that was printed last.
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;
import quotebase.Graphic;

public class TextGenerator {

    private int k, n;
    private String text;
    MarkovModel model;

    /**
     * // Generates text based on an input string using the Markov Model
     * outlined in Claude Shannon's seminal paper // A Mathematical Theory of
     * Communication. The basic idea is that the next character printed to the
     * console follows // a probability distributio given by the probability of
     * that character following a string of length 'order' (kgram) // in the
     * input text. This kgram is the string of length order that was printed
     * last.
     *
     * @param order
     * @param numCharsToGenerate
     * @param source
     */
    public String TextGenerator(int order, int numCharsToGenerate, String source) {
        setK(order);
        setN(numCharsToGenerate);

//		try {
//			getText(fileName);
//		}
//		catch (IOException e){
//			e.printStackTrace();
//		}
        text = source;
        return generateText();
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MarkovModel getModel() {
        return model;
    }

    public void setModel(MarkovModel model) {
        this.model = model;
    }

    // Read a file
//	private void getText(String corpus) throws IOException {
//		StringBuffer buffer = new StringBuffer();
//
//		    for (String line = null; (line = corpus.readLine()) != null;) {
//		    	// Convert UTF-8 encoding to ASCII
//		    	line = new String(line.getBytes("ASCII"));
//		    	buffer.append(line);
//		    }
//		
//		
//		text = buffer.toString();
//	}
    private String generateText() {
        model = new MarkovModel(text, k);
        Random numGenerator = new Random();
        int randomNum = numGenerator.nextInt(text.length() - k);

        // chooses a random substring from within the text of length k
        String kgram = text.substring(randomNum, randomNum + k);

        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < n; i++) {
            char nextChar = model.nextCharacter(kgram);

            // if no possible next char
            if (nextChar == (char) 255) {
                buffer = new StringBuffer();
                kgram = text.substring(0, k);
                nextChar = model.nextCharacter(kgram);
                i = 0;
            }

            // new kgram is equal to kgram - first letter of kgram + nextChar
            kgram = kgram.substring(1, kgram.length()) + nextChar;
            buffer.append(nextChar);
            // Start a new line when a full stop is encountered
            if (nextChar == '.') {
                buffer.append('\n');
            }
        }

        System.out.println(buffer.toString());
        return buffer.toString();
    }

//    public static void main(String[] args) {
//        // order, number of characters to print, filename of input text
//        TextGenerator gen = new TextGenerator(15, 500, "input.txt");
//    }
  
}
