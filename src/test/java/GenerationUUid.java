import java.util.UUID;

/**
 * @author Qays
 * @createTime 2017/11/24 8:54
 */
public class GenerationUUid {
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
        System.out.println(UUID.randomUUID().toString().replace("-",""));
    }
}
