TIPOS_REPARACION=['motor', 'frenos', 'suspension', 'electricidad', 'carroceria', 'climatizacion', 'transmision', 'neumaticos']

def crear_reparacion(matricula, descripcion, tipo_reparacion, mecanico_asignado):
    if tipo_reparacion not in TIPOS_REPARACION:
        raise ValueError("Tipo de reparacion no reconocida")
    if descripcion=="":
        raise ValueError("La descripcion de la reparacion no puede estar vacia")
    if 