public class LoginException extends Exception {
    public final String cause;

    LoginException(String msg) {
        this.cause = msg;
    }

}
