package practice;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created by Philip on 12/6/16.
 */
public class xmlTransferation {
    private String xmlText;

    public xmlTransferation(String text) {
        this.xmlText = text;
    }

    public static void main(String[] args) {
        xmlTransferation obj = new xmlTransferation("this is >> 传送门.");

        obj.showXml();

        Map<String, Object> srcMap = new HashMap<>();
        Map<String, Object> resMap = new HashMap<>();
        Map<String, Object> tmpMap = new HashMap<>();
        Map<String, Object> tmpMap2 = new HashMap<>();
        ArrayList<Map<String, Object>> tmpList = new ArrayList<>();

        tmpMap.put("color", "white");
        tmpMap.put("name", "Frank");
        tmpMap2.put("owner", tmpMap);
        tmpMap = new HashMap<>();
        tmpMap.put("addr", "局部地区");
        tmpMap.put("staff", tmpMap2);
        srcMap.put("person", tmpMap);
        srcMap.put("other", "show time");
        srcMap.put("trip", 1);
        tmpMap = new HashMap<>();
        tmpMap2 = new HashMap<>();


        tmpMap = (Map<String, Object>) srcMap.get("test");
        resMap.put("knull", tmpMap);
        tmpMap = new HashMap<>();

        System.out.println("srcMap: "+srcMap.toString());
        resMap.put("single", srcMap.get("trip"));
        resMap.put("single", 3);
        System.out.println("srcMap 2 : "+srcMap.get("trip"));
        ((Map<String,Object>)srcMap.get("person")).put("addr", "anywhere");
        System.out.println("srcMap 3 : "+srcMap.toString());
        tmpMap.put("test", 111);
        srcMap.putAll(tmpMap);
        tmpMap.put("test", 222);
        tmpMap.put("age", "xxx");
        srcMap.put("age", tmpMap.get("age"));
        tmpMap.put("age", "yy");
        System.out.println("srcMap 4 : "+srcMap.toString());
        tmpMap = new HashMap<>();
        tmpMap.put("name", "new");
        tmpMap.put("ctime", "2016-11-20");
        tmpMap.put("size", 52814);
        srcMap.put("file", tmpMap);
        System.out.println("srcMap 5 : "+srcMap.toString());
        tmpMap.put("size", 123);
        System.out.println("srcMap 6 : "+srcMap.toString());

        tmpList.clear();
        tmpMap2.clear();
        tmpMap2 = (Map<String,Object>)((Map<String,Object>)srcMap.get("person")).get("staff");
        tmpMap2.put("who", "came");
        System.out.println("srcMap 7 : "+srcMap.toString());

    }

    private void showXml() {
        Document doc = DocumentHelper.createDocument();
//        doc.setXMLEncoding("UTF8");
        Element root = doc.addElement("info");
        root.setText(this.xmlText);

        System.out.println("asXml: "+doc.asXML());

        System.out.println("format1: "+formatXml(doc, "UTF8", true));

        System.out.println("format2: "+formatXml(doc, "UTF8", false));
    }

    private String formatXml(Document document, String charset, boolean isTrasfer) {
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding(charset);
        StringWriter sw = new StringWriter();
        XMLWriter xw = new XMLWriter(sw, format);
        xw.setEscapeText(isTrasfer);

        try {
            xw.write(document);
            xw.flush();
            xw.close();
        } catch (IOException e) {
            System.out.println("XML格式化异常");
            e.printStackTrace();
        }

        return sw.toString();
    }
}
