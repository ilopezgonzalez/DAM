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
    


def validar_telefono(telefono:str)->str:
    """
    Valida un numero de telefono

    Parametro:
        int: numero de telefono

    Return:
        int: telefono normalizado
    """
    telefono=telefono.replace("-","").replace(" ","")

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
    import random
    import string
    numero=""
    letras=""
    for i in range(4):
        numero+=str(random.randint(0,9))
    for i in range(2):
        letras+=str(random.choice(string.ascii_uppercase))
    id="REP"+numero+letras
    return id
    

print(generar_id_unico())
