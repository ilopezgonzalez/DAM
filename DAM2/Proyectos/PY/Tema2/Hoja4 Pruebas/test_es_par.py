"""paquete que contiene las pruebas de la funcion es_par"""
from operaciones import es_par

def realizar_pruebas():
    """
    Docstring para realizar_pruebas
    """

    #Casos normales

    assert es_par(2) is True, "2 debe ser par"
    assert es_par(3) is False, "3 debe ser impar"
    
    #Casos límite

    assert es_par(0) is True, "0 debe ser par"
    assert es_par(-2) is True, "-2 debe ser par"
    assert es_par(-3) is False, "-3 debe ser impar"

    #Numeros float






    print("Todas la pruebas han sido satisfactorias")
if __name__=='__main__':
    realizar_pruebas()