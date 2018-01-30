import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 01-20-2018 15:52
 */
public class DateTest {



    public static void main(String[] args) {
//        System.out.println(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateTime = sdf.format(1417140957L);
        System.out.println(dateTime);
    }
}
