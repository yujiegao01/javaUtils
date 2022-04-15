package test;

import java.io.BufferedReader;

import java.io.DataOutputStream;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.net.URL;

import java.util.LinkedHashMap;

import java.util.List;

import java.util.Map;

import java.util.Set;

import javax.net.ssl.HttpsURLConnection;

public class MyHttp {

    /**
     * 
     * 发起Http的get请求
     * 
     * @param property 请求头参数
     * 
     * @url 请求的地址
     * 
     * @return 响应内容[Map<String, List<String>>(响应头),String(响应体)]
     * 
     */

    public static Object[] get(String url, LinkedHashMap<String, String> property) {

        StringBuffer buffer = null;

        Map<String, List<String>> headerFields = null;

        try {

            URL u = new URL(url);

            HttpsURLConnection conn = (HttpsURLConnection) u.openConnection();

            Set<String> keySet = property.keySet();

            for (String key : keySet) {

                conn.setRequestProperty(key, property.get(key));

            }

            // 设置当前实例使用的SSLSoctetFactory

            System.out.println("开始链接");

            conn.connect();

            System.out.println("链接成功");

            // 读取服务器返回的响应头

            headerFields = conn.getHeaderFields();

            // 读取服务器端返回的内容

            InputStream is = conn.getInputStream();

            InputStreamReader isr = new InputStreamReader(is, "utf-8");

            BufferedReader br = new BufferedReader(isr);

            buffer = new StringBuffer();

            String line = null;

            while ((line = br.readLine()) != null) {

                buffer.append(line);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        Object[] response = { headerFields, buffer.toString() };

        return response;

    }

    /**
     * 
     * 发情http的post请求
     * 
     * @param url      目标地址
     * 
     * @param property 请求头参数
     * 
     * @param content  请求内容
     * 
     * @return 响应内容[Map<String, List<String>>(响应头),String(响应体)]return 返回内容 [请求头,内容]
     * 
     */

    public static Object[] post(String url, LinkedHashMap<String, String> property, String content) {

        StringBuffer buffer = null;

        Map<String, List<String>> headerFields = null;

        try {

            URL u = new URL(url);

            HttpsURLConnection conn = (HttpsURLConnection) u.openConnection();

            conn.setDoOutput(true);

            conn.setDoInput(true);

            conn.setUseCaches(false);

            conn.setRequestMethod("POST");

            Set<String> keySet = property.keySet();

            for (String key : keySet) {

                conn.setRequestProperty(key, property.get(key));

            }

            // 设置当前实例使用的SSLSoctetFactory

            System.out.println("开始链接");

            conn.connect();

            DataOutputStream os = new DataOutputStream(conn.getOutputStream());

            os.writeBytes(content);

            os.flush();

            os.close();

            System.out.println("链接成功");

            // 读取服务器返回的响应头

            headerFields = conn.getHeaderFields();

            // 读取服务器端返回的内容

            InputStream is = conn.getInputStream();

            InputStreamReader isr = new InputStreamReader(is, "utf-8");

            BufferedReader br = new BufferedReader(isr);

            buffer = new StringBuffer();

            String line = null;

            while ((line = br.readLine()) != null) {

                buffer.append(line);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        Object[] response = { headerFields, buffer.toString() };

        return response;

    }

}