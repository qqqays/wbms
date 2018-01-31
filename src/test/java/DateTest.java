import org.springframework.web.bind.annotation.RequestMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 01-20-2018 15:52
 */
public class DateTest {


    @Test
    public void fuck(){
        System.out.println(RequestMethod.POST);
        System.out.println("get".toUpperCase().equals(RequestMethod.GET.toString()));
    }

    public static void main(String[] args) {
//        System.out.println(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateTime = sdf.format(1417140957L);
        System.out.println(dateTime);
    }
}
