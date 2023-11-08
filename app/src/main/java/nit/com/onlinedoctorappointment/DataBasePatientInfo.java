package nit.com.onlinedoctorappointment;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DataBasePatientInfo {

    DataBaseClass dataBaseClass;

    public DataBasePatientInfo(Context context) {
        dataBaseClass = new DataBaseClass(context);
    }

    public long insertData(String Registrationno, String Pt_name, String Pt_mobile, String Pt_address, String Dr_name, String Dr_mobile, String Appointment_time) {

        SQLiteDatabase sqLiteDatabase = dataBaseClass.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseClass.REGISTRATION_NO, Registrationno);
        contentValues.put(DataBaseClass.PT_NAME, Pt_name);
        contentValues.put(DataBaseClass.PT_MOBILE, Pt_mobile);
        contentValues.put(DataBaseClass.PT_ADDRESS, Pt_address);
        contentValues.put(DataBaseClass.DR_NAME, Dr_name);
        contentValues.put(DataBaseClass.DR_MOBILE, Dr_mobile);
        contentValues.put(DataBaseClass.APPOINTMENT_TIME, Appointment_time);

        long id = sqLiteDatabase.insert(DataBaseClass.TABLE_NAME, null, contentValues);
        return id;

    }

    public String getalldata(String Patient) {

        SQLiteDatabase sqLiteDatabase = dataBaseClass.getReadableDatabase();

        String[] columns = {DataBasePatientInfo.DataBaseClass.REGISTRATION_NO, DataBasePatientInfo.DataBaseClass.PT_NAME, DataBasePatientInfo.DataBaseClass.PT_MOBILE,
                DataBasePatientInfo.DataBaseClass.PT_ADDRESS, DataBasePatientInfo.DataBaseClass.DR_NAME, DataBasePatientInfo.DataBaseClass.DR_MOBILE, DataBasePatientInfo.DataBaseClass.APPOINTMENT_TIME};
        Cursor cursor = sqLiteDatabase.query(DataBasePatientInfo.DataBaseClass.TABLE_NAME, columns, "contact=?", new String[]{Patient}, null, null, null);

        StringBuffer stringBuffer = new StringBuffer();
        if (cursor.moveToFirst()) {

            int index1 = cursor.getColumnIndex(DataBasePatientInfo.DataBaseClass.REGISTRATION_NO);
            int index2 = cursor.getColumnIndex(DataBasePatientInfo.DataBaseClass.PT_NAME);
            int index3 = cursor.getColumnIndex(DataBasePatientInfo.DataBaseClass.PT_MOBILE);
            int index4 = cursor.getColumnIndex(DataBasePatientInfo.DataBaseClass.PT_ADDRESS);
            int index5 = cursor.getColumnIndex(DataBasePatientInfo.DataBaseClass.DR_NAME);
            int index6 = cursor.getColumnIndex(DataBasePatientInfo.DataBaseClass.DR_MOBILE);
            int index7 = cursor.getColumnIndex(DataBasePatientInfo.DataBaseClass.APPOINTMENT_TIME);

            String get_Registration_No = cursor.getString(index1);
            String get_Pt_Name = cursor.getString(index2);
            String get_Mobile_No = cursor.getString(index3);
            String get_Pt_Address = cursor.getString(index4);
            String get_DR_Name = cursor.getString(index5);
            String get_DR_MObile = cursor.getString(index6);
            String get_appinment_date = cursor.getString(index7);

            stringBuffer.append("Registration No. :   " + get_Registration_No + "Patient Name  :   " + get_Pt_Name + "Mobile No.  : " + get_Mobile_No + "PT Address  : " + get_Pt_Address + " Doctor Name.  :  "+get_DR_Name+ " Doctore No.  : "+ get_DR_MObile+ "Appoinment Time  : "+get_appinment_date + " #");
        }
        return stringBuffer.toString();
    }
    //==============================Create Data Base Class And Extend in Abstarct Claases=========================================
    static class DataBaseClass extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "PateintInfo.db";
        private static final String TABLE_NAME = "STUDENT";
        private static final String UID = "_id";
        private static final int DATABASE_VERSION = 1;
        private static final String REGISTRATION_NO = "Registrationno";
        private static final String PT_NAME = "Pt_name";
        private static final String PT_MOBILE = "Pt_mobile";
        private static final String PT_ADDRESS = "Pt_address";
        private static final String DR_NAME = "Dr_name";
        private static final String DR_MOBILE = "Dr_mobile";
        private static final String APPOINTMENT_TIME = "Appointment_time";

        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + REGISTRATION_NO + " VARCHAR(255)," + PT_NAME + " VARCHAR(255)," + PT_MOBILE + " VARCHAR(255)," + PT_ADDRESS + " VARCHAR(255)," + DR_NAME + " VARCHAR(255)," + DR_MOBILE + " VARCHAR(255)," + APPOINTMENT_TIME + " VARCHAR(255));";

        private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        private Context context;


        public DataBaseClass(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            try {
                sqLiteDatabase.execSQL(CREATE_TABLE);
                Toast.makeText(context, "Table is Created", Toast.LENGTH_SHORT).show();
            } catch (SQLException e) {
                Message.message(context, "" + e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            //DELETE TABLE IF EXIST "P_INFO_TABLE" ;
            //  String DROP_TABLE= "DROP TABLE IF EXIST"+TABLE_NAME;
            try {
                sqLiteDatabase.execSQL(DROP_TABLE);
                onCreate(sqLiteDatabase);
            } catch (SQLException e) {
                Message.message(context, "" + e);
            }
        }
    }
}

