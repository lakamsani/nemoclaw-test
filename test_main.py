import unittest
from main import get_last_close_price


class TestGetLastClosePrice(unittest.TestCase):

    def test_known_ticker_aapl(self):
        price = get_last_close_price("AAPL")
        self.assertIsNotNone(price, "expected price for AAPL, got None")
        self.assertEqual(price, 175.43)

    def test_known_ticker_msft(self):
        price = get_last_close_price("MSFT")
        self.assertIsNotNone(price, "expected price for MSFT, got None")
        self.assertEqual(price, 342.12)

    def test_invalid_ticker(self):
        price = get_last_close_price("INVALID")
        self.assertIsNone(price, "expected None for INVALID ticker")

    def test_empty_ticker(self):
        price = get_last_close_price("")
        self.assertIsNone(price, "expected None for empty ticker")


if __name__ == "__main__":
    unittest.main()
