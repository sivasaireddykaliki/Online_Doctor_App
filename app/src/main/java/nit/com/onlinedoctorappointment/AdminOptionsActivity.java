package nit.com.onlinedoctorappointment;

import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class AdminOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_options);
    }

    public void adddoctore(View view) {
        startActivity(new Intent(getApplicationContext(), AdminPage.class));
    }

    public void userdetails(View view) {
        startActivity(new Intent(getApplicationContext(), UserDetailsActivity.class));
    }

    public void Doctordetails(View view) {
        startActivity(new Intent(getApplicationContext(), DoctoreDetailsActivity.class));
    }
}








