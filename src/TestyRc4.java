import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TestyRc4 implements Runnable{
	long pocz;
	long koniec;
	
	public TestyRc4(long pocz,long koniec)
	{
		this.pocz=pocz;
		this.koniec=koniec;
	}
	
	//RC4( "Key", "Plaintext" ) == BBF316E8D940AF0AD3
	public static byte[] tablicaBitów(String klucz)
	{
		byte[] bit=new byte[klucz.length()];
		for(int i=0;i<klucz.length();i++)
		{
			bit[i]=(byte)klucz.charAt(i);
			System.out.print(bit[i]);
		}
		return bit;
	}

public static void drukuj(byte[] backtext)
{	
	for (int i = 0; i < backtext.length; i++) { 
		System.out.print((char)backtext[i]);
	}
	System.out.println("");
}


public void run() {
		PrintWriter zapis=null;
		try
		{
		zapis = new PrintWriter("wyniki.txt");
		}catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
        String czescKlucza = "ec4d11fd";
        //            514eaec2ec4d11fd
         //convert keyword to byte
        
       String text = "101111000011111100100101001001111000010010000100000111110101011111111011011101011101100001011001111001101011011101011000011011101000011100000000111010100000101000111001110001011101101011101110000110010100001101110100010011000111110111000011001101101010111010110111110010111101111011100110111111000101011000010011100111010100111010100000001110110001011000110110111001011110001111111001000010001011000111011100111101001111011110010100010001001111011000001111101001000100110101110011"; // text as 12345
        byte[] texttest = new byte[text.length()/8];
        int k=0;int s=0;
        while(k+8<=text.length())
        {
        	texttest[s]=(byte) Integer.parseInt(text.substring(k, k+8), 2);
        	k=k+8;
        	s=s+1;
        }
        RC4 rc4;
  
        for (long a = pocz; a < koniec; a++) {

            String test2 = Long.toHexString(a);

            while (test2.length() < 8) {
                test2 = "0" + test2;
            }

            String klucz = test2 + czescKlucza;
            byte[] keytest = klucz.getBytes();

        rc4 = new RC4(keytest);
        byte[] backtext = rc4.decrypt(texttest); //decryption
        for (int i = 0; i < backtext.length; i++) {  
        	if((backtext[i]<32 || backtext[i]>122))
        		break; else{
        	if(i==backtext.length-1)
        	{
        		System.out.println(klucz);
        	zapis.println(a);
        	drukuj(backtext);
        	}  
        		}
        } 
        
        }
        zapis.close();
}}