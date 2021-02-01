package ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;

import java.util.Collection;

/**
 * @Description: TODO
 * @Author: GCL
 * @Date: 2021/1/17 14:57
 */
public class UserCollections {

    private Collection<User> users;

    private BeanFactory beanFactory;//内建的非 Bean 对象

    private ObjectFactory<User> userObjectFactory;

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public ObjectFactory<User> getUserObjectFactory() {
        return userObjectFactory;
    }

    public void setUserObjectFactory(ObjectFactory<User> userObjectFactory) {
        this.userObjectFactory = userObjectFactory;
    }

    @Override
    public String toString() {
        return "UserCollections{" +
                "users=" + users +
                '}';
    }
}
