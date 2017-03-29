package com.cvnchina.emsquartz.test;

import java.io.*;
import java.util.*;

/**
 * Created by machenike on 2017/3/21.
 */
public class ShuffleWord {
//    "src/com/lavasoft/res/a.txt"
    public static void main(String[] args){
        File f = new File("src\\main\\java\\com\\cvnchina\\emsquartz\\test\\123.txt");
        System.out.println(f.getAbsolutePath());
        try {
            BufferedReader bf = new BufferedReader(new FileReader(f));

            BufferedWriter bw = new BufferedWriter(new FileWriter("1234.txt"));
            String line = bf.readLine();
            while(line !=null){
                String string = shuffleLine1(line);
                bw.write(string);
                line = bf.readLine();
            }

            bw.flush();
            bw.close();
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String shuffleLine(String line){
//        List<String> words = Arrays.asList(line.split("\\s+|[，,.]"));
        line = line.replace(","," , ");
        line = line.replace("."," . ");
        line = line.replace("?"," ? ");
        List<String> words = Arrays.asList(line.split("\\s"));
        StringBuffer result = new StringBuffer();
        for (int i=0;i<words.size();i++){
            String s = words.get(i);
            List<Character> cs = new ArrayList<Character>();
            for (char c : s.toCharArray()){
                cs.add(c);
            }
            Collections.shuffle(cs);
            StringBuffer sb = new StringBuffer();
            for (char c : cs){
                sb.append(c);
            }
            String l = sb.toString();
            l = l.replace(" , ",",");
            l = l.replace(" . ",".");
            l = l.replace(" ? ","?");
            result.append(l).append(" ");

        }
        result.append("\n");
        return result.toString();
    }

    public static String shuffleLine1(String line){
        line = line.replace(","," , ");
        line = line.replace("."," . ");
        line = line.replace("?"," ? ");
        line = line.replace("'"," ' ");
        line = line.replace(":"," : ");
        List<String> words = Arrays.asList(line.split("\\s"));
        StringBuffer result = new StringBuffer();
        for (int i=0;i<words.size();i++){
            String s = words.get(i);
//            if (){
//
//            }
            char[] chars = s.toCharArray();
            List<Character> cs = new ArrayList<Character>();
            for (int k =1;k<chars.length-1;k++){
                cs.add(chars[k]);
            }
            Collections.shuffle(cs);
            StringBuffer sb = new StringBuffer();
            if (chars.length>=1){
                sb.append(chars[0]);
            }

            for (char c : cs){
                sb.append(c);
            }
            if (chars.length>1){
                sb.append(chars[chars.length-1]);
            }

            String l = sb.toString();
            l = l.replace(" , ",",");
            l = l.replace(" . ",".");
            l = l.replace(" ? ","?");
            l = l.replace(" ' ","'");
            l = l.replace(" : ",":");
            result.append(l).append(" ");

        }
        result.append("\n");
        return result.toString();
    }
}
