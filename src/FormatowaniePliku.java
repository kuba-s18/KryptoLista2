import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FormatowaniePliku {
	public static void main(String args[]){
		Scanner odczyt = null;
		PrintWriter zapis=null;
		String[] szyfrogram = new String[20];
		String[] klucz= new String[256];
		String[][] wyniki=new String[256][20];
		String linia;
		
	try
	{
		odczyt = new Scanner(new File("D:\\Programowanie\\KryptoL2\\src\\kryptogramy.txt"));
		zapis = new PrintWriter("wyniki.txt");
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
	// Tworzenie 256 kluczy 
	for(int i=0;i<256;i++)
	{
		klucz[i]=Integer.toBinaryString(i);
		while (klucz[i].length()<8)
		{
			klucz[i]="0"+klucz[i];
		}
		System.out.print("K"+i+": ");
		for(int j=0;j<20;j++)
		{
			wyniki[i][j]="";
			for(int k=0;k<8;k++){
				wyniki[i][j]=wyniki[i][j]+(szyfrogram[j].charAt(k+405)^klucz[i].charAt(k));
			}
			if((Integer.parseInt(wyniki[i][j],2)<32 || Integer.parseInt(wyniki[i][j],2)>122)){
				wyniki[i][j]="";
				break;
			}
			if(j==19)
			System.out.print(" "+j+":"+(char)Integer.parseInt(wyniki[i][j],2));
			else{
				System.out.print(" "+(char)Integer.parseInt(wyniki[i][j],2));
			}
		}
		System.out.println("");
		}
	
	
	
	
	
	
	
	

}
	
}

