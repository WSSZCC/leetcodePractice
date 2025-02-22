package test.practice;

import test.entry.BeanDefinition;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class ResourceLoader {
    public static Map<String, BeanDefinition> getResource() {
        Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>(16);
        Properties properties = new Properties();
        InputStream inputStream = ResourceLoader.class.getResourceAsStream("/beans.properties");
        try {
            properties.load(inputStream);
            Iterator<String> it = properties.stringPropertyNames().iterator();
            while (it.hasNext()) {
                String key = it.next();
                String className = properties.getProperty(key);
                BeanDefinition beanDefinition = new BeanDefinition();
                beanDefinition.setBeanName(key);
                Class clazz = Class.forName(className);
                beanDefinition.setBeanClass(clazz);
                beanDefinitionMap.put(key,beanDefinition);
            }
        } catch (IOException  | ClassNotFoundException e){
            e.printStackTrace();
        }
        return beanDefinitionMap;
    }
}
