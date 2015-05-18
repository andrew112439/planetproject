import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Click implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Run.getSaveButton()){
			System.out.println("SAVE");
		}else if(e.getSource() == Run.getTransport()){
			if(Run.getMain().getEnergy() >= 50 && Run.getMain().getMaterials() >= 50){
				Run.getMain().addTransportModule("collector");
				Run.getMain().addEnergy(-50);
				Run.getMain().addMaterials(-50);
				Run.getMain().setTransport(Run.getMain().getTransport()+1);
			}
		}else if(e.getSource() == Run.getMine()){
			if(Run.getMain().getEnergy() >= 50 && Run.getMain().getMaterials() >= 50){
				Run.getMain().addTransportModule("miner");
				Run.getMain().addEnergy(-50);
				Run.getMain().addMaterials(-50);
				Run.getMain().setMines(Run.getMain().getMines()+1);
			}
		}else if(e.getSource() == Run.getHospital()){
			if(Run.getMain().getEnergy() >= 50 && Run.getMain().getMaterials() >= 50){
				Run.getMain().addTransportModule("ambulance");
				Run.getMain().addEnergy(-50);
				Run.getMain().addMaterials(-50);
				Run.getMain().setHospitals(Run.getMain().getHospitals()+1);
			}
		}
	}
			
}