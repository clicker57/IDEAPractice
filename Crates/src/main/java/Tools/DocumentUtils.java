package Tools;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.Properties;

public class DocumentUtils {
    /**
     * ��ʼ��һ����Document���󷵻ء�
     *
     * @return a Document
     */
    public static Document newXMLDocument() {
        try {
            return newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * ��ʼ��һ��DocumentBuilder
     *
     * @return a DocumentBuilder
     * @throws ParserConfigurationException
     */
    public static DocumentBuilder newDocumentBuilder()
            throws ParserConfigurationException {
        return newDocumentBuilderFactory().newDocumentBuilder();
    }

    /**
     * ��ʼ��һ��DocumentBuilderFactory
     *
     * @return a DocumentBuilderFactory
     */
    public static DocumentBuilderFactory newDocumentBuilderFactory() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        return dbf;
    }

    /**
     * �������һ��XML Stringת����һ��org.w3c.dom.Document���󷵻ء�
     *
     * @param xmlString һ������XML�淶���ַ�����
     * @return a Document
     */
    public static Document parseXMLDocument(String xmlString) {
        if (xmlString == null) {
            throw new IllegalArgumentException();
        }
        try {
            return newDocumentBuilder().parse(new InputSource(new StringReader(xmlString)));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * ����һ��������������Ϊһ��org.w3c.dom.Document���󷵻ء�
     *
     * @param input
     * @return a org.w3c.dom.Document
     */
    public static Document parseXMLDocument(InputStream input) {
        if (input == null) {
            throw new IllegalArgumentException("����Ϊnull��");
        }
        try {
            return newDocumentBuilder().parse(input);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * ����һ���ļ�������ȡ���ļ�������Ϊһ��org.w3c.dom.Document���󷵻ء�
     *
     * @param fileName �������ļ����ļ���
     * @return a org.w3c.dom.Document
     */
    public static Document loadXMLDocumentFromFile(String fileName) {
        if (fileName == null) {
            throw new IllegalArgumentException("δָ���ļ�����������·����");
        }
        try {
            return newDocumentBuilder().parse(new File(fileName));
        } catch (SAXException e) {
            throw new IllegalArgumentException("Ŀ���ļ���" + fileName + "�����ܱ���ȷ����ΪXML��" + e.getMessage());
        } catch (IOException e) {
            throw new IllegalArgumentException("���ܻ�ȡĿ���ļ���" + fileName + "����" + e.getMessage());
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * ��dom�ļ�ת��Ϊxml�ַ���
     */
    public static String toStringFromDoc(Document document) {
        String result = null;

        if (document != null) {
            StringWriter strWtr = new StringWriter();
            StreamResult strResult = new StreamResult(strWtr);
            TransformerFactory tfac = TransformerFactory.newInstance();
            try {
                Transformer t = tfac.newTransformer();
                t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                t.setOutputProperty(OutputKeys.INDENT, "yes");
                t.setOutputProperty(OutputKeys.METHOD, "xml"); // xml, html,
                // text
                t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
                t.transform(new DOMSource(document.getDocumentElement()), strResult);
            } catch (Exception e) {
                System.err.println("XML.toString(Document): " + e);
            }
            result = strResult.getWriter().toString();
            try {
                strWtr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    /**
     * ����һ���ڵ㣬���ýڵ�����¹����Document�С�
     *
     * @param node a Document node
     * @return a new Document
     */

    public static Document newXMLDocument(Node node) {
        Document doc = newXMLDocument();
        doc.appendChild(doc.importNode(node, true));
        return doc;
    }

    /**
     * �������һ��DOM Node����������ַ��������ʧ���򷵻�һ�����ַ���""��
     *
     * @param node DOM Node ����
     * @return a XML String from node
     */
    public static String toString(Node node) {
        if (node == null) {
            throw new IllegalArgumentException();
        }
        Transformer transformer = null;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
        } catch (TransformerConfigurationException tce) {
            throw new RuntimeException(tce.getMessage());
        }
        if (transformer != null) {
            try {
                StringWriter sw = new StringWriter();
                transformer.transform(new DOMSource(node), new StreamResult(sw));
                return sw.toString();
            } catch (TransformerException te) {
                throw new RuntimeException(te.getMessage());
            }
        }
        return "";
    }

    /**
     * ��ȡһ��Transformer��������ʹ��ʱ������ͬ�ĳ�ʼ����������ȡ������Ϊ����������
     *
     * @return a Transformer encoding gb2312
     */
    public static Transformer newTransformer() {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            Properties properties = transformer.getOutputProperties();
            properties.setProperty(OutputKeys.ENCODING, "gb2312");
            properties.setProperty(OutputKeys.METHOD, "xml");
            properties.setProperty(OutputKeys.VERSION, "1.0");
            properties.setProperty(OutputKeys.INDENT, "no");
            transformer.setOutputProperties(properties);
            return transformer;
        } catch (TransformerConfigurationException tce) {
            throw new RuntimeException(tce.getMessage());
        }
    }

    /**
     * ����һ��XML�����Ĵ�����Ϣ����ʾ��Ϣ��TITLEΪ��ϵͳ����
     * ֮����ʹ���ַ���ƴװ����Ҫ��������һ�� �������쳣���֡�
     *
     * @param errMsg
     *            ��ʾ������Ϣ
     * @param errClass
     *            �׳��ô�����࣬������ȡ������Դ��Ϣ��
     * @return a XML String show err msg
     */
    public static String errXMLString(String errMsg, Class errClass) {
        StringBuffer msg = new StringBuffer(100);
        msg.append("<?xml version='1.0' encoding='gb2312' ?>");
        msg.append("<errNode title=\"ϵͳ����\" errMsg=\"" + errMsg + "\" errSource=\"" + errClass.getName()+ "\"/>");
        return msg.toString();
    }

    /**
     * ����һ��XML�����Ĵ�����Ϣ��
     *
     * @param title    ��ʾ��title
     * @param errMsg   ��ʾ������Ϣ
     * @param errClass �׳��ô�����࣬������ȡ������Դ��Ϣ��
     * @return a XML String show err msg
     */
    public static String errXMLString(String title, String errMsg, Class errClass) {
        StringBuffer msg = new StringBuffer(100);
        msg.append("<?xml version='1.0' encoding='utf-8' ?>");
        msg.append("<errNode title=" + title + "errMsg=" + errMsg + "errSource=" + errClass.getName() + "/>");
        return msg.toString();
    }




    /**
     * ʵ��dom4j��w3c��Document��ת��
     * @param doc org.dom4j.Document
     * @return org.w3c.dom.Document
     * @throws Exception
     */
    public static Document parseToW3C(org.dom4j.Document doc) throws Exception {
        if (doc == null) {
            return null;
        }
        StringReader reader = new StringReader(doc.toString());
        InputSource source = new InputSource(reader);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        return (documentBuilder.parse(source));
    }

    /**
     *
     * ʵ��w3c��dom4j��Document��ת��
     * @param doc org.w3c.dom.Document
     * @return org.dom4j.Document
     * @throws Exception
     */
    public static org.dom4j.Document parseToDOM4J(Document doc) throws Exception {
        if (doc == null) {
            return null;
        }
        org.dom4j.io.DOMReader xmlReader = new org.dom4j.io.DOMReader();
        return xmlReader.read(doc);
    }
}
