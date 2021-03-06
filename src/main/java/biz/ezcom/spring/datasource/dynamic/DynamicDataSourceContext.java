package biz.ezcom.spring.datasource.dynamic;


public final class DynamicDataSourceContext {
    private static final DynamicDataSourceContext context = new DynamicDataSourceContext();

    public static DynamicDataSourceContext getInstance() {
        return context;
    }

    private ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    private DynamicDataSourceContext() {}

    public void setDataSourceKey(String dataSourceKey) {
        threadLocal.set(dataSourceKey);
    }

    public String getDataSourceKey() {
        return threadLocal.get();
    }
}
