package bean.instantiating;

import ioc.User;
import ioc.factory.bean.UserFactory;

/**
 * @Description: 实例工厂实例化Bean
 * @Author: GCL
 * @Date: 2021/1/24 16:45
 */
public class DefaultUserFactory implements UserFactory {
    @Override
    public User getUser() {
        System.out.println("工厂实例化User：");
        return User.getObject();
    }
}
