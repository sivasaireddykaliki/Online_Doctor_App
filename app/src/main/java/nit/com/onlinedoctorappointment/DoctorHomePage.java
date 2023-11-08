package nit.com.onlinedoctorappointment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class DoctorHomePage extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_home_page);

    }
    public  void patientHistory(View view){
        Intent intent=new Intent(this,PatientHIstoryDrPage.class);
        startActivity(intent);

    }
    public  void updateDetail(View view){
        Intent intent=new Intent(this,DoctorUpdateDetail.class);
        startActivity(intent);
    }
}
