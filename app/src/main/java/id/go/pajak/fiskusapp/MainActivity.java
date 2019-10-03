package id.go.pajak.fiskusapp;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import id.go.pajak.fiskusapp.models.UserHelper;
import id.go.pajak.fiskusapp.views.CariWP;
import id.go.pajak.fiskusapp.views.HelpView;
import id.go.pajak.fiskusapp.views.CariPegawaiView;
import id.go.pajak.fiskusapp.views.CekKepatuhan;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "";
    DrawerLayout mDrawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle drawerToggle;
    TextView tvUnitkerja;
    TextView tvNama;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserHelper userHelper= new UserHelper(this);

        String tblcreatedstatus="users inserted";
        if(!userHelper.cekUserInserted()){
            tblcreatedstatus="users empty";
            Intent gotoPreconfig = new Intent(MainActivity.this,LoginsActivity.class);
            startActivity(gotoPreconfig);
        }
        Log.e(TAG, "cekTableCreated: "+tblcreatedstatus,null );



        tvNama = findViewById(R.id.tvNama);
        tvUnitkerja = findViewById(R.id.tvUnitkerja);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null){
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }

        mDrawerLayout = findViewById(R.id.drawer_layout);
        drawerToggle = setupDrawerToggle();

        NavigationView navigationView = findViewById(R.id.nav_view);
        mDrawerLayout.addDrawerListener(drawerToggle);

        if(setupNavDrawer(navigationView)){
            setupNavDrawer(navigationView);
        }else {
            Fragment fragment = new CariPegawaiView();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
        }


    }

    private ActionBarDrawerToggle setupDrawerToggle(){
        return new ActionBarDrawerToggle(
                this,
                mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
    }

    private boolean setupNavDrawer(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = new Fragment();
                switch (item.getItemId()){
                    case R.id.nav_home:
                        fragment = new CariPegawaiView();
                        break;
                    case R.id.nav_gallery:
                        fragment = new CariWP();
                        break;
                    case R.id.nav_share:
                        fragment = new CekKepatuhan();
                        break;
                    case R.id.nav_help:
                        fragment = new HelpView();
                        break;
                    default:
                        fragment = new CariPegawaiView();
                }

                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

                item.setChecked(true);
                setTitle(item.getTitle());
                mDrawerLayout.closeDrawers();

                return true;
            }
        });
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                mDrawerLayout.openDrawer(Gravity.START);
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }


}
