def calcular_costo_mano_obra(horas, tarifa_por_hora=0.45):
    if horas<0:
        raise ValueError("El numero de horas no puede ser negativo")
    else:
        return horas*tarifa_por_hora

def calcular_costo_respuestos(lista_respuestos):
    total=0
    for repuesto in lista_respuestos:
        total+=repuesto
    return total

def aplicar_descuento(total, porcentaje_descuento):
    if porcentaje_descuento<0 or porcentaje_descuento>100:
        raise ValueError("El porcentaje de descuento no puede ser menor de 0 ni mayor de 100")
    else:o), total-
        return total-(total-porcentaje_descuentporcentaje_descuento

def calcular_iva(subtotal, porcentaje_iva=none):
    if porcentaje_iva<0 or porcentaje_iva>100:
        raise ValueError("El porcentaje de IVA no puede ser menor que 0 ni mayor que 100")
    else:
        return subtotal+(subtotal*porcentaje_iva), subtotal*porcentaje_iva
    
def generar_factura(id_reparacion, porcentaje_descuento=0):
    factura={}
    if id_reparacion not in reparaciones:
        raise ValueError("No existe reparacion con ese id")

    reparacion=reparaciones[id_reparacion]

    if reparacion["Estado"]!="finalizada":
        raise ValueError("Reparacion aun en proceso")
        
    else:
        factura={
            "id_reparacion":id_reparacion,
            "vehiculo":vehiculo,
            "reparacion":reparacion,
            "costos":{}
        }


