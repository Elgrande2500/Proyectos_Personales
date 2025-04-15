class Persona:
    def __init__(self, nombre, apellido):
        self.nombre = nombre
        self.apellido = apellido

class Cliente(Persona):
    def __init__(self, nombre, apellido, numero_cuenta, balance=0):
        super().__init__(nombre, apellido)
        self.num_cuenta = numero_cuenta
        self.balance = balance

    def __str__(self):
        return f"Cliente : {self.nombre} {self.apellido}\n Balance de cuenta: {self.num_cuenta}: {self.balance}"

    def depositar(self, monto_deposito):
        self.balance += monto_deposito
        print("Su deposito se ha aceptado")

    def retirar(self, monto_retiro):
        if self.balance >= monto_retiro:
            self.balance -= monto_retiro
            print("Su retiro se ha aceptado")
        else:
            print("No tiene fondos suficientes")


def crear_cliente():
    nombre_cliente = input("Ingrese su nombre: ")
    apellido_ciente = input("Ingrese su apellido: ")
    num_cuenta = input("Ingrese su numero de cuenta: ")
    cliente = Cliente(nombre_cliente, apellido_ciente, num_cuenta)
    return cliente


def inicio():
    mi_cliente = crear_cliente()
    print(mi_cliente)
    opcion = 0

    while opcion != 3:
        print("Elije una opcion para pooder usar su cuenta bancaria:")
        print("1. Depositar")
        print("2. Retirar")
        print("3. Salir")
        opcion = int(input("Ingrese una opcion: "))
        if opcion == 1:
            monto_deposito = int(input("Ingrese el monto a depositar: "))
            mi_cliente.depositar(monto_deposito)
        elif opcion == 2:
            monto_retiro = int(input("Ingrese el monto a retirar: "))
            mi_cliente.retirar(monto_retiro)
        print(mi_cliente)
    print("Gracias por operar banco python")


inicio()
