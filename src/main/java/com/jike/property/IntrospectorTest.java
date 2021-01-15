package com.jike.property;

import com.jike.entity.Parent;

import java.beans.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.StreamSupport;

/**
 * @Description: TODO
 * @Author: GCL
 * @Date: 2021/1/14 22:09
 */
public class IntrospectorTest {
    //类型转换 JVM是如何知道传入的是什么类型？
    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Parent.class, Object.class);
        PropertyDescriptor[] properties = beanInfo.getPropertyDescriptors();
        Arrays.stream(properties).forEach(data -> {
            Class<?> propertyType = data.getPropertyType();
            String name = data.getName();
            if ("age".equals(name)) {
                data.setPropertyEditorClass(Str2Int.class);
                data.setValue(name, 12);
            }

            System.out.println(name + ":" + data.getValue(name));
        });


    }

    static class Str2Int extends PropertyEditorSupport {
        public void setAsText(String text) throws java.lang.IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }
}
