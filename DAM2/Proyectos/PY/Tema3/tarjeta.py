class tarjeta:
    """
    Clase que representa una tarjeta
    """

    def __init__(self, nombre, cuenta, saldo):
        self.nombre=nombre
        self.cuenta=cuenta
        self.pin="1234"
        self.estado=False
        self.saldo=saldo

    def get_nombre(self):
        return self.nombre
    
    def set_nombre(self, nombre):
        self.nombre=nombre

    def get_cuenta(self):
        return self.cuenta
    
    
    