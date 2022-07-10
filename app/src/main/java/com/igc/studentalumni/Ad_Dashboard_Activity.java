package com.igc.studentalumni;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.ss.bottomnavigation.BottomNavigation;
import com.ss.bottomnavigation.events.OnSelectedItemChangeListener;

public class Ad_Dashboard_Activity extends AppCompatActivity {
    BottomNavigation bottomNavigation;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ad_activity_dashboard_);
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
                        fragmentTransaction.replace(R.id.frmNavigate,new Ad_Alumni_Fragment());
                        break;
                    case R.id.tbStudent:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frmNavigate,new Ad_Stundent_Fragment());
                        break;
                    case R.id.tbPlacements:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frmNavigate,new Ad_Placements_Fragment());
                        break;
                    case R.id.tbEvent:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frmNavigate,new Ad_Events_Activity());
                        break;
                    case R.id.tbNotices:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frmNavigate,new Ad_Notices_Fragment());
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
                AlertDialog.Builder dlg = new AlertDialog.Builder(Ad_Dashboard_Activity.this);
                dlg.setMessage("Do you want to LogOut?");
                dlg.setPositiveButton("YES.", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        startActivity(new Intent(Ad_Dashboard_Activity.this,SLogin.class));
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
}