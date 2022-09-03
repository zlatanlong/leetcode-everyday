package t400_499;

public class T468 {

    public static final String NEITHER = "Neither";
    public static final String IPV4 = "IPv4";
    public static final String IPV6 = "IPV6";

    public String validIPAddress(String queryIP) {
        for (int i = 0; i < queryIP.toCharArray().length; i++) {
            if (queryIP.charAt(i) == '.') return getIpv4(queryIP);
            if (queryIP.charAt(i) == ':') return getIpv6(queryIP);
        }
        return NEITHER;
    }

    public String getIpv4(String queryIP) {
        String[] split = queryIP.split("\\.");
        if (split.length != 4) {
            return NEITHER;
        }
        for (String s : split) {
            if (s.length() > 3 || Integer.parseInt(s) > 255 || Integer.parseInt(s) < 0) return NEITHER;
        }
        return IPV4;
    }

//    public String getIpv6(String queryIP) {
//        String[] split = queryIP.split("\\:");
//        if (split.length != 8) {
//            return NEITHER;
//        }
//        for (String s : split) {
//            if (s.length() > 4)
//                return NEITHER;
//            for (char c : s.toCharArray()) {
//                if(c>'f' && c<)
//            }
//        }
//        return IPV6;
//    }

}
