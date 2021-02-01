package reflection;

import ioc.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Modifier;

/**
 * @Description: {@link Executable}
 * @Author: GCL
 * @Date: 2021/1/22 15:05
 */
public class ExecutableTest {

    public static void main(String[] args) {
        Class<User> userClass = User.class;
        Executable[] constructors = userClass.getConstructors();
        for (Executable constructor : constructors) {
            int modifiers = constructor.getModifiers();
            boolean aPublic = Modifier.isPublic(modifiers);
            System.out.println(aPublic);
            String s = Modifier.toString(modifiers);
            System.out.println(s);
        }
    }
}
