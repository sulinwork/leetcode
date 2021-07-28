package code;

import cn.hutool.core.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class IPUtil {

    public static void main(String[] args) {
        Document document = XmlUtil.readXML(IPUtil.class.getClassLoader().getResourceAsStream(""));
        NodeList entities = document.getElementsByTagName("entity");
        for (int i = 0; i < entities.getLength(); i++) {
            entities.item(i).getAttributes().getNamedItem("class").getNodeValue();


            Element entity = (Element) entities.item(i);
            String className = entity.getAttribute("class");
            NodeList fields = entity.getElementsByTagName("field");
            for (int j = 0; j < fields.getLength(); j++) {
                Element field = (Element) fields.item(j);
                String fieldName=field.getAttribute("value");
                NodeList labels = field.getElementsByTagName("label");
                for (int k = 0; k < labels.getLength(); k++) {
                    //自己来吧
                }
            }
        }
//        IPUtil ipInt = new IPUtil();
//        System.out.println(ipInt.ipToInt("128.255.10.1"));
//        System.out.println(ipInt.intToIp(ipInt.ipToInt("192.168.10.1")));
    }


    public static int ipToInt(String ipStr) {
        String[] ip = ipStr.split("\\.");
        return (Integer.parseInt(ip[0]) << 24) + (Integer.parseInt(ip[1]) << 16) + (Integer.parseInt(ip[2]) << 8) + Integer.parseInt(ip[3]);
    }

    public static String intToIp(int intIp) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.valueOf(intIp >>> 24) + ".");
        builder.append(String.valueOf((intIp & 0x00FFFFFF) >>> 16) + ".");
        builder.append(String.valueOf((intIp & 0x0000FFFF) >>> 8) + ".");
        builder.append(String.valueOf((intIp & 0x000000FF)));
        return builder.toString();
    }

}