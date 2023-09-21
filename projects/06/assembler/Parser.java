import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Parser{
    private Queue<String> commands;
    private String command;
    private final Map<String, Integer> command_type = new HashMap<String, Integer>() { 
        {
            put("A_COMMAND", 0);
            put("C_COMMAND", 1);
            put("L_COMMAND", 2);
        }
    };
    Parser(String data){
        Path path = Paths.get(data);
		
		try {
			String content = Files.readString(path);

            content = content.replaceAll("//.*", "").replaceAll(" ", "")
                            .replaceAll("^[\\r\\n]+", "");
            List<String> temp = Arrays.asList(content.split("[\\r\\n]+")); 
            List<String> empty = Arrays.asList(" ");
            temp.removeAll(empty);
            this.commands = new ArrayDeque<>(temp);
		} catch(IOException ex) {
			ex.printStackTrace();
		}

    }
    
    boolean hasMoreCommands(){
        return this.commands.size() != 0;
    }

    void advance(){
        this.command = this.commands.poll();
    }

    Integer commandType(){
        if(this.command.matches("^[@](([^0-9][\\w_.$:]+)|([0-9]+))$")){
            return this.command_type.get("A_COMMAND");
        }else if(this.command.matches("^((M|D|MD|A|AM|AD|AMD)=)?((![DAM])|(D[+-][AM1])|(A[+-][D1])|(M[+-][D1])|(D[&|][AM])|0|([-]?[1MDA]))(;(JGT|JEQ|JGE|JLT|JNE|JLE|JMP))?$")){
            return this.command_type.get("C_COMMAND");
        }else if(this.command.matches("\\([A-Za-z_.$:]+[\\w_.$:]*\\)")){
            return this.command_type.get("L_COMMAND");
        }
        return null;
    }

    String symbol(){
        if(this.command.charAt(0) == '@'){
            return this.command.split("@")[1];
        }else{
            return this.command.replaceAll("[()]", "");
        }
    }

    String dest(){
        if(this.command.split("=").length==2){
            return this.command.split("=")[0];
        }else{
            return null;
        }
    }

    String comp(){
        String[] comp = this.command.split("[;=]");
        if(comp.length==3){
            return comp[1];
        }else{
            if(this.command.split("=").length==2){
                return this.command.split("=")[1];
            }else{
                return this.command.split(";")[0];
            }
        }
    }

    String jump(){
        if(this.command.split(";").length==2){
            return this.command.split(";")[1];
        }else{
            return null;
        }
    }

    Integer getCommandNum(String type){
        return this.command_type.get(type);
    }
}