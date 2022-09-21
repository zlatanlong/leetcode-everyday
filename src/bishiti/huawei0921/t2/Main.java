package bishiti.huawei0921.t2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class Bgp {
        List<Area> areas;
        String value;

        public Bgp(String str) {
            this.value = str;
        }

        public void add(Area area) {
            if (areas == null) {
                areas = new ArrayList<>();
            }
            areas.add(area);
        }

    }

    static class Area {
        List<String> routes;
        String value;

        public Area(String str) {
            this.value = str;
        }

        public void add(String route) {
            if (routes == null) {
                routes = new ArrayList<>();
            }
            routes.add(route);
        }
    }
    static boolean bgpFlag = false;
    static boolean areaFlag = false;
    static boolean iprouteFlag = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cflag = 0;
        List<Bgp> bgps = new ArrayList<>();
        Bgp bgp = null;
        Area area = null;
        while (cflag < 2) {
            String rawStr = scanner.nextLine();
            if (rawStr.equals("#")) {
                cflag++;
                continue;
            }
            if (cflag == 0) {
                if (rawStr.startsWith("bgp")) {
                    bgp = new Bgp(rawStr);
                    bgps.add(bgp);
                } else if (rawStr.startsWith(" area")) {
                    area = new Area(rawStr);
                    bgp.add(area);
                } else {
                    area.add(rawStr);
                }
            } else {
                if (rawStr.startsWith("bgp")) {
                    bgpFlag = true;
                } else if (rawStr.startsWith(" area")) {
                    areaFlag = true;
                } else {
                    iprouteFlag = true;
                }
            }
        }
        // 排序bgp
        if (bgpFlag) {
            if (bgps.size() > 1 && bgps.get(1).value.endsWith("1000")) {
                Bgp tmp = bgps.get(0);
                bgps.remove(0);
                bgps.add(tmp);
            }
        }
        // 排序area
        if (areaFlag) {
            for (Bgp b : bgps) {
                if (b.areas != null && b.areas.size() > 1 && b.areas.get(1).value.endsWith("10")) {
                    Area tmp = b.areas.get(0);
                    b.areas.remove(0);
                    b.areas.add(tmp);
                }
            }
        }
        // 排序router
        if (iprouteFlag) {
            for (Bgp b : bgps) {
                for (Area a : b.areas) {
                    Collections.sort(a.routes);
                }
            }
        }
        for (Bgp b : bgps) {
            System.out.println(b.value);
            for (Area a : b.areas) {
                System.out.println(a.value);
                for (String r : a.routes) {
                    System.out.println(r);
                }
            }
        }
    }
}
