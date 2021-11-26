import luxcampus.com.requesthandle.resources.HttpMethod;
import luxcampus.com.requesthandle.resources.Request;
import luxcampus.com.requesthandle.resources.RequestParser;
import luxcampus.com.requesthandle.resources.ResourceReader;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

public class RequestHandleTests {
    RequestParser requestParser = new RequestParser();


    @BeforeAll
    private static void createRequestFile() throws IOException {
        Files.createFile(Path.of("request.txt"));
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of("request.txt"), StandardOpenOption.WRITE)) {
            bufferedWriter.write("GET /wiki/HTTP HTTP/1.1\n" +
                    "Host: uk.wikipedia.org\n" +
                    "User-Agent: firefox/5.0 (Linux; Debian 5.0.8; en-US; rv:1.8.1.7) Gecko/20070914 Firefox/2.0.0.7\n" +
                    "Connection: close");

        }
    }


    @Test
    public void requestParserParseMethodReturnsCorrectRequestObject() throws IOException {
        Request expected = createExpectedRequest();
        Request actual = requestParser.parse(Files.newBufferedReader(Path.of("request.txt")));
        assertEquals(expected.getUri(), actual.getUri());
        assertEquals(expected.getMethod(), actual.getMethod());
        Map<String, String> expectedHeaders = expected.getHeaders();
        Map<String, String> actualHeaders = actual.getHeaders();
        assertEquals(expectedHeaders.get("Host:"), actualHeaders.get("Host:"));
        assertEquals(expectedHeaders.get("User-Agent:"), actualHeaders.get("User-Agent:"));
        assertEquals(expectedHeaders.get("Connection:"), actualHeaders.get("Connection:"));
    }

    @Test
    public void resourceReaderReturnsCorrectResponse() {
        ResourceReader resourceReader = new ResourceReader();
        resourceReader.setWebAppPath("src/main/resources/webApp");
        String correctUri = "index.html";
        String notCorrectUri = "index2.html";
        assertEquals("src/main/resources/webApp" + correctUri, resourceReader.readResource(correctUri));
//        assertEquals();

    }


    @AfterAll
    private static void deleteRequestFile() throws IOException {
        Files.delete(Path.of("request.txt"));
    }


    private Request createExpectedRequest() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Host:", "uk.wikipedia.org");
        headers.put("User-Agent:", "firefox/5.0 (Linux; Debian 5.0.8; en-US; rv:1.8.1.7) Gecko/20070914 Firefox/2.0.0.7");
        headers.put("Connection:", "close");
        return new Request("/wiki/HTTP", headers, HttpMethod.GET);
    }
}
