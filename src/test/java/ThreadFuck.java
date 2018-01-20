import java.util.Date;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 01-18-2018 13:21
 */
public class ThreadFuck {
    public static Date getNextDay(){
        try {
            Thread.sleep(24 * 60 * 60 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Date();
    }

    public static long getCurrentTime(){
        try {
            System.out.println(Thread.activeCount());
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            return System.currentTimeMillis();
    }

    public static void main(String[] args) {
//        Date a = getNextDay();
        Long a = System.currentTimeMillis();
        System.out.println(a);
        Long b = getCurrentTime();
        System.out.println(b);
        System.out.println(b - a);
    }
}
