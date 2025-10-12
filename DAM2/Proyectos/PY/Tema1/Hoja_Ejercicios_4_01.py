import random
"""lista=[]
for i in range(20):
    aleatorio=random.randint(1,100)
    lista.append(aleatorio)
print(lista)

print(lista[6])

lista2=[]
lista2[0:5]=[8]*5
print(lista2)

lista3=[34]
lista4=lista3[0:11]"""

"""lista=[0,1,2,3,4,5,6,7,8,9]
lista2=lista[::-1]
print(lista)
print(lista2)"""

"""numbers=[]
squares=[]
cubes=[]
for i in range(20):
    aleatorio=random.randint(1,100)
    numbers.append(aleatorio)
for numero in numbers:
    cuadrado=numero**2
    squares.append(cuadrado)
for numero in numbers:
    cubo=numero**3
    cubes.append(cubo)
print(numbers)
print(squares)
print(cubes)"""

"""lista=[]
for i in range(10):
    numero=input("Introduce un numero:")
    lista.append(numero)
for numero in lista:
    if numero==max(lista):
        print("MAXIMO", numero)
    elif numero==min(lista):
        print("MINIMO", numero)
    else:
        print(numero)"""

"""temperaturas=[]
for i in range(12):
    numero=int(input("Introduce la temperatura del mes:"))
    temperaturas.append(numero)

for temperatura in temperaturas:
    print("*"*temperatura)"""

"""numeros=[]
for i in range(20):
    aleatorio=random.randint(1,100)
    if aleatorio%2==0:
        numeros.insert(0,aleatorio)
    else:
        numeros.append(aleatorio)
print(numeros)"""

numeros=[]
numeros2=[]
for i in range(15):
    aleatorio=random.randint(1,15)
    numeros.append(aleatorio)
numeros2=numeros[-1:]+numeros[:-1]
print(numeros)
print(numeros2)









