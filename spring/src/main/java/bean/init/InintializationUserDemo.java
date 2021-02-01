package bean.init;

import ioc.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

/**
 * @Description: TODO
 * @Author: GCL
 * @Date: 2021/1/24 18:39
 */
public class InintializationUserDemo implements InitializingBean {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(InintializationUserDemo.class);
        annotationConfigApplicationContext.refresh();

//        annotationConfigApplicationContext.getBean(User.class);


        annotationConfigApplicationContext.close();
    }

    @PostConstruct
    public void initUserByPostConstruct() {
        System.out.println("postConstruct初始化-order=1");
    }

    @Bean(initMethod = "initUserByInitMethod")
    public InintializationUserDemo initUserByInitMethod() {
        System.out.println("initMethod初始化-order=3");
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("initializingBean初始化-order=2");
    }
}
