package edu.nguyenmy.marveladroid_7.utils;

/**
 * Created by DELL on 11/17/2017.
 */

public final class DigestUtils {
    public static String getMD5(String md5) {
        try {
            java.security.MessageDigest md = java
                    .security.MessageDigest
                    .getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            String hash;
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            hash = sb.toString();
            return hash;

        } catch (java.security.NoSuchAlgorithmException e) {
            return null;
        }

    }
}
