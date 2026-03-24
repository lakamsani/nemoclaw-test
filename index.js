const mockPrices = {
  AAPL: 175.43,
  MSFT: 342.12,
  GOOGL: 142.78,
  AMZN: 185.67,
  TSLA: 248.91,
  META: 498.32,
  NVDA: 925.50,
  JPM: 198.45,
  V: 278.11,
  WMT: 65.89,
};

export function getLastClosePrice(ticker) {
  const upper = ticker.toUpperCase();
  if (Object.prototype.hasOwnProperty.call(mockPrices, upper)) {
    return { price: mockPrices[upper], ok: true };
  }
  return { price: 0, ok: false };
}

if (process.argv[1] === new URL(import.meta.url).pathname) {
  if (process.argv.length !== 3) {
    process.stderr.write('Usage: stock_price <ticker>\n');
    process.exit(1);
  }

  const ticker = process.argv[2];
  const { price, ok } = getLastClosePrice(ticker);
  if (!ok) {
    process.stderr.write(`Error: Could not retrieve price for symbol '${ticker}'\n`);
    process.exit(1);
  }

  process.stdout.write(`${ticker.toUpperCase()}: $${price.toFixed(2)}\n`);
}
