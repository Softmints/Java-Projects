/*
 * Name: Craig David Harris
 * Student number: c1335098
 */

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Shortener {
    // This class is only a starting point. You should complete all members
    // below, but you may also need to add other fields and methods to
    // finish the implementation as per the question on the assignment sheet.
    public File file;
    /*
     * Default constructor that will load a default abbreviations text file.
     */
    public Shortener() {
        // to be completed
            file = new File("abbreviations.txt");
    }   
    /*
     * Constructor that will load the abbreviations file represented by the
     * File parameter.
     */
    public Shortener( File inAbbreviationsFile ) {
        // to be completed
        file = inAbbreviationsFile;
    } 
    
    
    /*
     * Constructor that will load the abbreviations file that the String 
     * parameter is a file path for.
     */
    public Shortener( String inAbbreviationsFilePath ) {
        // to be completed
        file = new File(inAbbreviationsFilePath);
    }
    
    /*
     * This method attempts to shorten a word by finding its abbreviation. If 
     * no abbreviation exists for this word, then this method will return the 
     * original (i.e., unshortened) word.
     * 
     * You may assume that words are always lower case.
     *
     * `inWord` should be a single word (no spaces). It may optionally be
     * followed by one of the five following punctuation characters:
     *   ,
     *   ?
     *   .
     *   !
     *   ;
     * If one of these characters is at the end of the word this method will
     * shorten the word (ignoring the punctuation) and return the shortened
     * word with the punctuation character at the end.
     * For example,
     *     shortenerObject.shortenWord( "hello?" )
     * should return
     *     "lo?"
     *
     * You may assume that words are always lower case.
     */
    public String shortenWord( String inWord ) {

    int x = 0;
    String in = inWord;
    String fIn = inWord;
    String pIn = "";
    String pOut = "";
    boolean oneLetter = false;

    ArrayList<String> words = new ArrayList<String>();

        try {
            Scanner def = new Scanner(this.file);

            while ( def.hasNextLine() ) {
                String line = def.nextLine();
                String[] parts = line.split(",");
                String correct = parts[0];
                String abbrev = parts[1];
                words.add(correct);
                words.add(abbrev);
            }
            def.close();

            pIn = in.replaceAll("[^a-zA-Z ]", "");
            pOut = in.replaceAll("[^!?,;.]", "");
            for (int i = 0; i < words.size(); i++){
                if( words.get(i).equalsIgnoreCase(pIn) ){
                    x = i+1;
                    fIn = words.get(x);
                    fIn = fIn + pOut;
                }       
            }

            if(fIn.matches(".*[a-zA-Z0-9]+.*")){
                oneLetter = true;
            } 

            else{
                throw new Exception();
            }            
        }

        catch (Exception e){
            System.out.println(e);
            return "Unable to complete";
        }

    return fIn;

    }
    
    /*
     * Attempts to shorten a message by replacing words with their 
     * abbreviations. 
     *
     * You may assume that messages are always lower case.
     *
     * Punctuation characters (,?.!;) should be retained after shortening. See
     * `shortenWord( String inWord )` for more information.
     */
    public String shortenMessage( String inMessage ) {
    // to be completed
    String sIn = inMessage;
    String finMsgStr = "";

    ArrayList<String> finList = new ArrayList<String>();

        try{
            ArrayList<String> tmpWords = new ArrayList<String>();
            String[] tmp = sIn.split("\\s+");

            for(int i=0; i < tmp.length; i++){
           
                String single = tmp[i];
                tmpWords.add(single);

            }

            for(int i=0; i < tmpWords.size(); i++){
                String test = tmpWords.get(i);
                String tstWord = shortenWord(test);
                finList.add(tstWord);
            }

            for(int i=0; i < finList.size(); i++){

                finMsgStr += finList.get(i);

                if(i < (finList.size()-1)){
                    finMsgStr += " ";
                }
            }
        }

        catch (Exception e){
            System.out.println(e);
        }

    return finMsgStr;

    }
}