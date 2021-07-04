package LR3.Behaviours.SubBehsForFSMStarter;

import LR3.AgentCfg;
import LR3.AgentData;
import LR3.FinalCalc;
import LR3.XmlHelper;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.util.ArrayList;

public class GettingMessagesForStarter extends Behaviour {

    AgentData agentData;

    public GettingMessagesForStarter(Agent a, AgentData agentData) {
        super(a);
        this.agentData = agentData;
    }

    ArrayList<String> namesForNeighbours = new ArrayList<>();
    ArrayList<Double> weightsForNeighbours = new ArrayList<>();

    @Override
    public void action() {

        AgentCfg cfg = XmlHelper.unMarshalAny(AgentCfg.class, getAgent().getLocalName()+".xml");
      //Добавляем наших агентов и их веса в листы
        for (int i=0; i<cfg.getNeighbours().size(); i++) {
            namesForNeighbours.add(cfg.getNeighbours().get(i).getName());
            weightsForNeighbours.add(cfg.getNeighbours().get(i).getWeight());
        }
        //Ждем определенное сообщение
        MessageTemplate info = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
        ACLMessage inform = getAgent().receive(info);
        //Реазилуем работу, при получении сообщения
        if (inform != null) {
            String informTosplit = inform.getContent().replace("[", "");
            informTosplit = informTosplit.replace("]", "");
            String[] splitedInform = informTosplit.split("\\*");
            double sumWeight = Double.parseDouble(splitedInform[1]);
            String[] splitedInf = splitedInform[0].split("\\,\\ ");
            ArrayList<String> infoNamesList = new ArrayList<>();
            for (int b = 0; b < splitedInf.length; b++) {
                infoNamesList.add(splitedInf[b]);
            }
            int myPlaceInThisList=0;
            int sendersNameInMyNeighboursList=0;
            for (int i = 0; i<infoNamesList.size(); i++) {
                if (getAgent().getLocalName().equals(infoNamesList.get(i))) {
                    myPlaceInThisList = i;
                }
            }
            int sendersPlaceInThisList = myPlaceInThisList+1;
            for (int i = 0; i<namesForNeighbours.size(); i++) {
                if (namesForNeighbours.get(i).equals(infoNamesList.get(sendersPlaceInThisList))) {
                    sendersNameInMyNeighboursList = i;
                }
            }
            double newSumWeight = sumWeight + weightsForNeighbours.get(sendersNameInMyNeighboursList);

            FinalCalc finalCalc = new FinalCalc();
            finalCalc.setWay(inform.getContent());
            finalCalc.setFinalWeight(newSumWeight);
            ArrayList<FinalCalc> newFinalCalcList = agentData.getFinalCalcList();
            newFinalCalcList.add(finalCalc);
            agentData.setFinalCalcList(newFinalCalcList);

        } else {
            block();
        }
    }

    @Override
    public boolean done() {
        return false;
    }
}
