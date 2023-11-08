package nit.com.onlinedoctorappointment;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ForgotPassword extends Activity {
    EditText editText;
    TextView textView;
    Button btn_getpwd;
    DataBaseClassAdapter dataBaseClass;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);

        editText = (EditText) findViewById(R.id.editText5);
        textView = (TextView) findViewById(R.id.textView2);
        btn_getpwd = (Button) findViewById(R.id.button9);

        dataBaseClass = new DataBaseClassAdapter(this);
    }
    public void getpwd(View view) {
        String email = editText.getText().toString().trim();
        if (!email.equals("")) {
            donotify();
        } else {
            editText.setError("Enter Valid User Name");
        }
        data = dataBaseClass.showpassword(email);
    }
    private void donotify() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
        r.play();
        long[] v = {500,1000};

        builder .setSmallIcon(R.drawable.notification);
        builder.setContentTitle("Doctor Appoinment App");
        builder.setContentText("Your Password is :-  " + data);
        builder.setVibrate(v);

        Intent notificationIntent = new Intent(ForgotPassword.this, Login.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());

    }
}

