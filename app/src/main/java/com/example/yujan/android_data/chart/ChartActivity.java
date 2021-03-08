package com.example.yujan.android_data.chart;

import android.graphics.Color;
import android.os.Bundle;

import com.example.yujan.android_data.R;
import com.example.yujan.android_data.sjms.base.BaseActivity;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class ChartActivity extends BaseActivity {
    private LineChart mLineChart;
    private BarChart mBarChart;
    private HorizontalBarChart mBarChart_hor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        setBarChart();
        setBarChart1();
        setBarChartHor();
    }

    /**
     * 设置折线图
     */
    private void setBarChart() {
        mLineChart = findViewById(R.id.mLineChart);
        int[] x = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] y = {22, 35, 29, 27, 34, 36, 22, 35};
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < x.length; i++) {
            entries.add(new Entry(x[i], y[i]));
        }
        LineDataSet dataSet = new LineDataSet(entries, "1月份业绩");
        dataSet.setColor(Color.GREEN);
        dataSet.setFormSize(15f);

        int[] x1 = {1, 2, 3, 4, 5, 6, 7, 8,};
        int[] y1 = {15, 30, 40, 37, 40, 46, 15, 30};
        List<Entry> entries1 = new ArrayList<>();
        for (int i = 0; i < x1.length; i++) {
            entries1.add(new Entry(x1[i], y1[i]));
        }
        LineDataSet dataSet1 = new LineDataSet(entries1, "2月份业绩");
        dataSet1.setColor(Color.RED);
        dataSet1.setFormSize(15f);

        // 使用ILineDataSet接口
        List<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(dataSet);
        dataSets.add(dataSet1);

        LineData lineData = new LineData(dataSets);
        mLineChart.setData(lineData);
        mLineChart.invalidate();

        //标记信息
        Description description = new Description();
        description.setText("");
        mLineChart.setDescription(description);
        //x轴
        XAxis xAxis = mLineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(15f);
        xAxis.setTextColor(Color.BLUE);
        xAxis.setDrawAxisLine(true);
        //y轴
        // 左边区域
        YAxis left = mLineChart.getAxisLeft();
        left.setDrawLabels(true);//不设置坐标轴数据标签
        left.setDrawAxisLine(true);// 不绘制坐标轴线
        left.setDrawGridLines(true);//不绘制网格线
        left.setTextColor(Color.BLACK);
        left.setTextSize(12f);
        //绘制零线
        left.setDrawZeroLine(true);
        left.setZeroLineColor(Color.GREEN);
        left.setZeroLineWidth(5);
        // 右边区域
        YAxis right = mLineChart.getAxisRight();
        right.setDrawLabels(false);//不设置坐标轴数据标签
        right.setDrawAxisLine(false);// 不绘制坐标轴线
        right.setDrawGridLines(false);//不绘制网格线
        right.setTextColor(Color.BLUE);
        right.setTextSize(12f);
        //绘制零线
        left.setDrawZeroLine(true);
        left.setZeroLineColor(Color.GRAY);
        left.setZeroLineWidth(5);
        /** 图例的属性 */
        Legend l = mLineChart.getLegend();
        l.setEnabled(false);
        //决定底部图例的位置。
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(true);
        l.setForm(Legend.LegendForm.LINE);
        l.setFormSize(9f);
        l.setTextSize(11f);
        l.setXEntrySpace(10f);
        l.setYEntrySpace(10f);
        //设置双击,两指拉伸等交互的开关
        mLineChart.setScaleEnabled(false);
        mLineChart.setDoubleTapToZoomEnabled(false);
    }

    /**
     * 柱状图
     */
    private void setBarChart1() {
        mBarChart = findViewById(R.id.mBarChart);
        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, new float[]{20f, 15f}));
        entries.add(new BarEntry(1f, new float[]{50f, 0f}));
        entries.add(new BarEntry(3f, new float[]{40f, 20f}));
        entries.add(new BarEntry(4f, new float[]{60f, 0f}));
        entries.add(new BarEntry(5f, new float[]{20f, 10f}));
        entries.add(new BarEntry(6f, new float[]{50f, 5f}));
        BarDataSet set = new BarDataSet(entries, "");
        set.setStackLabels(new String[]{"nihao", "xzb"});
        //设置柱状图颜色 单个 多个
        set.setColors(new int[]{Color.GREEN, Color.RED});
        //设置柱状图顶部不显示数值
        set.setDrawValues(true);
        BarData data = new BarData(set);
        data.setBarWidth(0.9f);//设置数据条的宽度
        data.setValueTextColor(Color.RED);
        mBarChart.setData(data);
        mBarChart.setFitBars(true);// 让X轴与所有的数据条适配
        mBarChart.invalidate();
        //标记信息
        Description description = new Description();
        description.setText("");
        mBarChart.setDescription(description);
        //设置双击,两指拉伸等交互的开关
        mBarChart.setScaleEnabled(false);
        mBarChart.setDoubleTapToZoomEnabled(false);
    }

    /**
     * 柱状图(横向)
     */
    private void setBarChartHor() {
        mBarChart_hor = findViewById(R.id.mBarChart_hor);
        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, 30f));
        entries.add(new BarEntry(1f, 20f));
        entries.add(new BarEntry(3f, 50f));
        entries.add(new BarEntry(4f, 30f));
        entries.add(new BarEntry(5f, 40f));
        BarDataSet set = new BarDataSet(entries, "");
        set.setStackLabels(new String[]{"nihao", "xzb"});
        //设置柱状图颜色 单个 多个
        set.setColors(Color.GREEN);
        //设置柱状图顶部不显示数值
        set.setDrawValues(true);
        BarData data = new BarData(set);
        data.setBarWidth(0.9f);//设置数据条的宽度
        data.setValueTextColor(Color.RED);
        mBarChart_hor.setData(data);
        mBarChart_hor.setFitBars(true);// 让X轴与所有的数据条适配
        mBarChart_hor.invalidate();
        //标记信息
        Description description = new Description();
        description.setText("");
        mBarChart_hor.setDescription(description);
        //设置双击,两指拉伸等交互的开关
        mBarChart_hor.setScaleEnabled(false);
        mBarChart_hor.setDoubleTapToZoomEnabled(false);
    }
}
