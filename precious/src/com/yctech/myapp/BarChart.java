package com.yctech.myapp;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

import java.util.ArrayList;
import java.util.List;
public class BarChart extends Activity {
    private GraphicalView mChartView;

    public void back(View v) {
    }

    protected void setChartSettings(XYMultipleSeriesRenderer renderer,
                                    String title, String xTitle, String yTitle, double xMin,
                                    double xMax, double yMin, double yMax, int axesColor,
                                    int labelsColor) {
        renderer.setChartTitle(title);
        renderer.setXTitle(xTitle);
        renderer.setYTitle(yTitle);
        renderer.setXAxisMin(xMin);
        renderer.setXAxisMax(xMax);
        renderer.setYAxisMin(yMin);
        renderer.setYAxisMax(yMax);
        renderer.setAxesColor(axesColor);
        renderer.setLabelsColor(labelsColor);
    }

    protected XYMultipleSeriesRenderer buildBarRenderer(int[] colors) {
        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
        renderer.setAxisTitleTextSize(16);
        renderer.setChartTitleTextSize(20);
        renderer.setLabelsTextSize(15);
        renderer.setLegendTextSize(15);
        int length = colors.length;
        for (int i = 0; i < length; i++) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(colors[i]);
            renderer.addSeriesRenderer(r);
        }
        return renderer;
    }

    protected XYMultipleSeriesDataset buildBarDataset(String[] titles,
                                                      List<double[]> values) {//柱形图的数据源和饼图差不多，也是由一些键值对组成
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        int length = titles.length;
        for (int i = 0; i < length; i++) {
            CategorySeries series = new CategorySeries(titles[i]);
            double[] v = values.get(i);
            int seriesLength = v.length;
            for (int k = 0; k < seriesLength; k++) {
                series.add(v[k]);
            }
            dataset.addSeries(series.toXYSeries());
        }
        return dataset;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_chart);
        LinearLayout mLinear = (LinearLayout) findViewById(R.id.chart);
        mLinear.setBackgroundColor(Color.BLACK);

        String[] titles = new String[] { "2016" };
        List<double[]> values = new ArrayList<double[]>();
        values.add(new double[] { 100,10 });
        int[] colors = new int[] { Color.RED };
        XYMultipleSeriesRenderer renderer = buildBarRenderer(colors);// 柱形图颜色设置
        setChartSettings(renderer, "工单", "种类", "数量", 0.5, 2.5, 0, 120,
                Color.GRAY, Color.LTGRAY);// 设置柱形图标题，横轴（X轴）、纵轴（Y轴）、最小的伸所刻度、最大的伸所刻度
        renderer.getSeriesRendererAt(0).setDisplayChartValues(true);// 在第0条柱形图上显示数据
        renderer.setXLabels(12);
        renderer.setYLabels(10);
        renderer.setXLabelsAlign(Paint.Align.LEFT);// 数据从左到右显示
        renderer.setYLabelsAlign(Paint.Align.LEFT);
        renderer.setPanEnabled(true, false);
        renderer.setZoomEnabled(true);
        renderer.setZoomButtonsVisible(true);// 显示放大缩小功能按钮
        renderer.setZoomRate(1.1f);
        renderer.setBarSpacing(0.5f);// 柱形图间隔

        if (mChartView == null) {// 构建柱形图
            mChartView = ChartFactory.getBarChartView(getApplicationContext(),
                    buildBarDataset(titles, values), renderer, org.achartengine.chart.BarChart.Type.DEFAULT);
            renderer.setClickEnabled(true);
            //renderer.set
            mLinear.addView(mChartView, new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
        } else
            mChartView.repaint();
    }
}