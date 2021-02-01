package bean;

import ioc.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;

/**
 * @Description: bean别名测试
 * @Author: GCL
 * @Date: 2021/1/23 20:57
 */
public class BeanAliasTest {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        PathResource pathResource = new PathResource("/Users/gcl/Desktop/project/my_java_demo/demo/spring/src/main/resources/dependency-lookup.xml");
        xmlBeanDefinitionReader.loadBeanDefinitions(pathResource);

        User guochengli = beanFactory.getBean("guochengli", User.class);
        User parent = beanFactory.getBean("parent", User.class);
        System.out.println("parent==guochengli:"+guochengli.equals(parent));
    }
}
