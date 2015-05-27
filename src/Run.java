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
	 *
	 *	ADD UPGRADE SYSTEM FOR THE HOSPITALS SO THEY CAN CURE MORE PEOPLE AT ONCE
	 * 
	 *
	 */
	
	private static boolean running = false;
	
	private static JButton transport;
	private static JButton hospitals;
	private static JButton mine;
	private static JButton bus;
	
	private static JButton bub;
	private static JButton bubUp;
	private static JButton yel;
	private static JButton yelUp;
	private static JButton mal;
	private static JButton malUp;
	private static JButton pox;
	private static JButton poxUp;
	
	//LEVELS OF HOSPITALS
	private static int bubLevel = 1;
	private static int malLevel = 1;
	private static int poxLevel = 1;
	private static int yelLevel = 1;
	
	private static JButton shield;
	
	private static Main m;
	
	private static int counter = 0;
	
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
		transport = new JButton("Collector");
		transport.addActionListener(new Click());
		p.add(transport);
		mine = new JButton("Miner");
		mine.addActionListener(new Click());
		p.add(mine);
		bus = new JButton("Bus");
		bus.addActionListener(new Click());
		p.add(bus);
		
		controls.setResizable(false);
		controls.setSize(400,60);
		controls.setTitle("Materials: " + m.getMaterials() + 
				" | Energy: " + m.getEnergy());

		//SETTING UP MAIN WINDOW
		JFrame f = new JFrame();
		f.setTitle("Loading...");
		f.setSize(700, 700);
		f.setDefaultCloseOperation(3);
		f.setResizable(false);
		f.setFocusable(true);
		f.setLocationRelativeTo(null);
		Menu t = new Menu(); 
		
		f.add(t);
		f.setVisible(true); 
		
		Thread.sleep(2000); //MENU STAYS FOR TWO SECONDS
		f.remove(t); //SWITCHES TO GAME AFTER MENU
		f.add(m);
		f.setVisible(true); 
		
		controls.setVisible(true);
		
		JFrame h = new JFrame();
		h.setTitle("Plague: " + m.getBub() + " | Smallpox: " + m.getPox() + " | Malaria: " + m.getMal() + " | Fever: " + m.getYel());
		h.setResizable(false);
		
		//SETS UP HOSPITAL STORE WINDOW
		JPanel hp = new JPanel();
		bub = new JButton("Bubonic Plague");
		bub.addActionListener(new Click());
		bubUp = new JButton("Upgrade");
		bubUp.addActionListener(new Click());
		yel = new JButton("Yellow Fever");
		yel.addActionListener(new Click());
		yelUp = new JButton("Upgrade");
		yelUp.addActionListener(new Click());
		pox = new JButton("Smallpox");
		pox.addActionListener(new Click());
		poxUp = new JButton("Upgrade");
		poxUp.addActionListener(new Click());
		mal = new JButton("Malaria");
		mal.addActionListener(new Click());
		malUp = new JButton("Upgrade");
		malUp.addActionListener(new Click());
		hp.add(bub);
		hp.add(yel);
		hp.add(pox);
		hp.add(mal);
		hp.add(bubUp);
		hp.add(yelUp);
		hp.add(poxUp);
		hp.add(malUp);
		h.add(hp);
		h.setSize(500, 130);
		h.setVisible(true);

		//GAME LOOP
		while(running){
			if(m.getSick() < 10){ //ALL DISEASE CURED
				f.setTitle("YOU WIN!");
				running = false;
				break;
			}
			if(m.getSick() >= m.getPopulation()){ //ENTIRE POPULATION SICK
				f.setTitle("GAME OVER | YOU SURVIVED " + counter/100 + " SECONDS");
				running = false;
				break;
			}
			//updates hospital title
			h.setTitle("Plague: " + m.getBub() + " | Fever: " + m.getYel() + " | Smallpox: " + m.getPox() + " | Malaria: " + m.getMal());
			controls.setTitle("Materials: " + m.getMaterials() + 
					" | Energy: " + m.getEnergy());
			//updates main window title
			f.setTitle( 
					"Sick: " + (m.getSick()-100) + " | Population: " + m.getPopulation() + " | Collectors: " + m.getCollectors()
					+ " | Miners: " + m.getMines() + " | Ambulances: " + m.getHospitals() + " | Buses: " + m.getBuses());
			//spreading disease, gaining energy, gaining materials
			if(counter % 1000 == 0){
				Random r = new Random();
				m.addEnergy(5);
				m.addMaterials(5);
				if(m.bubExists()){
					m.addBubonic(r.nextInt(50)+(m.getBub()/10)*rand.nextInt(2));
				}
				if(m.yelExists()){
					m.addFever(r.nextInt(50)+(m.getYel()/10)*rand.nextInt(2));
				}
				if(m.poxExists()){
					m.addPox(r.nextInt(50)+(m.getPox()/10)*rand.nextInt(2));
				}
				if(m.malExists()){
					m.addMalaria(r.nextInt(50)+(m.getMal()/10)*rand.nextInt(2));
				}
				
				//checks if an asteroid should be added
				int addAsteroid = r.nextInt(50);
				if(addAsteroid <= 30 && m.getAsteroidList().size() == 0){
					m.addAsteroid(new Asteroid());
				}
				
				//checks if an invader should be added
				int invader = r.nextInt(50);
				if(invader <= 25 && m.getInvaderList().size() == 0){
					m.addInvader(new Invader());
				}
			}
			Thread.sleep(5);
			f.repaint();
			counter++;
		}
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

	public static void addPopulation(int n){
		m.addPopulation(n);
	}
	
	public static JButton getShieldButton(){
		return shield;
	}
	
	public static int getCounter(){
		return counter;
	}
	
	public static JButton getBusButton(){
		return bus;
	}
	
	public static JButton getMalButton(){
		return mal;
	}
	
	public static JButton getYelButton(){
		return yel;
	}
	
	public static JButton getPoxButton(){
		return pox;
	}
	
	public static JButton getBubButton(){
		return bub;
	}
	
	public static JButton getBubUp(){
		return bubUp;
	}
	
	public static JButton getYelUp(){
		return yelUp;
	}
	
	public static JButton getPoxUp(){
		return poxUp;
	}
	
	public static JButton getMalUp(){
		return malUp;
	}
	
	public static void levelUpBub(){
		bubLevel++;
	}
	
	public static void levelUpPox(){
		poxLevel++;
	}
	
	public static void levelUpYel(){
		yelLevel++;
	}
	
	public static void levelUpMal(){
		malLevel++;
	}
	
	public static int getBubLevel(){
		return bubLevel;
	}
	
	public static int getPoxLevel(){
		return poxLevel;
	}
	
	public static int getMalLevel(){
		return malLevel;
	}
	
	public static int getYelLevel(){
		return yelLevel;
	}
}
