package projects.assembler;

public class Parser<T>{
    Parser(){

    }
    
    boolean hasMoreCommands(){
        return false;
    }

    void advance(){

    }

    T commandType(){
        return null;
    }

    String symbol(){
        return null;
    }

    String dest(){
        return null;
    }

    String comp(){
        return null;
    }

    String jump(){
        return null;
    }
}