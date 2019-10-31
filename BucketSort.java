import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class BucketSort{

    static int arr[] = {41, 97, 45, 70, 42, 79, 7, 73, 4, 15, 85, 64, 3, 98, 30, 84, 72, 71, 35};
    static final int PLACE = 10;

    public static void main(String[] args) {
        
        ArrayList<Integer> mainList[] = new ArrayList[10];

        for(int i = 0 ; i < 10; i++){
            mainList[i] = new ArrayList<Integer>();
        }

        for(int ele : arr){
            int posi = (ele/PLACE) % 10;
            mainList[posi].add(ele);
        }

        for(ArrayList<Integer> a : mainList){
            Collections.sort(a);
            for(int ele : a){
                System.out.print("- " + ele);
            }
        }

    }

}