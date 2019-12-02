package edu.deu.gencoglutugrul;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int askCount=0;
        int answer;
        RomanNumberConverter converter = new RomanNumberConverter();

        System.out.println("Roma ve Arap Sayı Çevirici programı versiyon: 1.0");

        do {
            if(askCount>0 )
                System.out.println("Geçersiz giriş yaptınız lütfen tekrar deneyiniz.");

            if(askCount==3){
                System.out.println("3 defa art arda geçersiz giriş yaptınız, program kapatılacaktır.");
                System.exit(0);
            }

            System.out.println("Roma sayısını arap sayısına çevirmek için 1'e,");
            System.out.println("Arap sayısını roma sayısına çevirmek için 2'ye,");
            System.out.println("Çıkış yapmak için 3'e basınız.");

            answer=s.nextInt();

            // nextInt method just get int part of input and [enter] part of input waiting for
            // another input parsing method. We MUST invoke nextLine method.
            s.nextLine();

            askCount++;
        }while(answer != 1 && answer != 2 && answer != 3);

        if(answer == 3)
            System.exit(0);

        if(answer == 1){
            // convert roman number to arabic number
            System.out.println("Lütfen I-MMMCMXCIX aralığında, roma rakamları ile oluşturulan bir sayı giriniz: ");
            String romanNumber = s.nextLine().toUpperCase();
            if(converter.checkIfValidRomanNumber(romanNumber)) {
                int arabicNumber = converter.romanNumberToArabicNumber(romanNumber);
                System.out.println(romanNumber + " sayısının arap rakamları ile karşılığı: " + arabicNumber);
            }else{
                System.out.println("Hata: Program sadece I-MMMCMXCIX aralığındaki geçerli sayılara destek vermektedir!");
            }
        }else{
            // convert arabic number to roman number
            System.out.println("Lütfen 1-3999 aralığında, arap rakamları ile oluşturulan bir sayı giriniz: ");
            int arabicNumber = s.nextInt();

            // nextInt method just get int part of input and [enter] part of input waiting for
            // another input parsing method. We MUST invoke nextLine method.
            s.nextLine();

            if(arabicNumber >=1 && arabicNumber <= 3999) {
                String romanNumber = converter.arabicNumberToRomanNumber(arabicNumber);
                System.out.println(arabicNumber + " sayısının roma rakamları ile karşılığı: " + romanNumber);
            }else{
                System.out.println("Hata: Program sadece 1-3999 aralığındaki sayılara destek vermektedir!");
            }
        }

    }
}
