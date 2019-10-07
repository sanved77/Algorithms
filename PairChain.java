import java.util.ArrayList;
import java.util.Collections;
import java.lang.Comparable;

class PairChain {

    public static void main(String[] args) {

        /*

        Longest Pair Chain problem

        Given a (a,b) and (c,d) pair, it tries to find a chain of pairs which respects (a < b < c < d). 

        Here the algorithm checks the current pair and then compares it with the pair which was put in the bucket previously 
        Thus it ends up appending all the pairs which should be in the list 

        */
        
        ArrayList<Pair> pairs = new ArrayList<>();

        pairs.add(new Pair(1,2));
        pairs.add(new Pair(8,10));
        pairs.add(new Pair(5,6));
        pairs.add(new Pair(2,3));
        pairs.add(new Pair(7,8));
        pairs.add(new Pair(17,18));
        pairs.add(new Pair(19,20));
        pairs.add(new Pair(21,22));
        pairs.add(new Pair(4,5));
        // pairs.add(new Pair(1,2));
        // pairs.add(new Pair(2,3));
        // pairs.add(new Pair(3,5));
        // pairs.add(new Pair(6,7));
        // pairs.add(new Pair(8,9));
        
        int R[] = new int[pairs.size()];
        int j = 0;

        Collections.sort(pairs);
       
        for(Pair a : pairs){
            System.out.println("[" + a.first + "," + a.second + "]");
        }

        R[0] = 1;

        for(int i = 1; i < pairs.size(); i++){
            if(pairs.get(i).first > pairs.get(j).second){
                R[i] = R[j] + 1;
                j = i;
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