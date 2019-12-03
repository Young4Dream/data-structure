package com.yan.uf.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/16 10:07
 */
public class UFDSProxy implements InvocationHandler {
    private Object targetObject;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
