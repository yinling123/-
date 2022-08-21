package com.example.utils;


import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 便于servlet程序进行操作的工具类
 */

public class WebUtil {

    /**
     * 进行bean对象属性注入
     * @param value 传入表单的map对象
     * @param bean 闯入javabean对象
     * @param <T> 表示泛型类型
     * @return 返回对应类型的值
     */

    public static <T> T copyParamToBean(Map value,T bean){
        try {
            BeanUtils.populate(bean,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

}
