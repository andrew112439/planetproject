public class Letter {

	private String letter;
	private int[][] matrix;
	
	public Letter(String l, int[][] m){
		letter = l;
		matrix = m;
	}
	
	public int[][] getMatrix(){
		return matrix;
	}
	
	public String getLetter(){
		return letter;
	}
	
}
