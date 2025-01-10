public class StackOne{
    private Integer[] list;
    private int top;

    public StackOne(int size){
        list = new Integer[size];
        top = -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public Integer top(){
        if (!isEmpty()) { 
            return list[top];
        }

        return null;
    }

    public void pop(){
        if (!isEmpty()) {
            top--;
        }
    }

    public void push(Integer item){
        if (top >= list.length - 1) {
            return;
        }
        top++;
        list[top] = item;
    }
}