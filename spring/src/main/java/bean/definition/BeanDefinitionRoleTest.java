package bean.definition;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;

/**
 * @Description: TODO
 * @Author: GCL
 * @Date: 2021/1/25 21:49
 */
public class BeanDefinitionRoleTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(Config.class);
        applicationContext.refresh();

        //getBeanDefinition()与getBean()区别？
        BeanDefinition foo = applicationContext.getBeanDefinition("foo");
        System.out.println(foo.getRole());

        //怎么通过@Role注入的role 奇怪？
        BeanDefinition fun = applicationContext.getBeanDefinition("fun");
        System.out.println(fun.getRole());

    }

    static class Config {

        @Bean
        public String foo() {
            return "foo";
        }

        @Bean
        @Role(BeanDefinition.ROLE_SUPPORT)
        public String fun() {
            return "fun";
        }
    }
}
