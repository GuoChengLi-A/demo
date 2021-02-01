package bean.di;

import ioc.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.nio.ch.sctp.Shutdown;

/**
 * @Description: 循环依赖实例化 throw new BeanCurrentlyInCreationException()
 * @Author: GCL
 * @Date: 2021/1/26 11:01
 */
public class CircularReferenceTest {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("circular-reference.xml");
//        circularReference(applicationContext);

        CircularReferenceTest test = applicationContext.getBean("innerClass", CircularReferenceTest.class);
        User user = test.getUser();
        System.out.println(user);
    }

    //测试循环引用Bean
    private static void circularReference(ApplicationContext applicationContext) {

        SpecialBird specialBird = applicationContext.getBean(SpecialBird.class);
        System.out.println(specialBird);
        Crocodile crocodile = applicationContext.getBean(Crocodile.class);
        System.out.println(crocodile);
    }

    static class SpecialBird {
        private Crocodile crocodile;

        public SpecialBird(Crocodile crocodile) {
            this.crocodile = crocodile;
        }

        public Crocodile getCrocodile() {
            return crocodile;
        }

        public void setCrocodile(Crocodile crocodile) {
            this.crocodile = crocodile;
        }
    }

    static class Crocodile {
        private SpecialBird specialBird;

        public Crocodile(SpecialBird specialBird) {
            this.specialBird = specialBird;
        }

        public SpecialBird getSpecialBird() {
            return specialBird;
        }

        public void setSpecialBird(SpecialBird specialBird) {
            this.specialBird = specialBird;
        }
    }


}
