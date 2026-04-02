import sys

MOCK_PRICES = {
    "AAPL": 175.43,
    "MSFT": 342.12,
    "GOOGL": 142.78,
    "AMZN": 185.67,
    "TSLA": 248.91,
    "META": 498.32,
    "NVDA": 925.50,
    "JPM": 198.45,
    "V": 278.11,
    "WMT": 65.89,
}


def get_last_close_price(ticker):
    return MOCK_PRICES.get(ticker.upper() if ticker else "")


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: stock_price <ticker>", file=sys.stderr)
        sys.exit(1)

    ticker = sys.argv[1]
    price = get_last_close_price(ticker)
    if price is None:
        print(f"Error: Could not retrieve price for symbol '{ticker}'", file=sys.stderr)
        sys.exit(1)

    print(f"{ticker.upper()}: ${price:.2f}")
