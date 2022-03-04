package cn.polarismesh.agent.plugin.dubbox.polaris;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.*;

public class PolarisFilterWrapper {
    public static <T> Invoker<T> buildInvokerChain(final Invoker<T> invoker) {
        Filter filter = new PolarisFilter();
        return new Invoker<T>() {

            public Class<T> getInterface() {
                return invoker.getInterface();
            }

            public URL getUrl() {
                return invoker.getUrl();
            }

            public boolean isAvailable() {
                return invoker.isAvailable();
            }

            public Result invoke(Invocation invocation) throws RpcException {
                return filter.invoke(invoker, invocation);
            }

            public void destroy() {
                invoker.destroy();
            }

            @Override
            public String toString() {
                return invoker.toString();
            }
        };
    }
}
