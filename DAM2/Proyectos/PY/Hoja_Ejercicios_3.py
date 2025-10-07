"""import random
numero=random.randint(1,100)
intentos=0
for i in range(10):
    intento=int(input("Intenta adivinar el numero: "))
    if(intento==numero):
        print("Has acertado")
        break
    else:
        print("Vuelve a intentarlo, te quedan", 9-i, "intentos")
        if (intento>numero):
            print("El numero que buscamos es inferior")
        else:
            print("El numero que buscamos es superior")"""

"""cantidadPares=0
cantidadImpares=0
cantidad=int(input("¿Cuantos numeros quieres introducir?: "))
while(cantidad>0):
    numero=int(input("Introduce un numero: "))
    if (numero%2==0):
        cantidadPares+=1
    else:
        cantidadImpares+=1
    cantidad-=1
print("La cantidad de numero pares es:", cantidadPares)
print("La cantidad de numero impares es:", cantidadImpares)"""

"""numero1=int(input("Introduce el primer numero: "))
numero2=int(input("Introduce el segundo numero: "))
if (numero1<numero2):
    numeros=numero1
    while (numeros<=numero2):
        if (numeros%2==0):
            print(numeros)
        numeros+=1
elif (numero2<numero1):
    numeros=numero2
    while (numeros<=numero1):
        if (numeros%2==0):
            print(numeros)
        numeros+=1
else:
    print("Los numeros son iguales")"""

"""while True:
    limiteInferior=int(input("Introduce el limite inferior: "))
    limiteSuperior=int(input("Introduce el limite superior: "))
    if (limiteInferior<limiteSuperior):
        break
    else:
        print("El limite inferior debe ser inferior al superior")
suma=0
fuera=0
numero=1
while (numero!=0):
    numero=int(input("Introduce el numero (0 para salir):"))
    if(numero==0):
        break
    if (limiteInferior<numero<limiteSuperior):
        suma+=numero
    elif (numero<limiteInferior or numero>limiteSuperior):
        fuera+=1
    elif (numero==limiteInferior or numero==limiteSuperior):
        print("El numero introducido es igual a uno de los limites")
print("La suma de los numeros que estan en el intervalo es:", suma)
print("Hay", fuera, "numoer fuera del intervalo")"""

"""base=int(input("Introduce la base: "))
exponente=int(input("Introduce la exponente: "))
potencia=1
for i in range(exponente):
    
    potencia=potencia*base
print("El resultado de la potencia es: ", potencia)"""

"""dineroInicio=10
suma=0
for i in range(20):
    suma+=dineroInicio
    dineroInicio=dineroInicio*2
    print(suma)
print("En 20 meses el cliente ha pagado:", suma, "€")"""

"""import time

de esta manera podemos ver como cambian las horas y los minutos
segundos=7190 

while segundos<1000000:
    horas=segundos//3600
    minutos=(segundos%3600)//60
    segundosImprimir=segundos%60
    print(horas,"H", minutos,"M", segundosImprimir ,"seg")
    time.sleep(1)
    segundos+=1"""

"""cantidad=int(input("¿Cuantos numeros primos quieres mostrar? "))
contador=0
numero=2
while contador<cantidad:
    esPrimo=True
    for i in range (2, int(numero**0.5)+1):
        if numero%i==0:
            esPrimo=False
            break
    if esPrimo:
        print (numero, end=" ")
        contador+=1
    numero+=1"""

"""cadena=input("Introduce una frase: ")
caracter=input("Introduce un caracter para buscar: ")
contador=0
for i in range(len(cadena)):
    if cadena[i].__contains__(caracter):
        contador+=1
print("La frase tiene", contador, 'caracteres iguales a "'+ caracter+'"')"""


cadena=input("Introduce una frase: ")
caracter=" "
contador=0
for i in range(len(cadena)):
    if cadena[i].__contains__(caracter):
        contador+=1
print("La frase tiene", (contador+1), "palabras")
