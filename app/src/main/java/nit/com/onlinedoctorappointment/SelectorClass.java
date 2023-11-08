package nit.com.onlinedoctorappointment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SelectorClass extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selector_class);
    }

    public void userClick(View view) {
        Intent i = new Intent(getBaseContext(), Login.class);
        startActivity(i);
    }

    public void doctorClick(View view) {
        Intent intent = new Intent(getApplicationContext(), DoctoreLoginPageActivity.class);
        startActivity(intent);
    }

    public void adminClick(View view) {
        Intent i = new Intent(getBaseContext(), Login.class);
        startActivity(i);
    }


}


