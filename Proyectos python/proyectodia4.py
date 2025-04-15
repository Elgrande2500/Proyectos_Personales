from random import *
turno = 0
num_elegido = 0
azar = randint(1,51)
nombre = input('Dime tu nombre: ')
print(f'Buen dia {nombre}, he pensado en un numero entre el 1 y el 50\n y tienes solo 8 intentos para adivinarlo')
while turno < 8:
    num_elegido = int(input('Ingresa un numero: '))
    turno += 1

    if num_elegido not in range(1,51):
        print('Tu numero no se encuentra en el rango de los numeros')
    elif num_elegido < azar:
        print("El numero es menor al que pense")
    elif num_elegido > azar:
        print('El numero es mayor al que pense')
    else:
        print(f'Asertaste el numero !Felicidades¡ Te ha tomado {turno} intentos')
        break

    if num_elegido != azar:
        print(f'Se te han acabado los intentos, el unmero era {azar}')


