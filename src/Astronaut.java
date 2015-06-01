import java.awt.Color;
import java.awt.Graphics;

public class Astronaut extends TransportModule {
    
    //THE ARRAYS THE REPRESENT THE IMAGE FOR THE ASTRONAUT GOING AWAY FROM THE PLANET AND COMING TOWARDS THE PLANET
    private int[][] outArr;
    private int[][] inArr;
    
    private boolean comingBack;

    private int initY;
    private int initX;
    
    public Astronaut(){
        initX = 350;
        initY = r.nextInt(200)+250;
        setUpArr();
    }
    
    //MOVES THE COLLECTOR AROUND THE SCREEN
    public void move(){
        if(!isInBounds()){
            //DETERMINES IF THE COLLECTOR SHOULD TURN AROUND
            left = !left;
            comingBack = !comingBack;
            out = !out;
        }
        if(left){
            initX-=1;
        }else{
            initX+=1;
        }
    }
    
    //A CHEAPER VERSION OF A COLLECTOR/MINER (THE ASTRONAUT GATHERS 5 OF EACH)
    public boolean isInBounds(){
        if(out){
            if(left){
                return initX > 0;
            }else{
                return initX < 700;
            }
        }else{
            if(initX == 350){
                if(comingBack){
                    //WHEN THE ASTRONAUT RETURNS IT IS CARRYING BOTH ENERGY AND MATERIALS
                    Run.addEnergy(5);
                    Run.addMaterials(5);
                }
                return false;
            }else{
                return true;
            }
        }
    }
    
    public void setUpArr(){
        //CREATES THE IMAGE FOR ASTRONAUT
        /*COLOR CODES:
         * 0: BLANK
         * 1: WHITE (ASTRONAUT SUIT)
         * 2: MASK COLOR
         * 3: EXTREMETIES (HANDS + FEET)
         * 4: ENERGY
         * 5: MATERIALS
         */
        
        //IMAGES CREATED USING REFERENCE TO GRAVONAUT DEVELOPED BY NEXUS GAMES STUDIOS
        if(!left){
            int[][] astroO = {
                {0,0,1,1,1,1,0,0},
                {0,1,2,2,2,2,1,0},
                {0,1,2,2,2,2,1,0},
                {3,1,2,2,2,2,1,3},
                {1,0,1,1,1,1,0,1},
                {0,1,1,1,1,1,1,0},
                {0,0,1,1,1,1,0,0},
                {0,0,1,0,0,1,0,0},
                {0,3,1,0,3,1,0,0},
                {0,3,0,0,3,0,0,0}
            };
            outArr = astroO;
            
            //FLIP ASTROI FROM BELOW
            int[][] astroI = {
                {0,0,1,1,1,1,0,0},
                {0,1,2,2,2,2,1,0},
                {0,1,2,2,2,2,1,0},
                {0,1,2,2,2,2,1,0},
                {0,0,1,1,1,1,0,0},
                {1,1,1,1,1,1,1,1},
                {5,0,1,1,1,1,0,4},
                {0,0,1,0,0,1,0,0},
                {0,0,1,3,0,1,3,0},
                {0,0,0,3,0,0,3,0}
            };
            inArr = astroI;
        }else{
            int[][] astroI = {
                {0,0,1,1,1,1,0,0},
                {0,1,2,2,2,2,1,0},
                {0,1,2,2,2,2,1,0},
                {0,1,2,2,2,2,1,0},
                {0,0,1,1,1,1,0,0},
                {1,1,1,1,1,1,1,1},
                {4,0,1,1,1,1,0,5},
                {0,0,1,0,0,1,0,0},
                {0,3,1,0,3,1,0,0},
                {0,3,0,0,3,0,0,0}
            };
            inArr = astroI;
            
            //FLIP ASTROO FROM ABOVE
            int[][] astroO = {
                {0,0,1,1,1,1,0,0},
                {0,1,2,2,2,2,1,0},
                {0,1,2,2,2,2,1,0},
                {3,1,2,2,2,2,1,3},
                {1,0,1,1,1,1,0,1},
                {0,1,1,1,1,1,1,0},
                {0,0,1,1,1,1,0,0},
                {0,0,1,0,0,1,0,0},
                {0,0,1,3,0,1,3,0},
                {0,0,0,3,0,0,3,0}
            };
            outArr = astroO;
        }
    }
    
    public void paint(Graphics g){
        int[][] p;
        if(!comingBack){
            p = outArr;
        }else{
            p = inArr;
        }
        //USING THE OUT ARRAY (ASTRONAUT IS GOIGN TO COLLECT MATERIALS)
            
            /*COLOR CODES:
               * 0: BLANK
                 * 1: WHITE (ASTRONAUT SUIT)
                   * 2: MASK COLOR
                     * 3: EXTREMETIES (HANDS + FEET)
                       * 4: ENERGY
                         * 5: MATERIALS
                           */
            
        for(int r = 0; r < p.length; r++){
                for(int c = 0; c < p[r].length; c++){
                    if(p[r][c] != 0){
                        if(p[r][c] == 1){
                            g.setColor(Color.WHITE);
                        }else if(p[r][c] == 2){
                            g.setColor(Color.BLUE);
                        }else if(p[r][c] == 3){
                            g.setColor(Color.gray);
                        }else{
                            if(comingBack){
                                g.setColor(new Color(0x00FFFF));
                            }
                        }
                        g.fillRect((c * 2)+initX, (r * 2)+initY, 2, 2);
                    }
                }
            }
    }
}
