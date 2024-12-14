package com.example;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;

public class StockDataParser{

    public static void parseData(String jsonString){
    
        List<Date> date = new ArrayList<>();
        List<Double> open = new ArrayList<>();
        List<Double> high = new ArrayList<>(); 
        List<Double> low = new ArrayList<>(); 
        List<Double> close = new ArrayList<>();
        
        try{
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONObject timeSeries = jsonObject.getJSONObject("Time Series (Daily)");
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            for(String dateData : timeSeries.keySet())
            {
                JSONObject day = timeSeries.getJSONObject(dateData);

                open.add(day.getDouble("1. open"));
                high.add(day.getDouble("2. high"));
                low.add(day.getDouble("3. low"));
                close.add(day.getDouble("4. close"));

                Date dateObj = sdf.parse(dateData);

                date.add(dateObj);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        DataVisualizer.drawChart(date, open, high, low, close);

    }

}