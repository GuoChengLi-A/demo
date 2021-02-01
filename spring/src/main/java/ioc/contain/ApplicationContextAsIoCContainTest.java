package ioc.contain;

import ioc.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: applicationContext作为ioc容器
 * @Author: GCL
 * @Date: 2021/1/19 20:37
 * {@link org.springframework.context.ApplicationContext}
 */
//@Configuration
public class ApplicationContextAsIoCContainTest {
//通过注解注入bean
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ApplicationContextAsIoCContainTest.class);
        //启动应用上下文
        applicationContext.refresh();

        User bean = applicationContext.getBean(User.class);
        System.out.println(bean);

        //关闭上下文
        applicationContext.close();
    }

    @Bean
    public User user() {
        User user = new User();
        user.setAge(12);
        user.setFirstName("guo");
        user.setLastName("chengli");
        return user;
    }
}
