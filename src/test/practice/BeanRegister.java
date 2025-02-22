package test.practice;

import test.entry.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

public class BeanRegister {
   private Map<String, Object> singletonMap = new HashMap<>(32);

   public Object getSingletonBean(String beanName){
       return singletonMap.get(beanName);
   }

   public void registerSingletonBean(String beanName,Object bean){
       if(singletonMap.containsKey(beanName)){
           return;
       }
       singletonMap.put(beanName,bean);
   }
}
