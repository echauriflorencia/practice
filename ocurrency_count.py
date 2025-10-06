# You are given a list of orders.
# Each order is represented as a dictionary with the following keys:

# "id" → integer
# "status" → string, possible values: "pending", "completed", "canceled"

# Write a function that returns a dictionary counting how many orders there are in each status.

# If an order has an unknown status (different from those three), count it under "unknown".

# Example
# Input 
# orders = [
#     {"id": 1, "status": "completed"},
#     {"id": 2, "status": "pending"},
#     {"id": 3, "status": "pending"},
#     {"id": 4, "status": "canceled"},
#     {"id": 5, "status": "on_hold"}
# ]

# Output
# {
#     "pending": 2,
#     "completed": 1,
#     "canceled": 1,
#     "unknown": 1
# }