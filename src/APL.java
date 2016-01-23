import agents.CustomerAgent;
import agents.TerminationListenerAgent;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import config.AplConfig;
import router.MyRouter;

public class APL {

	public static void main(String[] args) {
		ActorSystem system = ActorSystem.create("ticketSystem");
		ActorRef router = system.actorOf(Props.create(MyRouter.class, AplConfig.NUMBER_OF_CUSTOMER_DISTRIBUTORS), "router");
		ActorRef terminationListener = system.actorOf(Props.create(TerminationListenerAgent.class, AplConfig.NUMBER_OF_CUSTOMERS), "terminationListener");
		for(int i = 0; i < AplConfig.NUMBER_OF_CUSTOMERS; i++){
			ActorRef customer = system.actorOf(Props.create(CustomerAgent.class, router, terminationListener, i), "customer"+i);
			customer.tell(CustomerAgent.START, null);
		}
		

	}

}
