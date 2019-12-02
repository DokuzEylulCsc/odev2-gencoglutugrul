package edu.deu.gencoglutugrul;

import java.util.Arrays;
import java.util.List;

public class RomanNumberConverter {

    /**
     *  // figure word used instead of turkish word "rakam"
     *
     *
     * @desc Converts given arabicFigure to romanFigure only for 1-9 and multiplies of ten's power
     * @param arabicFigure
     * @return romanFigure
     */
    private String getRomanFigureFromArabicFigure(int arabicFigure){
        String[] startsWithOne = {"I","X","C","M"};
        String[] startsWithFive = {"V","L","D"};

        // for example arabicNumber=300
        // tenPower=2 because 300= 3 * 10^2
        // biggestDigitsFigure=3
        int tenPower = (int)Math.log10(arabicFigure);
        int biggestDigitsFigure = arabicFigure/(int)Math.pow(10, tenPower);

        if(biggestDigitsFigure >= 1 && biggestDigitsFigure<=3)
            return startsWithOne[tenPower].repeat(biggestDigitsFigure);
        else if(biggestDigitsFigure==4)
            return startsWithOne[tenPower]+startsWithFive[tenPower];
        else if(biggestDigitsFigure==5)
            return startsWithFive[tenPower];
        else if(biggestDigitsFigure>=6 && biggestDigitsFigure<=8)
            return startsWithFive[tenPower]+startsWithOne[tenPower].repeat(biggestDigitsFigure - 5);
        else if(biggestDigitsFigure == 9)
            return startsWithOne[tenPower]+startsWithOne[tenPower+1];

        return null;
    }


    /**
     * Converts given romanFigure to arabicFigure
     * @param romanFigure
     * @return
     */
    private int getArabicFigurueFromRomanFigure(String romanFigure){
        String[] romanFigures = new String[]{"I","X","C","M","V","L","D"};
        List<String> romanFigureList = Arrays.asList(romanFigures);

        int[] arabicFigures = { 1, 10, 100, 1000, 5, 50, 500 };

        return arabicFigures[romanFigureList.indexOf(romanFigure)];
    }

    /**
     *
     * @desc Converts given arabicNumber to romanNumber
     * @param arabicNumber
     * @return romanNumber
     */
    public String arabicNumberToRomanNumber(int arabicNumber){
        // get digit length of arabicNumber
        int length =  (int)Math.log10(arabicNumber) + 1;
        int lastValue = arabicNumber;
        String romanNumber = "";

        for(int i = (length - 1); i>=0; i--){
            // for example 3213 - ( 3213 % 10^3 ) = 3000
            // second loop: 213 - ( 213 % 10^2 ) = 200
            int arabicFigure = (int)(lastValue - (lastValue % Math.pow(10, i)));
            romanNumber = romanNumber + this.getRomanFigureFromArabicFigure(arabicFigure);

            // lastValue = 3213 - 3000 = 213
            // second loop: lastValue = 213 - 200 = 13
            // keep going like that
            lastValue = lastValue - arabicFigure;
        }

        return romanNumber;
    }

    /**
     *
     * @desc Converts given romanNumber to arabicNumber
     * @param romanNumber
     * @return arabicNumber
     */
    public int romanNumberToArabicNumber(String romanNumber){

        char[] charArray = romanNumber.toCharArray();
        int lastFigure = 0; // lowest number for compare
        int arabicNumber = 0;

        for(int i=charArray.length -1; i>=0; i--){
            String nowChar = String.copyValueOf(new char[]{charArray[i]});
            int arabicEqualsOfNowChar = this.getArabicFigurueFromRomanFigure(nowChar);

            // for example romanNumber: XL = 50 - 10 = 40 L>X --> L-X
            if(lastFigure > arabicEqualsOfNowChar)
                arabicNumber = arabicNumber - arabicEqualsOfNowChar;
            else
                arabicNumber = arabicNumber + arabicEqualsOfNowChar;

            lastFigure = arabicEqualsOfNowChar;
        }

        return arabicNumber;
    }

    /**
     * Checks given romanNumber valid or not.
     * @param romanNumber
     * @return
     */
    public boolean checkIfValidRomanNumber(String romanNumber) {
        String[] romanCharArray = new String[]{"I","X","C","M","V","L","D"};
        List<String> validCharList = Arrays.asList(romanCharArray);

        // check if there is an invalid character
        for(int i=0; i<romanNumber.length(); i++){
            String romanChar = String.copyValueOf(new char[]{romanNumber.charAt(i)});

            if(!validCharList.contains(romanChar))
                return false;
        }

        // check if something repeated more than 3 like xxxx
        for(int i=0; i<romanCharArray.length; i++){
            if( romanNumber.indexOf(validCharList.get(i).repeat(4)) > -1 )
                return false;
        }

        // TODO: Check if is there something like this XXC -> XC valid but XXC is not.
        // TODO: Check if is there something like this IC -> XC valid but IC is not.
        // TODO: Check if is there something like this LL -> XX valid but LL is not.

        return true;
    }
}
