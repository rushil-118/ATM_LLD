public interface IBankServer {
    Account getAccInfo(Card card);
    boolean sendTransaction(ITransaction transaction);
}
