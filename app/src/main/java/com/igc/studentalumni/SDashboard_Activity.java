package com.igc.studentalumni;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.ss.bottomnavigation.BottomNavigation;
import com.ss.bottomnavigation.events.OnSelectedItemChangeListener;

public class SDashboard_Activity extends AppCompatActivity {

    private boolean doublebackpressedonce = false;
    BottomNavigation bottomNavigation;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sactivity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bottomNavigation = findViewById(R.id.btmDash);
        frag_nav();
    }
    private void frag_nav(){
        bottomNavigation.setOnSelectedItemChangeListener(new OnSelectedItemChangeListener() {
            @Override
            public void onSelectedItemChanged(int i) {

                switch (i)
                {
                    case R.id.tbAlumni:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frmNavigate,new SAlumni_Fragment());
                        break;
                    case R.id.tbPlacements:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frmNavigate,new SPlacements_Fragment());
                        break;
                    case R.id.tbNotices:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frmNavigate,new SNotices_Fragment());
                        break;
                    case R.id.tbEvent:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frmNavigate,new S_Events_Activity());
                        break;
                    case R.id.tbProfile:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frmNavigate,new SProfile_Fragment());
                        break;
                }
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                AlertDialog.Builder dlg = new AlertDialog.Builder(SDashboard_Activity.this);
                dlg.setMessage("Do you want to LogOut?");
                dlg.setPositiveButton("YES.", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        startActivity(new Intent(SDashboard_Activity.this,SLogin.class));
                    }
                });
                dlg.setNegativeButton("NO.",null);
                dlg.show();
                //finish();
                //return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.doublebackpressedonce = false;
    }

    @Override
    public void onBackPressed() {
        if (doublebackpressedonce)
        {
            super.onBackPressed();
            return;
        }
        this.doublebackpressedonce = true;
        Toast.makeText(this, "tap back twice to exit", Toast.LENGTH_SHORT).show();
    }
}