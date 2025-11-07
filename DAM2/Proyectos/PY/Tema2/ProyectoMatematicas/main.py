from Matematicas import (
    suma, resta, multiplicacion, division,
    promedio, mediana, moda,
    fibonacci, factorial, es_primo
)

def mostrar_menu():
    print("\n===== MENÚ PRINCIPAL =====")
    print("1. Funciones aritméticas")
    print("2. Funciones estadísticas")
    print("3. Funciones avanzadas")
    print("0. Salir")

def mostrar_menu_operaciones():
    print("\n==== MENÚ OPERACIONES ====")
    print("1. Suma")
    print("2. Resta")
    print("3. Multiplicación")
    print("4. División")
    print("0. Volver al menú anterior")

def mostrar_menu_estadistica():
    print("\n==== MENÚ ESTADÍSTICA ====")
    print("1. Promedio")
    print("2. Mediana")
    print("3. Moda")
    print("0. Volver al menú anterior")

def mostrar_menu_avanzadas():
    print("\n==== MENÚ AVANZADAS ====")
    print("1. Fibonacci")
    print("2. Factorial")
    print("3. Es primo")
    print("0. Volver al menú anterior")

lista = (1, 2, 3, 4, 4, 5, 6, 7, 8, 9, 10)

def main():
    while True:
        mostrar_menu()
        opcion = input("Elige una opción: ")

        if opcion == "1":  # Aritmética
            while True:
                mostrar_menu_operaciones()
                subop = input("Elige una opción: ")

                if subop == "1":
                    n1 = float(input("Introduce el número 1: "))
                    n2 = float(input("Introduce el número 2: "))
                    print("Resultado:", suma(n1, n2))
                elif subop == "2":
                    n1 = float(input("Introduce el número 1: "))
                    n2 = float(input("Introduce el número 2: "))
                    print("Resultado:", resta(n1, n2))
                elif subop == "3":
                    n1 = float(input("Introduce el número 1: "))
                    n2 = float(input("Introduce el número 2: "))
                    print("Resultado:", multiplicacion(n1, n2))
                elif subop == "4":
                    n1 = float(input("Introduce el número 1: "))
                    n2 = float(input("Introduce el número 2: "))
                    print("Resultado:", division(n1, n2))
                elif subop == "0":
                    break
                else:
                    print("Opción no válida")

        elif opcion == "2":  # Estadística
            while True:
                mostrar_menu_estadistica()
                subop = input("Elige una opción: ")

                if subop == "1":
                    print("Promedio:", promedio(lista))
                elif subop == "2":
                    print("Mediana:", mediana(lista))
                elif subop == "3":
                    print("Moda:", moda(lista))
                elif subop == "0":
                    break
                else:
                    print("Opción no válida")

        elif opcion == "3":  # Avanzadas
            while True:
                mostrar_menu_avanzadas()
                subop = input("Elige una opción: ")

                if subop == "1":
                    n1 = int(input("Introduce un número: "))
                    print("Fibonacci:", fibonacci(n1))
                elif subop == "2":
                    n1 = int(input("Introduce un número: "))
                    print("Factorial:", factorial(n1))
                elif subop == "3":
                    n1 = int(input("Introduce un número: "))
                    print("¿Es primo?:", es_primo(n1))
                elif subop == "0":
                    break
                else:
                    print("Opción no válida")

        elif opcion == "0":
            print("Saliendo del programa...")
            break
        else:
            print("Opción no válida. Intenta de nuevo.")

if __name__ == "__main__":
    main()
