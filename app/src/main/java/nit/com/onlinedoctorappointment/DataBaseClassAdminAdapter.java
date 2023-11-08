package nit.com.onlinedoctorappointment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DataBaseClassAdminAdapter {
    DataBaseClass dataBaseClass;

    public DataBaseClassAdminAdapter(Context context) {
        dataBaseClass = new DataBaseClass(context);
    }

    //==============================================================
    public long insert(String Name, String Degree, String Specialization, String DOCEmail, String Contact) {
        SQLiteDatabase sqLiteDatabase = dataBaseClass.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseClass.NAME, Name);
        contentValues.put(DataBaseClass.DEGREE, Degree);
        contentValues.put(DataBaseClass.SPECIALIZATION, Specialization);
        contentValues.put(DataBaseClass.DREMAIL, DOCEmail);
        contentValues.put(DataBaseClass.CONTACT, Contact);
        long id = sqLiteDatabase.insert(DataBaseClass.TABLE_NAME, null, contentValues);
        return id;
    }

    //=======================================================================
    public String getData(String Contact) {

        SQLiteDatabase sqLiteDatabase = dataBaseClass.getWritableDatabase();
        String[] columns = {DataBaseClass.NAME, DataBaseClass.DEGREE, DataBaseClass.SPECIALIZATION, DataBaseClass.DREMAIL, DataBaseClass.CONTACT};
        Cursor cursor = sqLiteDatabase.query(DataBaseClass.TABLE_NAME, columns, "Contact=? ", new String[]{Contact}, null, null, null);
        StringBuffer stringBuffer = new StringBuffer();
        if (cursor.moveToNext()) {

            int index1 = cursor.getColumnIndex(DataBaseClass.NAME);
            int index2 = cursor.getColumnIndex(DataBaseClass.DEGREE);
            int index3 = cursor.getColumnIndex(DataBaseClass.SPECIALIZATION);
            int index4 = cursor.getColumnIndex(DataBaseClass.DREMAIL);
            int index5 = cursor.getColumnIndex(DataBaseClass.CONTACT);

            String getname = cursor.getString(index1);
            String get_degree = cursor.getString(index2);
            String get_specialization = cursor.getString(index3);
            String get_email = cursor.getString(index4);
            String get_contact = cursor.getString(index5);

            stringBuffer.append("Name:- " + getname + "\nDegree:- " + get_degree + "\nSpecailization:- " + get_specialization + "\nEmail:- " + get_email + "\nContact:-" + get_contact + "#");
        }
        return stringBuffer.toString();
    }

    //============================method for gettting all details================================================
    public String getDocterData(String Specialization) {

        SQLiteDatabase sqLiteDatabase = dataBaseClass.getWritableDatabase();
        String[] columns = {DataBaseClass.NAME, DataBaseClass.DEGREE, DataBaseClass.SPECIALIZATION, DataBaseClass.DREMAIL, DataBaseClass.CONTACT};

        Cursor cursor = sqLiteDatabase.query(DataBaseClass.TABLE_NAME, columns, "Specialization = ? ", new String[]{Specialization}, null, null, null);
        StringBuffer stringBuffer = new StringBuffer();
        if (cursor.moveToNext()) {
            int index1 = cursor.getColumnIndex(DataBaseClass.NAME);
            int index2 = cursor.getColumnIndex(DataBaseClass.DEGREE);
            int index3 = cursor.getColumnIndex(DataBaseClass.SPECIALIZATION);
            int index4 = cursor.getColumnIndex(DataBaseClass.DREMAIL);
            int index5 = cursor.getColumnIndex(DataBaseClass.CONTACT);


            String getname = cursor.getString(index1);
            String get_degree = cursor.getString(index2);
            String get_specialization = cursor.getString(index3);
            String get_email = cursor.getString(index4);
            String get_contact = cursor.getString(index5);


            stringBuffer.append("Name:- " + getname + "\nDegree:- " + get_degree + "\nSpecailization:- " + get_specialization + "\nEmail:- " + get_email + "\nContact:-" + get_contact);
        }
        return stringBuffer.toString();
    }

    public String getalldatamain() {
        SQLiteDatabase sqLiteDatabase = dataBaseClass.getWritableDatabase();

        String[] columns = {DataBaseClassAdminAdapter.DataBaseClass.NAME, DataBaseClassAdminAdapter.DataBaseClass.DEGREE, DataBaseClassAdminAdapter.DataBaseClass.SPECIALIZATION, DataBaseClassAdminAdapter.DataBaseClass.DREMAIL, DataBaseClassAdminAdapter.DataBaseClass.CONTACT};
        Cursor cursor = sqLiteDatabase.query(DataBaseClassAdminAdapter.DataBaseClass.TABLE_NAME, columns, null, null, null, null, null);
        StringBuffer stringBuffer = new StringBuffer();
        while (cursor.moveToNext()) {

            String get_name = cursor.getString(0);
            String get_degree = cursor.getString(1);
            String get_speciality = cursor.getString(2);
            String get_dr_email = cursor.getString(3);
            String get_contact_no = cursor.getString(4);


            stringBuffer.append("Doctor Name  :  " + get_name + ", DR. Degree  :  " + get_degree + ",  Speciality  :  " + get_speciality + ",  DR. Email-id  :   " + get_dr_email + ",  DR. Mobile No.  :   " + get_contact_no + "#");
        }

        return stringBuffer.toString();
    }

    //=========================================================================
    public String showStudent(String Specialization) {
        SQLiteDatabase sqLiteDatabase;
        sqLiteDatabase = dataBaseClass.getWritableDatabase();
        String[] columns = {DataBaseClass.NAME, DataBaseClass.DEGREE, DataBaseClass.SPECIALIZATION, DataBaseClass.DREMAIL, DataBaseClass.CONTACT};


        Cursor cursor = sqLiteDatabase.query(DataBaseClass.TABLE_NAME, columns, "Specialization = ?", new String[]{Specialization}, null, null, null);
        StringBuffer stringBuffer = new StringBuffer();
        while (cursor.moveToNext()) {

            int index1 = cursor.getColumnIndex(DataBaseClass.NAME);
            int index2 = cursor.getColumnIndex(DataBaseClass.DEGREE);
            int index3 = cursor.getColumnIndex(DataBaseClass.SPECIALIZATION);
            int index4 = cursor.getColumnIndex(DataBaseClass.DREMAIL);
            int index5 = cursor.getColumnIndex(DataBaseClass.CONTACT);


            String getname = cursor.getString(index1);
            String get_degree = cursor.getString(index2);
            String get_specialization = cursor.getString(index3);
            String get_email = cursor.getString(index4);
            String get_contact = cursor.getString(index5);


            if ((getname.trim().toUpperCase()).equalsIgnoreCase(getname.toUpperCase()) && (get_degree.trim().toUpperCase()).equalsIgnoreCase(get_degree.toUpperCase()) && (get_specialization.trim().toUpperCase()).equalsIgnoreCase(get_specialization.toUpperCase()) && (get_email.trim().toUpperCase()).equalsIgnoreCase(get_email.toUpperCase()) && (get_contact.trim().toUpperCase()).equalsIgnoreCase(get_contact.toUpperCase())) {
                //stringBuffer.append(getname+"&&"+get_degree+"&&"+get_specialization+"&&"+get_email+"&&"+get_contact+"#") ;
                stringBuffer.append("Name:- " + getname + "&&" + get_contact + "#");
                // stringBuffer.append("Name:- "+getname+"\nDegree:- "+get_degree+"\nSpecailization:- "+get_specialization+"\nEmail:- "+get_email+"\nContact:-"+get_contact) ;
            }
        }
        return stringBuffer.toString().trim();

    }

    //=======================================================================

    public String doctorNameList(String Specialization) {
        SQLiteDatabase sqLiteDatabase = dataBaseClass.getWritableDatabase();

        String[] columns = {DataBaseClass.UID, DataBaseClass.NAME, DataBaseClass.SPECIALIZATION};
        Cursor cursor = sqLiteDatabase.query(DataBaseClass.TABLE_NAME, columns, null, null, null, null, null);
        StringBuffer stringBuffer = new StringBuffer();

        while (cursor.moveToNext()) {

            int index1 = cursor.getColumnIndex(DataBaseClass.UID);
            int index2 = cursor.getColumnIndex(DataBaseClass.NAME);

            String mid = cursor.getString(index1);
            String magzinName = cursor.getString(index2);
            stringBuffer.append(mid + "@sep" + magzinName + "@sep");
        }
        return stringBuffer.toString();
    }

    //============================crate database class=========================================

    static class DataBaseClass extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "PATIENTGG";
        private static final String TABLE_NAME = "PATIENTREGGG";
        private static final String UID = "_id";
        private static final int DATABASE_VERSION = 3;
        private static final String NAME = "Name";
        private static final String DEGREE = "Degree";
        private static final String SPECIALIZATION = "Specialization";
        private static final String DREMAIL = "DOCEmail";
        private static final String CONTACT = "Contact";
        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255)," + DEGREE + " VARCHAR(255)," + SPECIALIZATION + " VARCHAR(255)," + DREMAIL + " VARCHAR(255)," + CONTACT + " VARCHAR(255));";
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
                Toast.makeText(context, "Drop Table is Created", Toast.LENGTH_SHORT).show();
            } catch (SQLException e) {
                Message.message(context, "" + e);
            }
        }
    }

}

