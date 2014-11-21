
import jade.core.*;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.*;

public class CounterAgent extends Agent{

	protected void setup(){
		System.out.println("Counter agent initialized\n");
		
		addBehaviour(new CyclicBehaviour(this){
			
			Game[] games = new Game[5];
			int count=0;
			
			public void action(){
				ACLMessage msg = receive();
				
				if(msg!=null){
					try{
						games[count] = (Game) msg.getContentObject();
						games[count].Print();
						count++;
					}catch(Exception e){
						System.err.println("Error");
					}
					
				}else
					block(); //Waits new message
				
			}
			
		});
		
	}

}
