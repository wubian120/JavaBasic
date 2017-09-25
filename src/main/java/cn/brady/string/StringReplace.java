package cn.brady.string;

import org.apache.commons.lang3.StringUtils;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class StringReplace {

    public enum KeyType{
        IN(1),
        IN_AND(2),
        IN_NOT(3),
        NOT(4);
        private int typeValue;
        KeyType(int value){
            typeValue = value;
        }

    }

    public static void main(String[] args){


        System.out.println(KeyType.IN);
        System.out.println(KeyType.IN.typeValue);

        String s = "11122+dd+344+bb";

        String s2 = StringUtils.replace(s,"+","%");

        System.out.println(s2);






    }
}
