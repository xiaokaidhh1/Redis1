import com.kai.jedis.SecKill_Redis;
import org.w3c.dom.ls.LSOutput;

import java.util.Random;

public class MyTest1 {
    public static void main(String[] args) {
        String uid = new Random().nextInt(5000) + "";
        String proid = "0101";
        boolean isSuccess = SecKill_Redis.doSeckill(uid, proid);
        System.out.println(isSuccess);
    }

}
