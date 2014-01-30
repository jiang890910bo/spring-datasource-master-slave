package biz.ezcom.spring.datasource.dynamic;

import java.util.List;

public class DynamicDataSourceAspect {
    private List<String> slaveKeys;
    private int          slaveKeyIndex;

    public DynamicDataSourceAspect() {
        this.slaveKeyIndex = 0;
    }

    public List<String> getSlaveKeys() {
        return slaveKeys;
    }

    public void setSlaveKeys(List<String> slaveKeys) {
        this.slaveKeys = slaveKeys;
    }

    /**
     * 数据源切换
     */
    public synchronized void changeDataSourceSlave() {
        DynamicDataSourceContext.getInstance().setDataSourceKey(this.slaveKeys.get(this.slaveKeyIndex));
        this.slaveKeyIndex = (this.slaveKeyIndex+1) % slaveKeys.size();
    }
}
