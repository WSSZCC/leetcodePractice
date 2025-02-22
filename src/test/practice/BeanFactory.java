package test.practice;

import test.entry.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

public class BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();
    private BeanRegister beanRegister;

    public BeanFactory(){
        beanRegister = new BeanRegister();
        this.beanDefinitionMap = new ResourceLoader().getResource();
    }

    public Object getBean(String beanName){
        Object bean = beanRegister.getSingletonBean(beanName);
        if(bean!=null){
            return bean;
        }
        return createBean(beanDefinitionMap.get(beanName));
    }

    private Object createBean(BeanDefinition beanDefinition) {
        try {
            Object bean = beanDefinition.getBeanClass().newInstance();
            beanRegister.registerSingletonBean(beanDefinition.getBeanName(),bean);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
