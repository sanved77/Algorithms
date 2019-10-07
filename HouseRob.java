class HouseRob {

    public static void main(String ag[]){

        /*

        House Robber problem
        - Given - A set of houses and the reward for stealing them 
        - To find the maximum reward one can get by stealing from multiple houses which aren't next to each other. 

        The trick here is to find if robbing the previous house is better than robbing the current house alongwith the house before the previous house
        That is stored on table which is used for lookup later

        Example - 

        nums = {10, 12, 16, 13, 3, 26, 7}

        R[1] = nums[1] = 10 
        R[2] = max(nums[1], nums[2]) = max(10,12) = 12

        R[] = {10,12}
        
        R[3] = max(R[i-1], nums[i] + R[i-2])) = max(12, (16 + 10)) = max(12, 26) = 26
        R[] = {10,12,26}   
        R[4] = max(R[i-1], nums[i] + R[i-2])) = max(26, (13 + 12)) = max(26, 25) = 26
        R[] = {10,12,26,26}
        R[5] = max(R[i-1], nums[i] + R[i-2])) = max(26, (3 + 26)) = max(26, 29) = 29
        R[] = {10,12,26,26,29}
        R[6] = max(R[i-1], nums[i] + R[i-2])) = max(29, (26 + 26)) = max(26, 52) = 52
        R[] = {10,12,26,26,29,52}
        R[7] = max(R[i-1], nums[i] + R[i-2])) = max(52, (7 + 29)) = max(52, 36) = 52
        R[] = {10,12,26,26,29,52}
        
        */

        // int[] nums = {1,2,3,4,5,6,7};
        int[] nums = {10, 12, 16, 13, 3, 26, 7};
        int[] R = new int[nums.length];
        int[] taken = new int[nums.length];
        String[] rSet = new String[nums.length];

        R[0] = nums[0];
        rSet[0] = nums[0] + ",";
        R[1] = Math.max(nums[0], nums[1]);
        rSet[1] = Math.max(nums[0], nums[1]) + ",";

        for(int i = 2 ; i < nums.length; i++) {
            // R[i] = Math.max(R[i-1], nums[i] + R[i-2]);
            if(R[i-1] >= nums[i] + R[i-2]){
                R[i] = R[i-1];
                rSet[i] = rSet[i-1];
                if(taken[i-2] != 1) taken[i-1] = 1;
            } else {
                R[i] = nums[i] + R[i-2];
                rSet[i] = nums[i] + "," + rSet[i-2];
                
                try{
                    if(taken[i-3] != 1) {
                        taken[i-2] = 1;
                        if(i == nums.length - 1) {
                            taken[i] = 1;
                        }
                    }
                }catch(IndexOutOfBoundsException ie){
                    taken[i-2] = 1;
                    if(i == nums.length - 1) {
                        taken[i] = 1;
                    }
                }
            }
            
        }

        System.out.println("--------Max R[i]--------");
        for(int a : R){
            System.out.println(" - " + a);
        }

        System.out.println("--------String Taken--------");
        for(String a : rSet){
            System.out.println("- " + a);
        }
        System.out.println("--------Taken Array--------");
        for(int a : taken){
            System.out.println("- " + a);
        }

    }   

}