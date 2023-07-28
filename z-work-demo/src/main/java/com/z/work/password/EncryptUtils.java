package com.z.work.password;



import cn.hutool.core.codec.Base64Decoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/**
 * @author zhaoxu
 * @className EncryptUtils
 * @projectName JavaConcentration
 * @date 2020/7/23 12:13
 */
public class EncryptUtils {
    public static final String KEY = "MDEyMzQ1Njc4OTEyMzQ1Ng==";
    public static final String IV = "MDEyMzQ1Njc4OTEyMzQ1Ng==";
    public static final String CHARSET_CODE = "UTF-8";
    private static final String AES_TYPE = "AES/CBC/PKCS5Padding";

    public EncryptUtils() {
    }

    public static void main(String[] args) throws Exception {

        String key = new String(Base64Decoder.decode("MDEyMzQ1Njc4OTEyMzQ1Ng=="));
        String iv = new String(Base64Decoder.decode("MDEyMzQ1Njc4OTEyMzQ1Ng=="));
        String str1 = "asset_manage";
//            String str1 = "asset";
        String str2 = "#2e9AL0O%";
//        String user = encrypt(str1, key, iv);
//        String password = encrypt(str2, key, iv);
//        System.out.println("user: " + user);
//        System.out.println("password: " + password);


        String user1 = decrypt("s+cxV2Zz6WGkE1WHZ8ZR4w==", key, iv);
        String password1 = decrypt("cbauCu4dhNAykIrrbkZ1bg==", key, iv);
        System.out.println("user1: " + user1);
        System.out.println("password1: " + password1);

    }

//    public static String encrypt(String sSrc, String sKey, String iv) throws Exception {
//        if (sKey == null) {
//            System.out.print("Key为空null");
//            return null;
//        } else if (sKey.length() != 16) {
//            System.out.print("Key长度不是16位");
//            return null;
//        } else {
//            byte[] raw = sKey.getBytes("UTF-8");
//            IvParameterSpec zeroIv = new IvParameterSpec(iv.getBytes());
//            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
//            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//            cipher.init(1, skeySpec, zeroIv);
//            byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
//            return (new BASE64Encoder()).encode(encrypted);
//        }
//    }

    public static String decrypt(String sSrc, String sKey, String iv) throws Exception {
        try {
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            } else if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            } else {
                byte[] raw = sKey.getBytes("UTF-8");
                IvParameterSpec zeroIv = new IvParameterSpec(iv.getBytes());
                SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(2, skeySpec, zeroIv);
                byte[] encrypted1 = (Base64Decoder.decode(sSrc));

                try {
                    byte[] original = cipher.doFinal(encrypted1);
                    String originalString = new String(original, "utf-8");
                    return originalString;
                } catch (Exception var10) {
                    System.out.println(var10.toString());
                    return null;
                }
            }
        } catch (Exception var11) {
            System.out.println(var11.toString());
            return null;
        }
    }

}