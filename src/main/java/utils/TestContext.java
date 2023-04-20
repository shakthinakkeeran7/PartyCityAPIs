package utils;

import java.util.HashMap;
import java.util.Map;

public class TestContext {

    private Map<String, Object> context;

    public TestContext() {
        context = new HashMap<>();
    }

    public void setContext(String key, Object value) {
        context.put(key, value);
    }

    public Object getContext(String key) {
        return context.get(key);
    }

    public boolean isContains(String key) {
        return context.containsKey(key);
    }

    public void clearContext() {
        context.clear();
    }
}
