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

def mediana(lista):
    """
    Calcula la mediana de una lista de números.
    
    Parámetros:
        lista (list): Lista de números (int o float)
    
    Retorna:
        float: Valor de la mediana.
    """
    if not lista:
        raise ValueError("La lista no puede estar vacía.")
    
    lista_ordenada = sorted(lista)
    n = len(lista_ordenada)
    mitad = n // 2
    
    if n % 2 == 0:
        # Promedio de los dos valores del centro
        return (lista_ordenada[mitad - 1] + lista_ordenada[mitad]) / 2
    else:
        # Valor central
        return lista_ordenada[mitad]

def moda(lista):
    """
    Calcula la moda de una lista de números o elementos.
    
    Parámetros:
        lista (list): Lista de elementos (int, float o incluso strings)
    
    Retorna:
        list: Lista con el/los valores más frecuentes.
    """
    if not lista:
        raise ValueError("La lista no puede estar vacía.")
    
    frecuencias = {}
    for elemento in lista:
        frecuencias[elemento] = frecuencias.get(elemento, 0) + 1
    
    max_frecuencia = max(frecuencias.values())
    
    # Puede haber más de una moda
    modas = [k for k, v in frecuencias.items() if v == max_frecuencia]
    return modas
