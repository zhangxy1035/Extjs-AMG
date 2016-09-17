package com.ow.util;

import java.security.MessageDigest;

/** 
 * ����MD5���ܽ��� 
 * @author zxy 
 * @datetime 2016-09-13 
 */  
public class MD5Util {  
  
    /*** 
     * MD5���� ����32λmd5�� 
     */  
    public static String string2MD5(String inStr){
        MessageDigest md5 = null;  
        try{  
            md5 = MessageDigest.getInstance("MD5");  
        }catch (Exception e){  
            System.out.println(e.toString());  
            e.printStackTrace();  
            return "";  
        }  
        char[] charArray = inStr.toCharArray();  
        byte[] byteArray = new byte[charArray.length];  
  
        for (int i = 0; i < charArray.length; i++)  
            byteArray[i] = (byte) charArray[i];  
        byte[] md5Bytes = md5.digest(byteArray);  
        StringBuffer hexValue = new StringBuffer();  
        for (int i = 0; i < md5Bytes.length; i++){  
            int val = ((int) md5Bytes[i]) & 0xff;  
            if (val < 16)  
                hexValue.append("0");  
            hexValue.append(Integer.toHexString(val));  
        }  
        return hexValue.toString();  
  
    }
    /**
     * �����Լ��Ĺ������MD5����
     * ���磬�������������ַ�������zhang��xy
     * ����zhang�Ǵ�����ַ�
     * Ȼ����Ҫ��zhang���ַ����в��z����hang��
     * �����Ҫ���ܵ��ֶ�Ϊzxyhang
     */
    public static String MD5Test(String inStr){
    	String xy = "xy";
    	String finalStr="";
    	if(inStr!=null){
    		String fStr = inStr.substring(0, 1);
    		String lStr = inStr.substring(1, inStr.length());
    		finalStr = string2MD5( fStr+xy+lStr);
    		
    	}else{
    		finalStr = string2MD5(xy);
    	}
        return finalStr;  
    }
    
    /*** 
     * ���ݹ���������������Ӧ��MD5�������� 
     * ��������в�֣������һ���ַ�ƴ����ourway+ʣ�µ��ַ�
     */  
    public static String MD5OurWay(String inStr){
    	String ourway = "ourway";
    	String finalStr="";
    	if(inStr!=null){
    		String fStr = inStr.substring(0, 1);
    		String lStr = inStr.substring(1, inStr.length());
    		finalStr = string2MD5( fStr+ourway+lStr);
    		
    	}else{
    		finalStr = string2MD5(ourway);
    	}
        return finalStr;  
  
    }  
  
    /** 
     * ���ܽ����㷨 ִ��һ�μ��ܣ����ν��� 
     */   
    public static String convertMD5(String inStr){  
  
        char[] a = inStr.toCharArray();  
        for (int i = 0; i < a.length; i++){  
            a[i] = (char) (a[i] ^ 't');  
        }  
        String s = new String(a);  
        return s;  
  
    }  
  
//    // ����������  
//    public static void main(String args[]) { 
//        String s = new String("oourwayurway");
//        String s1 = "ourway";
//        System.out.println("ԭʼ��" + s);  
//        System.out.println("MD5��" + string2MD5(s));  
//        System.out.println("���ܵģ�" + convertMD5(s));  
//        System.out.println("���ܵģ�" + convertMD5(convertMD5(s)));  
//        System.out.println("ʹ�ù�������м��ܵ�Ϊ "+MD5Test(s1));
//  
//    }  
}  