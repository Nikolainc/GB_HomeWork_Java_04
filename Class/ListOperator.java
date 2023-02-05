package Class;

import java.util.Random;
import java.util.LinkedList;

public class ListOperator {
    
    public static LinkedList<Integer> fillRandom(int length, int bound){
        
        LinkedList<Integer> list = new LinkedList<Integer>();
        Random rand = new Random();

        for (int i = 0; i < length; i++) {
            
            list.add(rand.nextInt(bound));

        }

        return list;

    }

    public static void print(Iterable list){

        System.out.println("Start!");

        for (Object object : list) {

            System.out.print(object + " ");
            
        }

        System.out.println("\nReady!");

    }

    public static LinkedList reverse(LinkedList list){

        LinkedList reversedlist = new LinkedList();

        int k = 0;

        for (int i = list.size() - 1; i >= 0; i--) {

            reversedlist.add(k, list.get(i));
            k++;

        }

        return reversedlist;

    }

}
