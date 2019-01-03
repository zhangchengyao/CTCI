package chapter16_Moderate;

import java.util.List;

public class Q12_XMLEncoding {
    class Element{
        List<Attribute> attributes;
        List<Element> children;
        int getTagCode(){return 1;}
    }
    class Attribute{
        int value;
        int getTagCode(){return 1;}
    }

    String encodeXML(Element root){
        StringBuilder sb = new StringBuilder();
        encode(root, sb);
        return sb.toString();
    }

    private void encode(Element root, StringBuilder sb){
        sb.append(root.getTagCode()).append(" ");
        for(Attribute attribute: root.attributes){
            encode(attribute, sb);
        }

        sb.append(0).append(" ");
        for(Element ele: root.children){
            encode(ele, sb);
        }
        sb.append(0).append(" ");
    }

    private void encode(Attribute attr, StringBuilder sb){
        sb.append(attr.getTagCode()).append(" ").append(attr.value).append(" ");
    }
}
