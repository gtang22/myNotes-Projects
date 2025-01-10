import java.util.Arrays;

public class CircularQueue {
    public int[] data;
    public int tail, head;
    private int capacity;

    public CircularQueue(int size){
        data = new int[size];
        capacity = size;
        tail = -1;
        head = -1;
    }

    public boolean enqueue(int n){
        boolean result = false;
        if(head == -1){
            data[0] = n;
            head = 0;
            tail = 1;
            result = true;
        }
        else{
            if(tail != head && tail < capacity){
                data[tail] = n;
                result = true;
                if(tail == data.length -1){
                    tail = 0;
                }
                else{
                    tail++;
                }
            }
            
        }
        return result;
    }

    public void dequeue(){
        if(head == -1){
            return;
        }

        if(head < data.length){
            head++; 
            if(head == tail){
                if(tail == data.length -1){
                    tail = 0;
                }
                else{
                    tail ++;
                }
            }
        }
        else{
            head = 0;
            tail = 1;
        }
    }

    public static void main(String[] args){
        CircularQueue test = new CircularQueue(5);
        System.out.println(test.enqueue(1));
        System.out.println(test.enqueue(2));
        System.out.println(test.enqueue(3));
        test.dequeue();
        System.out.println(Arrays.toString(test.data));
        System.out.println(test.head);
        System.out.println(test.tail);
        System.out.println(test.enqueue(4));
        System.out.println(test.enqueue(54));
        System.out.println(Arrays.toString(test.data));
        System.out.println(test.enqueue(55));
        System.out.println(Arrays.toString(test.data));
        System.out.println(test.tail);
        System.out.println(test.enqueue(56));
        System.out.println(Arrays.toString(test.data));
        System.out.println(test.head);
        System.out.println(test.tail);
      

    }
}
