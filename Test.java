import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Test {

    public static void main( String[] args ) {

    Shortener aq = new Shortener("abbreviations.txt");
    Evaluator nq = new Evaluator("abbreviations.txt");

    System.out.println(aq.shortenWord("thanks!"));

    System.out.println(aq.shortenMessage("Hello, any anyone! thanks. your!?"));

    System.out.println(nq.evaluateMessage("Hello, any anyone! thanks. your!?"));

    }
}