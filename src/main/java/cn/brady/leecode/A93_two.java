package cn.brady.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/13 11:21
 */
public class A93_two {


    List result = new ArrayList<String>();
    char[] IP ;

    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        if( len < 4 || len > 12)
            return result;
        IP = s.toCharArray();

        getReult(0,0,new char[len+3]);
        return result;

    }

    public void getReult(int num,int pos,char[] ans){

        if( num != 3){
            if ( pos-num < ans.length-3 && IP[pos-num] == '0'){
                ans[pos] = '0';
                ans[pos+1] = '.';
                getReult(num+1,pos+2,ans);
                return ;
            }
            for( int i = pos ; i < pos+2 && i<ans.length-3+num;i++){
                ans[i] = IP[i-num];
                ans[i+1] = '.';
                getReult(num+1,i+2,ans);
            }
            if( ans.length-3+num-pos >= 3){
                int tt = (IP[pos-num]-'0')*100+(IP[pos-num+1]-'0')*10+(IP[pos-num+1]-'0');
                if( tt <= 255 ){
                    ans[pos+2] = IP[pos+2-num];
                    ans[pos+3] = '.';
                    getReult(num+1,pos+4,ans);
                }
            }

        }else{

            int len = ans.length-pos;
            if( len < 1 || len > 3)
                return ;
            if ( IP[pos-num] == '0' && len != 1)
                return ;
            else{
                if( len == 3 ){
                    int tt = (IP[pos-num]-'0')*100+(IP[pos-num+1]-'0')*10+(IP[pos-num+2]-'0');
                    if( tt > 255 )
                        return ;
                }
                for( int i = pos; i<ans.length;i++){
                    ans[i] = IP[i-3];
                }
                result.add( new String ( String.valueOf(ans)));

            }
        }

    }

    public static void main(String...args){
        String s = "25525511135";

        A93_two a93 = new A93_two();
        List<String> results = a93.restoreIpAddresses(s);

        for(String r:results){
            System.out.println(r);
        }
        System.out.println("end");

    }
}
