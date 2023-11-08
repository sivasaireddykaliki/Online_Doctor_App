package nit.com.onlinedoctorappointment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectDoctorFromList extends Activity {
    ListView listView;
    CheckBox checkBox;
    String roll[], studentName[];
    Button btnAttendence;
    Button button;
    RupeshAdapter rupeshAdapter = null;
    DataBaseClassAdminAdapter dataBaseClass;
    TextView textView;
    String studentAttendancestatuse[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_docter_from_list);
        listView = (ListView) findViewById(R.id.lv3);
        btnAttendence = (Button) findViewById(R.id.button34);
        textView = (TextView) findViewById(R.id.textView19);

        dataBaseClass = new DataBaseClassAdminAdapter(this);

        String selected_specaility =getIntent().getExtras().getString("speciality");

        Toast.makeText(this, ""+selected_specaility, Toast.LENGTH_SHORT).show();
        String data = dataBaseClass.showStudent(selected_specaility);
        String[] mydata = data.split("#");
        roll = new String[mydata.length];
        studentName = new String[mydata.length];
        int index = 0;

        for (int i = 0; i < mydata.length; i++) {
            String[] val = mydata[i].split("&&");
            if (val.length == 2) {
                roll[index] = val[0];
                studentName[index] = val[1];
                index = index + 1;
            }
        }
        rupeshAdapter = new RupeshAdapter(this, roll, studentName, checkBox, button);
        listView.setAdapter(rupeshAdapter);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), HomePage.class));
    }
}

class RupeshAdapter extends ArrayAdapter {
    private final CheckBox CheckBox;
    private final Button btnGetAppointment;
    Context context;
    String[] Title;
    String[] Desc;
    String[] roll;
    String[] studentName;
    ArrayList<Integer> sitm = null;
    int i = -1;

    RupeshAdapter(Context c, String[] titles, String[] description, CheckBox checkBox, Button button) {
        super(c, R.layout.single_row, R.id.textView, titles);
        this.context = c;
        this.Title = titles;
        this.Desc = description;
        this.CheckBox = checkBox;
        this.btnGetAppointment = button;
        sitm = new ArrayList<Integer>();
    }

    class MyViewHolder implements View.OnClickListener {
        TextView Ttitle;
        TextView TDesc;
        CheckBox checkBox;
        Button btnGetAppointment;

        public MyViewHolder(View v) {
            final ArrayList<String> selectedStrings = new ArrayList<String>();
            Ttitle = (TextView) v.findViewById(R.id.textView);
            TDesc = (TextView) v.findViewById(R.id.textView2);
            checkBox = (CheckBox) v.findViewById(R.id.checkbox);
            btnGetAppointment = (Button) v.findViewById(R.id.button8);

            // btnGetAppointment.setOnClickListener(this);
            btnGetAppointment.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Code here executes on main thread after user presses button
                    //  Integer.parseInt(btnGetAppointment.getTag().toString().trim());
                    String info = btnGetAppointment.getTag().toString();
                    //Toast.makeText(getContext(),"df"+info,Toast.LENGTH_LONG).show();
                    Intent intentdata = new Intent(getContext(), GetAppointment.class);
                    intentdata.putExtra("info", info);
                    getContext().startActivity(intentdata);
                }
            });
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        // do somtheing when is checked
                        //    selectedStrings.add(checkBox.getText().toString());
                        sitm.add(Integer.parseInt(checkBox.getTag().toString().trim()));
                    } else {
                        // do somthing when is removed the check**strong text**
                        //       selectedStrings.remove(checkBox.getText().toString());
                        sitm.remove(sitm.indexOf(Integer.parseInt(checkBox.getTag().toString().trim())));
                    }
                }
            });
        }

        @Override
        public void onClick(View view) {
            //on get appointment  button
            // Toast.makeText(getContext(),"hello",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getContext(), GetAppointment.class);
            getContext().startActivity(intent);
        }
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        MyViewHolder holder = null;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_row, parent, false);
            holder = new MyViewHolder(row);
            row.setTag(holder);
        } else {
            holder = (MyViewHolder) row.getTag();
        }
        holder.Ttitle.setText(Title[position]);
        holder.TDesc.setText(Desc[position]);
        holder.checkBox.setChecked(row.isSelected());
        holder.checkBox.setTag(position);
        holder.checkBox.setChecked(false);
        holder.btnGetAppointment.setTag(Title[position] + "#" + Desc[position]);
        return row;
    }
}









