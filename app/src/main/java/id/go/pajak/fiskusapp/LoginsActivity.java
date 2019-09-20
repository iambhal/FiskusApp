package id.go.pajak.fiskusapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logins);



        EditText editTextUser = findViewById(R.id.editTextUser);
        String stringUser = editTextUser.getText().toString();
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        String stringPassword = editTextPassword.getText().toString();

        final Bundle bundle = new Bundle();
        bundle.putString("user",stringUser);
        bundle.putString("password",stringPassword);

        Button buttonLogin = findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoMain =  new Intent(LoginsActivity.this,PreconfigActivity.class);
                gotoMain.putExtras(bundle);
                startActivity(gotoMain);
                finish();
            }
        });


    }

}
