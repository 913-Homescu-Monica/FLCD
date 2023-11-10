import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();

        System.out.println("p1:");
        lexicalAnalyzer.scanProgram("p1.in", "p1_ST.out", "p1_PIF.out");

        System.out.println("\np1err:");
        lexicalAnalyzer.scanProgram("p1err.in", "p1err_ST.out", "p1err_PIF.out");

        System.out.println("p2:");
        lexicalAnalyzer.scanProgram("p2.in", "p2_ST.out", "p2_PIF.out");

        System.out.println("\np3:");
        lexicalAnalyzer.scanProgram("p3.in", "p3_ST.out", "p3_PIF.out");
    }
}
