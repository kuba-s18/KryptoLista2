import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Pomoc {


public static void main(String args[]){

	String kryptogram;
	String kluczZnak="";
	String wynik[]= new String[79];
	Scanner odczyt = null;
	String[] szyfrogram = new String[20];
	int[] klucz={134,216,237,16,234,187,67,222,194,173,10,153,101,62,233,4,83,30,38,164,115,225,202,29,23,155,245,17,75,176,30,31,127,96,66,80,1,227,128,161,217,220,199,56,195,24,232,131,202,146,170,242,0,165,158,21,210,92,24,98,51,5,177,107,140,200,211,227,205,95,90,72,251,151,67,163,181,246,249};

	try
	{
		odczyt = new Scanner(new File("D:\\Programowanie\\KryptoL2\\src\\kryptogramy.txt"));
	}
	catch (FileNotFoundException e) 
	{
		e.printStackTrace();
	}
	for(int i=0;i<20;i++)
	{
		odczyt.nextLine();
		szyfrogram[i]=odczyt.nextLine();
	}
	for(int s=0;s<=20;s++)
	{
		int j=0;
		int skok =0;
		if(s==20)
		{
			System.out.println("WYNIK ZADANIE 1:");
			kryptogram="11010100 10111101 10000110 01100100 10000101 11001001 01100011 10110010 10101101 11001001 01110000 11110010 00001100 01011011 10000011 00100100 00110101 01110111 01001010 11001001 00011100 10010110 10100001 01110100 00110111 11111010 10000101 01110100 00100111 11000101 01110100 01111010 01011111 00000100 00101101 01110000 01110010 10010111 11110101 11000101 10111100 10110010 10110011 11001011 10110100 00100010 11001000 10100001 10000100 11111011 11001111 11010010 01101111 11000010 11110010 01110100 10110110 00111101 01110010 00001111 01001010 00100101 11100001 00000100 11100000 10111011 10110010 10010111 10111000 01111111 00110011 01101000 10101111 11000001 00001101 10001110 11000000 11010111 11011011";

		}else
		kryptogram=szyfrogram[s];
		
for(int i=0;i<79;i++)
{
	kluczZnak=Integer.toBinaryString(klucz[i]);
	while (kluczZnak.length()<8)
	{
		kluczZnak="0"+kluczZnak;
	}
		//System.out.println(kluczZnak);
		wynik[j]="";
	for(int k=0;k<8;k++){
		wynik[j]=wynik[j]+(kryptogram.charAt(k+skok)^kluczZnak.charAt(k));
	}
	System.out.print(""+(char)Integer.parseInt(wynik[j],2));
	j++;
	skok=skok+9;
}
System.out.println("");
	}
}}
