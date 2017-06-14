package cn.brady.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 *
 * 匹配 数字行 匹配 字母行
 *
 * Created by Brady on 2017/6/12.
 */
public class PatternFirst {

    public void readFileByLines(String name){

        try{
            Stream<String> stream = Files.lines(Paths.get(name));
            stream.forEach(System.out::println);

        }catch (IOException e){
            e.printStackTrace();
        }

    }


    public static void main(String[] args){


        String fileName ="D:\\house.of.cards.2013.s05e01.720p.webrip.x264-morose.eng.srt";
        PatternFirst pf = new PatternFirst();

        pf.readFileByLines(fileName);

//        String regEx = "^?[0~9]{0,2}";
    }

}
