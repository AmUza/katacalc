package katacalc.src.main.java;

class Digits {

     boolean isRoman = false;
     boolean isArab = false;
     static int result;

     public Digits(boolean isRoman, boolean isArab) {
         this.isArab = isArab;
         this.isRoman = isRoman;

     }

     static int switchToArab(String input) {
        int output;
        switch (input) {
            case "VIII":
                output = 8;
                break;
            case "VII":
                output = 7;
                break;
            case "VI":
                output = 6;
                break;
            case "III":
                output = 3;
                break;
            case "II":
                output = 2;
                break;
            case "IV":
                output = 4;
                break;
            case "I":
                output = 1;
                break;
            case "V":
                output = 5;
                break;
            case "IX":
                output = 9;
                break;
            case "X":
                output = 10;
                break;
            default:
                throw new RuntimeException("Error in value: " + input + " is not supported. ");
        }
        return output;
    }

    static String switchToRomanAll(int input) {

        String output = null;
        String value = String.valueOf(input);
        if (input/10>0) {
            output = "X";
            input = input - 10;
            for (int i = input / 10; i > 0; i--) {
                output = output + "X";
                System.out.println(output);
                input = input - 10;
            }
        }
        if (input==9) {
            if (output==null) {
                output = "IX";
            } else {
                output = output + "IX";
            }
            input = input - 9;
        }
        if (input/5>0) {
            if (output==null) {
                output = "V";
            } else {
                output = output + "V";
            }
            input = input - 5;
            for(int i = input/5; i > 0; i--) {
                output = output + "V";
                System.out.println(output);
                input = input - 5;
            }
        }
        if (input==4) {
            if (output==null) {
                output = "IV";
            } else {
                output = output + "IV";
            }
            input = input - 4;
        }
        if (input/1>0) {
            if (output==null) {
                output = "I";
            } else {
                output = output + "I";
            }
            input = input - 1;
            int count = 0;
            for(int i = input/1; i > 0; i--) {
                output = output + "I";
                System.out.println(output);
                input = input - 1;
            }
        }
        return output;
    }
    static String switchToRoman(int input) {
        String output;
        switch (input) {
            case 1:
                output = "I";
                break;
            case 2:
                output = "II";
                break;
            case 3:
                output = "III";
                break;
            case 4:
                output = "IV";
                break;
            case 5:
                output = "V";
                break;
            case 6:
                output = "VI";
                break;
            case 7:
                output = "VII";
                break;
            case 8:
                output = "VIII";
                break;
            case 9:
                output = "IX";
                break;
            case 10:
                output = "X";
                break;
            default:
                throw new RuntimeException("Error in value: " + input + " is not supported. ");
        }
        return output;
    }


     int result(double input){
         int output;
         double value = input;
         //output = (int)Math.ceil(input);
         value = value * Math.pow(10, 0);
         value = Math.floor(value);
         value = value / Math.pow(10, 0);
         output = (int)value;
         if ( ((this.isRoman) && (input>=1)) | (this.isArab) ) {
             this.result = output;
         } else {
             throw new RuntimeException("Error in result: " + output + " is not supported. ");
         }
         return output;
     }

    void setResult(double result) {
         this.result = result(result);
     }
     static int getResult (){
         return result;
     }
}
