package com.sxt.auth.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by shixiaotian on 16/4/20.
 */
public class Sha1Utils {

    /*
	 * 注：
	 * 1、安全哈希算法（Secure Hash Algorithm）主要适用于数字签名标准 （Digital Signature Standard DSS）里面定义的
	 * 数字签名算法（Digital Signature Algorithm DSA）。对于长度小于2^64位的消息，SHA1会产生一个160位的消息摘要。
	 * 2、SHA-1与MD5的比较：前者在长度上长32 位；强行攻击有更大的强度
	 * 3、MD5输出128bit、SHA1输出160bit、SHA256输出256bit、另外还有SHA244,SHA512，分别输出244bit，512bit
	 */

    public static final String ALGORITHM = "SHA1";

    /**
     *
     * 加密方法
     *
     * @param content 被加密的数据
     *
     * @return byte[]
     *
     */
    public static byte[] encode(byte[] content) {
        try{
            MessageDigest digest = MessageDigest.getInstance(ALGORITHM);
            digest.update(content);
            return digest.digest();
        }catch(NoSuchAlgorithmException e){

        }
        return null;
    }

    /**
     *
     * 对字符串生成验签
     *
     * @param str 字符串
     *
     * @return String
     */
    public static String encode(String str) {

        if(str != null && str.length() > 0) {

            char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                    'a', 'b', 'c', 'd', 'e', 'f'};
            try {

                // 获取utf-8字符串的byte
                byte[] utf8StrByte = str.getBytes("UTF-8");

                // 获取字符串
                byte[] md = Sha1Utils.encode(utf8StrByte);
                int j = md.length;
                char[] buf = new char[j * 2];
                int k = 0;
                for (int i = 0; i < j; i++) {
                    byte byte0 = md[i];
                    buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                    buf[k++] = hexDigits[byte0 & 0xf];
                }

                return new String(buf);

            } catch (Exception e) {

                return null;

            }

        } else {

            return null;

        }

    }

    // 生成sha1
    public static void main(String arg[]) {
        System.out.println(Sha1Utils.encode("qweasd"));
    }

}
