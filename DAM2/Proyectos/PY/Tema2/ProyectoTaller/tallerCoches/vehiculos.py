import utils
vehiculos={}
def registar_vehiculo(matricula, marca, modelo, anio, propietario, telefono):
    telefono_formateado=utils.validar_telefono(telefono)
    if utils.validar_matricula(matricula) and telefono_formateado and utils.validar_anio(anio):
        vehiculo={
            "Matricula": matricula,
            "Marca": marca,
            "Modelo": modelo,
            "Anio": anio,
            "Propietario":propietario,
            "Telefono":telefono_formateado
        }
        vehiculos[matricula]=vehiculo
        return True
    else:
        if not utils.validar_matricula(matricula):
            raise ValueError ("La matricula ya existe")
        elif not utils.validar_anio(anio):
            raise ValueError ("El año no es correcto")
        else



def buscar_vehiculo(matricula):
    if matricula

def listar_vehuiculos():

"""def actualizar_kilometraje(matricula, kilometros):"""

def vehiculo_existe(matricula):
    if matricula in vehiculos:
        return True
    else:
        return False


def obtener_vehiculo_por_marca(marca):