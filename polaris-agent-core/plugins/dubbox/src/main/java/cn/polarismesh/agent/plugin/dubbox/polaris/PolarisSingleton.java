package cn.polarismesh.agent.plugin.dubbox.polaris;

import cn.polarismesh.common.polaris.PolarisOperator;

public class PolarisSingleton {

    private static final PolarisOperator polarisOperation = new PolarisOperator();

    public static PolarisOperator getPolarisOperation() {
        return polarisOperation;
    }
}
