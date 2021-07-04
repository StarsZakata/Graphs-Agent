package LR3.Behaviours;

import LR3.AgentData;
import LR3.Behaviours.SubBehsForFSMStarter.BehaviorForFirstAgentToStart;
import LR3.Behaviours.SubBehsForFSMStarter.LastSubBehForStarter;
import LR3.Behaviours.SubBehsForFSMStarter.ParallelBehForStarter;
import jade.core.Agent;
import jade.core.behaviours.FSMBehaviour;

public class FSMBehForStarter extends FSMBehaviour {
    private final String START = "start", PARBEH = "sendingprice", END = "success";

    AgentData agentData;

    public FSMBehForStarter(Agent a, AgentData agentData) {
        super(a);
        this.agentData = agentData;
        //Отправляем сообщение агентам(соседям)
        registerFirstState(new BehaviorForFirstAgentToStart(), START);
        //Параллельное поведение Ожидания и Время Окончания
        registerState(new ParallelBehForStarter(getAgent(), agentData, 10000), PARBEH);
        //Закачиваем поведение и выводим результат
        registerLastState(new LastSubBehForStarter(getAgent(), agentData), END);

        registerDefaultTransition(START, PARBEH);
        registerDefaultTransition(PARBEH, END);
    }
}
