package nit.com.onlinedoctorappointment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Random;

public class PatientRegisteration extends Activity {
    EditText et_pt_regno, et1, et2, et3, et4, et5;
    Button btn_save, btn_send_sms;
    String dt, dt_1, dt_2;
    String u_name, u_designation, u_qualification, u_experience, u_email,date_Time;
    String number;
    MyDataBaseClass dataBaseClass;
    RadioGroup rb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_registration);
        et_pt_regno = (EditText) findViewById(R.id.editText13);
        et1 = (EditText) findViewById(R.id.name);
        et2 = (EditText) findViewById(R.id.designation);
        et3 = (EditText) findViewById(R.id.qualification);
        et4 = (EditText) findViewById(R.id.experience);
        et5 = (EditText) findViewById(R.id.email_id);
        btn_save = (Button) findViewById(R.id.button20);
        btn_send_sms = (Button) findViewById(R.id.btn_send_sms);
        rb = (RadioGroup) findViewById(R.id.rb1);

        dataBaseClass = new MyDataBaseClass(this);
        Random r = new Random();
        int i1 = (r.nextInt(999999) + 100000);
        String no = "" + Integer.parseInt(String.valueOf(i1));
        et_pt_regno.setText(no);

        Intent i = getIntent();
        dt = i.getStringExtra("date_time");
        dt_1 = i.getStringExtra("Doctor _Name");
        dt_2 = i.getStringExtra("Doctor_mobile");
        Log.e("All Date And Time Data", "" + dt + "\n" + dt_1 + "\n" + dt_2);

    }

    public void submitreg(View view) {
        btn_send_sms.setVisibility(View.VISIBLE);
        number = et_pt_regno.getText().toString().trim();
        u_name = et1.getText().toString().trim();
        u_designation = et2.getText().toString().trim();
        u_qualification = et3.getText().toString().trim();
        u_experience = et4.getText().toString().trim();
        u_email = et5.getText().toString().trim();
        date_Time=dt;

        if (!u_name.equals("")) {
            if (!u_designation.equals("")) {
                if (!u_qualification.equals("")) {
                    if (!u_experience.equals("")) {
                        if (!u_email.equals("")) {
                            if (!number.equals("")) {
                                insertdata();
                            } else {
                                Toast.makeText(this, "Enter Registration Number", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(this, "Enter Patient Address", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "Enter Patient Email-id", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Enter Patient Mobile No.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Enter Pateint Age", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Enter Patient Name", Toast.LENGTH_SHORT).show();
        }
    }

    private void insertdata() {
        long id = dataBaseClass.insert(u_name, u_designation, u_qualification, u_experience, u_email,date_Time, "AGENCYCHIEF");
        Log.e("String Data", "" + id);
        if (id < 0) {
            Toast.makeText(PatientRegisteration.this, "Error", Toast.LENGTH_SHORT).show();
        } else {
//            startActivity(new Intent(getApplicationContext(), SelectorClass.class));
            Toast toast = Toast.makeText(this, "Patient Registration Sucessfully", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
        btn_send_sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataBaseClass = new MyDataBaseClass(PatientRegisteration.this);
                String data = dataBaseClass.getnumber(u_qualification);
                // String[] mydata = data.split("#");
                Log.e("Patient Phone Number", "" + data);

        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + data));
        smsIntent.putExtra("sms_body", "Your Appoinment is Confirm...!,  Your Date And Time is :-" + dt + ", Doctor Name :- "+dt_1+", Mobile no.  :-  "+dt_2);
        startActivity(smsIntent);
            }
        });
    }
}




