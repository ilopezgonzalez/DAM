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