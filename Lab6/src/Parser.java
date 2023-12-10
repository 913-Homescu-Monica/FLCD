import java.util.*;

public class Parser {
    private final Grammar grammar;
    private final HashMap<String, Set<String>> firstSets;
    private final HashMap<String, Set<String>> followSets;

    public Parser(String fileName) {
        grammar = new Grammar(fileName);

        firstSets = new HashMap<>();
        for (String nonTerminal : grammar.getNonTerminals())
            firstSets.put(nonTerminal, computeFirstSet(nonTerminal));

        followSets = new HashMap<>();
        for (String nonTerminal : grammar.getNonTerminals())
            followSets.put(nonTerminal, computeFollowSet(nonTerminal));

    }

    private Set<String> computeFirstSet(String nonTerminal) {
        // return FIRST(nonTerminal) if it is already computed
        if (firstSets.containsKey(nonTerminal))
            return firstSets.get(nonTerminal);

        Set<String> firstSet = new HashSet<>();

        // iterate through each production for nonTerminal
        for (List<String> production : grammar.getProductionsForNonTerminal(nonTerminal)) {
            // get firstSymbol in the production
            String firstSymbol = production.get(0);

            // if firstSymbol is Є, add it to FIRST(nonTerminal)
            if (firstSymbol.equals("Є"))
                firstSet.add("Є");
            // if firstSymbol is a terminal, add it to FIRST(nonTerminal)
            else if (grammar.getTerminals().contains(firstSymbol))
                firstSet.add(firstSymbol);
            // if firstSymbol is a non-terminal, recursively compute FIRST(firstSymbol) and add it to FIRST(nonTerminal)
            else
                firstSet.addAll(computeFirstSet(firstSymbol));
        }

        return firstSet;
    }

    private Set<String> computeFollowSet(String nonTerminal) {
        // return FOLLOW(nonTerminal) if it is already computed
        if (followSets.containsKey(nonTerminal))
            return followSets.get(nonTerminal);

        Set<String> followSet = new HashSet<>();

        // if nonTerminal is the starting symbol, add $ to FOLLOW(nonTerminal)
        if (nonTerminal.equals(grammar.getStartingSymbol()))
            followSet.add("$");

        // iterate through each non-terminal in the grammar
        for (String symbol : grammar.getNonTerminals()) {
            // iterate through each production for the current non-terminal
            for (List<String> production : grammar.getProductionsForNonTerminal(symbol)) {
                int index = production.indexOf(nonTerminal);

                // if nonTerminal is found in the production and is not the last symbol
                if (index != -1 && index < production.size() - 1) {
                    // get nextSymbol in the production
                    String nextSymbol = production.get(index + 1);

                    // if nextSymbol is a non-terminal, add FIRST(nextSymbol) (excluding Є) to FOLLOW(nonTerminal)
                    if (grammar.getNonTerminals().contains(nextSymbol)) {
                        followSet.addAll(firstSets.get(nextSymbol));
                        followSet.remove("Є");

                        // if Є is in FIRST(nextSymbol), add FOLLOW(symbol) to FOLLOW(nonTerminal)
                        if (firstSets.get(nextSymbol).contains("Є"))
                            followSet.addAll(computeFollowSet(symbol));
                    }
                    // if nextSymbol is a terminal, add it to FOLLOW(nonTerminal)
                    else
                        followSet.add(nextSymbol);
                }
                // if nonTerminal is at the end of the production and is not the same as symbol, add FOLLOW(symbol) to FOLLOW(nonTerminal)
                else if (index == production.size() - 1 && !symbol.equals(nonTerminal))
                    followSet.addAll(computeFollowSet(symbol));
            }
        }

        return followSet;
    }

    public void printFirstSets() {
        for (String nonTerminal: firstSets.keySet())
            System.out.println("FIRST(" + nonTerminal + ") = " + firstSets.get(nonTerminal));
    }

    public void printFollowSets() {
        for (String nonTerminal: followSets.keySet())
            System.out.println("FOLLOW(" + nonTerminal + ") = " + followSets.get(nonTerminal));
    }
}