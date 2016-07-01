/*
 * Name: Craig David Harris
 * Student number: c1335098
 */

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class Evaluator extends Shortener {
    // This class is only a starting point. You should complete all members
    // below, but you may also need to add other fields and methods to
    // finish the implementation as per the question on the assignment sheet.
    int orgMsgLen = 0;
    int wordCount = 0;
    String outStr = "";
    int outStrLen = 0;
    double msgPerc = 0.0;
    /*
     * Default constructor that will load a default abbreviations text file.
     */
    public Evaluator() {
        // to be completed
        super();
    }
    
    /*
     * Constructor that will load the abbreviations file represented by the
     * File parameter.
     */
    public Evaluator( File inAbbreviationsFile ) {
        // to be completed
        super(inAbbreviationsFile);
    }
    
    /*
     * Constructor that will load the abbreviations file that the String 
     * parameter is a file path for.
     */
    public Evaluator( String inAbbreviationsFilePath ) {
        // to be completed
        super(inAbbreviationsFilePath);
    }
    
    /*
     * Evaluate the message.
     */
    public String evaluateMessage( String inMessage ) {
        // to be completed

    boolean oneLetter = false;

        try{
            String evaMsg = inMessage;

            if(evaMsg.matches(".*[a-zA-Z0-9]+.*")){
                oneLetter = true;
            } 

            else{
                throw new Exception();
            }

            this.orgMsgLen = evaMsg.length();

            ArrayList<String> tmpWords = new ArrayList<String>();
            String[] tmp = evaMsg.split("\\s+");

            for(int i=0; i < tmp.length; i++){
           
                String single = tmp[i];
                tmpWords.add(single);
            }

            this.wordCount = tmpWords.size();

            this.outStr = shortenMessage(evaMsg);

            this.outStrLen = outStr.length();

            this.msgPerc = (((double)orgMsgLen - (double)outStrLen) / orgMsgLen) * 100;
        }

        catch (Exception e){
            System.out.println(e);
            return "Unable to complete";
        }

    return toString();

    }

    @Override
    public String toString(){

        DecimalFormat format = new DecimalFormat("#.0");

        return "Length of input: " + orgMsgLen + "\n" +
                "\n" +
                "Number of words: " + wordCount + "\n" +
                "\n" +
                "Output: " + outStr + "\n" +
                "\n" +
                "Length of output: " + outStrLen + "\n" +
                "\n" +
                "Shortened by: " + format.format(msgPerc) + "%" + "\n";           
    }
}