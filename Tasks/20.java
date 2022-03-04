import java.util.*;

public class Level1{


 private static final ChangeBuffer buffer = new ChangeBuffer();
    private static final StringBuilder currentString;

    static {
        currentString = new StringBuilder();
    }

    public static String BastShoe(String command) {
        boolean isSimpleCommand = !command.contains(" ");

        if(!isCommandCorrect(command)){
            return currentString.toString();
        }

        int commandNumber = isSimpleCommand
                ? Integer.parseInt(command)
                : Integer.parseInt(command.substring(0, command.indexOf(" ")));

        String data = isSimpleCommand
                ? ""
                : command.substring(command.indexOf(" ") + 1);

        switch (commandNumber){
            case 1:
                String message = data;
                currentString.append(message);

                buffer.save(currentString.toString());
                return currentString.toString();
            case 2:
                int amountSymbolsToDelete = Integer.parseInt(data);
                if(amountSymbolsToDelete >= currentString.length()){
                    currentString.setLength(0);
                }
                else if(amountSymbolsToDelete >= 0) {
                    currentString.setLength(currentString.length() - amountSymbolsToDelete);
                }

                buffer.save(currentString.toString());
                return currentString.toString();
            case 3:
                String resultStr = "";
                int symbolIndex = Integer.parseInt(data);
                if(symbolIndex >= 0 && symbolIndex < currentString.length()){
                    resultStr = Character.toString(currentString.charAt(symbolIndex));
                }
                return resultStr;
            case 4:
                currentString.setLength(0);
                currentString.append(buffer.undo());
                return currentString.toString();
            case 5:
                currentString.setLength(0);
                currentString.append(buffer.redo());
                return currentString.toString();
        }
        return currentString.toString();
    }


    private static boolean isCommandCorrect(String command){
        if(!Character.isDigit(command.charAt(0))){
            return false;
        }

        int commandCode = Integer.parseInt(Character.toString(command.charAt(0)));

        if(commandCode < 1 || commandCode > 5){
            return false;
        }

        if((commandCode == 1 || commandCode == 2 || commandCode == 3) && (command.length() <= 1 || command.charAt(1) != ' ')){
            return false;
        }

        if((commandCode == 4 || commandCode == 5) && command.length() != 1){
            return false;
        }

        if((commandCode == 2 || commandCode == 3) && !Character.isDigit(command.charAt(2))){
            return false;
        }

        return true;
    }

    private static class ChangeBuffer {
        private List<String> buffer = new ArrayList<>();
        private int cursor = -1;
        private String lastOperation = "";

        public void save(String record){
            if(lastOperation.equals("undo") && cursor != -1){
                String current = buffer.get(cursor);
                buffer.clear();
                buffer.add(current);
                cursor = 0;
            }

            cursor++;
            buffer.add(cursor, record);

            lastOperation = "save";
        }

        public String undo(){
            if(cursor == -1){
                return buffer.get(0);
            }

            lastOperation = "undo";

            if(cursor != 0){
                cursor--;
                return buffer.get(cursor);
            }
            else {
                return buffer.get(0);
            }
        }

        public String redo(){
            if(cursor < buffer.size() - 1){
                cursor++;
            }

            lastOperation = "redo";

            return buffer.get(cursor);
        }
    }
}