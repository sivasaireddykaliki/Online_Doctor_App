package nit.com.onlinedoctorappointment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AdminPage extends Activity {
    EditText et_name, et_degree, et_email_dr, et_contact;
    Button button;
    Spinner spinner_specaility;
    ArrayAdapter adapter_section;
    String selected_speciality;
    DataBaseClassAdminAdapter dataBaseClass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);
        et_name = (EditText) findViewById(R.id.editText6);
        et_degree = (EditText) findViewById(R.id.editText9);
        et_email_dr = (EditText) findViewById(R.id.editText11);
        et_contact = (EditText) findViewById(R.id.editText12);

        spinner_specaility = (Spinner) findViewById(R.id.spinner3);
        button = (Button) findViewById(R.id.button6);

        dataBaseClass = new DataBaseClassAdminAdapter(this);

        adapter_section = ArrayAdapter.createFromResource(this, R.array.Specaility, android.R.layout.simple_spinner_item);
        adapter_section.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_specaility.setAdapter(adapter_section);

        selected_speciality = spinner_specaility.getSelectedItem().toString();
    }

    public void save(View view) {
        String name = et_name.getText().toString().trim();
        if (!StringUtils.isValidString(name)) {
            Toast.makeText(getApplicationContext(),"Enter a valid name", Toast.LENGTH_LONG).show();
            return;
        }
        String degree = et_degree.getText().toString().trim();
        if (!StringUtils.isValidString(degree)) {
            Toast.makeText(getApplicationContext(), "Enter a Degree", Toast.LENGTH_LONG).show();
            return;
        }
        String email = et_email_dr.getText().toString().trim();
        if (!new StringUtils().validate(email)) {
            Toast.makeText(getApplicationContext(),"Enter a valid email", Toast.LENGTH_LONG).show();
            return;
        }
        String contact = et_contact.getText().toString().trim();
        if (!StringUtils.isValidString(contact)) {
            Toast.makeText(getApplicationContext(),"Enter a valid password", Toast.LENGTH_LONG).show();
            return;
        }
        long id = dataBaseClass.insert(name, degree, selected_speciality, email, contact);
        if (id < 0) {
            Message.message(this,"unsuccessfull");
        } else {
            Message.message(this,"Registeration Sucessfull");
            Intent intent = new Intent(this, AdminOptionsActivity.class);
            startActivity(intent);
        }
    }
}

