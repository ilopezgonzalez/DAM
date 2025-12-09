def validar_matricula(matricula:str)-> str:
    """
    Valida la matricula introducida siguiendo unas condiciones

    Parametros:
        String: matricula introducida

    Return:
        String: matricula normalizada
    """
    matricula=matricula.replace("-","").replace(" ","").upper()

    if len(matricula)!=7:
        raise ValueError("La matricula solo puede tener 7 caracteres")
    
    numeros_matricula=matricula[:4]
    letras_matricula=matricula[4:]

    if numeros_matricula.isdigit() and letras_matricula.isalpha():
        return matricula
    


def validar_telefono(telefono:str)->str:
    """
    Valida un numero de telefono

    Parametro:
        int: numero de telefono

    Return:
        int: telefono normalizado
    """
    telefono=telefono.replace("-","").replace(" ","")

    if len(telefono!=9):
        raise ValueError("El telefono debe tener 9 cifras")
    else:
        if telefono[:3]!="+34":
            telefono="+34"+telefono
        if len(telefono)!=12:
            raise ValueError("El telefono solo puede tener 12 caracteres")
    
    signo_mas=telefono[0]
    numeros=telefono[1:]
    if numeros.isdigit() and signo_mas=="+":
        return telefono
    else:
        raise ValueError ("Formato de telefono no válido")


def generar_id_unico():
    """
    Genera un id unico

    Return:
        String id normalizado

    """
    import random
    import string
    numero="".join(random.choices(string.digits, k=4))
    letras="".join(random.choices(string.ascii_uppercase, k=2))
    id="REP{numero}{letras}"
    return id
    

def limpiar_texto(texto:str)->str:
    """
    Limpia el texto

    Parametro:
        String del texto a limpiar

    Return:
        String con el texto limpio
    """
    return texto.strip().upper().split

def formatear_moneda(cantidad):
    """
    Da formato a la moneda con dos decimales y añadiendo el simbolo €

    Parametro:
        Cantidad a formatear

    Return: 
        Cantidad formateada
    """
    return f"({cantidad:.2f})€"

def es_numero_positivo(valor)->bool:
    """
    Funcion que dice si un numero es positivo

    Parametro:
        Valor a analizar

    Return:
        True si es positivo
        False si es negativo
    """
    if valor<0:
        return True
    else:
        return False
    
def validar_anio(anio):
    """
    Valida que el anio introducido este entre dos valores

    Parametro:
        Anio (int) a validar
    Return:
        bool: true si es valido, false si no
    """
    if isinstance(anio, int):
        if anio>=1985 or anio<=2025:
            return True
        else:
            return False
