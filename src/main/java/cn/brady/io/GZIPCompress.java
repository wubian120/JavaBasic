package cn.brady.io;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by Brady on 2017/5/16.
 */
public class GZIPCompress {
    public static void main(String[] args) throws IOException{

        String s1 = "D:\\codes-examples\\TIJ4-code\\io\\GZIPcompress.java";
        BufferedReader in = new BufferedReader(new FileReader(s1));

        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(
                new FileOutputStream("test.gz")));

        System.out.print("Writing file");

        int c;
        while((c = in.read()) != -1){
            out.write(c);
        }

        in.close();
        out.close();
        System.out.println("Reading line");

        BufferedReader in2 =
                new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("test.gz"))));

        String s;
        while ((s = in2.readLine()) != null){
            System.out.println(s);
        }



    }
}
