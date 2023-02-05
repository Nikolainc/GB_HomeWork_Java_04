package Class;

import java.util.LinkedList;

public class QueueList<T>{

    private LinkedList<T> _queue;

    public QueueList(LinkedList<T> queue){

        _queue = queue;

    }

    public boolean enqueue(T obj){
        
        if(_queue.add(obj)){

            return true;

        } else {

            System.out.println("Error, invalid type");
            return false;

        }

    }

    public T dequeue(){

        if(_queue.isEmpty()){

            System.out.println("Error, queue is empty");
            return null;

        } else {

            T result = _queue.getFirst();
            _queue.removeFirst();
            return result;

        }

    }

    public T first(){

        if(_queue.isEmpty()){

            System.out.println("Error, queue is empty");
            return null;

        } else {

            return _queue.getFirst();

        }

    }

    public void print(){

        for (T t : _queue) {

            System.out.print(t + " ");

        }

        System.out.println("");
    }

}