package config;

import java.util.HashMap;
import java.util.Map;

public class EnvironmentManager {
    private static final String ENV_VAR = "QA";
    private static Map<String, String> environments = new HashMap<>();

    public static void addEnvironment(String envName, String baseUrl) {
        environments.put(envName, baseUrl);
    }

    public static String getBaseUrl() {
        String envName = System.getenv(ENV_VAR);
        if (envName == null) {
            envName = "default";
        }
        return environments.getOrDefault(envName, "");
    }
}
