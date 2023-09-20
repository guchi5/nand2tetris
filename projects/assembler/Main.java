public class Main {
    public static void main(String args[]){
        if(args.length != 1){
            return;
        }

        Parser parser = new Parser(args[0]);
    }
}
