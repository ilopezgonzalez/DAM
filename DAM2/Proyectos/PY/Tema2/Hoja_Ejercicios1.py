"""def saludar(nombre):
    print("Hola", nombre)
saludar("Juan")"""

"""def suma(a,b):
    suma=a+b
    print("El resultado de la suma es:",suma)
suma(5,7)"""

"""def area_circulo(radio):
    import math
    area=(math.pi)*(radio**2)
    print("El area del circulo es:",area)
area_circulo(12)"""

"""contador=0
def incrementar(valor):
    Devuelve el valor del contador incrementado en el valor del argumento
    global contador
    contador+=valor
    print("El valor actual del contador es:", contador)
incrementar(2)
print(incrementar.__doc__)
help(incrementar)"""

def factorial(numero):
    if numero>0 and isinstance(numero, int):
        factorial=1
        for i in range(numero, 0, -1):
            factorial*=i
        print(factorial)
    else:
        raise ValueError("No se puede hacer factorial de numero negativos o que no sean enteros")
factorial(6)

"""lista=[1,2,3,4,5,6,7,8]
def maximo(lista):
    numMax=0
    for numero in lista:
        if numero>numMax:
            numMax=numero
    print(numMax)
maximo(lista)

def minimo(lista):
    numMin=lista[0]
    for numero in lista:
        if numero<numMin:
            numMin=numero
    print(numMin)
minimo(lista)"""

"""def es_primo(numero):
    primo=True
    for i in range(2, int(numero**0.5)+1):
        if numero%i==0:
            primo=False
            break
    if primo:
        print("El numero es primo")
    else:
        print("El numero NO es primo")
es_primo(12)"""
