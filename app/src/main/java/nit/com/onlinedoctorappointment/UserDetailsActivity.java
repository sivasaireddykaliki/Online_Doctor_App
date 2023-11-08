package nit.com.onlinedoctorappointment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class UserDetailsActivity extends AppCompatActivity {
    ListView lv;
    DataBaseClassAdapter dataBaseClassAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        lv = (ListView) findViewById(R.id.details_lv1);
        dataBaseClassAdapter = new DataBaseClassAdapter(this);
        String str= dataBaseClassAdapter.alluserdata();
        String[] mydata= str.split("#");
        ArrayAdapter adapter = new ArrayAdapter(UserDetailsActivity.this,android.R.layout.simple_list_item_1,mydata);
        lv.setAdapter(adapter);

    }
}
