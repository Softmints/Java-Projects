/*
 * Name: Craig David Harris
 * Student number: c1335098
 */

/*
 * A command-line application that shortens a message.
 */
import java.util.ArrayList;

public class ShortenerUtility {
    // to be completed
	public static void main(String[] args){

	ArrayList<String> tmpWords = new ArrayList<String>();
	String finMsgStr = "";

		try{
			for (int i=0; i<args.length; i++){
				 String temp = args[i];
				 tmpWords.add(temp);
			}

	        for(int i=0; i < tmpWords.size(); i++){

	            finMsgStr += tmpWords.get(i);

	            if(i < (tmpWords.size()-1)){
	                finMsgStr += " ";
	            }
	        }

	        Shortener ns = new Shortener();

	        System.out.println(ns.shortenMessage(finMsgStr));
	    }

	    catch (Exception e){
	    	System.out.println(e);
	    }
	    
	} 
}