package com.godling.springboot.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * Spring 工具类
 *
 * @author cai
 */
@Component
public class SpringUtils implements BeanFactoryPostProcessor {

    /**
     * Spring应用上下文环境
     */
    private static ConfigurableListableBeanFactory beanFactory;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        SpringUtils.beanFactory = beanFactory;
    }

    /**
     * 获取对象(通过对象名称)
     *
     * @param name 对象名称
     * @return Object 一个以所给名字注册的bean的实例
     * @throws BeansException 实例异常
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) throws BeansException {
        return (T) beanFactory.getBean(name);
    }

    /**
     * 获取类型为requiredType的对象
     *
     * @param clazz 类类型
     * @return `Object` 一个以所给名字注册的`Bean`的实例
     * @throws BeansException 异常
     */
    public static <T> T getBean(Class<T> clazz) throws BeansException {
        return beanFactory.getBean(clazz);
    }

}
