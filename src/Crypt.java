import java.io.UnsupportedEncodingException;


public class Crypt {
	public static byte[] toBin(char c) {
		byte[] tab = Integer.toString(c,2).getBytes();
		for(int i=0;i<tab.length;i++){
			tab[i]-=48;
		}
		return tab;
	}
	
	public static byte[] toBin(String s) {
		char[] cTab = s.toCharArray();
		byte[] bTab = new byte[cTab.length * 8];
		for(int i=0;i<cTab.length;i++) {
			byte[] tmp = toBin(cTab[i]);
			int tmpi = 0;
			for(int j=0;j<8;j++) {
				if(tmp.length<8-j) {
					bTab[(i*8)+j]=0;
					tmpi++;
				}
				else
					bTab[(i*8)+j]=toBin(cTab[i])[j-tmpi];
			}
		}
		return bTab;
	}
	
	public static String toStr(byte[] tab) {
		StringBuffer tmp = new StringBuffer();
		
		for(int i=0;i<tab.length;i+=8) {
			byte[] tmpB = new byte[8];
			int tmpI = 0;
			for(int j=0;j<8;j++) {
				if(tab.length-i<8) {
					tmpB[j]=0;
					tmpI++;
				}
				else
					tmpB[j]=tab[i+j-tmpI];
			}
			for(int k=0;k<tmpB.length;k++){
				tmpB[k]+=48;
			}
			try {
				String testC = new String(tmpB, "UTF-8");
				int testI = Integer.parseInt(testC,2);
				tmp.append((char)testI);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return tmp.toString();
	}
	
	public static void printBin(byte[] tab) {
		System.out.print("[");
		for(int i=0;i<tab.length-1;i++) {
			System.out.print(tab[i]+", ");
		}
		System.out.println(tab[tab.length-1]+"]");
	}
}
