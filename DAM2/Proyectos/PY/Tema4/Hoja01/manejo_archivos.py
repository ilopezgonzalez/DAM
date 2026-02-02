def leer_lineas(nombre_archivo):
    """
    Lee un archivo de texto y devuelve sus líneas numeradas
    """
    try:
        with open(nombre_archivo, 'r', encoding='utf-8') as archivo:
            #Opcion leyendo todas las lineas de golpe, pero no es recomendable
            #por tamaño de buffer
            #todas_las_lineas = archivo.readlines()
            #lista = []
            #for i, linea in enumerate(todas_las_lineas, 1):
            #    lista.append(f"Linea {i}: {linea.strip()}")
            #print(lista)
            todas_las_lineas = []
            numero_linea = 1  
            for linea in archivo:
                todas_las_lineas.append(f"Línea {numero_linea}: {linea.strip()}")
                numero_linea += 1  
            
            # Imprime todas las líneas
            for linea in todas_las_lineas:
                print(linea)
    except FileNotFoundError:
        print("Error: El archivo", nombre_archivo, "no existe")
    except PermissionError:
         print(f"No tienes permisos para leer {nombre_archivo}")
    except IOError:
         print(f"No se ha podido acceder a {nombre_archivo}")


def escribir_en_archivo(nombre_archivo, contenido):
    """
    Escribe en un archivo el contenido introducido como parametro
    """
    try:
        with open(nombre_archivo, "w", encoding="utf-8") as archivo:
            archivo.write(contenido)
    except FileNotFoundError:
            print("Error: El archivo", nombre_archivo, "no existe")


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
    """
    Cuenta palabras, líneas y letras de un archivo
    """
    try:
        with open(nombre_archivo, 'r', encoding='utf-8') as archivo:
            contenido_completo = archivo.readlines()
            total_lineas = 0
            total_palabras = 0
            total_letras = 0

            for linea in contenido_completo:
                total_lineas += 1
                palabras = linea.split()
                total_palabras += len(palabras)
                total_letras += sum(len(palabra) for palabra in palabras)

            print(f"Líneas: {total_lineas}")
            print(f"Palabras: {total_palabras}")
            print(f"Letras: {total_letras}")

    except FileNotFoundError:
        print(f"Error: El archivo '{nombre_archivo}' no existe")

def copiar_archivo(origen, destino):
     """
     Copia todo el contenido de un archivo de texto origen a otro archivo destino
     """
     try:
        with open(origen, 'r', encoding='utf-8') as leido:
            todas_las_lineas=leido.readlines()
        with open(destino, 'w', encoding='utf-8') as escrito:
             for linea in todas_las_lineas:
                  escrito.write(linea)
     except FileNotFoundError:
          print(f"Error: El archivo '{origen}' no ha sido encontrado")
        

import os
print("Carpeta actual:", os.getcwd())
leer_lineas("Hoja01/archivo_texto.txt")

                             
