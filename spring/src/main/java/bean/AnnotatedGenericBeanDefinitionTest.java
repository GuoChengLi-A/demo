package bean;

import ioc.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.context.annotation.Bean;

/**
 * @Description: {@link org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition}
 * @Author: GCL
 * @Date: 2021/1/22 15:38
 */
public class AnnotatedGenericBeanDefinitionTest {

    public static void main(String[] args) {
        AbstractBeanDefinition annotatedGenericBeanDefinition = new AnnotatedGenericBeanDefinition(User.class);
        String beanClassName = annotatedGenericBeanDefinition.getBeanClassName();
        System.out.println("beanClassName:" + beanClassName);

        String factoryBeanName = annotatedGenericBeanDefinition.getFactoryBeanName();
        System.out.println("annotation beanfactory:" + factoryBeanName);

        MutablePropertyValues propertyValues = annotatedGenericBeanDefinition.getPropertyValues();
        Object lastName = propertyValues.get("lastName");
        System.out.println(lastName);
    }

    @Bean
    private User getUser() {
        User user = new User();
        user.setAge(27);
        user.setLastName("yc");
        return user;
    }

}
