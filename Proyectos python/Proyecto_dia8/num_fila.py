def per_turno():
    for x in range (1,1000):
        yield f"P - {x}"

def cos_turno():
    for x in range (1,1000):
        yield f"C - {x}"


def far_turno():
    for x in range (1,1000):
        yield f"F - {x}"

p = per_turno()
f = far_turno()
c = cos_turno()

def decorado(rubro):
    print("Su turno es:")
    if rubro == "P":
        print(next(p))
    elif rubro == "F":
        print(next(f))
    else:
        print(next(c))
