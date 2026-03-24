package main

import (
	"testing"
)

func TestKnownTickerAAPL(t *testing.T) {
	price, ok := getLastClosePrice("AAPL")
	if !ok {
		t.Fatal("expected price for AAPL, got not found")
	}
	if price != 175.43 {
		t.Errorf("expected 175.43, got %f", price)
	}
}

func TestKnownTickerMSFT(t *testing.T) {
	price, ok := getLastClosePrice("MSFT")
	if !ok {
		t.Fatal("expected price for MSFT, got not found")
	}
	if price != 342.12 {
		t.Errorf("expected 342.12, got %f", price)
	}
}

func TestInvalidTicker(t *testing.T) {
	_, ok := getLastClosePrice("INVALID")
	if ok {
		t.Error("expected not found for INVALID ticker")
	}
}

func TestEmptyTicker(t *testing.T) {
	_, ok := getLastClosePrice("")
	if ok {
		t.Error("expected not found for empty ticker")
	}
}
