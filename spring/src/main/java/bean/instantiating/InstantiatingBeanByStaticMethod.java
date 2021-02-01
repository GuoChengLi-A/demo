package bean.instantiating;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @Description: nested内嵌static类，必须要使用 "$" 分隔么？；静态工厂实例化Bean
 * @Author: GCL
 * @Date: 2021/1/25 19:42
 */
public class InstantiatingBeanByStaticMethod {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-instance.xml");

        NestClass nestClass = applicationContext.getBean("instantiateNestBean", NestClass.class);
        NestClass instantiateNestBeanByConstructor = applicationContext.getBean("instantiateNestBeanByConstructor", NestClass.class);

        System.out.println(nestClass);
        System.out.println(instantiateNestBeanByConstructor);

        //给bean一个id，通过id get
        Object userById = applicationContext.getBean("userFactoryBean？？？？");
        System.out.println("通过FactoryBean实例化的user：" + userById);

        //给一个name，通过name get
        Object userByName = applicationContext.getBean("userFactoryBean");
        System.out.println(userByName);
        System.out.println("userById == userByName:"+userById.equals(userByName));

    }


    static class NestClass {

        private String className;

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public NestClass() {
        }

        public static NestClass getInstance() {
            System.out.println("我正在实例化...");
            return new NestClass();
        }
    }
}
