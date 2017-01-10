public class GameException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 9182446934821478975L;
	private final String message;

    public GameException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}