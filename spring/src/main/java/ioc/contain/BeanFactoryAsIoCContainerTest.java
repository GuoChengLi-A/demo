package ioc.contain;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @Description: beanFactory作为ioc容器
 * @Author: GCL
 * @Date: 2021/1/19 20:27
 * {@link org.springframework.beans.factory.BeanFactory}
 */
public class BeanFactoryAsIoCContainerTest {
//需要配置文件
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(beanFactory);

        String path = "dependency-lookup.xml";
        int beanDefinitionsCount = xmlReader.loadBeanDefinitions(path);
        System.out.println("xml中bean数量：" + beanDefinitionsCount);
    }
}
