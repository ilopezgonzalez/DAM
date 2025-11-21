# tareas/utilidades/validaciones.py

def es_indice_valido(valor, lista):
    """
    Verifica si un valor es un índice válido dentro de la lista de tareas.
    
    Parámetros:
        valor (int): El índice a validar.
        lista (list): La lista de tareas.
    
    Retorna:
        bool: True si es válido, False si no.
    """
    return isinstance(valor, int) and 0 <= valor < len(lista)


def es_texto_valido(texto):
    """
    Verifica si un texto es válido para usar como descripción de tarea.
    
    Parámetros:
        texto (str): La descripción a validar.
    
    Retorna:
        bool: True si el texto no está vacío y no es solo espacios, False si no.
    """
    return isinstance(texto, str) and texto.strip() != ""
