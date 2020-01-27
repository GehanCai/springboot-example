package com.godling.springboot.core.shiro;

import com.godling.springboot.core.shiro.filter.JwtFilter;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cai
 */
@Configuration
public class ShiroConfiguration {

    @Bean
    public ShiroRealm shiroRealm() {
        return new ShiroRealm();
    }

    @Bean
    public DefaultWebSecurityManager securityManager(ShiroRealm shiroRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);

        // 添加jwt过滤器
        Map<String, Filter> filterMap = new HashMap<>();
        //                filterMap.put("jwt", new JwtFilter(jwtProp,syncCacheService,jedisUtils));
        //                filterMap.put("logout", new SystemLogoutFilter(jedisUtils));
        shiroFilter.setFilters(filterMap);
        //
        //        // 动态配置拦截器注入
        //        Map<String, String> filterRuleMap = new HashMap<>(16);
        //        List<Map<String, String>> perms = this.getShiroFilterProperties().getPerms();
        //        perms.forEach(perm -> filterRuleMap.put(perm.get("key"), perm.get("value")));
        //
        //        shiroFilter.setFilterChainDefinitionMap(filterRuleMap);

        return shiroFilter;
    }


    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public static DefaultAdvisorAutoProxyCreator getLifecycleBeanPostProcessor() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        // 强制使用cglib
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }
    //
    //    @Bean
    //    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
    //        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
    //        advisor.setSecurityManager(securityManager);
    //        return advisor;
    //    }
    //


    //
    //    @Bean
    //    public ShiroFilterProperties getShiroFilterProperties(){
    //        return new ShiroFilterProperties();
    //    }
    //
    //    @Bean
    //    public FilterRegistrationBean filterRegistrationBean(){
    //        FilterRegistrationBean bean = new FilterRegistrationBean();
    //        bean.setFilter(new UserContextFilter());
    //                return bean;
    //    }

}
