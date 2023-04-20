package api;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public class RequestBuilder {

    private String url;
    private String method;
    private Map<String, String> headers;
    private Object payload;

    public RequestBuilder() {
        headers = new HashMap<String, String>();
    }

    public RequestBuilder withUrl(String url) {
        this.url = url;
        return this;
    }

    public RequestBuilder withMethod(String method) {
        this.method = method;
        return this;
    }

    public RequestBuilder withHeader(String name, String value) {
        headers.put(name, value);
        return this;
    }

    public RequestBuilder withPayload(Object payload) {
        this.payload = payload;
        return this;
    }

    public Request build() throws Exception {
        if (url == null) {
            throw new Exception("Url is missing!");
        }

        if (method == null) {
            throw new Exception("Http Method is missing!");
        }

        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");

        RequestBody body = null;
        if (payload != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonPayload = objectMapper.writeValueAsString(payload);
            body = RequestBody.create(mediaType, jsonPayload);
        }

        Request.Builder requestBuilder = new Request.Builder()
                .url(url)
                .method(method, body);

        for (Map.Entry<String, String> header : headers.entrySet()) {
            requestBuilder.header(header.getKey(), header.getValue());
        }

        return requestBuilder.build();
    }

}
