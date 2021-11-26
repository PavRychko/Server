package luxcampus.com.requesthandle.resources;

public enum StatusCodes {
    OK(200, "OK"),
    NOT_FOUND(404, "Not found"),
    INTERNAL_SERVER_ERROR(500, "Internal server error");

    private final int code;
    private final String statusText;

    StatusCodes(int code, String statusText) {
        this.code = code;
        this.statusText = statusText;
    }

    public int getCode() {
        return code;
    }

    public String getStatusText() {
        return statusText;
    }
}
