package HttpUrlConnect;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/11/12 下午2:32
 */
public class MobileClient {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx");
        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
        httpConnection.setRequestMethod("POST");
        httpConnection.setRequestProperty("content-type", "text/xml;charset=UTF-8");
        httpConnection.setDoInput(true);
        httpConnection.setDoOutput(true);

        String soapXml = getXML("13083668372");
        OutputStream os = httpConnection.getOutputStream();
        os.write(soapXml.getBytes());

        int responseCode = httpConnection.getResponseCode();
        if (responseCode == 200) {
            InputStream is = httpConnection.getInputStream();
            InputStreamReader isReader = new InputStreamReader(is);
            BufferedReader bufIs = new BufferedReader(isReader);
            while (bufIs.ready()) {
                System.out.println(bufIs.readLine());
            }
        }
    }

    //组织数据，将数据拼接一下
    public static String getXML(String phoneNum) {
        String soapXML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
                + "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
                + "<soap:Body>"
                + "<getMobileCodeInfo xmlns=\"http://WebXml.com.cn/\">"
                + "<mobileCode>" + phoneNum + "</mobileCode>"
                + "<userID></userID>"
                + "</getMobileCodeInfo>"
                + "</soap:Body>"
                + "</soap:Envelope>";
        return soapXML;
    }
}

