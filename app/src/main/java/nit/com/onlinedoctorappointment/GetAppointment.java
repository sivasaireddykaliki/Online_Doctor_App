package nit.com.onlinedoctorappointment;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Calendar;

public class GetAppointment extends Activity {
    DataBaseClassAdminAdapter dataBaseClass;
    ListView listView;
    EditText editText_date;
    String et_time;
    String doctor_info;
    int mYear, mMonth, mDay;
    String str;
    Button button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_10, button_11, button_12, button_13, button_14, button_15, button_16, button_17, button_18, button_19, button_20, button_21, button_22;
    String name, mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_appointment);

        Intent intent = getIntent();
        String info = intent.getStringExtra("info");
        Log.e("Get Info Details", "" + info);

        String[] data = info.split("#");
        name = data[0];
        mobile = data[1];

      //  Log.e("Get Appoinment String Data", "" + name + " \n " + mobile);


        button_1 = (Button) findViewById(R.id.button_1);
        button_2 = (Button) findViewById(R.id.button_2);
        button_3 = (Button) findViewById(R.id.button_3);

        button_4 = (Button) findViewById(R.id.button_4);
        button_5 = (Button) findViewById(R.id.button_5);
        button_6 = (Button) findViewById(R.id.button_6);

        button_7 = (Button) findViewById(R.id.button_7);
        button_8 = (Button) findViewById(R.id.button_8);
        button_9 = (Button) findViewById(R.id.button_9);

        button_10 = (Button) findViewById(R.id.button_10);
        button_11 = (Button) findViewById(R.id.button_11);
        button_12 = (Button) findViewById(R.id.button_12);

        button_13 = (Button) findViewById(R.id.button_13);
        button_14 = (Button) findViewById(R.id.button_14);
        button_15 = (Button) findViewById(R.id.button_15);

        button_16 = (Button) findViewById(R.id.button_16);
        button_17 = (Button) findViewById(R.id.button_17);
        button_18 = (Button) findViewById(R.id.button_18);

        button_19 = (Button) findViewById(R.id.button_19);
        button_20 = (Button) findViewById(R.id.button_20);
        button_21 = (Button) findViewById(R.id.button_21);
        button_22 = (Button) findViewById(R.id.button_22);

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_1.setBackgroundColor(Color.RED);
                String time = " Time :-" + "09:00-09:30 am";
                String datetime = et_time.concat(time);
                editText_date.setText(datetime);
                buttonenable();
            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_2.setBackgroundColor(Color.RED);
                String time = " Time :-" + "09:30-10:00 am";
                String datetime = et_time.concat(time);
                editText_date.setText(datetime);
                buttonenable_2();
            }
        });
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_3.setBackgroundColor(Color.RED);
                String time = " Time :-" + "10:00-10:30 am";
                String datetime = et_time.concat(time);
                editText_date.setText(datetime);

                buttonenable_3();
            }
        });
        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_4.setBackgroundColor(Color.RED);
                String time = " Time :-" + "10:30-11:00 am";
                String datetime = et_time.concat(time);
                editText_date.setText(datetime);
                buttonenable_4();
            }
        });
        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_5.setBackgroundColor(Color.RED);
                String time = " Time :-" + "11:00-11:30 am";
                String datetime = et_time.concat(time);
                editText_date.setText(datetime);
                buttonenable_5();
            }
        });
        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_6.setBackgroundColor(Color.RED);
                String time = " Time :-" + "11:30-12:00 am";
                String datetime = et_time.concat(time);
                editText_date.setText(datetime);
                buttonenable_6();
            }
        });
        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_7.setBackgroundColor(Color.RED);
                String time = " Time :-" + "12:00-12:30 pm";
                String datetime = et_time.concat(time);
                editText_date.setText(datetime);
                buttonenable_7();
            }
        });
        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_8.setBackgroundColor(Color.RED);
                String time = " Time :-" + "12:30-01:00 pm";
                String datetime = et_time.concat(time);
                editText_date.setText(datetime);
                buttonenable_8();
            }
        });
        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_9.setBackgroundColor(Color.RED);
                String time = " Time :-" + "01:00-01:30 pm";
                String datetime = et_time.concat(time);
                editText_date.setText(datetime);
                buttonenable_9();
            }
        });
        button_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_10.setBackgroundColor(Color.RED);
                String time = " Time :-" + "01:30-02:00 pm";
                String datetime = et_time.concat(time);
                editText_date.setText(datetime);
                buttonenable_10();
            }
        });
        button_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_11.setBackgroundColor(Color.RED);
                String time = " Time :-" + "02:00-02:30 pm";
                String datetime = et_time.concat(time);
                editText_date.setText(datetime);
                buttonenable_11();
            }
        });
        button_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_12.setBackgroundColor(Color.RED);
                String time = " Time :-" + "02:30-03:00 pm";
                String datetime = et_time.concat(time);
                editText_date.setText(datetime);
                buttonenable_12();
            }
        });
        button_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_13.setBackgroundColor(Color.RED);
                String time = " Time :-" + "03:00-03:30 pm";
                String datetime = et_time.concat(time);
                editText_date.setText(datetime);
                buttonenable_13();
            }
        });
        button_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_14.setBackgroundColor(Color.RED);
                String time = " Time :-" + "03:30-04:00 pm";
                String datetime = et_time.concat(time);
                editText_date.setText(datetime);
                buttonenable_14();
            }
        });
        button_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_15.setBackgroundColor(Color.RED);
                String time = " Time :-" + "04:00-04:30 pm";
                String datetime = et_time.concat(time);
                editText_date.setText(datetime);
                buttonenable_15();
            }
        });
        button_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_16.setBackgroundColor(Color.RED);
                String time = " Time :-" + "04:30-05:00 pm";
                String datetime = et_time.concat(time);
                editText_date.setText(datetime);
                buttonenable_16();
            }
        });
        button_17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_17.setBackgroundColor(Color.RED);
                String time = " Time :-" + "05:00-05:30 pm";
                String datetime = et_time.concat(time);
                editText_date.setText(datetime);
                buttonenable_17();
            }
        });
        button_18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_18.setBackgroundColor(Color.RED);
                String time = " Time :-" + "05:30-06:00 pm";
                String datetime = et_time.concat(time);
                editText_date.setText(datetime);
                buttonenable_18();
            }
        });
        button_19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_19.setBackgroundColor(Color.RED);
                String time = " Time :-" + "06:00-06:30 pm";
                String datetime = et_time.concat(time);
                editText_date.setText(datetime);
                buttonenable_19();
            }
        });
        button_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_20.setBackgroundColor(Color.RED);
                String time = " Time :-" + "06:30-07:00 pm";
                String datetime = et_time.concat(time);
                editText_date.setText(datetime);
                buttonenable_20();
            }
        });
        button_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_21.setBackgroundColor(Color.RED);
                String time = " Time :-" + "07:00-07:30 pm";
                String datetime = et_time.concat(time);
                editText_date.setText(datetime);
                buttonenable_21();
            }
        });
        button_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_22.setBackgroundColor(Color.RED);
                String time = " Time :-" + "07:30-08:00 pm";
                String datetime = et_time.concat(time);
                editText_date.setText(datetime);
                buttonenable_22();
            }
        });
        listView = (ListView) findViewById(R.id.get_appointment);
        editText_date = findViewById(R.id.editText10);
        editText_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(GetAppointment.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                editText_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                et_time = editText_date.getText().toString();
                                Log.e("Show Date", "" + et_time);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        dataBaseClass = new DataBaseClassAdminAdapter(this);
        doctor_info = dataBaseClass.getData(mobile);
        if (doctor_info != null) {
            String[] mydata = doctor_info.split("#");
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mydata);
            listView.setAdapter(arrayAdapter);
        } else {
            Toast.makeText(getApplicationContext(), "enter correct phoneno.", Toast.LENGTH_SHORT).show();
        }
    }

    private void buttonenable() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2 * 60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                GetAppointment.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button_1.setEnabled(true);
                    }
                });
            }
        }).start();

    }

    private void buttonenable_2() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2 * 60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                GetAppointment.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button_2.setEnabled(true);
                    }
                });
            }
        }).start();
    }

    private void buttonenable_3() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2 * 60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                GetAppointment.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button_3.setEnabled(true);
                    }
                });
            }
        }).start();
    }

    private void buttonenable_4() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2 * 60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                GetAppointment.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button_4.setEnabled(true);
                    }
                });
            }
        }).start();
    }

    private void buttonenable_5() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2 * 60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                GetAppointment.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button_5.setEnabled(true);
                    }
                });
            }
        }).start();
    }

    private void buttonenable_6() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2 * 60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                GetAppointment.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button_6.setEnabled(true);
                    }
                });
            }
        }).start();
    }

    private void buttonenable_7() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2 * 60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                GetAppointment.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button_7.setEnabled(true);
                    }
                });
            }
        }).start();
    }

    private void buttonenable_8() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2 * 60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                GetAppointment.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button_8.setEnabled(true);
                    }
                });
            }
        }).start();
    }

    private void buttonenable_9() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2 * 60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                GetAppointment.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button_9.setEnabled(true);
                    }
                });
            }
        }).start();
    }

    private void buttonenable_10() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2 * 60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                GetAppointment.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button_10.setEnabled(true);
                    }
                });
            }
        }).start();
    }

    private void buttonenable_11() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2 * 60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                GetAppointment.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button_11.setEnabled(true);
                    }
                });
            }
        }).start();
    }

    private void buttonenable_12() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2 * 60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                GetAppointment.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button_12.setEnabled(true);
                    }
                });
            }
        }).start();
    }

    private void buttonenable_13() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2 * 60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                GetAppointment.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button_13.setEnabled(true);
                    }
                });
            }
        }).start();
    }

    private void buttonenable_14() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2 * 60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                GetAppointment.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button_14.setEnabled(true);
                    }
                });
            }
        }).start();
    }

    private void buttonenable_15() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2 * 60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                GetAppointment.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button_15.setEnabled(true);
                    }
                });
            }
        }).start();
    }

    private void buttonenable_16() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2 * 60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                GetAppointment.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button_16.setEnabled(true);
                    }
                });
            }
        }).start();
    }

    private void buttonenable_17() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2 * 60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                GetAppointment.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button_17.setEnabled(true);
                    }
                });
            }
        }).start();
    }

    private void buttonenable_18() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2 * 60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                GetAppointment.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button_18.setEnabled(true);
                    }
                });
            }
        }).start();
    }

    private void buttonenable_19() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2 * 60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                GetAppointment.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button_19.setEnabled(true);
                    }
                });
            }
        }).start();
    }

    private void buttonenable_20() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2 * 60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                GetAppointment.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button_20.setEnabled(true);
                    }
                });
            }
        }).start();
    }

    private void buttonenable_21() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2 * 60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                GetAppointment.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button_21.setEnabled(true);
                    }
                });
            }
        }).start();
    }

    private void buttonenable_22() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2 * 60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                GetAppointment.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button_22.setEnabled(true);
                    }
                });
            }
        }).start();
    }

    public void confirm(View view) {
        str = editText_date.getText().toString().trim();
        if (!str.equals("")) {
            Intent intentdata = new Intent(this, PaymentActivity.class);
            intentdata.putExtra("date_time", str);
            intentdata.putExtra("Doctor _Name",name);
            intentdata.putExtra("Doctor_mobile",mobile);
            startActivity(intentdata);
            openActivity();
        } else {
            Toast.makeText(this, "Please Select Date & Time", Toast.LENGTH_SHORT).show();
        }
    }

    private void openActivity() {
        Log.e("EditText Data", "" + str);
        Intent intentdata = new Intent(this, PatientRegisteration.class);
        intentdata.putExtra("date_time", str);
        intentdata.putExtra("Doctor _Name",name);
        intentdata.putExtra("Doctor_mobile",mobile);
        startActivity(intentdata);
    }
}

