from reparaciones import reparaciones, TIPOS_REPARACION
from vehiculo import vehiculos

def reporte_vehiculos_por_marca():
    lista=[]
    contador=0
    marca=input("¿Que marca quieres buscar?")
    for vehiculo in vehiculos.values():
        if vehiculo.get("Marca")==marca:
            contador+=1
    print("Marca:", marca, "Numero de vehiculos:", contador)
    for vehiculo in vehiculos.values():
        if vehiculo.get("Marca")==marca:
            print("Modelo:", vehiculo.get("Modelo"), "Matricula:", vehiculo.get("Matricula"))
            lista.append(vehiculo)
    return lista

def estadisticas_tipos_reparacion():
    estadisticas={}
    cantidad_reparaciones=0
    horas_totales=0
    costo_total=0
    for tipo in TIPOS_REPARACION:
        for reparacion in reparaciones.values():
            if reparacion["tipo"]==tipo:
                cantidad_reparaciones+=1
                horas_totales+=reparacion.get("horas_trabajo")
                costo_total+=reparacion.get("costo_total")
    estadisticas={
        "numero_reparaciones":cantidad_reparaciones,
        "horas_totales":horas_totales,
        "promedio_horas":horas_totales/cantidad_reparaciones,
        "costo_total":costo_total,
        "promedio_costo":costo_total/numero_reparaciones
    }
    print(estadisticas)
    return estadisticas

def vehiculos_mas_reparados(limite=5):
    total_reparaciones=0
    for vehiculo in vehiculos.values():
        for reparacion in vehiculo["reparaciones"]:
            




    
    