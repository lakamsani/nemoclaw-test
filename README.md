# Stock Price CLI

A simple command-line tool that returns mock last-close stock prices for a given ticker symbol.

## Usage

```
python main.py <ticker>
```

### Example

```
$ python main.py AAPL
AAPL: $175.43
```

## Supported Tickers

AAPL, MSFT, GOOGL, AMZN, TSLA, META, NVDA, JPM, V, WMT

## Running Tests

```
python -m unittest test_main.py
```
