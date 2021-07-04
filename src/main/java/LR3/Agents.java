package LR3;

import LR3.Behaviours.BehaviourForCommonAgent;
import LR3.Behaviours.BehaviourForLastAgent;
import LR3.Behaviours.FSMBehForStarter;
import jade.core.Agent;

public class Agents extends Agent {

    private AgentData agentData = new AgentData();


    @Override
    protected void setup() {
        AgentCfg agentCfg = XmlHelper.unMarshalAny(AgentCfg.class, getLocalName()+".xml");
         if (!agentCfg.isStartpoint() && !agentCfg.isEndpoint()) {
             addBehaviour(new BehaviourForCommonAgent());
         }
         if (!agentCfg.isStartpoint() && agentCfg.isEndpoint()) {
             addBehaviour(new BehaviourForLastAgent());
         }
         if (agentCfg.isStartpoint() && !agentCfg.isEndpoint()) {
             addBehaviour(new FSMBehForStarter(this,agentData));
         }
        super.setup();
    }
}
