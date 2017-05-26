package cn.brady.io;

import java.io.*;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

/**
 * thinking in java  18 I/O 18.10.6 内存映射文件
 * Created by Brady on 2017/5/16.
 */
public class MappedIO {

    private static int numOfInts      = 4000 * 1000;
    private static int numOfUbuffInts = 2000 * 1000;

    private abstract static class Tester{

        private String name;
        public Tester(String name){this.name = name;}
        public void runTest(){
            System.out.print(name + ": ");
            try{
                long start = System.nanoTime();
                test();
                double duration = System.nanoTime() - start;
                System.out.format("%.2f\n", duration/1.0e9);

            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }
        public abstract void test() throws IOException;

    }

    private static Tester[] tests = {
        new Tester("Stream Write") {
            public void test() throws IOException {
                DataOutputStream dos
                        = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("temp.tmp"))));
                    for (int i = 0; i < numOfInts; i++)
                        dos.writeInt(i);
                    dos.close();
                }
            },
            new Tester("Mapped Write") {
                @Override
                public void test() throws IOException {
                    FileChannel fc = new RandomAccessFile("temp.tmp", "rw").getChannel();
                    IntBuffer intBuffer = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
                    for(int i=0;i<numOfInts; i++){
                        intBuffer.put(i);
                    }
                    fc.close();
                }
            },
            new Tester("Stream Read") {
                @Override
                public void test() throws IOException {

                    DataInputStream dis = new DataInputStream(
                            new BufferedInputStream(
                                    new FileInputStream("temp.tmp")));
                    for(int i=0;i < numOfInts; i++){
                        dis.readInt();
                    }
                    dis.close();
                }
            },
            new Tester("Mapped Read") {
                @Override
                public void test() throws IOException {
                    FileChannel fileChannel = new FileInputStream(
                            new File("temp.tmp")).getChannel();
                    IntBuffer intBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size()).asIntBuffer();
                    while(intBuffer.hasRemaining())
                        intBuffer.get();
                    fileChannel.close();
                }
            },
            new Tester("Stream Read/Write") {
                @Override
                public void test() throws IOException {
                    RandomAccessFile raf = new RandomAccessFile(
                            new File("temp.tmp"),"rw");
                    raf.writeInt(1);
                    for(int i = 0; i < numOfUbuffInts; i++){
                        raf.seek(raf.length() - 4);
                        raf.writeInt(raf.readInt());
                    }
                    raf.close();
                }
            },
            new Tester("Mapped Read/Write") {
                @Override
                public void test() throws IOException {
                    FileChannel fileChannel = new RandomAccessFile(new File("temp.tmp"),"rw").getChannel();
                    IntBuffer intBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, fileChannel.size()).asIntBuffer();

                    intBuffer.put(0);
                    for(int i = 1; i < numOfUbuffInts; i++)
                        intBuffer.put(intBuffer.get(i - 1));
                    fileChannel.close();
                }
            }
    };

    public static void main(String[] args){
        for(Tester test: tests){
            test.runTest();
        }
    }
}
