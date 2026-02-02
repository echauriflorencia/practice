import java.util.*;

public class BankingSystemImpl implements BankingSystem {

    private final Map<String, Integer> accounts = new HashMap<>();
    private final Map<String, Long> outgoing = new HashMap<>();

    static final long CASHBACK_DELAY = 84_400_000L;

    class Payment {
        String paymentId;
        String accountId;
        int amount; 
        int cashback;
        long cashbackTimeStamp;
        boolean cashbackProcessed;
    }

    Map<String, Payment> payments = new HashMap<>();
    PriorityQueue<Payment> cashbackQueue = new PriorityQueue<>(Comparator.comparingLong(p -> p.cashbackTimeStamp));

    int paymentCounter = 0;

    @Override
    public boolean createAccount(int timestamp, String accountId) {
        processCashbacks(timestamp);
        if (accounts.containsKey(accountId)) {
            return false;
        }

        accounts.put(accountId, 0);
        return true;
    }

    @Override
    public Optional<Integer> deposit(int timestamp, String accountId, int amount) {
        processCashbacks(timestamp);
        if (!accounts.containsKey(accountId)) {
            return Optional.empty();
        }

        int newBalance = accounts.get(accountId) + amount;
        accounts.put(accountId, newBalance);
        return Optional.of(newBalance);
    }

    @Override
    public Optional<Integer> transfer(int timestamp, String sourceAccountId, String targetAccountId, int amount){
        processCashbacks(timestamp);
        if (sourceAccountId.equals(targetAccountId)) {
            return Optional.empty();
        }

        if (!accounts.containsKey(sourceAccountId) || 
            !accounts.containsKey(targetAccountId)) {
                return Optional.empty();
        }

        int sourceBalance = accounts.get(sourceAccountId);
        if (sourceBalance < amount) {
            return Optional.empty();
        }

        accounts.put(sourceAccountId, sourceBalance - amount);
        accounts.put(targetAccountId, accounts.get(targetAccountId) + amount);

        outgoing.put(sourceAccountId, outgoing.getOrDefault(sourceAccountId, 0L) + amount);
        return Optional.of(accounts.get(sourceAccountId));
    }

    @Override
    public List<String> topSpenders(int timestamp, int n) {
        processCashbacks(timestamp);
        return outgoing.entrySet()
            .stream()
            .sorte((e1, e2) -> {
                int cmp = Long.compare(e2.getValue(), e1.getValue());
                if (cmp != 0) return cmp;
                return e1.getKey().compareTo(e2.getKey());
            })
            .limit(n)
            .map(e -> e.getKey() + "(" + e.getValue() + ")" )
            .toList();
    }

    @Override
    public Optional<String> pay(int timestamp, String accountId, int amount) {
        processCashbacks(timestamp);

        if (!accounts.containsKey(accountId)) return Optional.empty();
        if (accounts.get(accountId) < amount) return Optional.empty();

        accounts.put(accountId, accounts.get(accountId) - amount);

        outgoing.put(
            accountId,
            outgoing.getOrDefault(accountId, 0L) + amount
        );

        int cashback = (int) Math.floor(amount * 0.02);
        String paymentId = "payment" + (++paymentCounter);

        Payment p = new Payment();
        p.paymentId = paymentId;
        p.accountId = accountId;
        p.amount = amount;
        p.cashback = cashback;
        p.cashbackTimestamp = (long) timestamp + CASHBACK_DELAY;
        p.cashbackProcessed = false;

        payments.put(paymentId, p);
        cashbackQueue.add(p);

        return Optional.of(paymentId);
    }

    @Override
    public Optional<String> getPaymentStatus(
            int timestamp,
            String accountId,
            String paymentId
    ) {
        processCashbacks(timestamp);

        if (!accounts.containsKey(accountId)) return Optional.empty();
        if (!payments.containsKey(paymentId)) return Optional.empty();

        Payment p = payments.get(paymentId);
        if (!p.accountId.equals(accountId)) return Optional.empty();

        return Optional.of(
            p.cashbackProcessed ? "CASHBACK_RECEIVED" : "IN_PROGRESS"
        );
    }

    private void processCashbacks(long currentTimestamp) {
        while (!cashbackQueue.isEmpty()
            && cashbackQueue.peek().cashbackTimestamp <= currentTimestamp) {

            Payment p = cashbackQueue.poll();
            if (!p.cashbackProcessed) {
                accounts.put(
                    p.accountId,
                    accounts.get(p.accountId) + p.cashback
                );
                p.cashbackProcessed = true;
            }
    }
}

}