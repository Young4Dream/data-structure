package com.yan.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.function.Supplier;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/16 10:07
 */
public class StopWatchProxy<T> implements InvocationHandler, Supplier<T> {
    private T t;

    public StopWatchProxy(T t) {
        this.t = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        StopWatch stopWatch = new StopWatch(t.getClass().getSimpleName());
        stopWatch.start(method.getName());
        Object invoke = method.invoke(t, args);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        return invoke;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get() {
        return (T) Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), this);
    }
}
