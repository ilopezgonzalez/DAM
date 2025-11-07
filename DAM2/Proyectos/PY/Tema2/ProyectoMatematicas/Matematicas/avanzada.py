def factorial(n):
    """
    Calcula el factorial de un número entero no negativo.
    
    Parámetros:
        n (int): Número entero no negativo.
    
    Retorna:
        int: El factorial de n.
    """
    if n < 0:
        raise ValueError("El factorial no está definido para números negativos.")
    elif n == 0 or n == 1:
        return 1
    else:
        resultado = 1
        for i in range(2, n + 1):
            resultado *= i
        return resultado


def fibonacci(n):
    """
    Calcula el n-ésimo número de la secuencia de Fibonacci.
    
    Parámetros:
        n (int): Posición en la secuencia (n >= 0)
    
    Retorna:
        int: El número de Fibonacci en la posición n.
    """
    if n < 0:
        raise ValueError("El índice no puede ser negativo.")
    elif n == 0:
        return 0
    elif n == 1:
        return 1
    
    a, b = 0, 1
    for _ in range(2, n + 1):
        a, b = b, a + b
    return b

def es_primo(numero):
    """
    Devuelve si un numero es primo o no.

    Parametros:
        numero (int): numero que se quiere analizar

    Retorna:
        String: Si es primo o no
    """
    if numero%2==0:
        return "El numero es primo"
    else:
        return "El numero no es primo"




