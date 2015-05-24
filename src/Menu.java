import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class Menu extends JPanel{

	//THIS CLASS IS USED TO PAINT THE MENU
	
	private static final long serialVersionUID = 1L;
	private Random rand = new Random();
	
	int[][] starArray;

	public void paint(Graphics g){
		paintStars(g); //PAINTS THE STARRY BACKGROUND
		
		//USES THE LETTERLIST CLASS TO DRAW THE WORD "PLANETARY" (THE TITLE OF THE GAME)
		LetterList.setup();
		String alpha = "    PLANETARY";
		int offsetY = 32;
		int offsetX = 8;
		for(int i = 0; i < alpha.length(); i++){
			String col = "" + rand.nextInt(99) + "00" + rand.nextInt(99);
			g.setColor(new Color(Integer.parseInt(col)));
			offsetY = 0;
			System.out.println(alpha.substring(i, i+1));
			if(alpha.substring(i, i+1).equals(" ")){
				offsetX += 8;
			}else{
				int[][] draw = LetterList.search(alpha.substring(i, i+1));
				for(int r = 0; r < draw.length; r++){
					offsetX = (i*32);
					offsetY+=8;
					for(int c = 0; c < draw[r].length; c++){
						if(draw[r][c] == 1){
							g.fillRect(offsetX+8*i, offsetY+128, 8, 8);
						}
						offsetX+=8;
					}
				}
			}
		}
	}
	
	//GENERATES STARRY BACKGROUND
	private void genStars(){
		int[][] stars = new int[70][70];
		for(int i = 0; i < stars.length; i++){
			for(int j = 0; j < stars[i].length; j++){
				if(rand.nextInt(99) >= 90){
					stars[i][j] = 0;
				}else{
					stars[i][j] = 1;
				}
			}
		}
		starArray = stars;
	}
	
	//PAINTS STARRY BACKGROUND
	private void paintStars(Graphics g){
		genStars();
		for (int i = 0; i < starArray.length; i++){
			for (int j = 0; j < starArray[i].length; j++){
				if(starArray[i][j] == 1){
					g.setColor(new Color(3355443));
				}else{
					g.setColor(new Color(0xFFCC99));
				}
				g.fillRect(i*10, j*10, 10, 10);
			}
		}
	}
	
}
