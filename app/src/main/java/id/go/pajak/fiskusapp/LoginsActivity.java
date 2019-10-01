package id.go.pajak.fiskusapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class LoginsActivity extends AppCompatActivity {

    public LoginsActivity() {
    }
    ImageView imageViewUser;
    String user;
    EditText editTextUser, editTextPassword;
    Bundle bundle ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logins);
        editTextUser = findViewById(R.id.editTextUser);
        editTextPassword = findViewById(R.id.editTextPassword);
        String stringPassword = editTextPassword.getText().toString();
        String user = "";
        imageViewUser = findViewById(R.id.loginPic);

        editTextUser.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String stringUser= editTextUser.getText().toString();
                if (stringUser.equalsIgnoreCase("123")){

                } else if(stringUser.length()==18){
                    String url ="https://account.kemenkeu.go.id/manage/Uploads/"+stringUser+".jpg";
                    int loader = R.drawable.loader;
                    ImageLoader imgLoader = new ImageLoader(getApplicationContext());
                    imgLoader.DisplayImage(url, loader, imageViewUser);
                }

            }
        });




        Button buttonLogin = findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle = new Bundle();
                bundle.putString("user",editTextUser.getText().toString());
                bundle.putString("password",editTextPassword.getText().toString());
                Intent gotoMain =  new Intent(LoginsActivity.this,PreconfigActivity.class);
                gotoMain.putExtras(bundle);
                startActivity(gotoMain);
//                finish();
            }
        });

    }



}
