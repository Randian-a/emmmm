package asia.neg.util;

import org.springframework.util.DigestUtils;

import java.security.MessageDigest;

/**
 * md5
 * @author mxchen
 * @create 2019-12-06
 */
public class SecurityUtil {
    /**
     * 盐，用于混交md5
     */
    private static final String slat = "&%1A2Asc*&%$$#@";

    public static void main(String[] args) {
        /**
         * 需要加密的密码尽可能的要复杂，包含大小写字母和数字，
         * 长度不小于8为，加密必须加盐，如果需要更高要求，可以多次加密，多次加盐
         */
        System.out.println(getMD5("12ASD23klk935"));
        System.out.println(getMD5(getMD5("12ASD23klk935")));
        System.out.println(md5("12ASD23klk935"));
        System.out.println(md5(md5("12ASD23klk935")));
        //a37fba0e7896e73e6b851c619a4ae599
    }

    /**
     * spring框架里面的加密方法
     *
     * @param value 需要加密的字符串
     * @return 加密后的字符串
     */
    public static String getMD5(String value) {
        String base = value + "/s/" + slat;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }

    /**
     * 原生的加密方法
     *
     * @param value 需要加密的字符串
     * @return 加密后的字符串
     */
    public static String md5(String value) {
        try {
            value = value + slat;
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(value.getBytes("UTF8"));
            byte message[] = messageDigest.digest();
            String result = "";
            for (int i = 0; i < message.length; i++) {
                result += Integer.toHexString((0x000000FF & message[i]) | 0xFFFFFF00).substring(6);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
