from datetime import datetime
from .utils import validar_anio, validar_matricula, validar_telefono, limpiar_texto


vehiculos={}

def registrar_vehiculo(matricula, marca, modelo, anio, propietario, telefono):
    telefono=validar_telefono(telefono)
    matricula=validar_matricula(matricula)
    anio=validar_anio(anio)
    if vehiculo_existe(matricula):
        raise ValueError(f"El vehiculo con matricula {matricula} ya esta registrado")
    vehiculo={
        "Matricula": matricula,
        "Marca": limpiar_texto(marca),
        "Modelo": limpiar_texto(modelo),
        "Anio": anio,
        "Propietario":propietario,
        "Telefono":telefono,
        "Kilometraje":0,
        "Fecha":datetime.now(),
        "Reparaciones":[]
    }
    vehiculos[matricula]=vehiculo
    print(f"Vehiculo registrado {matricula}, {marca}, {modelo}")
    return True


def buscar_vehiculo(matricula):
    matricula=validar_matricula(matricula)
    if matricula in vehiculos:
        return vehiculos.get(matricula)
    
def listar_vehuiculos():
    for vehiculo in vehiculos:
        return list(vehiculo.values())

def actualizar_kilometraje(matricula, kilometros):
    if kilometros <0:
        raise ValueError("Los kilometros no pueden ser negativos")
    else:
        for matricula, datos in vehiculos.items():
            if matricula in vehiculos:
                vehiculos[matricula]["Kilometraje"]=kilometros
                return True
            else:
                return ValueError ("La matricula no existe")


def vehiculo_existe(matricula):
    if matricula in vehiculos:
        return True
    else:
        return False


def obtener_vehiculo_por_marca(marca):
    lista=[]
    for vehiculo in vehiculos.values():
        if vehiculo.get("Marca")==marca.upper():
            lista.append(vehiculo)
    return lista