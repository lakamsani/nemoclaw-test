import java.util.Optional;

public class StockPriceTest {
    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {
        testKnownTickerAAPL();
        testKnownTickerMSFT();
        testInvalidTicker();
        testEmptyTicker();

        System.out.printf("Tests passed: %d, failed: %d%n", passed, failed);
        if (failed > 0) {
            System.exit(1);
        }
    }

    static void testKnownTickerAAPL() {
        Optional<Double> price = StockPrice.getLastClosePrice("AAPL");
        if (!price.isPresent()) {
            fail("testKnownTickerAAPL", "expected price for AAPL, got not found");
            return;
        }
        if (price.get() != 175.43) {
            fail("testKnownTickerAAPL", "expected 175.43, got " + price.get());
            return;
        }
        pass("testKnownTickerAAPL");
    }

    static void testKnownTickerMSFT() {
        Optional<Double> price = StockPrice.getLastClosePrice("MSFT");
        if (!price.isPresent()) {
            fail("testKnownTickerMSFT", "expected price for MSFT, got not found");
            return;
        }
        if (price.get() != 342.12) {
            fail("testKnownTickerMSFT", "expected 342.12, got " + price.get());
            return;
        }
        pass("testKnownTickerMSFT");
    }

    static void testInvalidTicker() {
        Optional<Double> price = StockPrice.getLastClosePrice("INVALID");
        if (price.isPresent()) {
            fail("testInvalidTicker", "expected not found for INVALID ticker");
            return;
        }
        pass("testInvalidTicker");
    }

    static void testEmptyTicker() {
        Optional<Double> price = StockPrice.getLastClosePrice("");
        if (price.isPresent()) {
            fail("testEmptyTicker", "expected not found for empty ticker");
            return;
        }
        pass("testEmptyTicker");
    }

    static void pass(String name) {
        System.out.println("PASS: " + name);
        passed++;
    }

    static void fail(String name, String message) {
        System.out.println("FAIL: " + name + " — " + message);
        failed++;
    }
}
