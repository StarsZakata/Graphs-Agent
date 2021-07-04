package LR3.Behaviours;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.util.ArrayList;

public class BehaviourForLastAgent extends Behaviour {
    @Override
    public void action() {
        //Отливливает определенное сообщение
        MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
        ACLMessage lastReq = getAgent().receive(mt);
        //Если сообщение получено, то реализуем...
        if (lastReq != null) {

            String lastReqTosplit = lastReq.getContent().replace("[", "");
            lastReqTosplit = lastReqTosplit.replace("]", "");
            String[] splitedReq = lastReqTosplit.split("\\,\\ ");

            ArrayList<String> namesList = new ArrayList<>();
            for (int b = 0; b < splitedReq.length; b++) {
                namesList.add(splitedReq[b]);
            }

            namesList.add(getAgent().getLocalName());
            System.out.println("namesList for last to send inform is"+namesList);

            ACLMessage firstInfoSend = new ACLMessage(ACLMessage.INFORM);
            firstInfoSend.setContent(namesList.toString()+"*0");
            firstInfoSend.addReceiver(new AID(namesList.get(namesList.size()-2), false));
            getAgent().send(firstInfoSend);
        } else {
            block();
        }
    }

    @Override
    public boolean done() {
        return false;
    }
}
