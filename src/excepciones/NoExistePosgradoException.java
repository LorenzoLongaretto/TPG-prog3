package excepciones;

public class NoExistePosgradoException extends Exception{

    private String posgrado;

    public NoExistePosgradoException(String msj,String posgrado) {
        super(msj);
        this.posgrado=posgrado;
    }
    public String getPosgrado() {
        return posgrado;
    }
}
