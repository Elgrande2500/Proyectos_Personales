import num_fila
def elegir ():
        while True:
            print("Bienvenido a donde se dirige")
            print("F. Farmacia")
            print("P. Perfumeria")
            print("C. Cosmetica")
            try:
                opcion = input("Elija su opcion ").upper()
                ["P", "C","F"].index(opcion)
            except ValueError:
                print("Elija una opcion valida")
            else:
                break
        num_fila.decorado(opcion)


def inicio():
    while True:
        elegir()
        try:
            otro_turno = input("¿Quieres sacar otro turno?  S/N  ").upper()
            ["S","N"].index(otro_turno)
        except ValueError:
            print("Elija una opcion valida")
        else:
            if otro_turno == "N":
                print("Gracias por su visita")
                break

inicio()