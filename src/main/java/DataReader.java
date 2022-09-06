import java.util.Scanner;
import java.util.regex.Pattern;

 class DataReader {

    private String arg1;
    private String arg2;
    private char oper;
    private boolean exitFlag;
    private char exitCharacter;

    DataReader(char exitCharacter) {
        this.exitCharacter = exitCharacter;
    }
    String read(String input, Digits check) {
        String text = input;
        boolean isRoman = false;
        boolean isArab = false;
        if (text.indexOf(exitCharacter) != -1) {
            this.exitFlag = true;
            System.out.println("Closed");
            System.exit(1);
        }
        isRoman = Pattern.matches("[I|V|X]*[-|+|*|/][I|V|X]*[=]", text);
        isArab = Pattern.matches("[0-9]*[-|+|*|/]*[0-9][=]", text);
        check.isArab = isArab;
        check.isRoman = isRoman;
        if (isRoman|isArab) {
            if (Pattern.matches(".*[-|+|*|/].*",text)) {
                text = text.substring(0, text.length() - 1);
                String[] blocks = text.split("[-|+|*|/]");
                this.arg1 = blocks[0];
                this.oper = text.charAt(blocks[0].length());
                this.arg2 = blocks[1];
                if (this.arg1.matches("^[\\d]+$") != this.arg2.matches("^[\\d]+$")) {
                    throw new RuntimeException("Can't calculate different types of number");
                }
            } else {
                throw new RuntimeException("Can't calculate without operator '+' '-' '*' or '/'");
            }
        } else {
            throw new RuntimeException("Input string doesn't match available expressions");
        }
        return "VALIDATED";
    }

    String getArg1() {
        return this.arg1;
    }

    String getArg2() {
        return this.arg2;
    }

    char getOper() {
        return this.oper;
    }

    boolean isExitFlag() {
        return this.exitFlag;
    }
}
