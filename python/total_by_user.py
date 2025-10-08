# Tienes una lista de pedidos, donde cada pedido es un diccionario con las claves "id", "user", "total", y "status".
# Ejemplo:
# orders = [
#     {"id": 1, "user": "Ana", "total": 50, "status": "completed"},
#     {"id": 2, "user": "Luis", "total": 20, "status": "pending"},
#     {"id": 3, "user": "Ana", "total": 30, "status": "completed"},
#     {"id": 4, "user": "Juan", "total": 70, "status": "completed"}
# ]
# Salida esperada:
# {
#   "Ana": 80,
#   "Juan": 70
# }

def total_by_user(orders): 
    result = {}
    for (order in orders):
        if order["status"] == "completed":
            user = order["user"]
            result[user] = result.get(user, 0) + order["total"]
    return disct(result)