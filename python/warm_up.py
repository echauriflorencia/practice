# You are given a list of integers.
# Write a function that returns the first number in the list that occurs more than once.
# If there are no duplicates, return -1.

# Example
# Input: [2, 1, 3, 5, 3, 2]
# Output: 3

def first_duplicate(nums):
    uniques = set()
    for (num in nums): 
        if (num in uniques):
            return num
        else
            uniques.add(num)
    
    return -1
