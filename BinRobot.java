public class BinRobot {
    
    public static void main(String[] args) {
        System.out.println(minTime(new int[]{1,2,3}));
        System.out.println(minTime(new int[]{7,4,7}));
        System.out.println(minTime(new int[]{2,1,4,2,3}));
    }

    public static int minTime(int[] packages){

        int travel = 0;
        int totalRounds = 0;
        for(int i = 0; i < packages.length; i++){
            int extraTravel = packages[i] - travel;

            if(extraTravel < 0) extraTravel = 0;
            
            travel += extraTravel;
            totalRounds += extraTravel * (packages.length - i);
        }

        int totalLoadUnload = 0;
        for(int p : packages){
            totalLoadUnload += p;
        }

        return totalLoadUnload + totalRounds;
    }
}
