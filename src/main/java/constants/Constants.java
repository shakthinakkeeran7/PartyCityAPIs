package constants;

public class Constants {
    
    // API endpoints
    public static final String BASE_URL = "https://api.example.com";
    public static final String GET_USERS_ENDPOINT = "/users";
    public static final String CREATE_USER_ENDPOINT = "/users/create";
    public static final String DELETE_USER_ENDPOINT = "/users/delete";
    
    // Request headers
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String CONTENT_TYPE_HEADER = "Content-Type";
    public static final String JSON_CONTENT_TYPE = "application/json";
    
    // Request payload data
    public static final String USERNAME = "JohnDoe";
    public static final String PASSWORD = "password123";
    public static final String EMAIL = "johndoe@example.com";
    
    // Response messages
    public static final String SUCCESSFUL_CREATION_MESSAGE = "User created successfully.";
    public static final String SUCCESSFUL_DELETION_MESSAGE = "User deleted successfully.";
}
