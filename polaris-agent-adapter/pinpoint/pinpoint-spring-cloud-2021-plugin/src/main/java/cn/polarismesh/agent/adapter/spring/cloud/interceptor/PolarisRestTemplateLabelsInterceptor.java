package cn.polarismesh.agent.adapter.spring.cloud.interceptor;

import cn.polarismesh.agent.core.spring.cloud.AroundPolarisInterceptor;
import cn.polarismesh.agent.core.spring.cloud.context.factory.PolarisAgentPropertiesFactory;
import com.navercorp.pinpoint.bootstrap.interceptor.AroundInterceptor;

/**
 * Polaris feign 服务调用拦截器
 *
 * @author zhuyuhan
 */
public class PolarisRestTemplateLabelsInterceptor implements AroundInterceptor {

    private final AroundPolarisInterceptor polarisInterceptor = InterceptorFactory.getInterceptor(this.getClass());

    @Override
    public void before(Object target, Object[] args) {
        // do get labels
        polarisInterceptor.beforeInterceptor(target, args, PolarisAgentPropertiesFactory.getPolarisAgentProperties());
    }

    @Override
    public void after(Object target, Object[] args, Object result, Throwable throwable) {
    }
}

