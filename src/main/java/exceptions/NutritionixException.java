package exceptions;

/**
 * Custom runtime exception for the Nutritionix framework.
 */
public class NutritionixException extends RuntimeException {

    public NutritionixException(String message) {
        super(message);
    }

    public NutritionixException(String message, Throwable cause) {
        super(message, cause);
    }
}
