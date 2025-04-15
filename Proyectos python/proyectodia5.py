from random import *
import os

palabras = [
    "casa", "amigo", "coche", "barco", "estupendo", "barriga", "consejo",
    "buho", "arbitro", "deporte", "corazon", "amor", "ciudad", "pajaro",
    "hueso", "chico", "chica", "mapa", "campo", "tarta", "television",
    "decoracion", "mueble", "mesa", "paloma", "tigre", "sillon", "agenda",
    "calendario", "mechero", "vaso", "botella", "perro", "casco", "leon",
    "pantera", "pelicano", "madera", "metal", "agua", "solido", "gas", "silla",
    "libro", "cesta", "pizarra", "planta", "basura", "collar", "pijama", "alicate",
    "hucha", "horno", "botella", "ahorcado", "raton", "alcohol", "medicamento",
    "guerra", "paz", "camiseta", "fuego", "tierra", "planeta", "sol", "luna",
    "jupiter", "urano", "pluton", "libreta", "marte", "mercurio", "venus",
    "galaxia", "universo", "guitarra", "musica", "piano", "cenicero", "tambor",
    "arte", "artesania", "violin", "gato", "correr", "saltar", "saturno", "estrella"

]


def palabra_azar(lista_palabras):
    """Esta función eligiera una palabra al azar"""
    palabra_elegida = choice(lista_palabras)
    letras_unicas = len(set(palabra_elegida))
    return palabra_elegida, letras_unicas


def adivinar_palabra(palabra):
    global palabra_adivinada
    global intentos

    palabra_adivinada = input("\t¡Dime la palabra!:\n>>>")
    if palabra_adivinada == palabra:
        palabra_adivinada = True
        return True, palabra_adivinada


    else:
        return True, False


def pedir_letras():
    global primera_letra
    global palabra_adivinada
    global probrar_suerte

    letra_elegida = ""
    es_valida = False
    abc = 'abcdefghijklmnñopqrstuvwxyz'

    if not primera_letra:
        adivi = "r"
        while adivi == "r":
            adivinar = input("\t¿Ya sabes la palabra secreta? (s/n):\n>>>")
            if adivinar == "s":
                adivi == adivinar
                probrar_suerte, palabra_adivinada = adivinar_palabra(palabra)
                break

            elif adivinar == "n":
                adivi == adivinar
                break
            else:
                print('respuesta incorrecta... Solo es valido los caracteres (s/n) ')
    if probrar_suerte == True:
        return palabra_adivinada
    while not es_valida:
        letra_elegida = input("\tElige una letra:\n>>>")
        if letra_elegida in abc and len(
                letra_elegida) == 1 and letra_elegida not in letras_incorrectas and letra_elegida not in letras_correctas:
            primera_letra = False
            es_valida = True

        else:
            print("La letra elegida no es valida o ya la usastes")
    return letra_elegida


def mostrar_tablero(palabra_elegida):
    if len(palabra) > 10:
        largopalabra = len(palabra) * 2
    else:
        largopalabra = len(palabra) * 4
    lista_oculta = []
    for l in palabra_elegida:
        if l in letras_correctas:
            lista_oculta.append(l)
        else:
            lista_oculta.append("_")

    print("\t" + " ".join(lista_oculta).center(largopalabra))


def chekear_letra(letra_elegida, palabra_oculta, vidas, coincidencias):
    global probrar_suerte
    fin = False
    if letra_elegida == True:
        fin = ganar(palabra_oculta)
        return vidas, fin, coincidencias
    elif letra_elegida == False:
        print("\nLo siento, esa no era la palabra secreta\n")
        os.system('pause')
        probrar_suerte = False
        vidas -= 1
        return vidas, fin, coincidencias
    else:

        if letra_elegida in palabra_oculta:
            letras_correctas.append(letra_elegida)
            coincidencias += 1
        else:
            letras_incorrectas.append(letra_elegida)
            vidas -= 1

        if vidas == 0:
            fin = perder()
        elif coincidencias == letras_unicas:
            fin = ganar(palabra_oculta)

        return vidas, fin, coincidencias


def perder():
    os.system('cls')
    print("\n\t=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*")
    print("\t\tLo siento. Te has quedado sin vidas")
    print(f"\t\tLa palabra secreta era: {palabra}")
    print("\t=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*")
    return True


def ganar(palabra_descubierta):
    os.system('cls')
    print("\n\t=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*")
    print("\t!Enhorabuena¡ Has descubierto la palabra secreta.\n")
    print("\t\t\t  " + palabra_descubierta.center(10))
    print("\t=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*")

    return True


def loop_juego():
    global juego_terminado
    global intentos
    global aciertos
    inicio = 0
    print("\nBien!, ya pensé una palabra...\n".center(20))
    os.system('pause')
    while not juego_terminado:
        os.system('cls')
        print("\n\t" + "*" * 31 + "\n")
        mostrar_tablero(palabra)
        print("\n")
        print("\tLetras incorrectas: ".center(10) + " ".join(letras_incorrectas).center(10))
        print(f"\tTe quedan {intentos} vidas.".center(20))
        print("\n\t" + "*" * 31 + "\n")
        letra = pedir_letras()

        intentos, terminado, aciertos = chekear_letra(letra, palabra, intentos, aciertos)

        juego_terminado = terminado


while True:
    letras_correctas = []
    letras_incorrectas = []
    intentos = 6
    aciertos = 0
    primera_letra = True
    palabra_adivinada = False
    probrar_suerte = False
    juego_terminado = False
    print("\n\n")
    print("==============================".rjust(50))
    print("El juego: Adivina la Palabra".rjust(49))
    print("==============================\n".rjust(51))
    print("[1]  Partida Nueva".rjust(42))
    print("\n")
    print("[2]\tSalir".rjust(33))
    print("\n")
    print("==============================\n".rjust(51))

    opcion = input("\tIntroduce una opción:\n\t\t\t>>>".rjust(50))

    os.system('cls')
    if opcion == "1":
        palabra, letras_unicas = palabra_azar(palabras)
        loop_juego()
    else:
        break