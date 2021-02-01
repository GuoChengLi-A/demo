package bean.name.generator;

import ioc.User;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @Description: {@link org.springframework.context.annotation.AnnotationBeanNameGenerator}
 * @Author: GCL
 * @Date: 2021/1/25 16:42
 */
public class AnnotationBeanNameGeneratorTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(AnnotationBeanNameGeneratorTest.class);
        annotationConfigApplicationContext.refresh();

        int beanDefinitionCount = annotationConfigApplicationContext.getBeanDefinitionCount();
        System.out.println("bean 定义的数量(包括spring内置bean)：" + beanDefinitionCount);
        AnnotationBeanNameGenerator instance = AnnotationBeanNameGenerator.INSTANCE;
//        instance.generateBeanName()
    }

    @Bean
    private User getUser() {
        User user = new User();
        user.setAge(24);
        user.setFirstName("guo");
        user.setLastName("chengli");
        return user;
    }
}
