package nit.com.onlinedoctorappointment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class HomePage extends Activity implements AdapterView.OnItemSelectedListener {

    ArrayAdapter adapter_section;
    Spinner spinner_specaility;
    String selected_specaility;
    Button btn_contact_to_dr;
    String label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        spinner_specaility = (Spinner) findViewById(R.id.spinner2);
        btn_contact_to_dr = (Button) findViewById(R.id.button5);

        adapter_section = ArrayAdapter.createFromResource(this, R.array.Specaility, android.R.layout.simple_spinner_item);
        adapter_section.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_specaility.setAdapter(adapter_section);
         selected_specaility = spinner_specaility.getSelectedItem().toString();



    }

    public void logout(View v) {
        startActivity(new Intent(getApplicationContext(), SelectorClass.class));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        label = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "You selected: " + label, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public void contactToDoctor(View view) {
        opennewpage();
    }

    private void opennewpage() {
        Intent intent = new Intent(this, SelectDoctorFromList.class);
        startActivity(intent);
        Intent intentdata = new Intent(this, SelectDoctorFromList.class);
        intentdata.putExtra("speciality", selected_specaility);
        startActivity(intentdata);

    }
}


