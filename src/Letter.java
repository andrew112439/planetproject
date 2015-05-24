public class Letter {

	//THIS CLASSED IS USED IN THE LETTERLIST CLASS
	//THE LETTERLIST CLASS IS USED TO DRAW THE TITLE
	
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
