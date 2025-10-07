"""numero=int(input("Introduce un numero:"))
if (numero%2==0):
    print("Numero par")
else:
    print("Numero impar")"""

"""numero1=int(input("Introduce un numero:"))
numero2=int(input("Introduce un numero:"))
if (numero2 !=0):
    print("La division es", numero1/numero2)
else:
    print("No se puede dividir un numero entre 0")"""

"""palabra=input("Introduce una palabra:")
if (palabra[0].isupper()):
    print("La palabra empieza por mayuscula")
else:
    print("La palabra empieza por minuscula")"""

"""nota=int(input("Introduce la nota:"))
edad=int(input("Introduce la edad:"))
sexo=chr(input("Itroduce el sexo M o F:"))
if (nota>=5&edad>=18&sexo.__contains__("")):
    print("ACEPTADA")
elif (nota>=5&edad>18&sexo="M"):
    print("POSIBLE")"""

"""import math
a=float(input("Introduce el primer lado: "))
b=float(input("Introduce el segundo lado: "))
c=float(input("Introduce el tercer lado: "))

if (a==b==c):
    print("Es un triangulo equilatero")
if (a==b|a==c):
    print("Es un triangulo isosceles")
elif ((math.sqrt(a**2+b**2)==math.sqrt(c**2))|(math.sqrt(a**2+c**2)==math.sqrt(b**2))|(math.sqrt(c**2+b**2)==math.sqrt(a**2))):
    print("Es un triangulo rectagulo")
else:
    print("Es un triangulo escaleno")"""

"""year=int(input("Introduce el año para comprobar si es bisiesto: "))
if (year%4==0 and year%100!=0 or year%400==0):
    print("El año es bisiesto")
else:
    print("El año no es bisiesto")"""


"""CORREGIR"""
"""tiempoMinutos=int(input("Introduce el numero de minutos:"))
if(tiempoMinutos<5):
    precio=1
elif (tiempoMinutos>5 and tiempoMinutos<8):
    precio=1+((tiempoMinutos-5)*0.8)
elif (tiempoMinutos>8 and tiempoMinutos<10):
    precio=1+((tiempoMinutos-5)*0.8)+((tiempoMinutos-8)*0.7)
else: 
    precio=1+((tiempoMinutos-5)*0.8)+((tiempoMinutos-8)*0.7)+((tiempoMinutos-10)*0.5)
diaSemana=input("¿El dia de la semana es domingo?")
if(diaSemana=="Si"):
    precio=precio+precio*0.03
turno=input("¿Turno de mañana o de tarde?")
if(turno=="mañana"):
    precioFinal=precio+precio*0.15
else:
    precioFinal=precio+precio*0.1
print("El precio de la llamada es:", precio)"""