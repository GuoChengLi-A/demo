package bean;

import ioc.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: GCL
 * @Date: 2021/1/23 20:36
 */
public class BeanFactoryTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {



        classPathRefreshTest();
    }

    private static void classPathRefreshTest() {
        AbstractApplicationContext
                applicationContext = new ClassPathXmlApplicationContext("dependency-lookup.xml");
        Map<String, User> beansOfType = applicationContext.getBeansOfType(User.class);
        beansOfType.entrySet().stream().map(Map.Entry::getValue).forEach(System.out::println);
    }

    private static void xmlBeanDefinitionReaderTest (){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions("dependency-lookup.xml");

        User user = beanFactory.getBean(User.class);
        Class<? extends DefaultListableBeanFactory> aClass = beanFactory.getClass();

    }
}
