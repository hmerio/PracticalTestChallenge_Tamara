public class PriceException extends Exception{
    /**
     * in this class we hve the Exception we have if user has not enough money
     * @param message - what we see in Exception
     */
    public PriceException(String message) {
        super(message);
    }

}
