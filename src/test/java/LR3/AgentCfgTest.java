package LR3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class AgentCfgTest  extends Agents {

    @Test
    public void TestCreateXml() {

        AgentCfg firstCFG = new AgentCfg();
        Neighbour secondToFirst = new Neighbour("John2", 1);
        Neighbour fifthToFirst = new Neighbour("John5",2);
        ArrayList<Neighbour> firstNeighbours = new ArrayList<>();
        firstNeighbours.add(secondToFirst);
        firstNeighbours.add(fifthToFirst);
        firstCFG.setNeighbours(firstNeighbours);
        firstCFG.setStartpoint(true);
        firstCFG.setEndpoint(false);
        XmlHelper.marshalAny(firstCFG,"John1.xml");

        AgentCfg SecondCFG = new AgentCfg();
        Neighbour firstToSecond = new Neighbour("John1", 1);
        Neighbour thirdToSecond = new Neighbour("John3", 2);
        Neighbour fourthToSecond = new Neighbour("John4", 2);
        ArrayList<Neighbour> secondNeighbours = new ArrayList<>();
        secondNeighbours.add(firstToSecond);
        secondNeighbours.add(thirdToSecond);
        secondNeighbours.add(fourthToSecond);
        SecondCFG.setNeighbours(secondNeighbours);
        SecondCFG.setStartpoint(false);
        SecondCFG.setEndpoint(false);
        XmlHelper.marshalAny(SecondCFG,"John2.xml");

        AgentCfg ThirdCFG = new AgentCfg();
        Neighbour secondToThird = new Neighbour("John2", 2);
        ArrayList<Neighbour> thirdNeighbours = new ArrayList<>();
        thirdNeighbours.add(secondToThird);
        ThirdCFG.setNeighbours(thirdNeighbours);
        ThirdCFG.setStartpoint(false);
        ThirdCFG.setEndpoint(false);
        XmlHelper.marshalAny(ThirdCFG, "John3.xml");

        AgentCfg FourthCFG = new AgentCfg();
        Neighbour secondToFourth = new Neighbour("John2", 2);
        Neighbour fifthToFourth = new Neighbour("John5", 2);
        Neighbour sixthToFourth = new Neighbour("John6", 2);
        Neighbour seventhToFourth = new Neighbour("John7", 5);
        ArrayList<Neighbour> fourthNeighbours = new ArrayList<>();
        fourthNeighbours.add(secondToFourth);
        fourthNeighbours.add(fifthToFourth);
        fourthNeighbours.add(sixthToFourth);
        fourthNeighbours.add(seventhToFourth);
        FourthCFG.setNeighbours(fourthNeighbours);
        FourthCFG.setStartpoint(false);
        FourthCFG.setEndpoint(false);
        XmlHelper.marshalAny(FourthCFG, "John4.xml");

        AgentCfg FifthCFG = new AgentCfg();
        Neighbour firstToFifth = new Neighbour("John1", 2);
        Neighbour fourthToFifth = new Neighbour("John4", 2);
        Neighbour eighthToFifth = new Neighbour("John8", 5);
        ArrayList<Neighbour> fifthNeighbours = new ArrayList<>();
        fifthNeighbours.add(firstToFifth);
        fifthNeighbours.add(fourthToFifth);
        fifthNeighbours.add(eighthToFifth);
        FifthCFG.setNeighbours(fifthNeighbours);
        FifthCFG.setStartpoint(false);
        FifthCFG.setEndpoint(false);
        XmlHelper.marshalAny(FifthCFG, "John5.xml");

        AgentCfg SixthCFG = new AgentCfg();
        Neighbour fourthToSixth = new Neighbour("John4", 2);
        Neighbour tenthToSixth = new Neighbour("John10", 1);
        ArrayList<Neighbour> sixthNeighbours = new ArrayList<>();
        sixthNeighbours.add(fourthToSixth);
        sixthNeighbours.add(tenthToSixth);
        SixthCFG.setNeighbours(sixthNeighbours);
        SixthCFG.setStartpoint(false);
        SixthCFG.setEndpoint(false);
        XmlHelper.marshalAny(SixthCFG, "John6.xml");


        AgentCfg SeventhCFG = new AgentCfg();
        Neighbour fourthToSeventh = new Neighbour("John4", 5);
        Neighbour ninthToSeventh = new Neighbour("John9", 2);
        Neighbour tenthToSeventh = new Neighbour("John10", 2);
        Neighbour eleventhToSeventh = new Neighbour("John11", 3);
        ArrayList<Neighbour> seventhNeighbours = new ArrayList<>();
        seventhNeighbours.add(fourthToSeventh);
        seventhNeighbours.add(ninthToSeventh);
        seventhNeighbours.add(tenthToSeventh);
        seventhNeighbours.add(eleventhToSeventh);
        SeventhCFG.setNeighbours(seventhNeighbours);
        SeventhCFG.setStartpoint(false);
        SeventhCFG.setEndpoint(false);
        XmlHelper.marshalAny(SeventhCFG, "John7.xml");

        AgentCfg EighthCFG = new AgentCfg();
        Neighbour fifthToEighth = new Neighbour("John5", 5);
        Neighbour eleventhToEighth = new Neighbour("John11", 2);
        ArrayList<Neighbour> eighthNeighbours = new ArrayList<>();
        eighthNeighbours.add(fifthToEighth);
        eighthNeighbours.add(eleventhToEighth);
        EighthCFG.setNeighbours(eighthNeighbours);
        EighthCFG.setStartpoint(false);
        EighthCFG.setEndpoint(false);
        XmlHelper.marshalAny(EighthCFG, "John8.xml");

        AgentCfg NinthCFG = new AgentCfg();
        Neighbour seventhToNinth = new Neighbour("John7", 2);
        Neighbour eleventhToNinth = new Neighbour("John11", 3);
        ArrayList<Neighbour> ninthNeighbours = new ArrayList<>();
        ninthNeighbours.add(seventhToNinth);
        ninthNeighbours.add(eleventhToNinth);
        NinthCFG.setNeighbours(ninthNeighbours);
        NinthCFG.setStartpoint(false);
        NinthCFG.setEndpoint(false);
        XmlHelper.marshalAny(NinthCFG, "John9.xml");


        AgentCfg TenthCFG = new AgentCfg();
        Neighbour sixthToTenth = new Neighbour("John6", 1);
        Neighbour seventhToTenth = new Neighbour("John7", 2);
        Neighbour eleventhToTenth = new Neighbour("John11", 6);
        ArrayList<Neighbour> tenthNeighbours = new ArrayList<>();
        tenthNeighbours.add(sixthToTenth);
        tenthNeighbours.add(seventhToTenth);
        tenthNeighbours.add(eleventhToTenth);
        TenthCFG.setNeighbours(tenthNeighbours);
        TenthCFG.setStartpoint(false);
        TenthCFG.setEndpoint(false);
        XmlHelper.marshalAny(TenthCFG, "John10.xml");

        AgentCfg EleventhCFG = new AgentCfg();
        Neighbour seventhToEleventh = new Neighbour("John7", 3);
        Neighbour eighthToEleventh = new Neighbour("John8", 2);
        Neighbour ninthToEleventh = new Neighbour("John9", 3);
        Neighbour tenthToEleventh = new Neighbour("John10", 6);
        ArrayList<Neighbour> eleventhNeighbours = new ArrayList<>();
        eleventhNeighbours.add(seventhToEleventh);
        eleventhNeighbours.add(eighthToEleventh);
        eleventhNeighbours.add(ninthToEleventh);
        eleventhNeighbours.add(tenthToEleventh);
        EleventhCFG.setNeighbours(eleventhNeighbours);
        EleventhCFG.setStartpoint(false);
        EleventhCFG.setEndpoint(true);
        XmlHelper.marshalAny(EleventhCFG,"John11.xml");












    }

}