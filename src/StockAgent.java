
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.core.AID;
import java.io.IOException;

public class StockAgent extends Agent {
	
	Game[] games = new Game[5];
	
	public StockAgent() {

	}
	
	protected void setup(){
		games[0] = new Game("Diablo 3", 16, 2012);
		games[1] = new Game("GTA V", 18, 2013);
		games[2] = new Game("The Last Of Us", 16, 2013);
		games[3] = new Game("Magicka", 12, 2013);
		games[4] = new Game("Little Big Planet", 3, 2010);
		
		addBehaviour(new SimpleBehaviour(this){
			
			int cont=0;
			
			public void action(){
				try{
					ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
					msg.addReceiver(new AID("Counter", AID.ISLOCALNAME));
					msg.setContentObject(games[cont]);
					myAgent.send(msg);
					cont++;
				}catch(IOException e){
					System.err.println("Error");
				}
			}
			
			public boolean done(){
				if(cont>4){
					myAgent.doDelete();
					return true;
				}else
					return false;
			}
			
		});
		
	}
	
	protected void takeDown(){
		System.out.println("Data sent");
	}

}
