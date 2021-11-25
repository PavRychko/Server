package luxcampus.com.requesthandle.resources;

import java.util.Map;

public class Request {
    String uri;
    Map<String, String> headers;
    HttpMethod method;

    public Request() {
    }

    public Request(String uri, Map<String, String> headers, HttpMethod method) {
        this.uri = uri;
        this.headers = headers;
        this.method = method;
    }

    public String getUri() {
        return uri;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }
}



