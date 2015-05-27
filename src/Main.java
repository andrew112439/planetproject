import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

public class Main extends JPanel{

	//STATS:
	private int mines;
	private int hospitals;
	private int money;
	private int collectors;
	private int buses;
	
	private int population = 2000;
	
	private int materials;
	private int energy;
	
	private int sick;
	private int bub;
	private boolean bubExists;
	private int yel;
	private boolean yelExists;
	private int pox;
	private boolean poxExists;
	private int mal;
	private boolean malExists;
	
	private boolean shield;
	
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
		/*yel = 1;
		bub = 1;
		mal = 1;
		pox = 1;*/
		
		buses = 0;
		collectors = 0;
		sick = 100;
		materials = 100;
		energy = 100;
		setMines(0);
		setHospitals(0);
		setTransport(0);
		setMoney(0);
		genStars();
	}
	
	public void paint(Graphics g){
		if(bub < 0){
			bub = 0;
		}
		if(yel < 0){
			yel = 0;
		}
		if(pox < 0){
			pox = 0;
		}
		if(mal < 0){
			mal = 0;
		}
		//checks to see if there is a patient zero yet
		bubExists = !(bub == 0);
		yelExists = !(yel == 0);
		poxExists = !(pox == 0);
		malExists = !(mal == 0);
		
		paintStars(g); //paints starry background
		paintPlanet(g); //paints the main planet
			for(int i = 0; i < transmods.size(); i++){ //paints the drones
				transmods.get(i).paint(g);
				transmods.get(i).move();
			}
		//paints the invader if an invader exists
		if(invader){ 
			i.paint(g);
			i.move(g);
		}
		//determines if invader should continue to be painted
		if(invaders.size()!=0){
			invaders.get(0).paint(g);
			invaders.get(0).move(g);
			if(!invaders.get(0).isInBounds()){
				invaders.remove(0);
			}
		}
		//paints an asteroid if an asteroid exists
		if(asteroid){
			a.paint(g);
			a.move();
		}
		//determines if asteroid should continue to be painted
		if(asteroids.size()!=0){
			asteroids.get(0).paint(g);
			asteroids.get(0).move();
			if(!asteroids.get(0).inBounds()){
				asteroids.remove(0);
			}
		}
		//paints a particle and checks if the particle should continue to be painted
		if(particle){
			if(particles.size() == 0){
				p = new Particle(invaders.get(0).getY(), invaders.get(0).getUp(), invaders.get(0).getParticleColor());
				p.paint(g);
				p.move();
				particles.add(p);
			}
		}
		//adds sickness when particle collides with planet
		if(particles.size() != 0){
			particles.get(0).setInvader(i);
			particles.get(0).paint(g);
			particles.get(0).move();
			if(!particles.get(0).inBounds()){
				//addSick(r.nextInt(20)+5);
				String type = particles.get(0).getInvader().getDiseaseType();
				if(type.equals("bub")){
					addBubonic(r.nextInt(20)+10);
				}else if(type.equals("pox")){
					addPox(r.nextInt(20)+10);
				}else if(type.equals("yel")){
					addFever(r.nextInt(20)+10);
				}else{
					addMalaria(r.nextInt(20)+10);
				}
				particles.remove(0);
				particle = false;
			}
		}
	}

	//generates starry background
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
	
	//paints starry background
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
	
	//paints planet
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
		return transmods.size();
	}
	
	public int getCollectors(){
		return collectors;
	}

	public void setTransport(int transport) {
		//this.transport = transport;
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
	
	public void addMalaria(int sick){
		mal+=sick;
	}
	public void addPox(int sick){
		pox+=sick;
	}
	public void addBubonic(int sick){
		bub+=sick;
	}
	public void addFever(int sick){
		yel+=sick;
	}
	
	public int getMal(){
		return mal;
	}
	public int getPox(){
		return pox;
	}
	public int getBub(){
		return bub;
	}
	public int getYel(){
		return yel;
	}
	
	public int getSick(){
		return yel+mal+pox+bub+sick;
	}
	
	public void setMoney(int money){
		this.money = money;
	}
	
	public int getMoney(){
		return money;
	}
	
	//method for adding nonhospitals
	public void addTransportModule(String type){
		if(type.equals("collector")){
			transmods.add(new Collector());
		}else if(type.equals("miner")){
			transmods.add(new Miner());
		}else if(type.equals("bus")){
			transmods.add(new Bus());
		}
	}
	
	//adds hospitals according to type (disease type)
	public void addAmbulance(String type){
		transmods.add(new Ambulance(type));
		hospitals++;
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
	
	public int getPopulation(){
		return population;
	}
	
	public void addPopulation(int n){
		population += n;
	}
	
	public void addCollector(){
		collectors++;
	}
	
	public void addBus(){
		buses++;
	}
	
	public int getBuses(){
		return buses;
	}

	public boolean bubExists(){
		return bubExists;
	}
	
	public boolean yelExists(){
		return yelExists;
	}
	
	public boolean poxExists(){
		return poxExists;
	}
	
	public boolean malExists(){
		return malExists;
	}
}
