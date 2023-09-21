import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code {
    final Map<String, List<Integer>> _dest = new HashMap<String, List<Integer>>();
    final Map<String, List<Integer>> _comp = new HashMap<String, List<Integer>>();
    final Map<String, List<Integer>> _jump = new HashMap<String, List<Integer>>();
    
    Code(){
        _dest.put(null, Arrays.asList(0, 0, 0));
        _dest.put("M", Arrays.asList(0, 0, 1));
        _dest.put("D", Arrays.asList(0, 1, 0));
        _dest.put("MD", Arrays.asList(0, 1, 1));
        _dest.put("A", Arrays.asList(1, 0, 0));
        _dest.put("AM", Arrays.asList(1, 0, 1));
        _dest.put("AD", Arrays.asList(1, 1, 0));
        _dest.put("AMD", Arrays.asList(1, 1, 1));

        _comp.put("0", Arrays.asList(0, 1, 0, 1, 0, 1, 0));
        _comp.put("1", Arrays.asList(0, 1, 1, 1, 1, 1, 1));
        _comp.put("-1", Arrays.asList(0, 1, 1, 1, 0, 1, 0));
        _comp.put("D", Arrays.asList(0, 0, 0, 1, 1, 0, 0));
        _comp.put("A", Arrays.asList(0, 1, 1, 0, 0, 0, 0));
        _comp.put("!D", Arrays.asList(0, 0, 0, 1, 1, 0, 1));
        _comp.put("!A", Arrays.asList(0, 1, 1, 0, 0, 0, 1));
        _comp.put("-D", Arrays.asList(0, 0, 0, 1, 1, 1, 1));
        _comp.put("-A", Arrays.asList(0, 1, 1, 0, 0, 1, 1));
        _comp.put("D+1", Arrays.asList(0, 0, 1, 1, 1, 1, 1));
        _comp.put("A+1", Arrays.asList(0, 1, 1, 0, 1, 1, 1));
        _comp.put("D-1", Arrays.asList(0, 0, 0, 1, 1, 1, 0));
        _comp.put("A-1", Arrays.asList(0, 1, 1, 0, 0, 1, 0));
        _comp.put("D+A", Arrays.asList(0, 0, 0, 0, 0, 1, 0));
        _comp.put("D-A", Arrays.asList(0, 0, 1, 0, 0, 1, 1));
        _comp.put("A-D", Arrays.asList(0, 0, 0, 0, 1, 1, 1));
        _comp.put("D&A", Arrays.asList(0, 0, 0, 0, 0, 0, 0));
        _comp.put("D|A", Arrays.asList(0, 0, 1, 0, 1, 0, 1));
        _comp.put("M", Arrays.asList(1, 1, 1, 0, 0, 0, 0));
        _comp.put("!M", Arrays.asList(1, 1, 1, 0, 0, 0, 1));
        _comp.put("-M", Arrays.asList(1, 1, 1, 0, 0, 1, 1));
        _comp.put("M+1", Arrays.asList(1, 1, 1, 0, 1, 1, 1));
        _comp.put("M-1", Arrays.asList(1, 1, 1, 0, 0, 1, 0));
        _comp.put("D+M", Arrays.asList(1, 0, 0, 0, 0, 1, 0));
        _comp.put("D-M", Arrays.asList(1, 0, 1, 0, 0, 1, 1));
        _comp.put("M-D", Arrays.asList(1, 0, 0, 0, 1, 1, 1));
        _comp.put("D&M", Arrays.asList(1, 0, 0, 0, 0, 0, 0));
        _comp.put("D|M", Arrays.asList(1, 0, 1, 0, 1, 0, 1));

        _jump.put(null, Arrays.asList(0, 0, 0));
        _jump.put("JGT", Arrays.asList(0, 0, 1));
        _jump.put("JEQ", Arrays.asList(0, 1, 0));
        _jump.put("JGE", Arrays.asList(0, 1, 1));
        _jump.put("JLT", Arrays.asList(1, 0, 0));
        _jump.put("JNE", Arrays.asList(1, 0, 1));
        _jump.put("JLE", Arrays.asList(1, 1, 0));
        _jump.put("JMP", Arrays.asList(1, 1, 1));

    }
    
    List<Integer> dest(String mnemonic){
        return _dest.get(mnemonic);
    }

    List<Integer> comp(String mnemonic){
        return _comp.get(mnemonic);
    }
    
    List<Integer> jump(String mnemonic){
        return _jump.get(mnemonic);
    }

}
