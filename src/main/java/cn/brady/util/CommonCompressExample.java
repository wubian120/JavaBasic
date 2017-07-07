package cn.brady.util;


import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;

import java.io.*;

//TODO  1. read in the file by SevenZFile
//TODO  2. read SevenZArchiveEntry entry by byte[]
//TODO  3. loop entry.hasNext()
//todo  4. write file , byte[]

//todo Problem 1. 如果压缩文件 里面还有目录 怎么处理？
//todo Problem 2. 如何筛选出 想要的 english 字幕。
//todo Problem 3. 如果用NIO 读取 字幕文件中的  Lines


/**
 * Created by Brady on 2017/7/4.
 */
public class CommonCompressExample {

    public static void main(String[] args){

        String f = "E:\\[zmk.tw]House.of.Cards.2013.S04.720p.WEBRip.X264-DEFLATE.7z";
        String p = "E:\\";
        try{
            decompress7ZFile(f,p);
//            CommonCompressExample.decompressZipFiles();
        }catch (Exception e){

            e.printStackTrace();
        }


    }

    // 解压缩
    public static void decompressZipFiles() throws IOException{
        long startInt = System.currentTimeMillis();

        String path = "e:\\"; // decompress path

//        String zipPath ="E:\\order-w.zip";
        String zipPath = "";
        File zipFile = new File(zipPath);
        InputStream  inputStream  = null;
        OutputStream outputStream = null;

//  ---------------------Uncompressing  7z file -----------------------------
        ZipArchiveInputStream zipArchiveInputStream = null;
        ArchiveEntry archiveEntry = null;



//      LOOP UNTIL entry.getSize() HAS BEEN READ {
//          sevenZFile.read(content, offset, content.length - offset);
//      }

        try{
            inputStream = new FileInputStream(zipFile);
            zipArchiveInputStream = new ZipArchiveInputStream(inputStream,"UTF-8");

//            while(null != (archiveEntry = zipArchiveInputStream.getNextEntry()))
            while(null != (archiveEntry = zipArchiveInputStream.getNextEntry())){

                String archiveEntryFileName = archiveEntry.getName();
                String archiveEntryPath = path + archiveEntryFileName;
                byte[] zipContent = new byte[(int)archiveEntry.getSize()];

                zipArchiveInputStream.read(zipContent);

                File entryFile = new File(archiveEntryPath);
                if(! entryFile.exists()){
                    entryFile.getParentFile().mkdirs();
                }
                outputStream = new FileOutputStream(entryFile);
                outputStream.write(zipContent);
                outputStream.flush();

            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();

        }finally {
            if(null != outputStream){
                try{
                    outputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            if(null != zipArchiveInputStream){

                try{
                    zipArchiveInputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            if(null != inputStream){
                try{
                    inputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

        }

    }

    public static void decompress7ZFile(String filePath, String targetPath)throws IOException{

        try{
            File szFile = new File(filePath);
            SevenZFile sevenZFile = new SevenZFile(szFile);

            SevenZArchiveEntry entry = sevenZFile.getNextEntry();
            while(entry !=null){
                System.out.println(entry.getName());
                entry = sevenZFile.getNextEntry();
            }

        }catch (IOException e){
            e.printStackTrace();
        }


//        byte[] sevenContent = new byte[(int)entry.getSize()];

    }

}
