package com.example.vanessa.uujbadminton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Progress extends AppCompatActivity {

    BarChart barChart;
    ArrayList<String> dates;
    Random random;
    ArrayList<BarEntry> enteries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        barChart = (BarChart) findViewById(R.id.histogram);

        createRandomBarGraph("2018/01/29", "2018/02/29");
    }

    public void createRandomBarGraph(String Date1, String Date2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

        try {
            Date date1 = simpleDateFormat.parse(Date1);
            Date date2 = simpleDateFormat.parse(Date2);

            Calendar nDate1 = Calendar.getInstance();
            Calendar nDate2 = Calendar.getInstance();
            nDate1.clear();
            nDate2.clear();

            nDate1.setTime(date1);
            nDate2.setTime(date2);

            dates = new ArrayList<>();
            dates = getList(nDate1, nDate2);

            enteries = new ArrayList<>();
            float max =0f;
            float value = 0f;
            random = new Random();
            for (int j = 0; j< dates.size();j++){
                max = 100f;
                value = random.nextFloat()*max;
                enteries.add(new BarEntry(value, j));

            }

        }catch(ParseException e){
            e.printStackTrace();
        }
        BarDataSet barDataSet = new BarDataSet(enteries, "Dates");
       // BarData barData = new BarData(dates, barDataSet);
      //  barChart.setData(barData);
       // barChart.setDescription("Progress");



    }

    public ArrayList<String> getList(Calendar startDate, Calendar endDate){
        ArrayList<String> list = new ArrayList<>();
        while(startDate.compareTo(endDate)<=0){
            list.add(getDate(startDate));
            startDate.add(Calendar.DAY_OF_MONTH,1);
        }
        return list;
    }

    public String getDate(Calendar cld){
        String curDate = cld.get(Calendar.YEAR) + "/" + (cld.get(Calendar.MONTH) + 1 ) +
                "/" + cld.get(Calendar.DAY_OF_MONTH);
        try{
            Date date = new SimpleDateFormat("yyyy/MM/dd").parse(curDate);
            curDate = new SimpleDateFormat("yyyy/MM/dd").format(date);
        }catch(ParseException e){
            e.printStackTrace();
        }
        return  curDate;

    }
}
