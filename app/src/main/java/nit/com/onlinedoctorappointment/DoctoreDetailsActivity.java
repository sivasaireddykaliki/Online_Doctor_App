package nit.com.onlinedoctorappointment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DoctoreDetailsActivity extends AppCompatActivity {
    ListView doc_lv;
    DataBaseClassAdminAdapter dataBaseClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctore_details);
        doc_lv=(ListView)findViewById(R.id.doc_lv);
        dataBaseClass = new DataBaseClassAdminAdapter(this);
        String str= dataBaseClass.getalldatamain();
        String []alldata= str.split("#");
        ArrayAdapter adapter= new ArrayAdapter(DoctoreDetailsActivity.this,android.R.layout.simple_list_item_1,alldata);
        doc_lv.setAdapter(adapter);


    }
}
