build:
	javac -d out src/StockPrice.java

test:
	javac -d out src/StockPrice.java src/StockPriceTest.java && java -cp out StockPriceTest

run:
	java -cp out StockPrice $(TICKER)

clean:
	rm -rf out
