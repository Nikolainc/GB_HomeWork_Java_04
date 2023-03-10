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

    public T dequeue(T obj) {

        if (_queue.contains(obj)) {

            System.out.println("Error, queue is empty");
            return null;

        } else {

            T result = _queue.get(_queue.indexOf(obj));
            _queue.remove(obj);
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

    public T last(){

        if (_queue.isEmpty()) {

            System.out.println("Error, queue is empty");
            return null;

        } else {

            return _queue.getLast();

        }

    }

    public void clear(){

        for (int i = 0; i < _queue.size(); i++) {
            dequeue();
        }

    }

    public void print(){

        for (T t : _queue) {

            System.out.print(t + " ");

        }

        System.out.println("");
    }

}