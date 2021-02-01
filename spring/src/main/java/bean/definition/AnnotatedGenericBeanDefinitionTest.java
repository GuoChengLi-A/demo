package bean.definition;

import ioc.User;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * @Description: {@link org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition}
 * @Author: GCL
 * @Date: 2021/1/26 09:36
 */
public class AnnotatedGenericBeanDefinitionTest {

    public static void main(String[] args) {
        AnnotatedGenericBeanDefinition annotatedGenericBeanDefinition = new AnnotatedGenericBeanDefinition(User.class);
        System.out.println(annotatedGenericBeanDefinition);

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注入一个User bean
        applicationContext.register(AnnotatedGenericBeanDefinitionTest.class);
        //又注入一个user bean
        applicationContext.registerBeanDefinition("userAnnotatedBeanDefinition", annotatedGenericBeanDefinition);
        applicationContext.refresh();

        Map<String, User> beansOfType = applicationContext.getBeansOfType(User.class);
        beansOfType.entrySet().forEach(System.out::println);

        applicationContext.close();
    }

    @Bean
    public User getUser() {
        User user = new User();
        user.setAge(24);
        user.setFirstName("guo");
        user.setLastName("chengli");
        return user;
    }
}
