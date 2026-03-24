package main

import (
	"fmt"
	"os"
	"strings"
)

var mockPrices = map[string]float64{
	"AAPL":  175.43,
	"MSFT":  342.12,
	"GOOGL": 142.78,
	"AMZN":  185.67,
	"TSLA":  248.91,
	"META":  498.32,
	"NVDA":  925.50,
	"JPM":   198.45,
	"V":     278.11,
	"WMT":   65.89,
}

func getLastClosePrice(ticker string) (float64, bool) {
	price, ok := mockPrices[strings.ToUpper(ticker)]
	return price, ok
}

func main() {
	if len(os.Args) != 2 {
		fmt.Fprintln(os.Stderr, "Usage: stock_price <ticker>")
		os.Exit(1)
	}

	ticker := os.Args[1]
	price, ok := getLastClosePrice(ticker)
	if !ok {
		fmt.Fprintf(os.Stderr, "Error: Could not retrieve price for symbol '%s'\n", ticker)
		os.Exit(1)
	}

	fmt.Printf("%s: $%.2f\n", strings.ToUpper(ticker), price)
}
