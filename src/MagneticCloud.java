import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class MagneticCloud extends Asteroid {
   //THE MAGNETIC CLOUD:
   //IF IT COLLIDES WITH PLANET - CAUSES POWER SURGE - DESTROYS DRONES
   public void paint(Graphics g){
        for(int r = 0; r < arr.length; r++){
            for(int c = 0; c < arr[r].length; c++){
                if(arr[r][c] != 0){
                    if(arr[r][c] == 1){
                        g.setColor(Color.black);
                    }else if(arr[r][c] == 2){
                        g.setColor(primary);
                    }else{
                        g.setColor(secondary);
                    }
                    g.fillRect((r * 16)+offset, (c * 16)+yOffset, 8, 8); //THE METHOD IS CHANGED SLIGHTLY FROM THE ASTEROID CLASS TO MAKE IT APPEAR AS THOUGH IT IS A CLOUD
                }
            }
        }
   }
   
   public boolean inBounds(){
        if(yOffset < 80 || yOffset > 505){
            if(left){
                return offset > -80;
            }else{
                return offset < 780;
            }
        }
        if(left){
            if(offset <= 350){
                //THIS SERVES AS THE POWER SURGE:
                if(Run.getMain().getTransport() > 2){ //IF THE PLAYER ONLY HAS ONE DRONE IT SHOULDNT BE DESTROYED, THAT WOULD MAKE THE GAME TOO HARD
                    Random r = new Random();
                    int toDestroy = r.nextInt(Run.getMain().getTransport())+1;
                    Run.getMain().powerSurge(toDestroy);
                }
            }
            return offset >= 350;
        }else{
            if(offset >= 350){
                
            }
            return offset <= 350;
        }
   }
}
