import os
from os import system
from pathlib import Path
mi_ruta = Path(Path.home(),"Recetas")


def contar_recetas(ruta):
    contador = 0
    for archivo in Path(ruta).glob("**/*.txt"):
        contador += 1
    return contador

def inicio():
    system('cls')
    print("*" * 50)
    print(f"Bienvenido al recetario")
    print("*" * 50)
    print("\n")
    print(f"las recetas se encuentran en {mi_ruta}")
    print("Total de recetas: ", contar_recetas(mi_ruta), "\n")

    opcion = 'x'
    while not opcion.isnumeric() or int(opcion) not in range(1,7):
        print("elije una opcion:")
        print("\n1. leer receta\n2. crear receta\n3. crear categoria\n4. Eliminar receta\n5. Eliminar categoría\n6. Finalizar el programa\n")
        opcion = input()
    return int(opcion)

def mostrar_categorias(ruta):
    print("Categorias:")
    ruta_categorias = Path(ruta)
    lista_categorias=[]
    contador = 1

    for carpeta in ruta_categorias.iterdir():
        carpeta_str = str(carpeta.name)
        print(f"[{contador}]. {carpeta_str}")
        lista_categorias.append(carpeta)
        contador += 1
    return lista_categorias

def elegir_categoria(lista):
    opcion = 'x'
    while not opcion.isnumeric() or int(opcion) not in range(1,len(lista)+1):
        opcion = input("\nElige una categoria:")
    return lista[int(opcion)-1]

def mostrar_recetas(ruta):
    print("Recetas:")
    ruta_recetas = Path(ruta)
    list_recetas = []
    contador = 1

    for receta in ruta_recetas.glob("**/*.txt"):
        receta_str = str(receta.name)
        print(f"[{contador}]. {receta_str}")
        list_recetas.append(receta)
        contador += 1
    return list_recetas

def elegir_receta(lista):
    opcion = 'x'
    while not opcion.isnumeric() or int(opcion) not in range(1,len(lista)+1):
        opcion = input("\nElige una receta:")
    return lista[int(opcion)-1]

def leer_receta(receta):
    print(Path.read_text(receta))

def crear_receta(ruta):
    existe = False
    while not existe:
        print("Escribe el nombre de tu receta: ")
        nombre_receta = input("") + ".txt"
        print("Escribe tu nueva receta")
        contenido_receta = input("")
        ruta_nueva = Path(ruta,nombre_receta)

        if not os.path.exists(ruta_nueva):
            Path.write_text(ruta_nueva,contenido_receta)
            print("Receta creada")
            existe = True
        else:
            print("Ya existe una receta con ese nombre")

def crear_categoria(ruta):
    existe = False
    while not existe:
        print("Escribe el nombre de tu nueva categoria: ")
        nombre_categoria = input("")
        ruta_nueva = Path(ruta,nombre_categoria)
        if not os.path.exists(ruta_nueva):
            Path.mkdir(ruta_nueva)
            print("Categoria creada")
            existe = True
        else:
            print("Ya existe una categoria con ese nombre")

def eliminar_receta(receta):
    Path(receta).unlink()
    print(f"Receta {receta.name} ha sido eliminada")

def eliminar_categoria(categoria):
    Path(categoria).rmdir()
    print(f"Categoria {categoria.name} ha sido eliminada")

def volver_inicio():
    opcion = "x"
    while opcion.lower() != "v":
        opcion = input("\n presione V para volver al inicio: ")

finalizar = False
while not finalizar:

    menu = inicio()
    if menu == 1:
        mis_categorias = mostrar_categorias(mi_ruta)
        mi_categoria = elegir_categoria(mis_categorias)
        mis_receta = mostrar_recetas(mi_categoria)
        mi_receta = elegir_receta(mis_receta)
        leer_receta(mi_receta)
        volver_inicio()

    elif menu == 2:
        mis_categorias = mostrar_categorias(mi_ruta)
        mi_categoria = elegir_categoria(mis_categorias)
        crear_receta(mi_categoria)
        volver_inicio()

    elif menu == 3:
        crear_categoria(mi_ruta)
        volver_inicio()

    elif menu == 4:
        mis_categorias = mostrar_categorias(mi_ruta)
        mi_categoria = elegir_categoria(mis_categorias)
        mis_receta = mostrar_recetas(mi_categoria)
        mi_receta = elegir_receta(mis_receta)
        eliminar_receta(mi_receta)
        volver_inicio()

    elif menu == 5:
        mis_categorias = mostrar_categorias(mi_ruta)
        mi_categoria = elegir_categoria(mis_categorias)
        eliminar_categoria(mi_categoria)

    elif menu == 6:
        finalizar = True
