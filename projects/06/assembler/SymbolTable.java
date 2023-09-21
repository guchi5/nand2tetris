import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private Map<String, Integer> symbol;
    SymbolTable(){
        this.symbol = new HashMap<>();
        this.symbol.put("SP", 0);
        this.symbol.put("LCL", 1);
        this.symbol.put("ARG", 2);
        this.symbol.put("THIS", 3);
        this.symbol.put("THAT", 4);
        this.symbol.put("R0", 0);
        this.symbol.put("R1", 1);
        this.symbol.put("R2", 2);
        this.symbol.put("R3", 3);
        this.symbol.put("R4", 4);
        this.symbol.put("R5", 5);
        this.symbol.put("R6", 6);
        this.symbol.put("R7", 7);
        this.symbol.put("R8", 8);
        this.symbol.put("R9",9);
        this.symbol.put("R10", 10);
        this.symbol.put("R11", 11);
        this.symbol.put("R12", 12);
        this.symbol.put("R13", 13);
        this.symbol.put("R14", 14);
        this.symbol.put("R15", 15);
        this.symbol.put("SCREEN", 16384);
        this.symbol.put("KBD", 24576);



    }   
    
    void addEntry(String symbol, int address){
        this.symbol.put(symbol, address);
    }

    boolean contains(String symbol){
        return this.symbol.get(symbol) != null;
    }

    int getAddress(String symbol){
        return this.symbol.get(symbol);
    }
}
