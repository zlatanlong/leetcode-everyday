package bishiti.nybank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Te9 {

    public static void main(String[] args) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("Te9.txt",true));
            out.write("Java");
//            out.flush();
            out.close();
        } catch (IOException e) {
        }
    }



}
