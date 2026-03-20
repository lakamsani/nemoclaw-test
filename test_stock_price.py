import unittest
from stock_price import get_last_close_price

class TestStockPrice(unittest.TestCase):

    def test_positive_case_known_ticker(self):
        # Test with a ticker that should return a mock price
        price = get_last_close_price('AAPL')
        self.assertIsNotNone(price)
        self.assertIsInstance(price, float)
        # Check that it's approximately the mock value (we know from the mock data)
        self.assertAlmostEqual(price, 175.43, places=2)

    def test_positive_case_another_ticker(self):
        price = get_last_close_price('MSFT')
        self.assertIsNotNone(price)
        self.assertIsInstance(price, float)
        self.assertAlmostEqual(price, 342.12, places=2)

    def test_negative_case_invalid_ticker(self):
        # Test with a ticker not in mock data
        price = get_last_close_price('INVALID')
        self.assertIsNone(price)

    def test_negative_case_empty_string(self):
        price = get_last_close_price('')
        self.assertIsNone(price)

if __name__ == '__main__':
    unittest.main()