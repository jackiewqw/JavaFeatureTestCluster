package com.wqw.decompile;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Dida {

    public static String getNowDate() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    public static String getVkey(String paramString) {
        return genVkey(new Object[] { "dida_app", paramString });
    }

    public static String genVkey(Object[] paramArrayOfObject) {
        String str = "";
        for (int k = 0; k < paramArrayOfObject.length; k++)
            str = str + paramArrayOfObject[k];
        return doGenVkey(doGenVkey(str.toUpperCase()).toUpperCase() + "kx123456789012345678901234567890").toUpperCase();
    }

    public static String doGenVkey(String paramString) {
        int i = 0;
        MessageDigest localMessageDigest;
        byte[] arrayOfByte1;
        String str;
        try {
            localMessageDigest = MessageDigest.getInstance("MD5");
            char[] arrayOfChar = paramString.toCharArray();
            arrayOfByte1 = new byte[arrayOfChar.length];
            for (int j = 0; j < arrayOfChar.length; j++)
                arrayOfByte1[j] = (byte) arrayOfChar[j];

            byte[] arrayOfByte2 = localMessageDigest.digest(arrayOfByte1);
            StringBuffer localStringBuffer = new StringBuffer();
            while (i < arrayOfByte2.length) {
                int k = 0xFF & arrayOfByte2[i];
                if (k < 16)
                    localStringBuffer.append("0");
                localStringBuffer.append(Integer.toHexString(k));
                i++;
            }
            str = localStringBuffer.toString();
        } catch (Exception localException) {
            localException.printStackTrace();
            str = "";
        }
        return str;
    }

    private static Map<String, String> getLocalHashMap(String paramString1, String paramString2) {
        HashMap<String, String> localHashMap = new HashMap<String, String>();
        localHashMap.put("actid", "dida_app");
        localHashMap.put("version", "2.9.0");
        localHashMap.put("token", "f1be7da7-53a8-4c5c-81e5-3e0cc2d67746");
        localHashMap.put("ts", paramString1);
        localHashMap.put("vkey", paramString2);
        localHashMap.put("mobiletype", "1");
        return localHashMap;
    }

    public static void sendRequest(TreeMap<String, String> requestParams) {
        String date = "20151015110650";//getNowDate();
        String vkey = getVkey(date);

        System.out.println(vkey);

        Map<String, String> localMap = getLocalHashMap(date, vkey);

        String sig = genSig(requestParams, vkey);

        System.out.println(sig);
    }

    public static String genSig(TreeMap<String, String> paramTreeMap, String paramString) {
        StringBuffer localStringBuffer = new StringBuffer();
        if ((paramTreeMap != null) && (!paramTreeMap.isEmpty())) {
            Iterator<?> localIterator = paramTreeMap.entrySet().iterator();
            while (localIterator.hasNext()) {
                Entry<?, ?> localEntry = (Entry<?, ?>) localIterator.next();
                StringBuilder localStringBuilder = new StringBuilder().append((String) localEntry.getKey()).append("=");
                localStringBuffer.append(localStringBuilder);
                localStringBuffer.append((String) localEntry.getValue());
            }
        }
        
        localStringBuffer.append(paramString);
        
        return encrypt(localStringBuffer.toString());
    }

    public static String encrypt(String paramString) {
        String str1;
        try {
            String str2 = encrypt(paramString.getBytes("UTF-8"));
            str1 = str2;
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            localUnsupportedEncodingException.printStackTrace();
            str1 = null;
        }

        return str1;
    }

    private static String encrypt(byte[] paramArrayOfByte) {
        String str1;
        try {
            MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
            localMessageDigest.update(paramArrayOfByte);
            byte[] arrayOfByte = localMessageDigest.digest();
            StringBuilder localStringBuilder = new StringBuilder();
            for (int i = 0; i < arrayOfByte.length; i++)
                localStringBuilder.append(Integer.toHexString(0xFFFFFF00 | 0xFF & arrayOfByte[i]).substring(6));
            String str2 = localStringBuilder.toString();

            str1 = str2;
        } catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
            localNoSuchAlgorithmException.printStackTrace();
            str1 = null;
        }
        return str1;
    }

    public static void main(String[] args) {
        TreeMap<String, String> map = new TreeMap<String, String>();
        map.put("user_cid", "e94ceee8-a0b1-11e4-94dc-782bcb4cf8d8");
        map.put("page_size", "20");
        map.put("filter_by", "");
        map.put("order_by", "");
        map.put("user_cid", "e94ceee8-a0b1-11e4-94dc-782bcb4cf8d8");
        map.put("page", "1");
        map.put("center_longitude", "116.314897");
        map.put("center_latitude", "40.051542");

        sendRequest(map);
    }
}
