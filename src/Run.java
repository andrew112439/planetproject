import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Run {

	/*
	 * CREATE GAME MODES:
	 * 		EASY: CURRENT SETTING
	 * 		MEDIUM: ASTEROIDS ARE MORE COMMON, ROBOTS COST MORE, GAME IS FAST
	 * 		HARD: ASTEROIDS AND INVADERS ARE VERY COMMON, ROBOTS COST MORE, GAME IS VERY FAST
	 */
	
	private static boolean running = false;
	
	private static JButton save;
	
	private static JButton wind;
	private static JButton hydro;
	private static JButton transport;
	private static JButton hospitals;
	private static JButton mine;
	
	private static JButton shield;
	
	private static Main m;
	
	private static int counter = 0;
	
	private static int shieldCounter = 0;
	
	private static Random rand = new Random();
	
	public static void main(String args[]) throws InterruptedException{
		running = true;
		
		m = new Main();
		Planet.setup();
		
		//CONTROL PANEL
		JFrame controls = new JFrame();
		controls.setTitle("Menu");
		controls.setSize(160, 200);
		controls.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JPanel p = new JPanel();
		controls.add(p);
		
		//BUTTON ADDING
		save = new JButton("Save");
		save.addActionListener(new Click());
		p.add(save);
		transport = new JButton("Collector");
		transport.addActionListener(new Click());
		p.add(transport);
		hospitals = new JButton("Hospital");
		hospitals.addActionListener(new Click());
		p.add(hospitals);
		mine = new JButton("Miner");
		mine.addActionListener(new Click());
		p.add(mine);
		
		shield = new JButton("Launch Shield");
		shield.addActionListener(new Click());
		p.add(shield);
		controls.setResizable(false);
		controls.setVisible(true);

		JFrame f = new JFrame();
		f.setTitle("Materials: " + m.getMaterials() + 
				" | Energy: " + m.getEnergy() + 
				" | Sick: " + m.getSick() + " | Collectors: " + m.getTransport()
				+ " | Miners: " + m.getMines() + " | Ambulances: " + m.getHospitals());
		f.setSize(700, 700);
		f.setDefaultCloseOperation(3);
		f.setResizable(false);
		f.setFocusable(true);
		f.setLocationRelativeTo(null);
		Menu t = new Menu();
		
		f.add(t);
		f.setVisible(true); 
		//THREE TO FIVE LOADING PHRASES
		
		int numPhrases = rand.nextInt()+3;
		
		Thread.sleep(5000);
		f.remove(t);
		//f.setVisible(false); 
		f.add(m);
		f.setVisible(true); 

		while(running){
			if(m.getShield()){
				shieldCounter++;
				if(shieldCounter % 100 == 0){
					m.shield(false);
				}
			}
			if(m.getSick() <= 0){
				m.setSick(10);
			}
			if(m.getSick() < 100){
				f.setTitle("YOU WIN!");
				running = false;
				break;
			}
			if(m.getSick() >= 2000){
				f.setTitle("GAME OVER | GAME OVER | GAME OVER | GAME OVER  | GAME OVER ");
				running = false;
				break;
			}
			f.setTitle("Materials: " + m.getMaterials() + 
					" | Energy: " + m.getEnergy() + 
					" | Sick: " + m.getSick() + " | Collectors: " + m.getTransport()
					+ " | Miners: " + m.getMines() + " | Ambulances: " + m.getHospitals());
			if(counter % 1000 == 0){
				Random r = new Random();
				m.addEnergy(5);
				m.addMaterials(5);
				m.addSick(r.nextInt(100));
				
				int addAsteroid = r.nextInt(50);
				if(addAsteroid <= 5 && m.getAsteroidList().size() == 0){
					m.addAsteroid(new Asteroid());
				}
				
				int invader = r.nextInt(50);
				if(invader <= 10 && m.getInvaderList().size() == 0){
					m.addInvader(new Invader());
				}
			}
			if(counter % 500 == 0){
				m.addSick(5);
			}
			Thread.sleep(5);
			f.repaint();
			counter++;
		}
	}
	
	public static JButton getSaveButton(){
		return save;
	}
	
	public static JButton getWind(){
		return wind;
	}
	
	public static JButton getHydro(){
		return hydro;
	}
	
	public static JButton getTransport(){
		return transport;
	}
	
	public static JButton getHospital(){
		return hospitals;
	}
	
	public static JButton getMine(){
		return mine;
	}
	
	public static Main getMain(){
		return m;
	}
	
	public static void addEnergy(int n){
		m.addEnergy(n);
	}
	
	public static void addMaterials(int n){
		m.addMaterials(n);
	}
	
	public static void addSick(int n){
		m.addSick(n);
	}
	
	public static JButton getShieldButton(){
		return shield;
	}
	
	public static int getCounter(){
		return counter;
	}
}
