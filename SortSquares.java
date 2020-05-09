import java.util.PriorityQueue;

public class SortSquares {

    public static void main(String[] args) {
        
        int nums[] = {-60,-4,-1,1,3,5,8,10, Integer.MAX_VALUE};
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num : nums){
            long res = (long)num * (long)num;
            if(res < Integer.MAX_VALUE)
                pq.add((int)res);
            else
                pq.add(-1);
        }

        while(!pq.isEmpty()){
            System.out.println("" + pq.remove());
        }
    }

}