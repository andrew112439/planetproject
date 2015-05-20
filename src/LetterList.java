import java.util.ArrayList;
import java.util.Random;

public class LetterList {

	private static ArrayList<Letter> letters;
	private static ArrayList<String> loadingPhrases;
	
	public static String getLoadingPhrase(){
		Random r = new Random();
		return loadingPhrases.get(r.nextInt(loadingPhrases.size()));
	}
	
	public static int[][] search(String find){
		for(int i = 0; i < letters.size(); i++){
			if(find.equals(letters.get(i).getLetter())){
				return letters.get(i).getMatrix();
			}
		}
		return null;
	}
	
	public static void setup(){
		letters = new ArrayList<Letter>();
		loadingPhrases = new ArrayList<String>();
		
		int[][] a = {
				{1,1,1,1},
				{1,0,0,1},
				{1,1,1,1},
				{1,0,0,1},
				{1,0,0,1}
		};
		letters.add(new Letter("A", a));
		
		int[][] b = {
				{1,1,1,1},
				{1,0,0,1},
				{1,1,1,1},
				{1,0,0,1},
				{1,1,1,1}
		};
		letters.add(new Letter("B", b));
		
		int[][] c = {
				{1,1,1,1},
				{1,0,0,0},
				{1,0,0,0},
				{1,0,0,0},
				{1,1,1,1}
		};
		letters.add(new Letter("C", c));
		
		int[][] d = {
				{1,1,1,0},
				{1,0,0,1},
				{1,0,0,1},
				{1,0,0,1},
				{1,1,1,0}
		};
		letters.add(new Letter("D", d));
		
		int[][] e = {
				{1,1,1,1},
				{1,0,0,0},
				{1,1,1,1},
				{1,0,0,0},
				{1,1,1,1}
		}; 
		letters.add(new Letter("E", e));
		
		int[][] f = {
				{1,1,1,1},
				{1,0,0,0},
				{1,1,1,1},
				{1,0,0,0},
				{1,0,0,0}
		};
		letters.add(new Letter("F", f));
		
		int[][] g = {
				{1,1,1,1},
				{1,0,0,0},
				{1,0,1,1},
				{1,0,0,1},
				{1,1,1,1}
		};
		letters.add(new Letter("G",g));
		
		int[][] h = {
				{1,0,0,1},
				{1,0,0,1},
				{1,1,1,1},
				{1,0,0,1},
				{1,0,0,1}
		};
		letters.add(new Letter("H", h));
		
		int[][] i = {
				{1,1,1,1},
				{0,1,1,0},
				{0,1,1,0},
				{0,1,1,0},
				{1,1,1,1}
		};
		letters.add(new Letter("I", i));
		
		int[][] j = {
				{1,1,1,1},
				{0,0,1,0},
				{1,0,1,0},
				{1,0,1,0},
				{1,1,1,0,}
		};
		letters.add(new Letter("J", j));
		
		int[][] k = {
				{1,0,0,1},
				{1,0,1,0},
				{1,1,0,0},
				{1,0,1,0},
				{1,0,0,1}
		};
		letters.add(new Letter("K", k));
		
		int[][] l = {
				{1,0,0,0},
				{1,0,0,0},
				{1,0,0,0},
				{1,0,0,0},
				{1,1,1,1}
		};
		letters.add(new Letter("L", l));
		
		int[][] m = {
				{1,0,0,1},
				{1,1,1,1},
				{1,1,1,1},
				{1,0,0,1},
				{1,0,0,1}
		};
		letters.add(new Letter("M", m));
		
		int[][] n = {
				{1,0,0,1},
				{1,1,0,1},
				{1,0,1,1},
				{1,0,0,1},
				{1,0,0,1}
		};
		letters.add(new Letter("N", n));
		
		int[][] o = {
				{1,1,1,1},
				{1,0,0,1},
				{1,0,0,1},
				{1,0,0,1},
				{1,1,1,1}
		};
		letters.add(new Letter("O", o));
		
		int[][] p = {
				{1,1,1,1},
				{1,0,0,1},
				{1,1,1,1},
				{1,0,0,0},
				{1,0,0,0}
		};
		letters.add(new Letter("P", p));
		
		int[][] q = {
				{1,1,1,1},
				{1,0,0,1},
				{1,1,1,1},
				{0,0,0,1},
				{0,0,0,1}
		};
		letters.add(new Letter("Q", q));
		
		int[][] r = {
				{1,1,1,1},
				{1,0,0,1},
				{1,1,1,1},
				{1,0,1,0},
				{1,0,0,1}
		};
		letters.add(new Letter("R", r));
		
		int[][] s = {
				{1,1,1,1},
				{1,0,0,0},
				{1,1,1,1},
				{0,0,0,1},
				{1,1,1,1}
		};
		letters.add(new Letter("S", s));
		
		int[][] t = {
				{1,1,1,1},
				{0,1,1,0},
				{0,1,1,0},
				{0,1,1,0},
				{0,1,1,0}
		};
		letters.add(new Letter("T", t));
		
		int[][] u = {
				{1,0,0,1},
				{1,0,0,1},
				{1,0,0,1},
				{1,0,0,1},
				{1,1,1,1}
		};
		letters.add(new Letter("U", u));
		
		int[][] v = {
				{1,0,0,1},
				{1,0,0,1},
				{1,0,0,1},
				{1,0,0,1},
				{0,1,1,0}
		};
		letters.add(new Letter("V", v));
		
		int[][] w = {
				{1,0,0,1},
				{1,0,0,1},
				{1,0,0,1},
				{1,0,1,1},
				{1,1,1,1}
		};
		letters.add(new Letter("W", w));
		
		int[][] y = {
				{1,0,0,1},
				{1,0,0,1},
				{0,1,1,0},
				{0,1,1,0},
				{0,1,1,0}
		};
		letters.add(new Letter("Y", y));
		
		int[][] x = {
				{1,0,0,1},
				{1,0,0,1},
				{0,1,1,0},
				{1,0,0,1},
				{1,0,0,1}
		};
		letters.add(new Letter("X", x));
		
		int[][] z = {
				{1,1,1,1},
				{0,0,1,0},
				{0,1,0,0},
				{1,0,0,0},
				{1,1,1,1}
		};
		letters.add(new Letter("Z", z));
		
		loadingPhrases.add("CREATING STAR DUST");
		loadingPhrases.add("GENERATING ASTEROID PARTICLES");
		loadingPhrases.add("DISCOVERING HIGGS BOSON");
		loadingPhrases.add("ADJUSTING GRAVITY");
		loadingPhrases.add("CREATING HADRON COLLIDER");
		loadingPhrases.add("PUTTING ATOMS BACK TOGETHER");
		loadingPhrases.add("GENERATING ALIEN INVADERS");
		loadingPhrases.add("CREATING ENERGY");
		loadingPhrases.add("CREATING MATERIALS");
		loadingPhrases.add("GENERATING STARS");
	}
	
}
