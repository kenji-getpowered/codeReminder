package com.generali.apogee.common;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mikael KROK
 * @param <T>
 */
public class XStreamFactory<T> {

    private static XStream xstream = new XStream(new DomDriver());

    private static XStreamFactory xStreamFactory = new XStreamFactory();

    public synchronized static XStream getIntance() {
        return xstream;
    }

    public synchronized static XStreamFactory getFactoryInstance() {
        return xStreamFactory;
    }

    public boolean toXmlFiles(String filePath, String prefix, T... objects) {
        Map<String, Integer> localObjectCache = new HashMap<String, Integer>(objects.length);

        boolean success = true;
        try {
            if(prefix == null){
                prefix = "";
            }
            if (!filePath.endsWith("/")) {
                prefix = "/" + prefix;
            }

            for (T o : objects) {
                String classSimpleName = o.getClass().getSimpleName();
                int index = 0;
                if (localObjectCache.containsKey(classSimpleName)) {
                    index = localObjectCache.get(classSimpleName);
                } else {
                    localObjectCache.put(classSimpleName, index + 1);
                }
                XStreamFactory.getIntance().toXML(new FileOutputStream(filePath + prefix + classSimpleName + index + ".xml"));
            }
        } catch (FileNotFoundException e) {
            success = false;
        }
        return success;
    }
}
