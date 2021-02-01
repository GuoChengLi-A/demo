package bean.name.generator;

import ioc.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: {@link org.springframework.beans.factory.support.BeanNameGenerator}
 * @Author: GCL
 * @Date: 2021/1/25 16:12
 */
public class BeanNameGeneratorTest {

    public static void main(String[] args) {
        BeanNameGenerator defaultBeanNameGenerator = new DefaultBeanNameGenerator();

        BeanDefinitionRegistry beanDefinitionRegistry = new DefaultListableBeanFactory();


        //实例化User#0
        BeanDefinition beanDefinition = generateBeanDefinition(User.class);
        beanDefinitionRegistry.registerBeanDefinition("user0", beanDefinition);

        //实例化User#1
        BeanDefinition beanDefinition1 = generateBeanDefinition(User.class);
        beanDefinitionRegistry.registerBeanDefinition("user1", beanDefinition1);

        String s = defaultBeanNameGenerator.generateBeanName(beanDefinition, beanDefinitionRegistry);
        System.out.println(s);



    }


    private static BeanDefinition generateBeanDefinition(Class<?> aClass) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        return beanDefinitionBuilder.getBeanDefinition();
    }
}
