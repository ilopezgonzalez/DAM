def validar_matricula(matricula:str)-> str:
    """
    Valida la matricula introducida

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
    
print(validar_matricula("1164 hvc"))

def validar_telefono(telefono:int)->int:
    """
    Valida un numero de telefono

    Parametro:
        int: numero de telefono

    Return:
        int: telefono normalizado
    """
    telefono.replace("-","").replace(" ","")

    if len(telefono)!=10:
        raise ValueError("El telefono solo puede tener 10 caracteres")
    if telefono[:2]!="+34":
        telefono=