package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * General test utility methods.
 */
public final class TestUtils {

    private TestUtils() {
        // Prevent instantiation
    }

    /**
     * Returns the current timestamp in 'yyyyMMdd_HHmmss' format.
     */
    public static String getTimestamp() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
    }

    /**
     * Generates a random UUID string.
     */
    public static String generateRandomUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * Reads a JSON file from the classpath and maps it to the specified class.
     *
     * @param resourcePath path under src/main/resources (e.g., "testdata/user_credentials.json")
     * @param clazz target class type
     * @param <T> type parameter
     * @return mapped object
     */
    public static <T> T readJson(String resourcePath, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream is = TestUtils.class.getClassLoader().getResourceAsStream(resourcePath)) {
            if (is == null) {
                throw new RuntimeException("Resource not found: " + resourcePath);
            }
            return mapper.readValue(is, clazz);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON resource: " + resourcePath, e);
        }
    }
}
