# You are given a list of products.
# Each product is represented as a dictionary with these keys:

# "name" → string

# "category" → string

# Write a function that returns a dictionary that groups all product names by their category

# Example
# Input

# products = [
#     {"name": "Laptop", "category": "Electronics"},
#     {"name": "TV", "category": "Electronics"},
#     {"name": "Shirt", "category": "Clothing"},
#     {"name": "Shoes", "category": "Clothing"},
#     {"name": "Apple", "category": "Groceries"}
# ]

# Output
# {
#     "Electronics": ["Laptop", "TV"],
#     "Clothing": ["Shirt", "Shoes"],
#     "Groceries": ["Apple"]
# }

def group_products_by_category(products):
    result = {}

    for product in products: 
        category = product.get("category")
        if category in result:
            result[category].append(product["name"])
        else:
            result[category] = [product["name"]]
    
    return result 
            
        
