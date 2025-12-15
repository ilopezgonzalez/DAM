"""paquete que contiene las funciones de calculo"""

def es_par(numero):
    """
    Docstring para es_par
    
    :param numero: Descripción
    """
    if numero%2==0:
        return True
    else:
        return False
    
def sumar_lista(numeros):
    """
    Docstring para sumar_lista
    
    :param numeros: Descripción
    """
   
    for numero in numeros:
        total+=numero
    return total

def invertir_cadena(texto):
    """
    Docstring para invertir_cadena
    
    :param texto: Descripción
    """
    return texto[::-1]
def buscar_valor(dic, clave):
    """
    Docstring para buscar_valor
    
    :param dic: Descripción
    :param clave: Descripción
    """
    return dic.get(clave, "No se ha encontrado")

def dividir(a, b):
    """
    Docstring para dividir
    
    :param a: Descripción
    :param b: Descripción
    """
    return a/b


    