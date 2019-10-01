package id.go.pajak.fiskusapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import id.go.pajak.fiskusapp.models.UserHelper;
import id.go.pajak.fiskusapp.presenters.UserPresenter;

public class PreconfigActivity extends AppCompatActivity {
    private Integer timer = 3000;
    private Integer mProgressStatus = 0 ;
    private Handler mHandler;

    private static final String TAG = "MainActivity";
    Context context;

    private String user,pass;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preconfig);

        Boolean insertUser;
        String tableUserStatus = "";
        String userStatus ="";
        TextView tvUsersStatus = findViewById(R.id.texviewUsersStatus);
        TextView tvTablesStatus = findViewById(R.id.texviewTablesStatus);

        if(getIntent().getExtras()!=null){

            Bundle bundle = getIntent().getExtras();
            user = bundle.getString("user");
            pass = bundle.getString("password");

        }else{
            user = getIntent().getStringExtra("user");
            pass = getIntent().getStringExtra("password");
        }



        UserPresenter userPresenter = new UserPresenter(null);

        UserHelper userHelper = new UserHelper(this);
        Boolean cekTableCreated = userHelper.cekTable();
        if (!cekTableCreated) {
            tableUserStatus = userPresenter.createTableUserStatus(cekTableCreated, userHelper.TABLE_NAME);
        }

        Boolean cekCountTable = userHelper.cekUserInserted();
        if (!cekCountTable) {

            SQLiteDatabase db = userHelper.getReadableDatabase();
            ContentValues values=new ContentValues();
            insertUser = true;
            values.put("user","060105300");
            values.put("password","alisyahbani");
            values.put("nip19","198405152003121004");
            values.put("nama","Ikhsan Alisyahbani");
            values.put("unitkerja","Direktorat Teknologi Informasi dan Komunikasi");
            values.put("jabatan","PRAKOM");

            try{db.insert(userHelper.TABLE_NAME,null,values);}
            catch (SQLiteException sqlException) {
                insertUser=false;
            }

            userStatus=userPresenter.insertUserStatus(insertUser,"060105300");
        }



        tvUsersStatus.setText(userStatus);
        tvTablesStatus.setText(tableUserStatus);

        //Log.e(TAG, "onCreate: "+ tableUserStatus,null );
        //insertUserStatus = userPresenter.insertUser();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent gotoMain =  new Intent(PreconfigActivity.this,MainActivity.class);
                startActivity(gotoMain);
                finish();
            }
        },timer);



        final ProgressBar mProgressBar =  findViewById(R.id.progressBar);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(mProgressStatus < 100){
                    mProgressStatus++;
                    android.os.SystemClock.sleep(50);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar.setProgress(mProgressStatus);
                        }
                    });
                }

            }
        });

    }
}
