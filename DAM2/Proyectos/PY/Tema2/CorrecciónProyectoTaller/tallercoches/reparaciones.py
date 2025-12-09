"""Modulo reparaciones"""
from datetime import datetime
from .utils import generar_id_unico, limpiar_texto
from .vehiculos import buscar_vehiculo, vehiculo_existe

TIPOS_REPARACION=['motor', 'frenos', 'suspension', 'electricidad', 'carroceria', 'climatizacion', 'transmision', 'neumaticos']

reparaciones={}

def crear_reparacion(matricula, descripcion, tipo_reparacion, mecanico_asignado):
    if tipo_reparacion.lower() not in TIPOS_REPARACION:
        raise ValueError("Tipo de reparacion no reconocida")
    if descripcion=="":
        raise ValueError("La descripcion de la reparacion no puede estar vacia")
    if not vehiculo_existe(matricula):
        raise ValueError("El vehiculo no existe")
    id_reparacion=generar_id_unico()
    reparacion={
        "id": id_reparacion,
        "Matricula": matricula,
        "Descripcion": descripcion.strip(),
        "Tipo": tipo_reparacion.lower(),
        "Mecanico":limpiar_texto(mecanico_asignado),
        "Estado":"en_proceso",
        "Fecha inicio":datetime.now(),
        "Fecha fin": None,
        "horas_trabajo":0,
        "repuestos_utilizados":[],
        "costo_total":0.0
    }   
    reparaciones[id_reparacion]=reparacion
    vehiculo=buscar_vehiculo(matricula)
    vehiculo["reparaciones_realizadas"].append(id_reparacion)
    print(f"Reparacion creada: {id_reparacion} para vehiculo {matricula}")

def finalizar_reparacion(id_reparacion, horas_trabajo, repuestos_utilizados=None):
    if reparaciones[id_reparacion]["Estado"]=="en_proceso":
        reparaciones[id_reparacion]["Estado"]="finalizada"
        reparaciones[id_reparacion]["horas_trabajo"]=horas_trabajo
        reparaciones[id_reparacion]["repuestos_utilizados"]=repuestos_utilizados
        return True
    else:
        raise ValueError ("La reparacion ya esta finalizada")

def listar_reparaciones (estado=None):
    lista_reparaciones=[]
    for reparacion in reparaciones.values():
        if estado is None or reparacion["estado"]==estado:
            listar_reparaciones.append(reparacion)
    return lista_reparaciones
    
def buscar_reparaciones_vehiculo(matricula):
    lista_reparaciones=[]
    for reparacion in reparaciones.values():
        if reparacion["Matricula"]==matricula:
            lista_reparaciones.append(reparacion)

def obtener_reparacion(id_reparacion):
    dict_reparaciones={}
    for reparacion in reparaciones.values:
        if reparacion["id"]==id_reparacion:
            dict_reparaciones.

def agregar_repuesto_reparacion(id_reparacion, repuesto, cantidad, precio_unitario):
    if id_reparacion not in reparaciones:
        raise ValueError("NO existe esa reparacion")
    else:
        reparacion["repuestos_utilizados"].append(
            repuesto={
                "Nombre":repuesto,
                "Cantidad":cantidad,
                "Precio Unitario":precio_unitario,
                "Subtotal":cantidad*precio_unitario
            }
        )
        return True
        