public interface BankingSystem {
    default boolean createAccount(int timestamp, String accountId); 

    default Optional<Integer> deposit(int timestamp, String accountId, int amount);

    default Optional<Integer> transfer(int timestamp, String sourceAccountId, String targetAccountId, int amount);

    default List<String> topSpenders(int timestamp, int n);

    default Optional<String> pay(int timestamp, String accountId, int amount);

    default Optional<String> getPaymentStatus(int timestamp, String accountId, String payment);
}