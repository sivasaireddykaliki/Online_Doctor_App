package nit.com.onlinedoctorappointment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyDataBaseClass {

    DataBaseClass dataBaseClass;
    private SQLiteDatabase writableDatabase;

    public MyDataBaseClass(Context context) {
        dataBaseClass = new DataBaseClass(context);
    }

    public String isAuthenticated(String Musername, String Mpassword) {
        SQLiteDatabase sqLiteDatabase = dataBaseClass.getWritableDatabase();
        String[] columns = {DataBaseClass.USERTYPE, DataBaseClass.USERNAME, DataBaseClass.Designation, DataBaseClass.Qualification, DataBaseClass.Experience, DataBaseClass.Email};
        String[] selectionArgs = {Musername, Mpassword};

        Cursor cursor = sqLiteDatabase.query(DataBaseClass.TABLE_NAME, columns, "Userame=? And Password=?", new String[]{Musername, Mpassword}, null, null, null);

        StringBuffer stringBuffer = new StringBuffer();
        while (cursor.moveToNext()) {
            int index1 = cursor.getColumnIndex(DataBaseClass.USERTYPE);
            String get_usertype_from_db = cursor.getString(index1);
            stringBuffer.append(get_usertype_from_db);
        }
        return stringBuffer.toString();
    }

    public long insert(String Name, String Designation, String Qualification, String Experience, String Email,String dateTime, String Usertype) {
        SQLiteDatabase sqLiteDatabase = dataBaseClass.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseClass.USERNAME, Name);
        contentValues.put(DataBaseClass.Designation, Designation);
        contentValues.put(DataBaseClass.Qualification, Qualification);
        contentValues.put(DataBaseClass.Experience, Experience);
        contentValues.put(DataBaseClass.Email, Email);
        contentValues.put(DataBaseClass.dateTime,dateTime);
        contentValues.put(DataBaseClass.USERTYPE, Usertype);
        long id = sqLiteDatabase.insert(DataBaseClass.TABLE_NAME, null, contentValues);
        return id;
    }

    public String showAllDatamain(String mUserType) {
        SQLiteDatabase sqLiteDatabase = dataBaseClass.getWritableDatabase();
        String[] columns = {DataBaseClass.USERNAME, DataBaseClass.Designation, DataBaseClass.Qualification, DataBaseClass.Experience, DataBaseClass.Email,DataBaseClass.dateTime, DataBaseClass.USERTYPE};
        Cursor cursor = sqLiteDatabase.query(DataBaseClass.TABLE_NAME, columns, " Utype=? ", new String[]{mUserType}, null, null, null);
        StringBuffer stringBuffer = new StringBuffer();

        while (cursor.moveToNext()) {
            String get_name = cursor.getString(0);
            String get_des = cursor.getString(1);
            String get_quali = cursor.getString(2);
            String get_exper = cursor.getString(3);
            String get_email = cursor.getString(4);
            String get_date = cursor.getString(5);

            stringBuffer.append("Date : "+ get_date+ "\n Patient Name: " + get_name + "\n Age: " + get_des + " \n Mobile No. : " + get_quali + "\n Email-id : " + get_exper + "\n Address : " + get_email + " # ");
        }
        return stringBuffer.toString();
    }

    public void deleteAllUserData() {
        SQLiteDatabase sqLiteDatabase = dataBaseClass.getWritableDatabase();
        sqLiteDatabase.delete(DataBaseClass.TABLE_NAME, null, null);

    }

    public List<String> getAllUsername(String mUserType) {
        SQLiteDatabase sqLiteDatabase = dataBaseClass.getWritableDatabase();
        String[] columns = {DataBaseClass.USERNAME, DataBaseClass.Designation, DataBaseClass.Qualification, DataBaseClass.Experience, DataBaseClass.Email, DataBaseClass.USERTYPE};
        Cursor cursor = sqLiteDatabase.query(DataBaseClass.TABLE_NAME, columns, " Utype=? ", new String[]{mUserType}, null, null, null);
        List<String> allCase = new ArrayList<String>();
        while (cursor.moveToNext()) {
            allCase.add(cursor.getString(0));
        }
        return allCase;
    }


    public SQLiteDatabase getWritableDatabase() {
        return writableDatabase;
    }

    public String getnumber(String mQualification) {

        SQLiteDatabase sqLiteDatabase = dataBaseClass.getWritableDatabase();
        String[] columnes = { MyDataBaseClass.DataBaseClass.Qualification};

        String s= "SELECT * FROM " + MyDataBaseClass.DataBaseClass.TABLE_NAME+ " WHERE "+  MyDataBaseClass.DataBaseClass.Qualification +"="+mQualification;
        Cursor cursor= sqLiteDatabase.rawQuery(s, null);
        cursor.moveToFirst();

        while ( !cursor.isAfterLast()) {
            String name = cursor.getString(cursor.getColumnIndex(MyDataBaseClass.DataBaseClass.Qualification));
            return  name;
        }
        Cursor c = sqLiteDatabase.query(MyDataBaseClass.DataBaseClass.TABLE_NAME, columnes," Utype=? ", new String[]{mQualification}, null, null, null);
        StringBuffer stringBuffer = new StringBuffer();

        while (c.moveToFirst()) {
            String get_my_number = c.getString(0);
            stringBuffer.append("Mobile number  : " + get_my_number+ "#");
        }
        return stringBuffer.toString();
    }

    static class DataBaseClass extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "LOGINDB";
        private static final String TABLE_NAME = "SINGUP";
        private static final String UID = "_id";
        private static final int DATABASE_VERSION = 5;
        private static final String USERNAME = "Userame";
        private static final String Designation = "Designation";
        private static final String Qualification = "Qualification";
        private static final String Experience = "Experience";
        private static final String Email = "Email";
        private static final String USERTYPE = "Utype";
        private static final String dateTime="DateTime";
        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + USERNAME + " VARCHAR(255)," + Designation + " VARCHAR(255)," + Qualification + " VARCHAR(255)," + Experience + " VARCHAR(255)," + Email + " VARCHAR(255)," + USERTYPE + " VARCHAR(255)," + dateTime + " VARCHAR(255));";
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
                Toast.makeText(context, "" + e, Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            try {
                sqLiteDatabase.execSQL(DROP_TABLE);
                onCreate(sqLiteDatabase);
            } catch (SQLException e) {
                Toast.makeText(context, "" + e, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
