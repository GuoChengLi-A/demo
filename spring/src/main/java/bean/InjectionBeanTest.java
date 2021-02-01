package bean;

import ioc.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: bean注入ioc容器测试
 * @Author: GCL
 * @Date: 2021/1/23 21:07
 */
@Import(User.class)
public class InjectionBeanTest {



    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationApplicationContext = new AnnotationConfigApplicationContext();
        //为什么注册之后需要refresh
        //为什么annotationConfigApplicationContext需要refresh()，而ClassPathXmlApplicationContext不需要refresh()
        annotationApplicationContext.register(InjectionBeanTest.class);
        annotationApplicationContext.refresh();

        User li = annotationApplicationContext.getBean(User.class);
        System.out.println(li);


        annotationApplicationContext.close();

    }

    //注解方式
    private void annotation() {

    }

    @Bean
    private User getUser (){
        User user = new User();
        user.setFirstName("莱昂纳多");
        user.setLastName("迪卡普日奥");
        user.setAge(50);
        return user;
    }
}
