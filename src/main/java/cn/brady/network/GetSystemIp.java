package cn.brady.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by Brady on 2017/5/17.
 */
public class GetSystemIp {

    public static void main(String[] args) throws Exception {


        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.arch"));
        System.out.println(System.getProperty("os.version"));

        String os = System.getProperty("os.name");
        System.out.println(os.startsWith("Windows"));
//        System.out.println(getMACAddress1());
        System.out.println(getMACAddress());

    }

    private static String getIpAddress() throws UnknownHostException{
        InetAddress ipAddress = InetAddress.getLocalHost();
        return ipAddress.getHostAddress();
    }

    /**
     * 获取 MAC地址
     * http://www.cnblogs.com/hxsyl/p/3422191.html
     * @return  MAC Address
     * @throws UnknownHostException
     * @throws SocketException
     */
    private static String getMACAddress() throws UnknownHostException, SocketException{

        InetAddress ia = InetAddress.getLocalHost();
        byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
        System.out.println("mac数组长度：" + mac.length);

        StringBuffer sb = new StringBuffer("");
        for(int i = 0; i < mac.length; i++){
            if(i != 0){
                sb.append("_");
            }

            int tem = mac[i] & 0xff;
            String str = Integer.toHexString(tem);
            System.out.println("Every 8 bit: " + str);
            if(str.length() == 1){
                sb.append("0" + str);
            }else {
                sb.append(str);
            }
        }

        return "MAC Address: " + sb.toString().toUpperCase();

    }
    //output:
    //Every 8 bit: 44
//    Every 8 bit: 39
//    Every 8 bit: c4
//    Every 8 bit: 91
//    Every 8 bit: 7f
//    Every 8 bit: f3
//    MAC Address: 44_39_C4_91_7F_F3


    /**
     * 获取MAC 地址  根据命令行 查找 测试 无效
     * @return
     */
    private static String getMACAddress1(){

        String s = null;

        String MAC = "";
        String os = System.getProperty("os.name");
        String osUser = System.getProperty("user.name");
        if(os != null && os.startsWith("Windows")){

            try{

                String command = "cmd.exe /c ipconfig /all";
                Process process =  Runtime.getRuntime().exec(command);

                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

                String line;
                while((line = reader.readLine()) != null){

                    if(line.indexOf("Pysical Address") > 0){
                        int index = line.indexOf(":");
                        index += 2;
                        MAC = line.substring(index);
                        break;
                    }
                }
                reader.close();;
                return MAC.trim();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return MAC;
    }




}
