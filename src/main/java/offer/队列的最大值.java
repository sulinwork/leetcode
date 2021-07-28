package offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 队列的最大值 {
    public static void main(String[] args) {


    }

    class MaxQueue {
        Queue<Integer> queue;
        Deque<Integer> assist;

        public MaxQueue() {
            queue = new LinkedList();
            assist = new LinkedList<>();
        }

        public int max_value() {
            if (queue.isEmpty()) return -1;
            return assist.peekFirst();
        }

        public void push_back(int value) {

            queue.offer(value);
            while(!assist.isEmpty() && assist.peekLast()<value) assist.removeLast();
            assist.addLast(value);
        }

        public int pop_front() {
            return 0;
        }
    }
}
