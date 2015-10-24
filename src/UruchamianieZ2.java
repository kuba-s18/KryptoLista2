
public class UruchamianieZ2 {
	public static void main(String[] args) {
        Runnable[] runners = new Runnable[1000];
        Thread[] threads = new Thread[1000];
        long poczatek=0;
        //long koniec=(long)Math.pow(16, 8);
        long koniec=4294968;
 
        for(int i=0; i<1000; i++) {
        	if(koniec>(long)Math.pow(16,8)){
        	runners[i] = new TestyRc4(poczatek,(long)Math.pow(16,8));
        	}else
        	{
            runners[i] = new TestyRc4(poczatek,koniec);
        	}
            koniec=koniec+4294968;
            poczatek=poczatek+4294969;
        }
 
        for(int i=0; i<1000; i++) {
            threads[i] = new Thread(runners[i]);
        }
 
        for(int i=0; i<1000; i++) {
            threads[i].start();
        }
    }

}
