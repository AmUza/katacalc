package katacalc.src.main.java;

import java.util.regex.Pattern;

class Calculator {

    static double calculate(int arg1, int arg2, char operation){
        double result;
        switch (operation){
            case '+': result = ((double)arg1) + ((double)arg2); break;
            case '-': result = ((double)arg1) - ((double)arg2); break;
            case '*': result = ((double)arg1) * ((double)arg2); break;
            case '/': result = ((double)arg1) / ((double)arg2); break;
            default:
                throw  new ArithmeticException("Error in calculation");
        }
        return result;
    }

    static int Format(String input) {
        int num = 0;
        int arg;
            if (Pattern.matches("[\\d]",input)){
                arg=Integer.parseInt(input);
                if ((arg<=10)&&(arg>=1)){
                    num=arg;
                } else {
                    throw new IllegalArgumentException("Error in value: number " + input + " is not supported. ");
                }
            } else {
                num = Digits.switchToArab(input);
            }
        return num;
    }
}