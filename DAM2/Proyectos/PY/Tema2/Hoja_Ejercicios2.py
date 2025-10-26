"""lista=[1, 2, 2, 3, 4, 5, 5, 6, 7, 7, 8]
resultado=[]

def sinDuplicados (lista):
    for numero in lista:
        if numero not in resultado:
            resultado.append(numero)
    return resultado

print(sinDuplicados(lista))"""


"""Ana=("Ana", 34, "Santander")
def info_persona(persona):
    print(persona[0], "tiene", persona[1], "años y vive en", persona[2])
info_persona(Ana)"""


"""lista=[1, 2, 2, 3, 4, 5, 5, 6, 7, 7, 8]
devuelve=()
def extremos(valores):
   return (min(valores), max(valores))
    
print(extremos(lista))"""

"""dict={"nombre": "Juan", "edad": 25, "email": "AAAAAAAAA"}

def mostrar_perfil(datos_usuario):
    print(datos_usuario)
mostrar_perfil(dict)"""

"""inventario1={"peras":25, "manzanas": 34, "piña":12}
inventario2={"peras":25, "manzanas": 16, "piña":38}
def combinar_inventarios(inv1, inv2):
    copia=inventario1.copy()
    for clave, valor in inventario2.items():
        if clave in copia:
            copia[clave]+=valor
        else:
            copia[clave]=valor
    return copia
print(combinar_inventarios(inventario1, inventario2))"""


"""calificaciones={"juan":5, "pepe": 3, "manolo":7, "antonio":2, "ramon":1}
lista=[]
def aprobados(calificaciones, nota_minima):
    for clave, valor in calificaciones.items():
        if valor>=nota_minima:
            lista.append(clave)
    return lista
print(aprobados(calificaciones, 5))"""

"""pedido=[{"producto":"camisa", "cantidad":1, "precio":25},
         {"producto":"pantalon", "cantidad":1, "precio":30},
         {"producto":"calcetines", "cantidad":1, "precio":10}]

def total_pedido(pedidos):
    precioTotal=0
    for pedido in pedidos:
        for clave, valor in pedido.items():
            if clave=="precio":
                precioTotal+=valor
    return precioTotal
print(total_pedido(pedido))"""

"""alumnos={"Ana": [8, 9], "Luis": [6, 7, 5]}

def actualiza_notas(alumnos, nombre, nueva_nota):
    for clave, valor in alumnos.items():
        if clave==nombre:
            valor.append(nueva_nota)
        return alumnos
print(actualiza_notas(alumnos, "Ana", 7))"""

"""dic = {"a": 1, "b": 2, "c": 1}
invertido={}
def invertir_diccionarios(diccionario):
    for clave, valor in diccionario.items():
        if valor in invertido:
            invertido[valor].append(clave)
        else:
            invertido[valor]=[clave]
    return invertido
print(invertir_diccionarios(dic))"""

"""lista=[2.5, 3.3, 5.7]

def aplicar_funcion(lista, funcion):
    nueva_lista=[]
    for numero in lista:
        nueva_lista.append(funcion(numero))
    return nueva_lista
print(aplicar_funcion(lista, round))"""


"""lista=[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
def operar(lista, funcion):
    resultado=funcion(lista)
    return resultado
print(operar(lista, max))"""

def configurar_servidor(**opciones):
    configuracion={
        "puerto":80,
        "modo_debug": False,
        "usuarios":[]
    }
    configuracion.update(opciones)
    print("Configuracion final del servidor")
    for clave, valor in configuracion.items():
        print(f"{clave}:{valor}")

configurar_servidor(puerto=8080, modo_debug=True, usuarios=["Ana", "Luis"])


