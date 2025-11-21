lista=[]

def agregar_tarea(descripcion):
    if isinstance(descripcion, str) and descripcion.strip():
        lista.append({"descripcion":descripcion, "completada":False})
    else:
        raise ValueError("La descripción no puede estar vacía ni ser inválida")

def eliminar_tarea(indice: int):
    if isinstance(indice, int) and 0 <= indice < len(lista):
        del lista[indice]
    else:
        raise ValueError("Debes introducir un índice válido")

def listar_tareas():
    for i,tarea in enumerate(lista):
        print(f"Tarea {i}: {tarea}")

