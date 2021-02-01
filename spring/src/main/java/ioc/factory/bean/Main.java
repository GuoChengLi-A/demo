package ioc.factory.bean;

import ioc.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @Description: TODO
 * @Author: GCL
 * @Date: 2021/1/24 16:30
 */
public class Main {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        new XmlBeanDefinitionReader(beanFactory).loadBeanDefinitions("factory-bean.xml");

        instantiateUserByStaticMethod(beanFactory);

        instantiateUserByFactory(beanFactory);

        instantiateUserByFactoryBean(beanFactory);
    }

    private static void instantiateUserByStaticMethod(BeanFactory beanFactory) {
        User guochengli = beanFactory.getBean("initUserByStaticMethod", User.class);
        System.out.println("静态方法实现：" + guochengli);
    }

    private static void instantiateUserByFactory(BeanFactory beanFactory) {
        User user = beanFactory.getBean("initUserByFactory", User.class);
        System.out.println("工厂实现：" + user);
    }

    private static void instantiateUserByFactoryBean(BeanFactory beanFactory) {
        User user = beanFactory.getBean("userFactoryBean", User.class);
        System.out.println("FactoryBean实现：" + user);
    }
}
