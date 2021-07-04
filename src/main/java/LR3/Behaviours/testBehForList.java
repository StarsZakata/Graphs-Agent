package LR3.Behaviours;

import jade.core.behaviours.OneShotBehaviour;

import java.util.ArrayList;

public class testBehForList extends OneShotBehaviour {
    @Override
    public void action() {
        ArrayList<String> TestList = new ArrayList<>();
        TestList.add("test1");
        TestList.add("Test2");
        TestList.add("Test3");

        ArrayList<String> SecondList = new ArrayList<>();
        SecondList.add("Test4");
        SecondList.add("Test5");

        ArrayList<ArrayList<String>> ListofLists = new ArrayList<>();
        ListofLists.add(TestList);
        ListofLists.add(SecondList);

        ArrayList<ArrayList<String>> FinalList = new ArrayList<>();

        String answer = ListofLists.toString();
        answer = answer.replace(" ","");
        String[] splitedanswer = answer.split("\\]\\,\\[");
        splitedanswer[0] = splitedanswer[0].replace("[[", "");
        splitedanswer[splitedanswer.length-1] = splitedanswer[splitedanswer.length-1].replace("]]", "");
        System.out.println(splitedanswer[0]);
        System.out.println(splitedanswer[1]);
        for (int i=0; i<splitedanswer.length; i++) {
            String[] anothersplitedanswer = splitedanswer[i].split("\\,");
            ArrayList<String> listOfanswers = new ArrayList<>();
            for (int b=0; b<anothersplitedanswer.length; b++) {
                System.out.println(anothersplitedanswer[b]);
                listOfanswers.add(anothersplitedanswer[b]);
            }

            FinalList.add(listOfanswers);
        }
        for (int v=0; v<FinalList.size(); v++) {
            FinalList.get(v).add("test6");
        }

        System.out.println(ListofLists);
        System.out.println(FinalList);


    }
}
