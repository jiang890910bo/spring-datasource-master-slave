package biz.ezcom.spring.datasource.dynamic;

import java.util.List;

public class DynamicDataSourceAspect {
    private List<String> slaves;
    private int          slaveIndex;
    private String       master;

    public DynamicDataSourceAspect() {
        this.slaveIndex = 0;
    }

    public List<String> getSlaves() {
        return this.slaves;
    }

    public void setSlaves(List<String> slaves) {
        this.slaves = slaves;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    /**
     * 数据源切换到slave
     */
    public void changeDataSourceSlave() {
        if (this.slaveIndex >= slaves.size()) {
            this.slaveIndex = 0;
        }
        DynamicDataSourceContext.getInstance().setDataSourceKey(slaves.get(this.slaveIndex));
        this.slaveIndex++;
    }

    /**
     * 数据源切换到master
     */
    public void changeDataSourceMaster() {
        DynamicDataSourceContext.getInstance().setDataSourceKey(this.master);
    }
}
