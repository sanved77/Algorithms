import java.util.ArrayList;
import java.util.Collections;
import java.lang.Comparable;

class PairChain {

    public static void main(String[] args) {
        
        ArrayList<Pair> pairs = new ArrayList<>();

        pairs.add(new Pair(1,2));
        pairs.add(new Pair(8,10));
        pairs.add(new Pair(5,6));
        pairs.add(new Pair(2,2));
        pairs.add(new Pair(7,8));
        pairs.add(new Pair(17,18));
        pairs.add(new Pair(19,20));
        pairs.add(new Pair(21,22));
        pairs.add(new Pair(3,4));

        int R[] = new int[pairs.size()];

        Collections.sort(pairs);
       
        for(Pair a : pairs){
            System.out.println("[" + a.first + "," + a.second + "]");
        }

        R[0] = 1;

        for(int i = 1; i < pairs.size(); i++){
            if(pairs.get(i).first > pairs.get(i-1).second){
                R[i] = R[i-1] + 1;
            }else{
                R[i] = R[i-1];
            }
        }

        System.out.println("R - ");
        for(int a : R){
            System.out.println(a + ",");
        }

        int count = 0;
        for(int i = 0 ; i < R.length; i++){
            if(R[i] > count){
                pairs.get(i).prettyPrint();
                count = R[i];
            }
        }
        

    }

    static class Pair implements Comparable<Pair>{
        int first, second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }

        public void prettyPrint(){
            System.out.println("[" + this.first + "," + this.second + "]");
        }

        @Override
        public int compareTo(Pair p) {
            if(this.second > p.first) return 1;
            // else if(this.second == p.first) return 0;
            else return -1;
        }
    }

}