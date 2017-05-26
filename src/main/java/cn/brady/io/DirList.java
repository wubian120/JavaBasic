package cn.brady.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by Brady on 2017/5/11.
 */
public class DirList {

    public static void main(String[] args){


        File path = new File("d:/");
        String[] list;
        String[] argus ;
        String argu1 = ".jar";
        list = path.list(new DirFilter(argu1));

        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);

        for(String dirItem : list){
            System.out.println(dirItem);
        }

    }

}

class DirFilter implements FilenameFilter{

    private Pattern pattern;
    public DirFilter(String regex){
        pattern = Pattern.compile(regex);
    }


    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
