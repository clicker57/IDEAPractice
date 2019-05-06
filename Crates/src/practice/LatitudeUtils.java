package practice;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LatitudeUtils {

    public static final String KEY_1 = "7d9fbeb43e975cd1e9477a7e5d5e192a";

    /**
     * ���������ַ�ľ�γ������
     * key lng(����),lat(γ��)
     */
    public static Map<String,String> getGeocoderLatitude(String address){
        BufferedReader in = null;
        try {

            //����ַת����utf-8��16����
            address = URLEncoder.encode(address, "UTF-8");

            URL tirc = new URL("http://api.map.baidu.com/geocoder/V2?address="+ address +"&output=json&key="+ KEY_1);
            System.out.println("tirc: " + tirc.toString());

            in = new BufferedReader(new InputStreamReader(tirc.openStream(), StandardCharsets.UTF_8));
            String res;
            StringBuilder sb = new StringBuilder();
            while((res = in.readLine())!=null){
                sb.append(res.trim());
            }
            String str = sb.toString();
            Map<String,String> map = null;
            if(StringUtils.isNotEmpty(str)){
                int lngStart = str.indexOf("lng\":");
                int lngEnd = str.indexOf(",\"lat");
                int latEnd = str.indexOf("},\"precise");
                if(lngStart > 0 && lngEnd > 0 && latEnd > 0){
                    String lng = str.substring(lngStart+5, lngEnd);
                    String lat = str.substring(lngEnd+7, latEnd);
                    map = new HashMap<>();
                    map.put("lng", lng);
                    map.put("lat", lat);
                    return map;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args){
        Map<String, String> json = LatitudeUtils.getGeocoderLatitude("����Ȫ�ݰ�Ϫ��ͷ");

        System.out.println("json: " + json.toString());
//        System.out.println("lng : " + json.get("lng"));
//        System.out.println("lat : " + json.get("lat"));
    }


}


/**
 * java�����signatureǩ��
 */
class SnCal {
    public static void main(String[] args)
            throws UnsupportedEncodingException, NoSuchAlgorithmException {
        SnCal snCal = new SnCal();
    /*
        ����sn�������Գ���˳���йأ�get������ʹ��LinkedHashMap����<key,value>���÷�������key�Ĳ���˳������
        post��ʹ��TreeMap����<key,value>���÷������Զ���key������ĸa-z˳������
        ����get������Զ������˳��sn������������󣩷������󣬵���post������밴����ĸa-z˳�����body��sn������������󣩡�
        ��get����Ϊ����http://api.map.baidu.com/geocoder/v2/?address=�ٶȴ���&output=json&ak=yourak��
        paramsMap���ȷ���address���ٷ�output��Ȼ���ak������˳������get�����ж�Ӧ�����ĳ���˳�򱣳�һ�¡�
     */

        Map paramsMap = new LinkedHashMap<String, String>();
        paramsMap.put("address", "�ٶȴ���");
        paramsMap.put("output", "json");
        paramsMap.put("ak", "yourak");

        // ���������toQueryString��������LinkedHashMap������value��utf8���룬ƴ�ӷ��ؽ��address=%E7%99%BE%E5%BA%A6%E5%A4%A7%E5%8E%A6&output=json&ak=yourak
        String paramsStr = snCal.toQueryString(paramsMap);

        // ��paramsStrǰ��ƴ����/geocoder/v2/?������ֱ��ƴ��yoursk�õ�/geocoder/v2/?address=%E7%99%BE%E5%BA%A6%E5%A4%A7%E5%8E%A6&output=json&ak=yourakyoursk
        String wholeStr = "/geocoder/v2/?" + paramsStr + "yoursk";

        // ������wholeStr����utf8����
        String tempStr = URLEncoder.encode(wholeStr, "UTF-8");

        // ���������MD5�����õ�����snǩ��7de5a22212ffaa9e326444c75a58f9a0
        System.out.println(snCal.MD5(tempStr));
    }

    /**
     * ��Map������value��utf8���룬ƴ�ӷ��ؽ��
     *
     * @param data
     * @return
     * @throws UnsupportedEncodingException
     */
    public String toQueryString(Map<?, ?> data)
            throws UnsupportedEncodingException {
        StringBuffer queryString = new StringBuffer();
        for (Entry<?, ?> pair : data.entrySet()) {
            queryString.append(pair.getKey() + "=");
            queryString.append(URLEncoder.encode((String) pair.getValue(),
                    "UTF-8") + "&");
        }
        if (queryString.length() > 0) {
            queryString.deleteCharAt(queryString.length() - 1);
        }
        return queryString.toString();
    }

    /**
     * ����stackoverflow��MD5���㷽����������MessageDigest�⺯��������byte������ת����16����
     *
     * @param md5
     * @return
     */
    public String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100), 1, 3);
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }

        return null;
    }
}
