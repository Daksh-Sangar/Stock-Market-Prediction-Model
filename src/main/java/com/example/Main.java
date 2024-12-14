package com.example;

public class Main {
    public static void main(String[] args){
        //System.out.println(StockDataFetcher.fetchStocks("AAPL"));
        String x = StockDataFetcher.fetchStocks("AAPL");
        System.out.println(x);
        StockDataParser.parseData(x);

    }

}
