package ioc.factory.bean;

import ioc.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Description: {@link org.springframework.beans.factory.FactoryBean}
 * @Author: GCL
 * @Date: 2021/1/19 10:18
 */
public interface UserFactory {

    User getUser();
}
