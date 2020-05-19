package com.ilp3.system.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.ilp3.system.shiro.UserRealm;
import net.sf.ehcache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {

    //@Autowired
    //private CacheManager cacheManager;

   // @Value("${server.session-timeout}")
    private static long sessionTimeout = 7200L;

    @Bean
    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

	@Bean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
		proxyCreator.setProxyTargetClass(true);
		return proxyCreator;
	}
    /**
     * ShiroDialect锛屼负浜嗗湪thymeleaf閲屼娇鐢╯hiro鐨勬爣绛剧殑bean
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

	@Bean
    ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		shiroFilterFactoryBean.setLoginUrl("/login");
		shiroFilterFactoryBean.setSuccessUrl("/index");

		shiroFilterFactoryBean.setUnauthorizedUrl("/403");
		LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		filterChainDefinitionMap.put("/css/**", "anon");
		filterChainDefinitionMap.put("/js/**", "anon");
		filterChainDefinitionMap.put("/fonts/**", "anon");
		filterChainDefinitionMap.put("/img/**", "anon");
		filterChainDefinitionMap.put("/docs/**", "anon");
		filterChainDefinitionMap.put("/druid/**", "anon");
		filterChainDefinitionMap.put("/upload/**", "anon");
		filterChainDefinitionMap.put("/files/**", "anon");
		filterChainDefinitionMap.put("/logout", "logout");
		filterChainDefinitionMap.put("/", "anon");
		//filterChainDefinitionMap.put("/**", "authc");
        filterChainDefinitionMap.put("/**", "anon");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}


    @Bean
    public SecurityManager securityManager(EhCacheManager ehCacheManager){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        //璁剧疆realm.
        securityManager.setRealm(userRealm());
        // 鑷畾涔夌紦瀛樺疄鐜� 浣跨敤redis
        securityManager.setCacheManager(ehCacheManager);
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }
    @Bean
    public EhCacheManager ehCacheManager(CacheManager cacheManager) {
        EhCacheManager em = new EhCacheManager();
        em.setCacheManagerConfigFile("classpath:ehcache.xml");
        //灏唀hcacheManager杞崲鎴恠hiro鍖呰鍚庣殑ehcacheManager瀵硅薄
        em.setCacheManager(cacheManager);
        return em;
    }
    /**
     * shiro session鐨勭鐞�
     */
    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(sessionTimeout*1000);
       // logger.error("server sessiontime:"+serverTimeout);
        //璁剧疆sessionDao瀵箂ession鏌ヨ锛屽湪鏌ヨ鍦ㄧ嚎鐢ㄦ埛service涓敤鍒颁簡
        sessionManager.setSessionDAO(sessionDAO());
        //閰嶇疆session鐨勭洃鍚�
        Collection<SessionListener> listeners = new ArrayList<SessionListener>();
        //listeners.add(new BDSessionListener());
        sessionManager.setSessionListeners(listeners);
        //璁剧疆鍦╟ookie涓殑sessionId鍚嶇О
        sessionManager.setSessionIdCookie(simpleCookie());
        sessionManager.setDeleteInvalidSessions(true);// 鍒犻櫎杩囨湡鐨剆ession
        sessionManager.setSessionValidationSchedulerEnabled(true);// 鏄惁瀹氭椂妫�鏌ession
        return sessionManager;
    }

    @Bean
    public SessionDAO sessionDAO(){
        return new MemorySessionDAO();
    }

    @Bean
    public SimpleCookie simpleCookie(){

        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setName("jeesite.session.id");

        return simpleCookie;
    }

	@Bean
    UserRealm userRealm() {
		UserRealm userRealm = new UserRealm();
		return userRealm;
	}

    /**
     *  寮�鍚痵hiro aop娉ㄨВ鏀寔.
     *  浣跨敤浠ｇ悊鏂瑰紡;鎵�浠ラ渶瑕佸紑鍚唬鐮佹敮鎸�;
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

}
