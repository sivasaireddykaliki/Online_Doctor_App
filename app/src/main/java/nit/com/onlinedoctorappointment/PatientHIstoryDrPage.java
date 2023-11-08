package nit.com.onlinedoctorappointment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PatientHIstoryDrPage extends Activity {
    ListView datalist;
    MyDataBaseClass dataBaseClass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_history_page);
        datalist = (ListView) findViewById(R.id.datalist);
        dataBaseClass = new MyDataBaseClass(this);
        String data = dataBaseClass.showAllDatamain("AGENCYCHIEF");
        String[] mydata = data.split("#");
        ArrayAdapter adapter = new ArrayAdapter(PatientHIstoryDrPage.this, android.R.layout.simple_list_item_1, mydata);
        datalist.setAdapter(adapter);
    }
    public void delete(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(PatientHIstoryDrPage.this);
        builder.setTitle("Are you sure do you want to delete Patient Details ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dataBaseClass.deleteAllUserData();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();

    }
}
