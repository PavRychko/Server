package luxcampus.com.requesthandle.resources;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.StringJoiner;

public class ResourceReader {
    String webAppPath;

    public ResourceReader(String webAppPath) {
        this.webAppPath = webAppPath;
    }

    public String readResource(String uri) throws IOException {
        File file = new File(webAppPath + "/" + uri);
        StringJoiner stringJoiner = new StringJoiner("\n");
        String line;
        if (Files.isDirectory(Path.of(webAppPath))&& file.exists()) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(webAppPath + "/" + uri)))) {
                while ((line = bufferedReader.readLine()) != null) {
                    stringJoiner.add(line);
                }
                return stringJoiner.toString();

            }

        }
            return null;
    }

}
