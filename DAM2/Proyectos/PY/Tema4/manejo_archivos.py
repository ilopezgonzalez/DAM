def leer_lineas(nombre_archivo):
    """
    Lee un archivo de texto y devuelve sus líneas numeradas
    """
    try:
        with open(nombre_archivo, 'r', encoding='utf-8') as archivo:
            todas_las_lineas = archivo.readlines()
            lista = []
            for i, linea in enumerate(todas_las_lineas, 1):
                lista.append(f"Linea {i}: {linea.strip()}")
            print(lista)
    except FileNotFoundError:
        print("Error: El archivo", nombre_archivo, "no existe")


def escribir_en_archivo(nombre_archivo, contenido):
    """
    Escribe en un archivo el contenido introducido como parametro
    """
    with open(nombre_archivo, "w", encoding="utf-8") as archivo:
            archivo.write(contenido)


def anadir_a_archivo(nombre_archivo, contenido):
     """
     Añade contenido a un archivo que ya existe
     """
     try:
          with open(nombre_archivo, "a", encoding="utf-8") as archivo:
               archivo.write(contenido)
     except FileNotFoundError:
          print(f"Error: El archivo '{nombre_archivo}' no existe")

def contar_palabras(nombre_archivo):
     try:
          with open(nombre_archivo, 'r', encoding='utf-8') as archivo:
               contenido_completo=archivo.read()
                              
    