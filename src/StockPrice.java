import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StockPrice {
    private static final Map<String, Double> MOCK_PRICES = new HashMap<>();

    static {
        MOCK_PRICES.put("AAPL",  175.43);
        MOCK_PRICES.put("MSFT",  342.12);
        MOCK_PRICES.put("GOOGL", 142.78);
        MOCK_PRICES.put("AMZN",  185.67);
        MOCK_PRICES.put("TSLA",  248.91);
        MOCK_PRICES.put("META",  498.32);
        MOCK_PRICES.put("NVDA",  925.50);
        MOCK_PRICES.put("JPM",   198.45);
        MOCK_PRICES.put("V",     278.11);
        MOCK_PRICES.put("WMT",    65.89);
    }

    public static Optional<Double> getLastClosePrice(String ticker) {
        if (ticker == null || ticker.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(MOCK_PRICES.get(ticker.toUpperCase()));
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: stock_price <ticker>");
            System.exit(1);
        }

        String ticker = args[0];
        Optional<Double> price = getLastClosePrice(ticker);
        if (!price.isPresent()) {
            System.err.printf("Error: Could not retrieve price for symbol '%s'%n", ticker);
            System.exit(1);
        }

        System.out.printf("%s: $%.2f%n", ticker.toUpperCase(), price.get());
    }
}
