import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class Main extends JPanel{

	//STATS:
	private int mines;
	private int hospitals;
	private int transport;
	private int money;
	
	private int materials;
	private int energy;
	private int sick;
	
	private boolean shield;
	
	private boolean loadedFromFile = false;
	
	private static final long serialVersionUID = 4131017062673607884L;

	private int[][] starArray;
	
	private Random r = new Random();
	
	private ArrayList<TransportModule> transmods = new ArrayList<TransportModule>();
	
	private ArrayList<Invader> invaders = new ArrayList<Invader>();
	private boolean invader;
	private Invader i = new Invader();
	
	private ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
	private boolean asteroid;
	private Asteroid a = new Asteroid();

	private ArrayList<Particle> particles = new ArrayList<Particle>();
	private boolean particle;
	private Particle p;
	
	public Main(){
		if(!loadedFromFile){
			sick = 100;
			materials = 100;
			energy = 100;
			setMines(0);
			setHospitals(0);
			setTransport(0);
			setMoney(0);
		}
		genStars();
	}
	
	public void paint(Graphics g){
		paintStars(g);
		paintPlanet(g);
			for(int i = 0; i < transmods.size(); i++){
				if(transmods.get(i) instanceof Ambulance){
					if(sick > 100){
						transmods.get(i).paint(g);
						transmods.get(i).move();
					}
				}else{
					transmods.get(i).paint(g);
					transmods.get(i).move();
				}
			}
		if(invader){
			i.paint(g);
			i.move(g);
		}
		if(invaders.size()!=0){
			invaders.get(0).paint(g);
			invaders.get(0).move(g);
			if(!invaders.get(0).isInBounds()){
				invaders.remove(0);
			}
		}
		if(asteroid){
			a.paint(g);
			a.move();
		}
		if(asteroids.size()!=0){
			asteroids.get(0).paint(g);
			asteroids.get(0).move();
			if(!asteroids.get(0).inBounds()){
				asteroids.remove(0);
			}
		}
		if(particle){
			if(particles.size() == 0){
				p = new Particle(invaders.get(0).getY(), invaders.get(0).getUp(), invaders.get(0).getParticleColor());
				p.paint(g);
				p.move();
				particles.add(p);
			}
			System.out.println(p.getY());
		}
		if(particles.size() != 0){
			particles.get(0).paint(g);
			particles.get(0).move();
			if(!particles.get(0).inBounds()){
				addSick(r.nextInt(20)+5);
				particles.remove(0);
				particle = false;
			}
		}
	}

	private void genStars(){
		int[][] stars = new int[70][70];
		for(int i = 0; i < stars.length; i++){
			for(int j = 0; j < stars[i].length; j++){
				if(r.nextInt(99) >= 90){
					stars[i][j] = 0;
				}else{
					stars[i][j] = 1;
				}
			}
		}
		starArray = stars;
	}
	
	private void paintStars(Graphics g){
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
	
	private void paintPlanet(Graphics g){
		int offset = 190;
		
		int[][] arr = Planet.getPlanetArray();
		
		for(int r = 0; r < arr.length; r++){
			for(int c = 0; c < arr[r].length; c++){
				if(arr[r][c] != 0){
					if(arr[r][c] == 1){
						g.setColor(Color.black);
					}else if(arr[r][c] == 2){
						g.setColor(Planet.getPrimary());
					}else{
						g.setColor(Planet.getSecondary());
					}
					g.fillRect((r * 16)+offset, (c * 16)+offset-10, 16, 16);
				}
			}
		}
	}
	
	public void addMine(){
		setMines(getMines() + 1);
	}

	public int getMines() {
		return mines;
	}

	public void setMines(int mines) {
		this.mines = mines;
	}

	public int getHospitals() {
		return hospitals;
	}

	public void setHospitals(int hospitals) {
		this.hospitals = hospitals;
	}

	public int getTransport() {
		return transport;
	}

	public void setTransport(int transport) {
		this.transport = transport;
	}
	
	public void setEnergy(int energy){
		this.energy = energy;
	}
	
	public int getEnergy(){
		return energy;
	}
	
	public int getMaterials(){
		return materials;
	}
	
	public void setMaterials(int materials){
		this.materials = materials;
	}
	
	public void addEnergy(int add){
		energy+=add;
	}
	
	public void addMaterials(int add){
		materials+=add;
	}
	
	public void addSick(int add){
		sick+=add;
		if(sick < 0){
			sick = 0;
		}
	}
	
	public void setSick(int sick){
		this.sick = sick;
	}
	
	public int getSick(){
		return sick;
	}
	
	public void setMoney(int money){
		this.money = money;
	}
	
	public int getMoney(){
		return money;
	}
	
	public void addTransportModule(String type){
		if(type.equals("collector")){
			transmods.add(new Collector());
		}else if(type.equals("miner")){
			transmods.add(new Miner());
		}else if(type.equals("ambulance")){
			transmods.add(new Ambulance());
		}
	}
	
	public void shield(boolean s){
		shield = s;
	}
	
	public boolean getShield(){
		return shield;
	}
	
	public void addAsteroid(Asteroid a){
		asteroids.add(a);
	}
	
	public void setAsteroid(boolean a){
		asteroid = a;
	}
	
	public ArrayList<Asteroid> getAsteroidList(){
		return asteroids;
	}
	
	public ArrayList<Invader> getInvaderList(){
		return invaders;
	}
	
	public void addInvader(Invader i){
		invaders.add(i);
	}
	
	public ArrayList<Particle> getParticleList(){
		return particles;
	}
	
	public void particle(){
		particle = !particle;
	}
}
