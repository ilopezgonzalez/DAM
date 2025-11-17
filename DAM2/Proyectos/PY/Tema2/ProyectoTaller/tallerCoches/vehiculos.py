from datetime import datetime
import utils


vehiculos={}

def registrar_vehiculo(matricula, marca, modelo, anio, propietario, telefono):
    telefono_formateado=utils.validar_telefono(telefono)
    if matricula not in vehiculos and telefono_formateado and utils.validar_anio(anio):
        vehiculo={
            "Matricula": matricula,
            "Marca": marca,
            "Modelo": modelo,
            "Anio": anio,
            "Propietario":propietario,
            "Telefono":telefono_formateado,
            "Kilometraje":0,
            "Fecha":datetime.now(),
            "Reparaciones":[]
        }
        vehiculos[matricula]=vehiculo
        return True
    else:
        if not utils.validar_matricula(matricula):
            raise ValueError ("La matricula no tiene formato valido")
        if matricula in vehiculos:
            raise ValueError ("La matricula ya existe")
        if not utils.validar_anio(anio):
            raise ValueError ("El año no es correcto")
        if not telefono_formateado:
            raise ValueError ("El telefono. no es correcto")


def buscar_vehiculo(matricula):
    if matricula in vehiculos:
        return matricula
    else:
        return None

def listar_vehuiculos():
    for vehiculo in vehiculos:
        return list(vehiculo.values())

def actualizar_kilometraje(matricula, kilometros):
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
        if vehiculo.get("Marca")==marca:
            lista.append(vehiculo)
    return lista