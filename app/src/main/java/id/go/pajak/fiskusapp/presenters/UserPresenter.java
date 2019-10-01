package id.go.pajak.fiskusapp.presenters;



import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import id.go.pajak.fiskusapp.models.UserHelper;





public class UserPresenter extends SQLiteOpenHelper {

    //UserHelper userHelper;
    public static final String DATABASE_NAME = "fiskusapp.db";
    public static final String DATABASE_PATH = "/data/data/id.go.pajak.fiskusapp/databases/";
    public static final int DATABASE_VERSION = 1;
    public static final String KEY_JABATAN = "jabatan";
    public static final String TABLE_NAME="users";

    public static final String KEY_ID = "id";
    public static final String KEY_NIP9 = "user";
    public static final String KEY_PWD = "pwd";
    public static final String KEY_NIP19 = "nip19";
    public static final String KEY_NAMA = "nama";
    public static final String KEY_UNITKERJA = "unitkerja";

    public UserPresenter(@Nullable Context context) {
        super(context, TABLE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String insertUserStatus(Boolean inputResult,String user){
        String userStatus="";
        if(inputResult){
            userStatus = "User "+user+" sudah ada";
        }else{
            userStatus="User "+user+" Berhasil diimport";
        }
        return userStatus;
    }

    public String createTableUserStatus(Boolean inputResult,String table){
        String userStatus="User "+table+" Gagal dicreate";
        if(inputResult){

        }else{
            userStatus="User "+table+" Berhasil dicreate";
        }
        return userStatus;
    }

    public String insertUser(){
        UserHelper userHelper= new UserHelper(null);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values=new ContentValues();

        String result060105300 = "User 060108500 Inserted";
        values.put("nip9","060105300");
        values.put("password","alisyahbani");
        values.put("nip19","198405152003121004");
        values.put("nama","Ikhsan Alisyahbani");
        values.put("unit","Direktorat Teknologi Informasi dan Komunikasi");
        values.put("jabatan","PRAKOM");
        try{db.insert(userHelper.TABLE_NAME,null,values);}
        catch (SQLiteException sqlException) {
            result060105300="User 060108500 NOT Inserted";
        }

        db.close();

        return result060105300+"dsdsd ";
    }

}
