package LR3.Behaviours.SubBehsForFSMStarter;

import LR3.AgentCfg;
import LR3.Neighbour;
import LR3.XmlHelper;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

import java.util.ArrayList;

public class BehaviorForFirstAgentToStart extends OneShotBehaviour {

    ArrayList<String> namesForNeighbours = new ArrayList<>();

    @Override
    public void action() {
        AgentCfg cfg = XmlHelper.unMarshalAny(AgentCfg.class, getAgent().getLocalName()+".xml");
      //Для каждого элемента листа(связи с другими агентами) формируем отдельный лист из Имент-Связей
        for (int i=0; i<cfg.getNeighbours().size(); i++) {
            namesForNeighbours.add(cfg.getNeighbours().get(i).getName());
        }
        //Создаем лист, куда запишем первого агента
        ArrayList<String> namesList = new ArrayList<>();
        namesList.add(getAgent().getLocalName());
        //Формируем сообщение. Внутри сообщения...
        ACLMessage commonSend = new ACLMessage(ACLMessage.REQUEST);
        commonSend.setContent(namesList.toString());

        //Добавляем в сообщения=получателей
        for (int i=0; i<namesForNeighbours.size(); i++) {
            commonSend.addReceiver(new AID(namesForNeighbours.get(i), false));
        }
        //Отправляем сообщение
        getAgent().send(commonSend);
    }
}
