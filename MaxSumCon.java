import java.util.Arrays;

class MaxSumCon{

    public static void main(String[] args) {
        
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        int res[] = new int[nums.length];

        res[0] = nums[0];

        int max = nums[0], maxP = 0, head = 0;

        for(int i = 1; i < nums.length;i++){
            res[i] = Math.max(res[i-1] + nums[i], nums[i]);
            if((res[i-1] + nums[i]) > nums[i]){
                res[i] = res[i-1] + nums[i];
            }else{
                res[i] = nums[i];
                head = i;
            }
            if(res[i] > max){
                max = res[i];
                maxP = i;
            }
        }

        System.out.println("------Table-------\n" + Arrays.toString(res));
        System.out.println("------Sequence-------"); 
        for(int i = head; i <= maxP; i++){
            System.out.print(nums[i] + ",");
        }

    }

}