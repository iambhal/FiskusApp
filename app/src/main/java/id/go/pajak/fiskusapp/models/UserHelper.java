package id.go.pajak.fiskusapp.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class UserHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "fiskusapp.db";
    public static final String DATABASE_PATH = "/data/data/id.go.pajak.fiskusapp/databases/";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME="users";

    public static final String KEY_ID = "id";
    public static final String KEY_NIP9 = "user";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_NIP19 = "nip19";
    public static final String KEY_NAMA = "nama";
    public static final String KEY_UNITKERJA = "unitkerja";
    public static final String KEY_JABATAN = "jabatan";


    public UserHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreateTableUser = "CREATE TABLE  IF NOT EXISTS "+TABLE_NAME+" ("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_NIP9+" TEXT NOT NULL, "+KEY_PASSWORD+" TEXT NOT NULL, " +
                KEY_NIP19+" TEXT NOT NULL, "+KEY_NAMA+" TEXT NOT NULL, " +
                KEY_UNITKERJA+" TEXT NOT NULL, "+KEY_JABATAN+" TEXT NOT NULL)";
        db.execSQL(sqlCreateTableUser);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }


    public Boolean cekTable() {
        Boolean result = true;
        SQLiteDatabase db = getReadableDatabase();
        String sqlUser = "SELECT * FROM "+ TABLE_NAME;
        try{
            Cursor cursor = db.rawQuery(sqlUser,null);
        }catch (SQLiteException sqlException){
            result = false;
        }
        return result;
    }

    public Boolean cekUserInserted() {
        Boolean result;
        SQLiteDatabase db = getReadableDatabase();
        String sqlUser = "SELECT * FROM "+ TABLE_NAME;

            Cursor cursor = db.rawQuery(sqlUser,null);
        if(cursor.getCount()>1){
            result = true;
        }else {
            result = false;
        }
        return result;
    }



    public UserModel findByid(Integer id){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor=db.query(TABLE_NAME, new String[]{KEY_ID,KEY_NIP9,KEY_PASSWORD,KEY_NIP19,KEY_NAMA,KEY_UNITKERJA,KEY_JABATAN},
                KEY_ID+"=?", new String[]{String.valueOf(id)},null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }

        return new UserModel(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),cursor.getString(2),
                cursor.getString(3),cursor.getString(4),
                cursor.getString(5),cursor.getString(6)
        );
    }

    public UserModel findUser(String key){
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor=db.query(TABLE_NAME, new String[]{KEY_ID,KEY_NIP9,KEY_PASSWORD,KEY_NIP19,KEY_NAMA,KEY_UNITKERJA,KEY_JABATAN},
                KEY_NIP9+"=?", new String[]{key},null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }

        return new UserModel(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),cursor.getString(2),
                cursor.getString(3),cursor.getString(4),
                cursor.getString(5),cursor.getString(6)
        );

    }

    public List<UserModel> findAll(){
        List<UserModel> listUserModels =new ArrayList<UserModel>();
        String query="SELECT * FROM "+ TABLE_NAME;

        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                UserModel user=new UserModel();
                user.setId(Integer.valueOf(cursor.getString(0)));
                user.setNip9(cursor.getString(1));
                user.setPwd(cursor.getString(2));
                user.setNip19(cursor.getString(3));
                user.setNama(cursor.getString(4));
                user.setUnitkerja(cursor.getString(5));
                user.setJabatan(cursor.getString(6));
                listUserModels.add(user);
            }while (cursor.moveToNext());
        }

        return listUserModels;
    }

    public void update(UserModel User){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values=new ContentValues();

        values.put(KEY_NIP9,User.getNip9());
        values.put(KEY_PASSWORD,User.getPwd());
        values.put(KEY_NIP19,User.getNip19());
        values.put(KEY_NAMA,User.getNama());
        values.put(KEY_UNITKERJA,User.getUnitkerja());
        values.put(KEY_JABATAN,User.getJabatan());

        db.update(TABLE_NAME, values, KEY_ID+"=?", new String[]{String.valueOf(User.getId())});
        db.close();
    }

    public void insert(UserModel User){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values=new ContentValues();

        values.put(KEY_NIP9,User.getNip9());
        values.put(KEY_PASSWORD,User.getPwd());
        values.put(KEY_NIP19,User.getNip19());
        values.put(KEY_NAMA,User.getNama());
        values.put(KEY_UNITKERJA,User.getUnitkerja());
        values.put(KEY_JABATAN,User.getJabatan());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Boolean delete(UserModel User){
        Boolean checkFlag =true;

        SQLiteDatabase db=getWritableDatabase();
        try {
            db.delete(TABLE_NAME, KEY_ID+"=?", new String[]{String.valueOf(User.getId())});
        }catch (SQLiteException sqlException) {
            checkFlag=false;
        }
        db.close();

        return checkFlag;
    }

    public Boolean cekDbPresent() {
        Boolean checkFlag =true;

        try{
            SQLiteDatabase.openDatabase(DATABASE_PATH+DATABASE_NAME, null,
                    SQLiteDatabase.OPEN_READWRITE);
        }
        catch(SQLiteException sqlException){

            checkFlag=false;
        }

        return checkFlag;

    }



    public void createTabel(SQLiteDatabase db) {
        String sqlUser = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+KEY_ID+" INTEGER PRIMARY KEY, " +
                KEY_NIP9+" TEXT, "+KEY_PASSWORD+" TEXT, " +
                KEY_NIP19+" TEXT, "+KEY_NAMA+" TEXT, " +
                KEY_UNITKERJA+" TEXT, "+KEY_JABATAN+" TEXT)";
        db.execSQL(sqlUser);
    }





    public Boolean cekLogin() {
        SQLiteDatabase db = this.getReadableDatabase();

        String sqlUser = "SELECT * FROM token WHERE created < NOW()  AND expired < NOW() ";
        Cursor cursor = db.rawQuery(sqlUser,null);
        if(cursor.getCount() >0){
            return true;
        }else{
            return false;
        }
    }
}
