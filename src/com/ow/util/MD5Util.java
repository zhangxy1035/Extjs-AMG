package com.ow.util;

import java.security.MessageDigest;

/** 
 * 采用MD5加密解密 
 * @author zxy 
 * @datetime 2016-09-13 
 */  
public class MD5Util {  
  
    /*** 
     * MD5加码 生成32位md5码 
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
     * 根据自己的规则进行MD5加密
     * 例如，现在需求是有字符串传入zhang，xy
     * 其中zhang是传入的字符
     * 然后需要将zhang的字符进行拆分z，和hang，
     * 最后需要加密的字段为zxyhang
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
     * 根据规则生成密码所对应的MD5加密密码 
     * 将密码进行拆分，密码第一个字符拼接上ourway+剩下的字符
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
     * 加密解密算法 执行一次加密，两次解密 
     */   
    public static String convertMD5(String inStr){  
  
        char[] a = inStr.toCharArray();  
        for (int i = 0; i < a.length; i++){  
            a[i] = (char) (a[i] ^ 't');  
        }  
        String s = new String(a);  
        return s;  
  
    }  
  
//    // 测试主函数  
//    public static void main(String args[]) { 
//        String s = new String("oourwayurway");
//        String s1 = "ourway";
//        System.out.println("原始：" + s);  
//        System.out.println("MD5后：" + string2MD5(s));  
//        System.out.println("加密的：" + convertMD5(s));  
//        System.out.println("解密的：" + convertMD5(convertMD5(s)));  
//        System.out.println("使用工具类进行加密的为 "+MD5Test(s1));
//  
//    }  
}  