package LR3.Behaviours.SubBehsForFSMStarter;

import LR3.AgentData;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class LastSubBehForStarter extends OneShotBehaviour {
    AgentData agentData;

    public LastSubBehForStarter(Agent a, AgentData agentData) {
        super(a);
        this.agentData = agentData;
    }

    @Override
    public void action() {
        int mini = 0;

        double finalWeight = agentData.getFinalCalcList().get(mini).getFinalWeight();

        for (int i = 1; i<agentData.getFinalCalcList().size(); i++) {

            if (finalWeight>=agentData.getFinalCalcList().get(i).getFinalWeight()) {
                finalWeight = agentData.getFinalCalcList().get(i).getFinalWeight();
                mini = i;
            }

        }
        System.out.println(agentData.getFinalCalcList().get(mini).getWay()+" Sum of weights is "+agentData.getFinalCalcList().get(mini).getFinalWeight());

    }
}
