package com.las.learn.xml;

import java.io.*;
import java.util.*;

import org.dom4j.*;
import org.dom4j.io.*;

public class XMLReader2DOM4J {

    public static void main(String arge[]) {
        try {
            File f = new File("/home/las/Desktop/snapp-i18n/v/values-fr-rFR/strings.xml");
            SAXReader reader = new SAXReader();
            Document doc = reader.read(f);
            Element root = doc.getRootElement();
            Element foo;
            for (Iterator i = root.elementIterator("string"); i.hasNext(); ) {
                foo = (Element) i.next();
                System.out.println(foo.attributeValue("name") + "=" + foo.getStringValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
