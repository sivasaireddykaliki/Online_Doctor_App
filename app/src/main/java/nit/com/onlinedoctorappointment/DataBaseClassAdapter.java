package nit.com.onlinedoctorappointment;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DataBaseClassAdapter {
    DataBaseClass dataBaseClass;


    public DataBaseClassAdapter(Context context) {

        dataBaseClass = new DataBaseClass(context);
    }

    //for showing data  for main class
    public boolean isAuthenticated(String email, String password) {
        SQLiteDatabase sqLiteDatabase = dataBaseClass.getWritableDatabase();

        String[] columns = {DataBaseClass.EMAIL, DataBaseClass.PASSWORD};
        String[] selectionArgs = {email, password};
        Cursor cursor = sqLiteDatabase.query
                (DataBaseClass.TABLE_NAME, columns, "Email=? And Pwd=?", new String[]{email, password}, null, null, null);

        Boolean f = false;

        if (cursor.moveToNext()) {
            f = true;
        }
        return f;
    }

    //==============================================================
    public long insert(String Name, String Email, String Pwd, String Cpwd) {
        SQLiteDatabase sqLiteDatabase = dataBaseClass.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseClass.NAME, Name);
        contentValues.put(DataBaseClass.EMAIL, Email);
        contentValues.put(DataBaseClass.PASSWORD, Pwd);
        contentValues.put(DataBaseClass.CONFIRMPASSWORD, Cpwd);


        long id = sqLiteDatabase.insert(DataBaseClass.TABLE_NAME, null, contentValues);
        return id;

    }

    public String alluserdata() {
        SQLiteDatabase sqLiteDatabase = dataBaseClass.getWritableDatabase();
        String[] columns = {DataBaseClassAdapter.DataBaseClass.NAME, DataBaseClassAdapter.DataBaseClass.EMAIL, DataBaseClassAdapter.DataBaseClass.PASSWORD, DataBaseClassAdapter.DataBaseClass.CONFIRMPASSWORD};
        Cursor cursor = sqLiteDatabase.query(DataBaseClassAdapter.DataBaseClass.TABLE_NAME, columns, null,null, null, null, null);
//        List<String> allCase = new ArrayList<String>();
        StringBuffer stringBuffer= new StringBuffer();
        while (cursor.moveToNext()) {
//            allCase.add(cursor.getString(0));
//            allCase.add(cursor.getString(1));
//            allCase.add(cursor.getString(2));
//            allCase.add(cursor.getString(3));

            String get_name = cursor.getString(0);
            String get_email = cursor.getString(1);
            String get_password = cursor.getString(2);
            String get_Cpassword = cursor.getString(3);



            stringBuffer.append("Name  :  " + get_name + ", Email-id  :  " + get_email + ",  Password  :  "+get_password +",  CPassword  :   "+get_Cpassword+  "#");
        }
        //return String.valueOf(allCase);
        return stringBuffer.toString();
    }

    //=======================================================================

    public String showpassword(String Email) {
        SQLiteDatabase sqLiteDatabase;
        sqLiteDatabase = dataBaseClass.getWritableDatabase();
        String[] columns = {DataBaseClass.EMAIL, DataBaseClass.PASSWORD};

        Cursor cursor = sqLiteDatabase.query(DataBaseClassAdapter.DataBaseClass.TABLE_NAME, columns, "Email=?", new String[]{Email}, null, null, null);


        StringBuffer stringBuffer = new StringBuffer();

        while (cursor.moveToNext()) {

            int indexpwd = cursor.getColumnIndex(DataBaseClass.PASSWORD);
            String get_pwd_from_db = cursor.getString(indexpwd);
            stringBuffer.append("Password: " + get_pwd_from_db);
        }
        return stringBuffer.toString();
    }


    //=======================================================================

    static class DataBaseClass extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "PATIENT";
        private static final String TABLE_NAME = "PATIENTREG";
        private static final String UID = "_id";
        private static final int DATABASE_VERSION = 3;
        private static final String NAME = "Name";
        private static final String EMAIL = "Email";
        private static final String PASSWORD = "Pwd";
        private static final String CONFIRMPASSWORD = "Cpwd";


        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255)," + EMAIL + " VARCHAR(255)," + PASSWORD + " VARCHAR(255)," + CONFIRMPASSWORD + " VARCHAR(255));";

        private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        private Context context;


        public DataBaseClass(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
            //Message.message(context, "constructor is called");
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            try {
                sqLiteDatabase.execSQL(CREATE_TABLE);
                // Message.message(context, "onCreate  is called");
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
                // Message.message(context, "onUpgrade is called");

            } catch (SQLException e) {
                Message.message(context, "" + e);
            }
        }
    }

}

