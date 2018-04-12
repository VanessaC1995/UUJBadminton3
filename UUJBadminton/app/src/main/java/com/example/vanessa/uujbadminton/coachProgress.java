package com.example.vanessa.uujbadminton;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

public class coachProgress extends AppCompatActivity {
    /*Button btnInsert;
    EditText xInput, yInput;
    GraphView graph;
    BarGraphSeries<DataPoint> series;
    DatabaseHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_progress);

        btnInsert = (Button) findViewById(R.id.btnInsert);
        xInput = (EditText) findViewById(R.id.tbXVal);
        yInput = (EditText) findViewById(R.id.tbYVal);
        graph = (GraphView) findViewById(R.id.graph);

        dbHelper= new DatabaseHelper(this);
        sqLiteDatabase = dbHelper.getWritableDatabase();

        exqButton();


        GraphView graphView = (GraphView) findViewById(R.id.graph);

        BarGraphSeries<DataPoint> series=new BarGraphSeries<>(getData());
        graphView.addSeries(series);

        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(Color.RED);

        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint dataPoint) {
                if (dataPoint.getY()>6)
                 return Color.GREEN;
                else if (dataPoint.getY()>4)
                    return Color.BLUE;
                else
                    return (Color.rgb(252,55,15));
            }
        });
    }

    private void exqButton() {

        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int xVal=Integer.parseInt(String.valueOf(xInput.getText()));
                int yVal=Integer.parseInt(String.valueOf(yInput.getText()));

                dbHelper.insertData(xVal, yVal);

                series = new BarGraphSeries<DataPoint>(getData());
                graph.addSeries(series);
            }
        });
    }

    private DataPoint[] getData() {
        //read data from database
        String[] columns = {"xValues", "yValues"};
        Cursor cursor = sqLiteDatabase.query("Progress", columns, null, null, null, null, null);

        DataPoint[] dp = new DataPoint[cursor.getCount()];

        for (int i=0;i<cursor.getCount();i++)
        {
            cursor.moveToNext();
            dp[i]=new DataPoint(cursor.getInt(0),cursor.getInt(1));
        }
        return dp;
    }*/



}
