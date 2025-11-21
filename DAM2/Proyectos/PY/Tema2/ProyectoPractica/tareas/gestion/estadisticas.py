from .lista_tareas import lista

def contar_tareas():
    return len(lista)

def tareas_completadas():
    for tarea in lista:
        if tarea["completada"]==True:
            print(tarea)

def tareas_pendientes():
    for tarea in lista:
        if tarea["completada"]==False:
            print(tarea)

def marcar_tarea_completada(indice):
    if isinstance(indice, int) and 0 <= indice < len(lista):
        tarea=lista[indice]
        if not tarea["completada"]:
            tarea["completada"]=True
            print("Tarea completada con exito")
        else:
            raise ValueError("La tarea ya estaba completada")
    else:
        raise ValueError("Debes introducir un índice válido")