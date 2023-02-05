import java.util.LinkedList;
import Class.ListOperator;
import Class.QueueList;

class program {

    public static void main(String[] args) {
        
        LinkedList<Integer> list = ListOperator.fillRandom(10, 100);

        ListOperator.print(list);

        list = ListOperator.reverse(list);

        ListOperator.print(list);

        QueueList<Integer> queue = new QueueList(new LinkedList());

        queue.enqueue(1);
        queue.enqueue(0);
        queue.enqueue(2);
        queue.enqueue(6);

        System.out.println(queue.first());
        System.out.println(queue.dequeue());
        System.out.println(queue.first());

        queue.print();

    }

}