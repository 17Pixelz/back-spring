package ma.uca.ensas.ebanking.ebanking.exceptions;

public class SoldeInsuffisant extends RuntimeException {
    public SoldeInsuffisant(String s) {
        super(s);
    }
}
