package quantitymeasurementtdd;

public class QuantityMeasurementException extends RuntimeException {

    public enum ExceptionType {
        NULL_VALUE
    }

    ExceptionType type;

    public QuantityMeasurementException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
