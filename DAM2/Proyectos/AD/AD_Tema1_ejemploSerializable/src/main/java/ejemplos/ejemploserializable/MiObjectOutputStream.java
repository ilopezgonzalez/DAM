/**
 * 
 * Redefinicion de la clase ObjectOutputStream para que no escriba una cabecera
 * al principio del Stream.
 */
package ejemplos.ejemploserializable;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MiObjectOutputStream extends ObjectOutputStream
{
    /** Constructor que recibe OutputStream
     * @param out
     * @throws java.io.IOException */
    public MiObjectOutputStream(OutputStream out) throws IOException
    {
        super(out);
    }

    /** Constructor sin parametros
     * @throws java.io.IOException */
    protected MiObjectOutputStream() throws IOException, SecurityException
    {
        super();
    }

    /** Redefinicion del metodo de escribir la cabecera para que no haga nada.
     * @throws java.io.IOException */
    @Override
    protected void writeStreamHeader() throws IOException
    {
    }

}
