package com.yctech.myapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

public class PieChart extends Activity {
    private String mResultItems[] = {"待处理","待上传"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        double[] values = new double[] { 90, 10 };
        int[] colors = new int[] { Color.BLUE, Color.GREEN };
        DefaultRenderer renderer = buildCategoryRenderer(colors);
        renderer.setZoomButtonsVisible(true);
        renderer.setZoomEnabled(false);
        renderer.setChartTitleTextSize(20);
        //        Intent intent = ChartFactory.getPieChartIntent(this, buildCategoryDataset("Project budget", values), renderer, "Budget");
        //        startActivity(intent);
        View view = ChartFactory.getPieChartView(this, buildCategoryDataset("工单", values), renderer);
        view.setBackgroundColor(Color.BLACK);
        setContentView(view);
    }
    protected DefaultRenderer buildCategoryRenderer(int[] colors) {
        DefaultRenderer renderer = new DefaultRenderer();
        renderer.setLabelsTextSize(15);
        renderer.setLegendTextSize(15);
        renderer.setMargins(new int[] { 20, 30, 15, 0 });
        for (int color : colors) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(color);
            renderer.addSeriesRenderer(r);
        }
        return renderer;
    }

    protected CategorySeries buildCategoryDataset(String title, double[] values) {
        CategorySeries series = new CategorySeries(title);
        int k = 0;
        for (double value : values) {
            series.add(mResultItems[k++], value);
        }
        return series;
    }
}