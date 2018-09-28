package newCoder;

/**
 * @author NicoleChen
 * @date 2018/5/11 10:42
 */
public class Code_03_ArrayToStackQueue {
    public static class ArrayStack{
        private int[] arr;
        private int size;
        public ArrayStack(int initialSize) {
            if(initialSize<0){
                throw new RuntimeException();
            }
            arr = new int[initialSize];
            size = 0;
        }
        public void push(int num){
            if(size == arr.length){
                throw new RuntimeException("栈已满");
            }
            arr[size++] = num;
        }
        public int pop(){
            if(size == 0){
                throw new RuntimeException("栈为空");
            }

            return arr[--size];
        }
        public int peek(){
            if(size == 0){
                throw new RuntimeException("栈为空");
            }
            return arr[size-1];
        }
    }
    public static class ArrayQueue{
        private int arr[];
        private int first;
        private int last;
        private int size;
        public ArrayQueue(int initialSize) {
            arr = new int[initialSize];
            size = 0;
        }
        public void push(int num){
            if(size == arr.length){
                throw new RuntimeException("队列已满");
            }
            size++;
            arr[last] = num;
            if(last == arr.length-1){
                last = 0;
            }else{
                last++;
            }
        }
        public int poll(){
            if(size == 0){
                throw new RuntimeException("队列为空");
            }
            size--;
            int num = first;
            if(first == arr.length-1){
                first = 0;
            }else{
                first++;
            }
            return arr[num];
        }
        public int peek(){
            if(size == 0){
                throw new RuntimeException("队列为空");
            }
            return arr[first];
        }
    }


    public static void main(String[] args) {

    }

}
