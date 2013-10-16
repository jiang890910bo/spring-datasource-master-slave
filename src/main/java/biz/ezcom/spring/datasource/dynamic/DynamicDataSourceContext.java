package biz.ezcom.spring.datasource.dynamic;

public class DynamicDataSourceContext {
    
    private static final DynamicDataSourceContext context = new DynamicDataSourceContext();
    
    private ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    private DynamicDataSourceContext() {
    }

    public static DynamicDataSourceContext getInstance() {
        return context;
    }

    public void setDataSourceKey(String dataSourceKey) {
        threadLocal.set(dataSourceKey);
    }

    public String getDataSourceKey() {
        return threadLocal.get();
    }
}
