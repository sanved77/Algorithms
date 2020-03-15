import java.util.Stack;

class CandyCrush1D {

    public static void main(String[] args) {

        Stack<Entry> stack = new Stack<>();

        String s = "abbccddeeedcbaxxy";

        for(char a : s.toCharArray()){

            if(!stack.isEmpty() && stack.peek().candy == a){ // there
                Entry temp = stack.pop();
                temp.countUp();
                stack.push(temp);
            }else{ // not there
                if(!stack.isEmpty() && stack.peek().count >= 3){
                    stack.pop();
                }
                Entry newE;
                if(!stack.isEmpty() && stack.peek().candy == a){
                    newE = stack.pop();
                    newE.countUp();
                }else
                    newE = new Entry(1, a);
                stack.push(newE);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            Entry temp = stack.pop();
            while(temp.count > 0) {
                sb.append(temp.candy);
                temp.count--;
            }
        }
        sb.reverse();
        System.out.println("" + sb.toString());

    }

    static class Entry {
        int count;
        char candy;

        Entry(int count, char candy){
            this.count = count;
            this.candy = candy;
        }

        public void countUp(){
            count++;
        }
    }

}