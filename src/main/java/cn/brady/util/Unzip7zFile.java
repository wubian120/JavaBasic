package cn.brady.util;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.Arrays;

import net.sf.sevenzipjbinding.*;
import net.sf.sevenzipjbinding.impl.RandomAccessFileInStream;
import net.sf.sevenzipjbinding.simple.ISimpleInArchive;
import net.sf.sevenzipjbinding.simple.ISimpleInArchiveItem;

/**
 *
 * https://stackoverflow.com/questions/38105945/decompressing-a-file-like-7zip-with-java
 * Decompress *.7z file
 *
 * Created by Brady on 2017/7/4.
 */
public class Unzip7zFile {


    public static void main(String[] args) throws SevenZipException,FileNotFoundException{

        String filePath = "E:\\[zmk.tw]House.of.Cards.2013.S04.720p.WEBRip.X264-DEFLATE.7z";

        try{

            SevenZip.initSevenZipFromPlatformJAR();
            RandomAccessFile accessFile = new RandomAccessFile(filePath,"r");

            IInArchive inArchive = SevenZip.openInArchive(null,new RandomAccessFileInStream(accessFile));

            System.out.println(inArchive.getNumberOfItems());

            ISimpleInArchive simpleInArchive = inArchive.getSimpleInterface();

            System.out.println(" Hash   |   Size   | Filename");
            System.out.println("--------+----------+---------");

            for(ISimpleInArchiveItem item : simpleInArchive.getArchiveItems()){
                final int[] hash = new int[]{0};
                if(!item.isFolder()){
                    ExtractOperationResult result;

                    final long[] sizeArray = new long[1];
                    result = item.extractSlow(new ISequentialOutStream() {
                        public int write(byte[] bytes) throws SevenZipException {
                            hash[0] ^= Arrays.hashCode(bytes);

                            for(byte b : bytes){
                                System.out.print((char) b);
                            }
                            sizeArray[0] += bytes.length;

                            return bytes.length;
                        }
                    });

                    if(result == ExtractOperationResult.OK){
                        System.out.println(String.format("%9x| %10s | %s",hash[0],sizeArray[0],item.getPath()));
                    }else {
                        System.err.println("Error extracting item: " + result);
                    }

                }
            }



        }catch (SevenZipNativeInitializationException e){
            e.printStackTrace();
        }




    }



}
