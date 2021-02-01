package bean.instantiating;

import ioc.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;

/**
 * @Description: TODO
 * @Author: GCL
 * @Date: 2021/1/25 20:05
 */
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        System.out.println("我是被UserFactoryBean实例化的");
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
