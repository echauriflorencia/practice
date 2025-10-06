# You are given a list of dictionaries representing houses in a neighborhood.
# Each dictionary has a key "id" (int) and may or may not have a "water_tank" key (bool).

# Write a function that returns the IDs of all houses that have a water tank,
# in the order they appear.

# If no house has a water tank, return an empty list.

# Example
# Input 
# houses = [
#     {"id": 1, "water_tank": True},
#     {"id": 2},
#     {"id": 3, "water_tank": False},
#     {"id": 4, "water_tank": True}
# ]

# Output [1, 4]

def houses_with_tanks(houses):
    result = []

    for house in houses:
        if (house.get("water_tank")):
            result.append(house["id"])
    return result
