package LR3.Behaviours;

import LR3.AgentCfg;
import LR3.XmlHelper;
import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.util.ArrayList;
import java.util.List;

public class BehaviourForCommonAgent extends Behaviour {



    @Override
    public void action() {
        AgentCfg cfg = XmlHelper.unMarshalAny(AgentCfg.class, getAgent().getLocalName()+".xml");

        //Отлавливаем определенное сообщение
        MessageTemplate request = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
        ACLMessage commonReq = getAgent().receive(request);
       //Реализуем при получении
        if (commonReq != null) {
            List<String> namesForNeighbours = new ArrayList<>();
            List<Double> weightsForNeighbours = new ArrayList<>();
            for (int i=0; i<cfg.getNeighbours().size(); i++) {
                namesForNeighbours.add(cfg.getNeighbours().get(i).getName());
                weightsForNeighbours.add(cfg.getNeighbours().get(i).getWeight());
            }
                   if (commonReq.getSender().getLocalName().equals("John1")) {
                        String commonFirstReq = commonReq.getContent().replace("[", "");
                        commonFirstReq = commonFirstReq.replace("]", "");
                        ArrayList<String> namesList = new ArrayList<>();
                        namesList.add(commonFirstReq);
                        namesList.add(getAgent().getLocalName());
                        ACLMessage commonSend = new ACLMessage(ACLMessage.REQUEST);
                        commonSend.setContent(namesList.toString());
                        List<String> namesToSend;
                        namesToSend = namesForNeighbours;
                        try {
                       if (namesForNeighbours.size() > 1) {
                            for (int i = 0; i<namesToSend.size(); i++) {
                               for (int a = 0; a<namesList.size(); a++) {
                                if (namesToSend.get(i).equals(namesList.get(a))) {
                                 namesToSend.remove(i);
                              }
                            }
                        } if (namesToSend.size()>0) {
                        for (int i=0; i<namesToSend.size(); i++) {
                            commonSend.addReceiver(new AID(namesToSend.get(i), false));
                        }
                        getAgent().send(commonSend);} else {block();} } else { block();} } catch (IndexOutOfBoundsException e) { block(); }
                    } else {

                        String commonReqTosplit = commonReq.getContent().replace("[", "");
                        commonReqTosplit = commonReqTosplit.replace("]", "");
                        String[] splitedReq = commonReqTosplit.split("\\,\\ ");
                        ArrayList<String> namesList = new ArrayList<>();
                        for (int b = 0; b < splitedReq.length; b++) {
                            namesList.add(splitedReq[b]);
                        }
                        namesList.add(getAgent().getLocalName());
                        ACLMessage commonSend = new ACLMessage(ACLMessage.REQUEST);
                        commonSend.setContent(namesList.toString());
                       List<String> namesToSend;
                       namesToSend = namesForNeighbours;
                       try {
                       if (namesForNeighbours.size() >1) {   //от тупиков
                       for (int i = 0; i<namesList.size(); i++) {
                           for (int a = 0; a<namesToSend.size(); a++) {
                               if (namesToSend.get(a).equals(namesList.get(i))) {
                                   namesToSend.remove(namesList.get(i));
                               }
                           }

                       }
                       if (namesToSend.size()>0) {

                           //от зацикливаний
                       for (int i=0; i<namesToSend.size(); i++) {
                           commonSend.addReceiver(new AID(namesToSend.get(i), false));
                       }
                        getAgent().send(commonSend);
                       } else { block();} } else { block();} } catch (IndexOutOfBoundsException e) { block(); }
            }
        } else {
            block();
        }
        //Отливливаем определенное сообщение
        MessageTemplate info = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
        ACLMessage inform = getAgent().receive(info);
        //Реализуем при получении
        if (inform != null) {
            List<String> namesForNeighbours = new ArrayList<>();
            List<Double> weightsForNeighbours = new ArrayList<>();
            //Добавляю в лист себя и свой размер
            for (int i=0; i<cfg.getNeighbours().size(); i++) {
                namesForNeighbours.add(cfg.getNeighbours().get(i).getName());
                weightsForNeighbours.add(cfg.getNeighbours().get(i).getWeight());
            }
            //
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
            int sendersPlaceInThisList = myPlaceInThisList++;
            for (int i = 0; i<namesForNeighbours.size(); i++) {
                if (namesForNeighbours.get(i).equals(infoNamesList.get(sendersPlaceInThisList+1))) {
                    sendersNameInMyNeighboursList = i;
                }
            }
            double newSumWeight = sumWeight + weightsForNeighbours.get(sendersNameInMyNeighboursList);

            ACLMessage InfoSend = new ACLMessage(ACLMessage.INFORM);
            InfoSend.setContent(infoNamesList.toString()+"*"+newSumWeight);
            InfoSend.addReceiver(new AID(infoNamesList.get(myPlaceInThisList-2), false));
            getAgent().send(InfoSend);

        } else {
            block();
        }

    }
    @Override
    public boolean done() {
        return false;
    }
}
