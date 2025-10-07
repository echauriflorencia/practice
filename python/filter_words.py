# You are given a list of words (strings).
# Write a function that returns a new list containing only the words that:

# Have more than 3 letters

# Start with a vowel (a, e, i, o, u)

# Are returned in lowercase, even if the input had mixed case letters

# Example
# Input
# words = ["Apple", "egg", "Umbrella", "on", "Sky", "Idea", "AI", "orange"]


# Output
# ["apple", "egg", "umbrella", "idea", "orange"]


def filter_vowel_words(words):
    vowels = "aeiou"
    result = []

    for word in words:
        new_word = word.lower()
        if len(new_word) > 3 and new_word[0] in vowels:
            result.append(new_word)
    return result
