package nit.com.onlinedoctorappointment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

 public class RegisterPage extends Activity {
    EditText et_name,et_email,et_password,et_cpassword;
    Button button;

    DataBaseClassAdapter dataBaseClass;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);

         et_name= (EditText) findViewById(R.id.editText);
         et_email= (EditText) findViewById(R.id.editText2);
         et_password= (EditText) findViewById(R.id.editText3);
         et_cpassword= (EditText) findViewById(R.id.editText4);
         button= (Button) findViewById(R.id.button4);
        dataBaseClass = new DataBaseClassAdapter(this);
    }

    public void submit(View view){
        String name=et_name.getText().toString();
        if (!StringUtils.isValidString(name)) {
            Toast.makeText(getApplicationContext(), "Enter a valid name", Toast.LENGTH_LONG).show();
            return;
        }

        String email=et_email.getText().toString();
        if (!new StringUtils().validate(email)) {
            Toast.makeText(getApplicationContext(), "Enter a valid email", Toast.LENGTH_LONG).show();
            return;
        }


        String password=et_password.getText().toString();


        if (!StringUtils.isValidString(password)) {
            Toast.makeText(getApplicationContext(), "Enter a valid password", Toast.LENGTH_LONG).show();
            return;
        }

        String confirm_password=et_password.getText().toString();
        if (!StringUtils.isValidString(confirm_password)) {
            Toast.makeText(getApplicationContext(), "Password does not Match", Toast.LENGTH_LONG).show();
            return;
        }
        if (!password.equals(confirm_password)) {
            Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_LONG).show();
            return;
        }

  long id = dataBaseClass.insert(name, email, password,confirm_password);
        if (id < 0) {
            Message.message(this, "unsuccessfull");
        } else {
            Message.message(this, "Registration Sucessfully");
            Intent intent=new Intent(this,SelectorClass.class);
            startActivity(intent);
        }
    }
}

