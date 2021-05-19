package ma.uca.ensas.ebanking.ebanking.exceptions;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(String s) {
        super(s);
    }
}
