import java.time.ZonedDateTime;

/**
 * 获取系统当前时间
 */
public class Test01 {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
    }
    //2020-06-07T17:39:45.975+08:00[Asia/Shanghai]
}
