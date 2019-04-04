package com.celsius.customstocks.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.celsius.customstocks.R;
import com.celsius.customstocks.databinding.FragmentQuoteBinding;
import com.celsius.customstocks.databinding.FragmentSettingsBinding;
import com.celsius.customstocks.datamodels.Quote;
import com.celsius.customstocks.services.PullChartDataFromIEXService;
import com.celsius.customstocks.services.PullMarketsDataFromIEXService;
import com.celsius.customstocks.utils.ReciverServiceConsts;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import static com.celsius.customstocks.utils.ReciverServiceConsts.QUOTE_DATA;

public class QuoteFragment extends BaseFragment {

    public final static String TAG = "QuoteFragment";
    private View view;
    private FragmentQuoteBinding binding;
    private Quote quote;

    private LineChart chart;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quote, container, false);
        view = binding.getRoot();


        quote = (Quote) getArguments().getSerializable(QUOTE_DATA);
        binding.setQuote(quote);

        ////////////////// CHART

        chart = view.findViewById(R.id.quote_chart);
        chart.setViewPortOffsets(0, 0, 0, 0);
        chart.setBackgroundColor(Color.WHITE);

        // no description text
        chart.getDescription().setEnabled(false);

        // enable touch gestures
        chart.setTouchEnabled(false);

        // enable scaling and dragging
        chart.setDragEnabled(false);
        chart.setScaleEnabled(true);

        // if disabled, scaling can be done on x- and y-axis separately
        chart.setPinchZoom(false);

        chart.setDrawGridBackground(false);
        chart.setMaxHighlightDistance(300);


        XAxis x = chart.getXAxis();
        x.setEnabled(false);

        YAxis y = chart.getAxisLeft();
        //y.setTypeface(tfLight);
        y.setLabelCount(6, false);
        y.setTextColor(Color.GRAY);
        y.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);
        y.setDrawGridLines(false);
        y.setAxisLineColor(Color.WHITE);

        chart.getAxisRight().setEnabled(false);

        // add data
        //seekBarY.setOnSeekBarChangeListener(this);
        //seekBarX.setOnSeekBarChangeListener(this);

        // lower max, as cubic runs significantly slower than linear
        //seekBarX.setMax(700);

        //seekBarX.setProgress(45);
        // seekBarY.setProgress(100);

        chart.getLegend().setEnabled(false);

        chart.animateXY(2000, 2000);

        // don't forget to refresh the drawing
        chart.invalidate();

        /////////////////// CHART

        Intent intent = new Intent(getActivity(), PullChartDataFromIEXService.class);
        intent.putExtra(ReciverServiceConsts.DATA_TYPE_KEY, ReciverServiceConsts.GET_CHART_DATA);
        intent.putExtra(ReciverServiceConsts.QUOTE_DATA, quote);
        getActivity().startService(intent);

        return view;
    }

    public void updateChartDataOnChartFragmet(){

        int count = helper.getChart().size();
        //float range = (float) helper.getChart().;

        ArrayList<Entry> values = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            float val = (float) (Float.valueOf(helper.getChart().get(i).getClose()) + 1) ;
            values.add(new Entry(i, val));
        }

        LineDataSet set1;

        if (chart.getData() != null &&
                chart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) chart.getData().getDataSetByIndex(0);
            set1.setValues(values);
            chart.getData().notifyDataChanged();
            chart.notifyDataSetChanged();
        } else {
            // create a dataset and give it a type
            set1 = new LineDataSet(values, "DataSet 1");

            set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);
            set1.setCubicIntensity(0.2f);
            set1.setDrawFilled(true);
            set1.setDrawCircles(false);
            set1.setLineWidth(1.8f);
            set1.setCircleRadius(4f);
            set1.setCircleColor(getResources().getColor(R.color.quote_chart_color));
            //set1.setHighLightColor(getResources().getColor(R.color.market_chart_end_color));
            set1.setColor(getResources().getColor(R.color.quote_chart_color));
            set1.setFillColor(getResources().getColor(R.color.quote_chart_color));
            set1.setFillAlpha(100);
            set1.setDrawHorizontalHighlightIndicator(false);
//            set1.setFillFormatter(new IFillFormatter() {
//                @Override
//                public float getFillLinePosition(ILineDataSet dataSet, LineDataProvider dataProvider) {
//                    return chart.getAxisLeft().getAxisMinimum();
//                }
//            });

            // create a data object with the data sets
            LineData data = new LineData(set1);
            //data.setValueTypeface(tfLight);
            data.setValueTextSize(9f);
            data.setDrawValues(false);

            // set data
            chart.setData(data);
        }
    }


}
