import java.util.EnumMap;
import java.util.Map;

// Ex 9.5 (Challenge)
enum Coin {
    PENNY(1), NICKEL(5), DIME(10), QUARTER(25);
    private final int cents;
    Coin(int cents) { this.cents = cents; }
    int getCents() { return cents; }

    // Greedy (largest first) gives the fewest coins for these denominations
    static Map<Coin, Integer> fewestCoins(int amount) {
        Map<Coin, Integer> result = new EnumMap<>(Coin.class);
        Coin[] all = values();
        for (int i = all.length - 1; i >= 0; i--) {
            int n = amount / all[i].cents;
            if (n > 0) { result.put(all[i], n); amount %= all[i].cents; }
        }
        return result;
    }
}
public class CoinDemo {
    public static void main(String[] args) {
        System.out.println(Coin.fewestCoins(68));    // 2 quarters, 1 dime, 1 nickel, 3 pennies
        System.out.println(Coin.fewestCoins(30));
        // Note: greedy is only guaranteed optimal for "canonical" coin systems such as this one.
        // With coins {1, 3, 4} and amount 6, greedy picks 4+1+1 (3 coins) but 3+3 (2 coins) is better.
    }
}
