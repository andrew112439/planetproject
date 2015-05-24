import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Click implements ActionListener{

	//CHECKS WHAT BUTTON IS CLICKED AND PERFORMS THE CORRESPONDING FUNCTION
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Run.getBusButton()){
			//IF THE PLAYER HAS 60 ENERGY+60 MATERIALS A BUS IS PURCHASED
			if(Run.getMain().getEnergy() >= 60 && Run.getMain().getMaterials() >= 60){
				Run.getMain().addTransportModule("bus");
				
				//MAKE SURE TO REMOVE THE MATERIAL+ENERGY USED TO PURCHASE THE BUS
				Run.getMain().addEnergy(-60);
				Run.getMain().addMaterials(-60);
				
				Run.getMain().addBus();
			}
		}else if(e.getSource() == Run.getTransport()){
			//IF THE PLAYER HAS 50 ENERGY+50 MATERIALS A COLLECTOR IS PURCHASED
			if(Run.getMain().getEnergy() >= 50 && Run.getMain().getMaterials() >= 50){
				Run.getMain().addTransportModule("collector");
				Run.getMain().addEnergy(-50);
				Run.getMain().addMaterials(-50);
				Run.getMain().addCollector();
			}
		}else if(e.getSource() == Run.getMine()){
			//IF THE PLAYER HAS 50 ENERGY+50 MATERIALS A MINER IS PURCHASED
			if(Run.getMain().getEnergy() >= 50 && Run.getMain().getMaterials() >= 50){
				Run.getMain().addTransportModule("miner");
				Run.getMain().addEnergy(-50);
				Run.getMain().addMaterials(-50);
				Run.getMain().setMines(Run.getMain().getMines()+1);
			}
		}else if(e.getSource() == Run.getBubButton()){
			//IF THE PLAYER HAS 50 ENERGY+50 MATERIALS A BUBONIC HOSPITAL IS PURCHASED
			if(Run.getMain().getEnergy() >= 50 && Run.getMain().getMaterials() >= 50){
				Run.getMain().addAmbulance("bub");
				Run.getMain().addEnergy(-50);
				Run.getMain().addMaterials(-50);
				Run.getMain().setMines(Run.getMain().getHospitals()+1);
			}
		}else if(e.getSource() == Run.getYelButton()){
			//IF THE PLAYER HAS 50 ENERGY+50 MATERIALS A YELLOW FEVER HOSPITAL IS PURCHASED
			if(Run.getMain().getEnergy() >= 50 && Run.getMain().getMaterials() >= 50){
				Run.getMain().addAmbulance("yel");
				Run.getMain().addEnergy(-50);
				Run.getMain().addMaterials(-50);
				Run.getMain().setMines(Run.getMain().getHospitals()+1);
			}
		}else if(e.getSource() == Run.getPoxButton()){
			//IF THE PLAYER HAS 50 ENERGY+50 MATERIALS A SMALLPOX HOSPITAL IS PURCHASED
			if(Run.getMain().getEnergy() >= 50 && Run.getMain().getMaterials() >= 50){
				Run.getMain().addAmbulance("pox");
				Run.getMain().addEnergy(-50);
				Run.getMain().addMaterials(-50);
				Run.getMain().setMines(Run.getMain().getHospitals()+1);
			}
		}else if(e.getSource() == Run.getMalButton()){
			//IF THE PLAYER HAS 50 ENERGY+50 MATERIALS A MALARIA HOSPITAL IS PURCHASED
			if(Run.getMain().getEnergy() >= 50 && Run.getMain().getMaterials() >= 50){
				Run.getMain().addAmbulance("mal");
				Run.getMain().addEnergy(-50);
				Run.getMain().addMaterials(-50);
				Run.getMain().setMines(Run.getMain().getHospitals()+1);
			}
		}
		//UPGRADING PURPOSES
		else if(e.getSource() == Run.getBubUp()){
			if(Run.getMain().getEnergy() >= 25 && Run.getMain().getMaterials() >= 25){
				Run.levelUpBub();
				Run.getMain().addEnergy(-25);
				Run.getMain().addMaterials(-25);
			}
		}else if(e.getSource() == Run.getMalUp()){
			if(Run.getMain().getEnergy() >= 25 && Run.getMain().getMaterials() >= 25){
				Run.levelUpMal();
				Run.getMain().addEnergy(-25);
				Run.getMain().addMaterials(-25);
			}
		}else if(e.getSource() == Run.getYelUp()){
			if(Run.getMain().getEnergy() >= 25 && Run.getMain().getMaterials() >= 25){
				Run.levelUpYel();
				Run.getMain().addEnergy(-25);
				Run.getMain().addMaterials(-25);
			}
		}else if(e.getSource() == Run.getPoxUp()){
			if(Run.getMain().getEnergy() >= 25 && Run.getMain().getMaterials() >= 25){
				Run.levelUpPox();
				Run.getMain().addEnergy(-25);
				Run.getMain().addMaterials(-25);
			}
		}
	}
			
}