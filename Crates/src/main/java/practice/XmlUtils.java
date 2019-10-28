package practice;

import org.dom4j.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/**
 * Created by Philip on 12/8/16.
 */
public class XmlUtils {
    public final static List<String> targetArr = Arrays.asList(
            "/Header/vise/Target/name",
            "/Header/vise/npc/size"
    );

    public final static List<String> EXCLUDED = Arrays.asList("hp");

    public static void processElement(Element element) throws ParseException {
        List list = element.elements();
        if (list.size()>0) {
            for (Iterator<Element> iter=list.listIterator(); iter.hasNext(); ) {
                Element e = iter.next();

                if (EXCLUDED.contains(e.getName())) {
                    System.out.println("found " + e.getName());
                }

                if (e.elements().size()>0) {
                    processElement(e);
                } else {
                    String ePath = e.getPath();
                    System.out.println("e: "+e.getName()+", path: "+ePath);
                    if (targetArr.contains(ePath)) {
                        e.setText(e.getTextTrim()+"adv");
                        System.out.println("value altered");
                    }
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> Dom2Map(Document doc) {
        Map<String, Object> map = new HashMap<>();
        if (doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext(); ) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if (list.size() > 0) {
                map.put(e.getName(), Dom2Map(e));
            } else
                map.put(e.getName(), e.getText());
        }
        return map;
    }

    @SuppressWarnings("unchecked")
    public static Map Dom2Map(Element e) {
        Map map = new HashMap();
        List list = e.elements();
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Element iter = (Element) list.get(i);

                if (iter.elements().size() > 0) {
                    Map m = Dom2Map(iter);
                    addToMap(iter, map, m);
                } else {
                    addToMap(iter, map, iter.getText());
                }
            }
        } else
            map.put(e.getName(), e.getText());
        return map;
    }

    public static void addToMap(Element e, Map<String, Object> dst, Object content) {
        List mapList;

        if (dst.get(e.getName()) != null) {
            Object obj = dst.get(e.getName());
            if (!obj.getClass().getName().equals("java.util.ArrayList")) {
                mapList = new ArrayList();
                mapList.add(obj);
                mapList.add(content);
            } else {
                mapList = (List) obj;
                mapList.add(content);
            }
            dst.put(e.getName(), mapList);
        } else
            dst.put(e.getName(), content);
    }

    public static Object fetch2Map(Map<String, Object> srcMap, String key) {
        for (Map.Entry<String, Object> entry: srcMap.entrySet()) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }

            Class<? extends Object> eType = entry.getValue().getClass();
            if (eType.getName().equals("java.util.ArrayList")) {
                ArrayList<Map<String,Object>> listData = (ArrayList<Map<String,Object>>) entry.getValue();
                if (listData == null || listData.size()<=0) {
                    continue;
                } else if (listData.size()>0) {
                    for (int i=0; i<listData.size(); i++) {
                        Object child = fetch2Map(listData.get(i), key);
                        if (child!=null && child.toString().length()>0) {
                            return child;
                        }
                    }
                }
            } else if (eType.getName().equals("java.util.HashMap")) {
                Object child = fetch2Map((Map<String, Object>) entry.getValue(), key);
                if (child!=null && child.toString().length()>0) {
                    return child;
                }
            }
        }
        return null;
    }

    public static Object fetchMapLeaf(Object ori) {
        Map<String,Object> item = new HashMap<>();
        Class<? extends Object> nodeType = ori.getClass();

        if (nodeType.getName().equals("java.util.ArrayList")) {
            List<Map<String,Object>> resList = new ArrayList<>();
            List<Map<String,Object>> listNode = (List)ori;
            for (int i=0; i<listNode.size(); i++) {
                item = new HashMap<>();
                fetchMapLeaf(listNode.get(i), item);
                resList.add(item);
            }
            return resList;
        }

        if (nodeType.getName().equals("java.util.HashMap")) {
            fetchMapLeaf((Map<String,Object>)ori, item);
            return item;
        }

        return null;
    }

    public static void fetchMapLeaf(Map<String,Object> original, Map<String,Object> result) {
        for (Map.Entry<String,Object> entry: original.entrySet()) {
            Class<? extends Object> eType = entry.getValue().getClass();

            if (eType.getName().equals("java.util.ArrayList")) {
                ArrayList<Map<String,Object>> listData = (ArrayList<Map<String,Object>>) entry.getValue();
                if (listData == null || listData.size()<=0) {
                    continue;
                } else if (listData.size()>0) {
                    for (int i=0; i<listData.size(); i++) {
                        fetchMapLeaf(listData.get(i), result);
                    }
                }
            } else {
                result.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        String file = "//Users//Philip//Downloads//aaa.xml";
        FileInputStream fis;
        String str = "";
        Document doc = null;
        try {
            fis = new FileInputStream(file);
            byte[] b = new byte[fis.available()];
            fis.read(b);
            str = new String(b, "UTF-8");
            doc = DocumentHelper.parseText(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("[error] file not found : " + file);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("[error] file cannot be accessed : " + file);
        } catch (DocumentException e) {
            e.printStackTrace();
            System.out.println("[error] cannot parse file content : " + str);
            return;
        }


        System.out.println(doc.asXML());
        System.out.println("-------------------------------");

        Element root = doc.getRootElement();
        try {
            XmlUtils.processElement(root);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println(doc.asXML());
        System.out.println("-------------------------------");

        List list = root.elements();
        if (list!=null && list.size()>0) {
            for (Iterator<Element> it = list.listIterator(); it.hasNext(); ) {
                Element e = it.next();
                for (Iterator iterA = e.attributeIterator(); iterA.hasNext(); ) {
                    Attribute attr = (Attribute) iterA.next();
                    System.out.println(e.getName() + " attribute " + attr.getName() + ": " + attr.getValue());
                }
                if (e.attribute("name").getValue().equals("guesswho")
                        && e.attribute("id").getValue().equals("112233")) {
                    System.out.println("boss here!");
                }
            }
        } else {
            System.out.println("list is empty");
        }
    }
}
