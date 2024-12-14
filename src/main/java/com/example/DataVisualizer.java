package com.example;
import java.util.Date;
import java.util.List;

import org.knowm.xchart.OHLCChart;
import org.knowm.xchart.OHLCChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler;

public class DataVisualizer {
    
    public static void drawChart(List<Date> date, List<Double> open, List<Double> high, List<Double> low, List<Double> close)
    {
        OHLCChart chart = new OHLCChartBuilder()
            .width(800)
            .height(600)
            .title("OHLC Chart")
            .build();

        chart.addSeries("Actual Prices", date, open, high, low, close);

        chart.getStyler()
            .setChartBackgroundColor(java.awt.Color.WHITE)          
            .setLegendVisible(true)                                
            .setLegendPosition(Styler.LegendPosition.InsideNE);        
       


        new SwingWrapper<>(chart).displayChart();
    }
}
