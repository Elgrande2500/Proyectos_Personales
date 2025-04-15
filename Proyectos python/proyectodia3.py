texto = input('Dame un texto cualquiera: ')
letras = []
texto = texto.lower()

letras.append(input('ingresa la primera letra: ').lower())
letras.append(input('ingresa la segunda letra: ').lower())
letras.append(input('ingresa la tercera letra: ').lower())

print("\n")
print("CANTIDAD DE LETRAS")
cantidad_letras1 = texto.count(letras[0])
cantidad_letras2 = texto.count(letras[1])
cantidad_letras3 = texto.count(letras[2])

print(f"Se encontro la letra '{letras[0]}' repetidas {cantidad_letras1} veces")
print(f"Se encontro la letra '{letras[1]}' repetidas {cantidad_letras2} veces")
print(f"Se encontro la letra '{letras[2]}' repetidas {cantidad_letras3} veces")

print("\n")
print("CANTIDAD DE PALABRAS")
palabras = texto.split()
print(f"Hemos encontrado {len(palabras)} palabras en tu texto")

print("\n")
print("LETRAS DE INICIO Y FIN")
letra_inicio = texto[0]
letra_final = texto[-1]
print(f"La letra inicial es '{letra_inicio}' y la letra final es '{letra_final}'")

print("\n")
print("TEXTOP INVERTIDO")
palabras.reverse()
texto_invertido = ' '.join(palabras)
print(f'Si ordenamos tu texto al reves sera: {texto_invertido}')

print("\n")
print("BUSCANDO PALABRA PYTHON")
buscar_python = "python" in texto
dic = {True:'si', False:'No'}
print(f"La palabra 'Python': {dic[buscar_python]} se encuentra en el texto" )
