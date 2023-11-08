package nit.com.onlinedoctorappointment;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.braintreepayments.cardform.view.CardForm;

public class PaymentActivity extends AppCompatActivity {
    CardForm cardForm;
    Button buy;
    Spinner amount;
    AlertDialog.Builder alertBuilder;
    String dt, dt_1, dt_2;
    String[] amt={"Select amount","300","400","500"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        cardForm = findViewById(R.id.card_form);
        buy = findViewById(R.id.btnBuy);
        amount=(Spinner)findViewById(R.id.amount);

        Intent i = getIntent();
        dt = i.getStringExtra("date_time");
        dt_1 = i.getStringExtra("Doctor _Name");
        dt_2 = i.getStringExtra("Doctor_mobile");
        Log.e("All Date And Time Data", "" + dt + "\n" + dt_1 + "\n" + dt_2);

        cardForm.cardRequired(true)
       // cardForm.cardRequired(false)
                .expirationRequired(true)
                .cvvRequired(true)
              //  .postalCodeRequired(true)
                .mobileNumberRequired(true)
                .mobileNumberExplanation("SMS is required on this number")
                .setup(PaymentActivity.this);
        cardForm.getCvvEditText().setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // if (cardForm.isValid()) {
                    if (!cardForm.equals(null)) {
                    alertBuilder = new AlertDialog.Builder(PaymentActivity.this);
                    alertBuilder.setTitle("Confirm before paying");
                    alertBuilder.setMessage("Card number: " + cardForm.getCardNumber() + "\n" +
                            "Card expiry date: " + cardForm.getExpirationDateEditText().getText().toString() + "\n" +
                            "Card CVV: " + cardForm.getCvv() + "\n" +
                           // "Postal code: " + cardForm.getPostalCode() + "\n" +
                            "Phone number: " + cardForm.getMobileNumber());
                    alertBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            Toast.makeText(PaymentActivity.this, "Thank you for pay Fee Payment...!", Toast.LENGTH_LONG).show();

                            Intent intentdata = new Intent(PaymentActivity.this, PatientRegisteration.class);
                            intentdata.putExtra("date_time", dt);
                            intentdata.putExtra("Doctor _Name",dt_1);
                            intentdata.putExtra("Doctor_mobile",dt_2);
                            startActivity(intentdata);
                        }
                    });
                    alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    AlertDialog alertDialog = alertBuilder.create();
                    alertDialog.show();

                } else {
                    Toast.makeText(PaymentActivity.this, "Please complete the form", Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}