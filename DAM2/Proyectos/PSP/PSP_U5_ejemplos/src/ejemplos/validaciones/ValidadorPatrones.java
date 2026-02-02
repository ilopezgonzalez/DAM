package ejemplos.validaciones;
import java.util.regex.Pattern;

public class ValidadorPatrones {

    // Patrones
    
    // Inicio String (^), 1 o mas carateres (+) que pueden ser cualquiera de la A-Z o a-z o 0-9 y +_.-
    // concatena (con +), @ obligatoria para correos, y concatena 1 o mas carateres (+) que pueden ser 
    // cualquiera de la A-Z o a-z o 0-9 y .-   
    private static final Pattern EMAIL = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    // Solo digitos con una longitud igual a 9
    private static final Pattern TELEFONO = Pattern.compile("\\d{9}");

    // Cualquier caracter (.), 1 o mas (*), de la a-z, de la A-Z y digitos, de longitud 8 o más (8,).
    private static final Pattern PASSWORD = Pattern.compile("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}");

    // 4 digitos, guion (-), 2 digitos, guion (-), 4 digitos
    private static final Pattern FECHA = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");

    // Solo digitos, 8 caracteres. Una letra de A-Z o a-z.
    private static final Pattern DNI = Pattern.compile("\\d{8}[A-Za-z]");

    private static final Pattern SOLO_NUMEROS = Pattern.compile("\\d+");

    // Métodos de validación
    public static boolean validarEmail(String email) {
        return EMAIL.matcher(email).matches();
    }

    public static boolean validarTelefono(String telefono) {
        return TELEFONO.matcher(telefono).matches();
    }

    public static boolean validarPassword(String password) {
        return PASSWORD.matcher(password).matches();
    }

    public static boolean validarFecha(String fecha) {
        return FECHA.matcher(fecha).matches();
    }

    public static boolean validarDni(String dni) {
        return DNI.matcher(dni).matches();
    }

    public static boolean validarSoloNumeros(String texto) {
        return SOLO_NUMEROS.matcher(texto).matches();
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        System.out.println(validarEmail("correo@mail.com"));   // true
        System.out.println(validarTelefono("612345678"));      // true
        System.out.println(validarPassword("Abc12345"));       // true
        System.out.println(validarFecha("2025-01-28"));        // true
        System.out.println(validarDni("12345678Z"));           // true
        System.out.println(validarSoloNumeros("123abc"));      // false
    }
    
}
