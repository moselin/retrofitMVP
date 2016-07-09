package com.moselin.moslmvp.util;

import java.lang.reflect.ParameterizedType;

/**
 * @Description 泛型工具类
 * @Author MoseLin
 * @Date 2016/7/8.
 */
public class TUitl
{
    /**
     * 根据泛型获取对象实例
     * @param o 超类的对象
     * @param i 此泛型参数的位置
     * @param <T> 泛型对象
     * @return 对象实例
     */
    public static <T> T getT(Object o, int i) {
        try {
            return ((Class<T>) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[i])
                    .newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }
}
