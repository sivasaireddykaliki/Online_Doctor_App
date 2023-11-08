package nit.com.onlinedoctorappointment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends Activity {
    EditText et_fullname, et_rollno;
    Button blogin, sign_up, bforgotpwd, bgoogleplus;
    DataBaseClassAdapter dataBaseClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        et_fullname = (EditText) findViewById(R.id.editText7);
        et_rollno = (EditText) findViewById(R.id.editText8);
        blogin = (Button) findViewById(R.id.button7);
        sign_up = (Button) findViewById(R.id.button22);
        et_fullname.requestFocus();
        dataBaseClass = new DataBaseClassAdapter(this);
    }

    public void signUP(View view) {
        Intent intent = new Intent(this, RegisterPage.class);
        startActivity(intent);
    }

    public void myLogin(View view) {
        String enteredfullname = et_fullname.getText().toString().trim();
        String enteredrollno = et_rollno.getText().toString().trim();

        SharedPreferences.Editor editor = getSharedPreferences("UserDetail", MODE_PRIVATE).edit();

        editor.putString("uname", enteredfullname);
        editor.putString("rollno", enteredrollno);
        editor.commit();

        if (enteredfullname.equalsIgnoreCase("admin@gmail.com") & enteredrollno.equalsIgnoreCase("admin")) {
            Toast.makeText(this, "Username and password is correct", Toast.LENGTH_SHORT).show();

           // Intent intentadmin = new Intent(this, AdminPage.class);
            Intent intentadmin = new Intent(this, AdminOptionsActivity.class);
            // Intent intentadmin = new Intent(this, HomePage.class);
            startActivity(intentadmin);
        } else {
            boolean f = dataBaseClass.isAuthenticated(enteredfullname, enteredrollno);
            if (f) {
                Intent intentadmin = new Intent(getApplicationContext(), HomePage.class);
                startActivity(intentadmin);

            } else {
                Toast.makeText(getApplicationContext(), "Enter Valid UserName & Password", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void forgetpassword(View v) {
        startActivity(new Intent(getApplicationContext(), ForgotPassword.class));
    }
}

