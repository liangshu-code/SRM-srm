package com.ilp3.common.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AESUtils {

   private static final String KEY_ALGORITHM = "AES";
   private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";//默认的加密算法

   public static byte[] initSecretKey(String keyRules) {

       //返回生成指定算法密钥生成器的 KeyGenerator 对象
       KeyGenerator kg = null;
       try {
           kg = KeyGenerator.getInstance(KEY_ALGORITHM);
       } catch (NoSuchAlgorithmException e) {
           e.printStackTrace();
           return new byte[0];
       }
       //初始化此密钥生成器，使其具有确定的密钥大小
       //AES 要求密钥长度为 128
       kg.init(128,new SecureRandom(keyRules.getBytes()));
       //生成一个密钥
       SecretKey  secretKey = kg.generateKey();
       return secretKey.getEncoded();
   }

   private static Key toKey(byte[] key){
       //生成密钥
       return new SecretKeySpec(key, KEY_ALGORITHM);
   }
   
 /*  public static byte[] encrypt(byte[] data) throws Exception{
       return encrypt(data, initSecretKey());
   }*/
   
   public static String encrypt(String encodeContent,String keyRules) throws Exception{
	   byte [] data=encodeContent.getBytes("utf-8");
       return new String(new BASE64Encoder().encode(encrypt(data, initSecretKey(keyRules))));
   }

   public static byte[] encrypt(byte[] data,Key key) throws Exception{
       return encrypt(data, key,DEFAULT_CIPHER_ALGORITHM);
   }

   public static byte[] encrypt(byte[] data,byte[] key) throws Exception{
       return encrypt(data, key,DEFAULT_CIPHER_ALGORITHM);
   }

   public static byte[] encrypt(byte[] data,byte[] key,String cipherAlgorithm) throws Exception{
       //还原密钥
       Key k = toKey(key);
       return encrypt(data, k, cipherAlgorithm);
   }

   public static byte[] encrypt(byte[] data,Key key,String cipherAlgorithm) throws Exception{
       //实例化
       Cipher cipher = Cipher.getInstance(cipherAlgorithm);
       //使用密钥初始化，设置为加密模式
       cipher.init(Cipher.ENCRYPT_MODE, key);
       //执行操作
       return cipher.doFinal(data);
   }

   public static String decrypt(String encodeContent,String keyRules) throws Exception{
	   byte [] data= new BASE64Decoder().decodeBuffer(encodeContent);
       return new String(decrypt(data, initSecretKey(keyRules)),"utf-8");
   }
   
   public static byte[] decrypt(byte[] data,byte[] key) throws Exception{
       return decrypt(data, key,DEFAULT_CIPHER_ALGORITHM);
   }

   public static byte[] decrypt(byte[] data,Key key) throws Exception{
       return decrypt(data, key,DEFAULT_CIPHER_ALGORITHM);
   }

   public static byte[] decrypt(byte[] data,byte[] key,String cipherAlgorithm) throws Exception{
       //还原密钥
       Key k = toKey(key);
       return decrypt(data, k, cipherAlgorithm);
   }

   public static byte[] decrypt(byte[] data,Key key,String cipherAlgorithm) throws Exception{
       //实例化
       Cipher cipher = Cipher.getInstance(cipherAlgorithm);
       //使用密钥初始化，设置为解密模式
       cipher.init(Cipher.DECRYPT_MODE, key);
       //执行操作
       return cipher.doFinal(data);
   }

   private static String  showByteArray(byte[] data){
       if(null == data){
           return null;
       }
       StringBuilder sb = new StringBuilder("{");
       for(byte b:data){
           sb.append(b).append(",");
       }
       sb.deleteCharAt(sb.length()-1);
       sb.append("}");
       return sb.toString();
   }
   

   public static void main(String[] args) throws Exception {
	   String ecodeC = encrypt("1", "admin");
	   System.out.println(ecodeC);
	   System.out.println(decrypt(ecodeC, "admin"));
   }
}