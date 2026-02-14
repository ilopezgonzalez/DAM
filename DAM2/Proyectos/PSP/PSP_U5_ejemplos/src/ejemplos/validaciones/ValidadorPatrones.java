package ejemplos.validaciones;
import java.util.regex.Pattern;

public class ValidadorPatrones {

    // Patrones
    
    // Inicio String (^), 1 o mas caracteres (+) de A-Z, a-z, 0-9 o símbolos (+_.-), @ obligatoria, 
    // y 1 o mas caracteres (+) de A-Z, a-z, 0-9 o símbolos (.-) hasta el fin ($).
    private static final Pattern EMAIL = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    // Solo dígitos (\\d) con una longitud exacta de 9 ({9}).
    private static final Pattern TELEFONO = Pattern.compile("\\d{9}");

    // Búsqueda en cualquier posición (.*) de minúscula, mayúscula y dígito (lookahead), con longitud de 8 o más (.{8,}).
    private static final Pattern PASSWORD = Pattern.compile("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}");

    // 4 dígitos (\\d{4}), guion (-), 2 dígitos (\\d{2}), guion (-) y otros 2 dígitos (\\d{2}).
    private static final Pattern FECHA = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");

    // Solo dígitos (\\d), longitud de 8 caracteres ({8}) y una letra de A-Z o a-z ([A-Za-z]).
    private static final Pattern DNI = Pattern.compile("\\d{8}[A-Za-z]");
    
    // Solo dígitos (\\d), 1 o mas caracteres (+).
    private static final Pattern SOLO_NUMEROS = Pattern.compile("\\d+");
    
    // Inicio (^), rango provincial 01-52 (0[1-9]|[1-4]\\d|5[0-2]), seguido de 3 dígitos (\\d{3}) y fin de línea ($).
    private static final Pattern CODIGO_POSTAL = Pattern.compile("^(?:0[1-9]|[1-4]\\d|5[0-2])\\d{3}$");
    
    // Inicio con ES (^ES), 2 dígitos de control (\\d{2}), 20 dígitos de cuenta (\\d{20}) y fin de línea ($).
    private static final Pattern IBAN_ES = Pattern.compile("^ES\\d{2}\\d{20}$");

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
