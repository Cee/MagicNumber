/**
 * Created by Cee on 4/21/14.
 */

public class MagicNumber {

    public static void main(String[] args) {
        String domain = ""; //your domain here
        int[] version = {3, 2}; // flowplayer version
        boolean multidomain = true;
        boolean allowSubdomains = true;
        String cal = getCalculatedKey(domain, version, multidomain, allowSubdomains);
        System.out.println(cal);
    }


    private static String getCalculatedKey(String domain, int[] version, boolean multidomain, boolean allowSubdomains) {
        String seed;
        Integer base = 1;
        for (int i = 0; i < version[0] + 3; i++) base *= (version[1] + 2);
        seed = base.toString();
        seed += domain;
        seed += (multidomain) ? "pa$kA" : "h0M*t";
        String ret = (allowSubdomains) ? "#" : "";
        ret += (multidomain) ? "@" : "$";
        ret += getMD5(seed.getBytes()).substring(11, 30);
        return ret;
    }

    public static String getMD5(byte[] source) {
        String s = null;
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',  'e', 'f'};
        try
        {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance( "MD5" );
            md.update( source );
            byte tmp[] = md.digest();
            char str[] = new char[16 * 2];
            int k = 0;
            for (int i = 0; i < 16; i++) {
                byte byte0 = tmp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            s = new String(str);

        }catch( Exception e )
        {
            e.printStackTrace();
        }
        return s;
    }
}
