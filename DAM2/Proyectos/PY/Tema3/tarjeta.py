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
        """
        Docstring para get_nombre
        
        :param self: Descripción
        """
        return self.nombre
    
    def set_nombre(self, nombre):
        """
        Docstring para set_nombre
        
        :param self: Descripción
        :param nombre: Descripción
        """
        self.nombre=nombre

    def get_cuenta(self):
        """
        Docstring para get_cuenta
        
        :param self: Descripción
        """
        return self.cuenta
    
    def desbloquea(self, pin):
        """
        Docstring para desbloquea
        
        :param self: Descripción
        :param pin: Descripción
        """
        if self.pin==pin:
            self.estado=True

    def pagar(self, importe, pin, descripcion, propina):
        if self.estado==False:
            assert ValueError ("La tarjeta esta desshabilitada")
        if self.pin!=pin:
            assert ValueError("El pin no es correcto")
        if self.saldo<importe:
            assert ValueError("No hay saldo suficiente")
        if propina:
            nuevo_importe=importe+propina
            importe_total=nuevo_importe*1.05
        else:
            importe_total=importe
        self.saldo-=importe_total
        self.__imprimir_ticket(importe, descripcion, propina)
        

    def __imprimir_ticket(self):
        nueva_cuenta=self.cuenta[:4]+self.cuenta[4:].replace(self.cuenta[4:], "*" *len(self.cuenta[4:]))
        printf("El cliente: {self.nombre}.\n" 
               "Cuenta {nueva_cuenta}.\n"
               "Descripcion: {self.descripciom[:8]}.\n"
               "Valor: {importe}.\n"
               "Recargos: {propina}.\n"
               "Valor total {importe_total}"  )

    
    
    