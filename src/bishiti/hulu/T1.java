package bishiti.hulu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author zlatanlong
 * @date 2022/9/16 19:10
 */
public class T1 {


    public static void main(String[] args) throws ParseException {
//        Scanner sc = new Scanner(System.in);
//        int k = sc.nextInt();
//        sc.nextLine();
//
//        HashMap<String, HashSet> sets = new HashMap<>(); //  {{}}
//        for (int i = 0; i < k; i++) {
//            String[] s = sc.nextLine().split("\\s");
//            if (!sets.containsKey(s[1])) {
//                HashSet<String> tmpSet = new HashSet<>();
//                tmpSet.add(s[0]);
//                sets.put(s[1], tmpSet);
//                continue;
//            }
//            HashSet set = sets.get(s[1]);
//            if (set.contains(s[0])) {
//                continue;
//            }
//            set.add(s[0]);
//        }
//        Object[] objects = sets.keySet().toArray();
//        Arrays.sort(objects);
//        int[]
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("2021-01-02");
        Date parse = simpleDateFormat.parse("2021-01-02");

        long l1 = Date.parse("2021-01-02");

    }


}
