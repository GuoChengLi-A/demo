package bean;

import ioc.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.Bean;

/**
 * @Description: TODO
 * @Author: GCL
 * @Date: 2021/1/21 21:12
 */
public class BeanDefinitionBuilderTest {
    public static void main(String[] args) {
//        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        //通过BeanDefinitionBuilder设置属性
//        beanDefinitionBuilder.addPropertyValue("age1", 12);
//        beanDefinitionBuilder.addPropertyValue("lastName", "guochengli");

        //通过AbstractBeanDefinition设置属性
//        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
//        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
//        mutablePropertyValues.add("age", 12);
//        mutablePropertyValues.add("lastName", "guo");
//
//        beanDefinition.setPropertyValues(mutablePropertyValues);
//        Object age = beanDefinition.getPropertyValues().get("age");
//        System.out.println(age);

        fun1();

    }

    private static void fun1() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        //一个bean对应一个BeanDefinition实例？
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("age", 24);
        propertyValues.add("lastName", "guochengli");
        beanDefinition.setPropertyValues(propertyValues);

        beanFactory.registerBeanDefinition("genericBean", beanDefinition);

        User bean = beanFactory.getBean(User.class);
        System.out.println(bean.toString());

        AbstractBeanDefinition genericBean = (AbstractBeanDefinition)beanFactory.getBean("genericBean");
        System.out.println("genericBean?"+genericBean);
    }


}
