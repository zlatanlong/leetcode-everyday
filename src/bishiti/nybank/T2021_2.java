package bishiti.nybank;

class T2021_2 {


    int count = 0;
    boolean[] used;
    public int getStrCount(String str) {
        used = new boolean[str.length()];
        dfs(str);
        return count-1;
    }

    public void dfs(String str) {
        count++;


        for(int i=0;i<str.length();i++) {
            if(used[i] || i>0 && str.charAt(i)==str.charAt(i-1) && !used[i-1]) {
                continue;
            }

            used[i] = true;

            dfs(str);

            used[i] = false;

        }

    }

    public static void main(String[] args) {
        T2021_2 t = new T2021_2();
        System.out.println(t.getStrCount("AAB"));
    }

}
