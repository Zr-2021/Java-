package concurrency;


import com.sun.tools.corba.se.idl.StringGen;

import javax.swing.plaf.IconUIResource;
import java.util.HashMap;

/**
 * @author zr
 * @date 2023/4/25
 */

public class hashMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>(14);
        int i=0;
        while (true){
            System.out.println(i++);
        }
    }
}
