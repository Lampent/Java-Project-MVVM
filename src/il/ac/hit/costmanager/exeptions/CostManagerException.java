package il.ac.hit.costmanager.exeptions;

/**
 * The only "exception" of the application
 * The exception that should be thrown by the applications implemented methods
 */
public class CostManagerException extends Exception {

    /**
     * Constructor of the exception
     * @param message the method that will be passed on the thrown exaction
     */
    public CostManagerException(String message) {
        super(message);
    }

    /**
     * Constructor of the exception
     * @param message the method that will be passed on the thrown exaction
     * @param cause the cause of the exception
     */
    public CostManagerException(String message, Throwable cause) {
        super(message, cause);
    }
}

