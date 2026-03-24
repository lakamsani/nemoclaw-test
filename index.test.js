import { test } from 'node:test';
import assert from 'node:assert/strict';
import { getLastClosePrice } from './index.js';

test('TestKnownTickerAAPL', () => {
  const { price, ok } = getLastClosePrice('AAPL');
  assert.ok(ok, 'expected price for AAPL, got not found');
  assert.strictEqual(price, 175.43);
});

test('TestKnownTickerMSFT', () => {
  const { price, ok } = getLastClosePrice('MSFT');
  assert.ok(ok, 'expected price for MSFT, got not found');
  assert.strictEqual(price, 342.12);
});

test('TestInvalidTicker', () => {
  const { ok } = getLastClosePrice('INVALID');
  assert.strictEqual(ok, false, 'expected not found for INVALID ticker');
});

test('TestEmptyTicker', () => {
  const { ok } = getLastClosePrice('');
  assert.strictEqual(ok, false, 'expected not found for empty ticker');
});
