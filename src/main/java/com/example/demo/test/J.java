package com.example.demo.test;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class J {

    /**
     * /admrw/630252.html   /admrw/771410.html
     *
     * <br/><img
     */

    public static void main(String[] args)  {
        List<String> list = read("b.txt");
//        for(String str: list){
//
//        }
        downloadPicture(list.get(0));

        System.out.println(list.size());
    }

    public static void write(String fileName, String content) {
        try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            // 将写文件指针移到文件尾。
            randomFile.seek(fileLength);
            randomFile.writeBytes(content+"\r\n");
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param urlStr
     */
    public static void downloadPicture(String urlStr) {
        URL url;
        try {
            url = new URL(urlStr);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());

            String imageName =  "image/" + urlStr.substring(urlStr.lastIndexOf("/") +1 ,urlStr.length());

            FileOutputStream fileOutputStream = new FileOutputStream(new File(imageName));
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> read(String name){
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            FileReader fr = new FileReader(name);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            while ((str = bf.readLine()) != null) {
                arrayList.add(str);
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
    public static void get(){

        try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile("a3.txt", "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            // 将写文件指针移到文件尾。
            randomFile.seek(fileLength);

            URL url = null;
            InputStream in = null;
            InputStreamReader isr = null;
            BufferedReader bufr = null;

            int count = 0;
            int number;
            for(int index = 0 ; index >= 1 ;index ++){
                System.out.println("=====" + index);
                url = new URL("http://XXX" + index + ".html");
                try{
                    in =url.openStream();

                }catch (Exception e){
                    e.printStackTrace();
                    continue;
                }
                isr = new InputStreamReader(in);
                bufr = new BufferedReader(isr);
                String str;
                String[] array;
                while ((str = bufr.readLine()) != null) {
                    if(str.startsWith("<br/><img src")){
                        array = str.split("<br/><img src=\"");
                        number = array.length - 1;
                        count = count + number;
                        System.out.println(index + "====" + number + "===" + count);
                        for(String s : array){
                            if("".equals(s) || s.length() < 10){
                                continue;
                            }
                            s = s.substring(0,s.indexOf("\""));
                            randomFile.writeBytes(s+"\r\n");
                        }
                    }
                }
            }
            if(bufr != null){
                bufr.close();
            }
            if (isr != null){
                isr.close();
            }
            if(in != null){
                in.close();
            }
            randomFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
