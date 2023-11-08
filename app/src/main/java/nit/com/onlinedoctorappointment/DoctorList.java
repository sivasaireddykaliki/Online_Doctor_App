package nit.com.onlinedoctorappointment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class DoctorList extends Activity implements AdapterView.OnItemClickListener {
    DataBaseClassAdminAdapter dataBaseClass;
    ListView listView;
    String[] index;
    String[] val;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_list);

        String data;
        listView = (ListView) findViewById(R.id.dr_lv);
        dataBaseClass = new DataBaseClassAdminAdapter(this);
        String selected_specaility = getIntent().getExtras().getString("speciality");
        data = dataBaseClass.getDocterData(selected_specaility);
        if (data != null) {
            String[] mydata = data.split("\n");
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mydata);
            listView.setAdapter(arrayAdapter);
            listView.setOnItemClickListener(this);
        } else {
            Toast.makeText(getApplicationContext(), "enter correct phoneno", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    }
}
