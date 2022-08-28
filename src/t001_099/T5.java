package t001_099;

public class T5 {

    public String longestPalindrome(String s) {
        int maxLen = 0;
        int start = 0;
        int end = 0;
        for(int i=0;i<s.length();i++) {
            Tmp t1 = longest(s,i,i);
            Tmp t2 = longest(s,i,i+1);
            int len = Math.max(t1.len(), t2.len());
            Tmp t = t1.len()>t2.len()?t1:t2;
            if(t.len()>maxLen) {
                start = t.start;
                end = t.end;
            }
        }
        return s.substring(start,end+1);
    }

    public Tmp longest(String s, int l, int r) {
        Tmp tmp = new Tmp();
        while(l>=0 && r<=s.length()-1 && s.charAt(l)==s.charAt(r)) {
            tmp.start = l;
            tmp.end = r;
            l--;
            r++;
        }
        return tmp;
    }

    class Tmp {
        int start;
        int end;
        public Tmp(){}
        public int len() {return end-start;}
    }
}
