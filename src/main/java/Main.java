import java.util.Scanner;

public class Main {

    private static final char exitCharacter = 'x';
    private static DataReader reader;
    private static Digits check = new Digits(false, false);
    public static void main(String[] args) {
        String outPut = null;
        System.out.println("Input arithmetic expression and press 'Enter' (for example '5+5=' or 'V-III='). ");
        System.out.println("Press 'x' key for exit. ");

        System.out.println("Input: ");
        reader = new DataReader(exitCharacter);
        //Digits check = new Digits(false, false);
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
            try {
                String validation = reader.read(text, check);
                outPut = calc(validation);
            } catch (RuntimeException e) {
                outPut = e.getMessage();
                //break;
            }
            System.out.println("Output: " + outPut);
    }

    public static String calc(String input) {
        String res = "Something went wrong";
        if (input.equals("VALIDATED")) {
            int numb1 = 0;
            int numb2 = 0;
            String str1 = reader.getArg1();
            if (str1 != null) {
                try {
                    numb1 = Calculator.Format(str1);
                } catch (RuntimeException e) {
                    return e.getMessage();
                }
            }
            String str2 = reader.getArg2();
            if (str2 != null) {
                try {
                    numb2 = Calculator.Format(str2);
                } catch (RuntimeException e) {
                    return e.getMessage();
                }
            }
            if (numb1 != 0 && numb2 != 0) {
                double result = Math.rint(100.00 * Calculator.calculate(numb1, numb2, reader.getOper())) / 100.00;
                check.setResult(result);
                int output = Digits.getResult();
                res = String.valueOf(output);
            }
        }
        return res;
    }
}