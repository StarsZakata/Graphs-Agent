package LR3.Behaviours.SubBehsForFSMStarter;

import LR3.AgentData;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.behaviours.WakerBehaviour;

public class ParallelBehForStarter extends ParallelBehaviour {
 private Behaviour receiver, waker;

    public ParallelBehForStarter(Agent a, AgentData agentData, long wakeUpTime) {
        super(a, WHEN_ANY);
        receiver = new GettingMessagesForStarter(getAgent(), agentData);
        waker = new WakerBehaviour(getAgent(), wakeUpTime) {
            @Override
            protected void onWake() {
                System.out.println(" Ok, let's finish ");
            }
        };
        addSubBehaviour(receiver);
        addSubBehaviour(waker);
    }
}
