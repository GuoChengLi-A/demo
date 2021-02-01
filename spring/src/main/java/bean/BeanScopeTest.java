package bean;

import ioc.User;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/**
 * @Description: singleton or prototype
 * @Author: GCL
 * @Date: 2021/1/26 10:07
 */
public class BeanScopeTest {

    public static void main(String[] args) {

        getBeansOfType("bean-scope.xml");
    }

    private static void getBeansOfType(String resource) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(resource);
        Map<String, UserCollections> beansOfType = applicationContext.getBeansOfType(UserCollections.class);
        for (Map.Entry<String, UserCollections> entry : beansOfType.entrySet()) {
            System.out.println(entry.getValue().getUsers().hashCode());
        }
    }

    private static void getBeanDefinition(String resource) {
        BeanDefinitionRegistry beanFactory = new DefaultListableBeanFactory();

        new XmlBeanDefinitionReader(beanFactory).loadBeanDefinitions(resource);
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
    }

    static class UserCollections {
        Collection<User> users;

        public Collection<User> getUsers() {
            return users;
        }

        public void setUsers(Collection<User> users) {
            this.users = users;
        }
    }
}
