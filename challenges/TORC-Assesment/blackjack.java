public static String ArrayChallenge(String[] strArr) {

    Map<String, Integer> values = new HashMap<>();
    values.put("two", 2);
    values.put("three", 3);
    values.put("four", 4);
    values.put("five", 5);
    values.put("six", 6);
    values.put("seven", 7);
    values.put("eight", 8);
    values.put("nine", 9);
    values.put("ten", 10);
    values.put("jack", 10);
    values.put("queen", 10);
    values.put("king", 10);
    values.put("ace", 11);

    int sum = 0;
    int aceCount = 0;

    for (String card : strArr) {
        sum += values.get(card);
        if (card.equals("ace")) aceCount++;
    }

    while (sum > 21 && aceCount > 0) {
        sum -= 10;  
        aceCount--;
    }

    String status;
    if (sum == 21) status = "blackjack";
    else if (sum < 21) status = "below";
    else status = "above";

    String highest = "";
    int highestValue = 0;

    List<String> faceOrder = Arrays.asList("jack", "queen", "king");

    for (String card : strArr) {
        int val = values.get(card);

        if (val > highestValue) {
            highestValue = val;
            highest = card;
        } else if (val == highestValue) {
            if (faceOrder.contains(card) && !faceOrder.contains(highest)) {
                highest = card;
            } else if (faceOrder.contains(card) && faceOrder.contains(highest)) {
                if (faceOrder.indexOf(card) > faceOrder.indexOf(highest)) {
                    highest = card;
                }
            }
        }
    }

    return status + " " + highest;
}
