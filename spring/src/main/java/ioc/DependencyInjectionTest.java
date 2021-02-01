package ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Collection;


/**
 * @Description: 依赖注入测试
 * @Author: GCL
 * @Date: 2021/1/17 15:42
 */
public class DependencyInjectionTest {

    public static void main(String[] args) {
        ApplicationContext beanFactory = new ClassPathXmlApplicationContext("dependency-injection.xml");
        UserCollections users = beanFactory.getBean("userCollections", UserCollections.class);

        BeanFactory autowireBeanFactory = beanFactory.getAutowireCapableBeanFactory();
        System.out.println("(容器内建Bean对象)applicationContext中的BeanFactory：" + autowireBeanFactory);
        System.out.println("依赖注入的BeanFactory与当前BeanFactory是否为统一对象：" + users.getBeanFactory().equals(beanFactory));
        System.out.println("依赖注入的BeanFactory:" + users.getBeanFactory().toString());
        System.out.println("容器BeanFactory：" + beanFactory);

        //既然容器中有BeanFactory，那么通过依赖查找BeanFactory对象
//        System.out.println(beanFactory.getBean(BeanFactory.class));

        //容器内建Bean
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println("一个内建Bean对象示例：" + environment);

        ObjectProvider<UserCollections> beanProvider = beanFactory.getBeanProvider(UserCollections.class);
        UserCollections userCollections = beanProvider.getIfAvailable();

    }
}
