package ioc.factory.bean;

import ioc.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Description: TODO
 * @Author: GCL
 * @Date: 2021/1/24 16:53
 */
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return User.getObject();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
