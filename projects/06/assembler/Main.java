import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static int pc;
    private static int rom_address = 16;
    public static void main(String args[]){
        if(args.length != 1){
            return;
        }

        Code code = new Code();
        SymbolTable symbol_table = new SymbolTable();

        pc = 0;
        for(int count=0;count<2;count++){
            Parser parser = new Parser(args[0]);

            while(parser.hasMoreCommands()){
                parser.advance();
                if(parser.commandType()==parser.getCommandNum("A_COMMAND")){

                    if(count==0){
                        pc++;
                        continue;
                    }
                    int symbol;
                    if(parser.symbol().matches("^[A-Za-z$:._]+.*")){
                        if(!symbol_table.contains(parser.symbol())){
                            symbol_table.addEntry(parser.symbol(), rom_address);
                            rom_address++;
                        }
                        symbol = symbol_table.getAddress(parser.symbol());
                    }else{
                        symbol = Integer.parseInt(parser.symbol());
                    }
                    String command = Integer.toBinaryString(symbol);
                    List<String> commandList = new ArrayList<>(Arrays.asList(command.split(""))); 
                    while(commandList.size()<16){
                        commandList.add(0, "0");
                    }

                    System.out.println(String.join("", commandList));
                    
                }else if(parser.commandType()==parser.getCommandNum("C_COMMAND")){
                    if(count==0){
                        pc++;
                        continue;
                    }

                    List<Integer> command = new ArrayList<>(Arrays.asList(1, 1, 1));
                    command.addAll(code.comp(parser.comp()));
                    command.addAll(code.dest(parser.dest()));
                    command.addAll(code.jump(parser.jump()));
                    
                    System.out.println(command.stream().map(String::valueOf).collect(Collectors.joining("")));
                }else if(parser.commandType()==parser.getCommandNum("L_COMMAND")){
                    if(count==1){
                        continue;
                    }            
                    symbol_table.addEntry(parser.symbol(), pc);
                }else{
                    return;
                }
                
            }

        }        

    }
}
