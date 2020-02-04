import java.util.concurrent.CountDownLatch;

class SleepSort {

    public static void main(String[] args) {
        
        int arr[] = {14, 5, 87, 12, 7, 2, 26, 9, 3};

        CountDownLatch latch = new CountDownLatch(arr.length);

        for(int a : arr){
            new Thread(new Runnable(){
                
                @Override
                public void run() {
                    latch.countDown();
                    try{
                        latch.await();
                        Thread.sleep(500 * a);
                        System.out.print(a + ",");
                    }catch(InterruptedException ie){
                        ie.printStackTrace();
                    }
                }
            }).start();
        }

    }
}