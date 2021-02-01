package ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.support.AbstractRefreshableConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @Description: 依赖查找test
 * @Author: GCL
 * @Date: 2021/1/17 09:54
 */
public class DependencyLookupTest {

    public static void main(String[] args) {
//        BeanFactory beanFactory = new ClassPathXmlApplicationContext("dependency-lookup.xml");
//        System.out.println(beanFactory);
        AbstractRefreshableConfigApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"dependency-lookup.xml"});
        applicationContext.setConfigLocation("dependency-injection.xml");
        applicationContext.refresh();//ClassPathXmlApplicationContext构造器中的refresh并不影响是否可 call refresh

        Object userCollections = applicationContext.getBean("userCollections");
        System.out.println(userCollections);
        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();
        System.out.println(beanFactory.getBean("userCollections"));
        //        System.out.println("applicationContext注入的BeanFactory：" +);

        lookupBeanById(beanFactory);//通过id实时查找bean
        lazyLookupBeanById(beanFactory);//如何体现延迟查找？作用是是什么？

        lookupBeanByType(beanFactory);//通过类型查找bean

        lookupCollectionBeanByType(beanFactory);

        lookupByAnnotation(beanFactory);

    }

    private static void lookupByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
//            Map<String, Parent> parents = listableBeanFactory.getBeansWithAnnotation(Parent.class);
        }
    }

    private static void lookupCollectionBeanByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> parents = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("集合查找：" + parents);
        }
    }

    private static void lookupBeanByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println(user);
    }

    private static void lazyLookupBeanById(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println(user);
    }

    private static void lookupBeanById(BeanFactory beanFactory) {
        User user = beanFactory.getBean("guochengli", User.class);
        System.out.println(user);
    }
}
