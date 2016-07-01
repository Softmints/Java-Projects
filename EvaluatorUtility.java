/*
 * Name: Craig David Harris
 * Student number: c1335098
 */

/*
 * A command-line application that pre-evaluates messages to be shortened and prints some statistics.
 */
import java.util.ArrayList;

public class EvaluatorUtility {
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

	        Evaluator ne = new Evaluator();

	        System.out.println(ne.evaluateMessage(finMsgStr));
        }

        catch (Exception e){
        	System.out.println(e);
        }
	} 
}