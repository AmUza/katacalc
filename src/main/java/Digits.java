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


     int result(double input){
         int output;
         if (((this.isRoman)&&(input<1))|(this.isArab)) {
             output = (int)Math.ceil(input);
             this.result = output;
         } else {
             throw new RuntimeException("Error in result: " + input + " is not supported. ");
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
