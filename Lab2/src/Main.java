public class Main {
    public static void main(String[] args) {
        HashTable<Object> symbolTable = new HashTable<>(10);

        symbolTable.add("a");
        symbolTable.add(11);
        symbolTable.add("b");
        symbolTable.add(27);
        symbolTable.add("a");

        System.out.println(symbolTable);

        System.out.println("Key a - Val " + symbolTable.search("a"));
        System.out.println("Key 11 - Val " + symbolTable.search(11));
        System.out.println("Key b - Val " + symbolTable.search("b"));
        System.out.println("Key 27 - Val " + symbolTable.search(27));
        System.out.println("Key 5 - Val " + symbolTable.search(5));
    }
}
