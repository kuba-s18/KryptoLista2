import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FormatowaniePliku {
	public static void main(String args[]){
		Scanner odczyt = null;
		PrintWriter zapis=null;
		String[] szyfrogram = new String[21];
		String[] klucz= new String[256];
		String[][] wyniki=new String[256][21];
		String linia;
		Ascii ascii = new Ascii();
		ArrayList<Integer> asciilista = (ArrayList<Integer>)ascii.getascii();
		int skok=0;
		int dl=0;
		
	try
	{
		odczyt = new Scanner(new File("D:\\Programowanie\\KryptoL2\\src\\kryptogramy.txt"));
		zapis = new PrintWriter("wyniki.txt");
	} 
	catch (FileNotFoundException e) 
	{
		e.printStackTrace();
	}
	
	for(int i=0;i<21;i++)
	{
		odczyt.nextLine();
		szyfrogram[i]=odczyt.nextLine();
	}
	while(szyfrogram[20].length()>=dl){
	// Tworzenie 256 kluczy 
	for(int i=0;i<256;i++)
	{
		klucz[i]=Integer.toBinaryString(i);
		while (klucz[i].length()<8)
		{
			klucz[i]="0"+klucz[i];
		}
		for(int j=0;j<21;j++)
		{
			wyniki[i][j]="";
			for(int k=0;k<8;k++){
				wyniki[i][j]=wyniki[i][j]+(szyfrogram[j].charAt(k+skok)^klucz[i].charAt(k));
			}
			if(asciilista.contains(Integer.parseInt(wyniki[i][j],2))==false){
				wyniki[i][j]="";
				break;
			}
			if(j==20)
			{
			System.out.print(""+(char)Integer.parseInt(wyniki[i][j],2));
			System.out.print("_");
			}
		}
		}
	skok=skok+9;
	System.out.println("");
	dl=dl+9;
	}
	
	
	
	
	
	
	
	

}
	
}

