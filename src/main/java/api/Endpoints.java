package api;
public class Endpoints {
    public static final String BASE_URL = "http://localhost:8081";

    // Example endpoints for a JSON server
    public static final String GET_USERS = BASE_URL + "/users";
    public static final String CREATE_USER = BASE_URL + "/users";
    public static final String GET_USER_BY_ID = BASE_URL + "/users/{id}";
    public static final String UPDATE_USER = BASE_URL + "/users/{id}";
    public static final String DELETE_USER = BASE_URL + "/users/{id}";
}
