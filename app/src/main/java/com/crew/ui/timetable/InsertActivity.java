package com.crew.ui.timetable;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.crew.R;

import static android.widget.AdapterView.OnItemSelectedListener;

public class InsertActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        
        String[] optionLavala = getResources().getStringArray(R.array.spinnerArray3);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_dropdown_item,optionLavala);
        Spinner obj = (Spinner)findViewById(R.id.Spinner3);
        obj.setAdapter(adapter);
        
        setSpinner(R.id.Spinner4, R.array.spinnerArray4, android.R.layout.simple_spinner_dropdown_item);
        setSpinner(R.id.Spinner5,R.array.spinnerArray5,android.R.layout.simple_spinner_dropdown_item);

        getSpinner(R.id.Spinner3).setOnItemSelectedListener(new OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedView, int position, long id){
                printChecked(selectedView, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });

        getSpinner(R.id.Spinner4).setOnItemSelectedListener(new OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedView, int position, long id){
                printChecked(selectedView, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });

        getSpinner(R.id.Spinner5).setOnItemSelectedListener(new OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedView, int position, long id){
                printChecked(selectedView, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });




    }

    public void printChecked(View v, int position){
        Spinner sp3 = (Spinner)findViewById(R.id.Spinner3);
        Spinner sp4 = (Spinner)findViewById(R.id.Spinner4);
        Spinner sp5 = (Spinner)findViewById(R.id.Spinner5);
        String resultText = "";

        if(sp3.getSelectedItemPosition() > 0){
            resultText = (String)sp3.getAdapter().getItem(sp3.getSelectedItemPosition());
        }

        if(sp4.getSelectedItemPosition() > 0){
            if(!"".equals(resultText))
                resultText+=",";
            resultText = (String)sp4.getAdapter().getItem(sp3.getSelectedItemPosition());
        }

        if(sp5.getSelectedItemPosition() > 0){
            if(!"".equals(resultText))
                resultText+=",";
            resultText = (String)sp5.getAdapter().getItem(sp3.getSelectedItemPosition());
        }
        if(resultText != ""){

        }

    }

    public void setSpinner(int objId, int optionLabelId,int listStyle)
    {
        setSpinner(objId,optionLabelId,-1,listStyle,null);
    }

    public void setSpinner(int objId, int optionLabelId, int optionId, int listStyle, String defaultVal){
        String[] optionLavala = getResources().getStringArray(optionLabelId);
        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item,optionLavala);

        if(listStyle > -1){
            adapter.setDropDownViewResource(listStyle);

            Spinner obj = (Spinner)findViewById(objId);
            obj.setAdapter(adapter);
            if(defaultVal != null){
                String[] optiona = getResources().getStringArray(optionId);
                int thei = 0;
                for(int a = 0; a < optiona.length; a++){
                    if(defaultVal.equals(optiona[a])){
                        thei = a;
                        break;
                    }
                }
                obj.setSelection(adapter.getPosition(optionLavala[thei]));
            }else{
                obj.setSelection(adapter.getPosition(defaultVal));
            }
        }
    }

    public Spinner getSpinner(int objId){
        return (Spinner)findViewById(objId);
    }

    public String getSpinnerVal(int objId)
    {
        return getSpinneVal(objId, null);
    }

    private String getSpinneVal(int objId, String[] optiona){
        String rtn = "";
        Spinner sp = ((Spinner)findViewById(objId));
        if(sp != null){
            int selectedIndex = sp.getSelectedItemPosition();
            if(optiona == null){
                rtn = ""+selectedIndex;
            }else{
                if(optiona.length > selectedIndex){
                    rtn = optiona[selectedIndex];
                }
            }
        }
        return rtn;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_insert, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
