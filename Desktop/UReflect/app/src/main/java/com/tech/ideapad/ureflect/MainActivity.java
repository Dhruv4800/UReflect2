package com.tech.ideapad.ureflect;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FloatingActionButton fab, fab_daily, fab_weekly, fab_monthly;
    Animation fabopen, fabclosed, fabRclockwise, fabRanticlockwise;
    boolean isopen = false;
    TextView daily, weekly, monthly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Calendar calendar = Calendar.getInstance();

        calendar.set(calendar.HOUR_OF_DAY, 23);
        calendar.set(calendar.MINUTE, 51);
        calendar.set(calendar.SECOND, 50);

        Intent intent = new Intent(getApplicationContext(), Notification_receiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext()
                , 100, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, pendingIntent);


        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab_daily = (FloatingActionButton) findViewById(R.id.fab_daily);
        fab_weekly = (FloatingActionButton) findViewById(R.id.fab_weekly);
        fab_monthly = (FloatingActionButton) findViewById(R.id.fab_monthly);
        fabopen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fabclosed = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        fabRclockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);
        fabRanticlockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anticlockwise);
        daily = (TextView) findViewById(R.id.txtdaily);
        weekly = (TextView) findViewById(R.id.txtweekly);
        monthly = (TextView) findViewById(R.id.txtmonthly);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isopen) {
                    fab_daily.startAnimation(fabclosed);
                    fab_weekly.startAnimation(fabclosed);
                    fab_monthly.startAnimation(fabclosed);
                    fab.startAnimation(fabRanticlockwise);
                    fab_weekly.setClickable(false);
                    fab_daily.setClickable(false);
                    fab_monthly.setClickable(false);
                    daily.setVisibility(View.INVISIBLE);
                    weekly.setVisibility(View.INVISIBLE);
                    monthly.setVisibility(View.INVISIBLE);
                    isopen = false;

                } else {
                    fab_daily.startAnimation(fabopen);
                    fab_weekly.startAnimation(fabopen);
                    fab_monthly.startAnimation(fabopen);
                    fab.startAnimation(fabRclockwise);
                    fab_weekly.setClickable(true);
                    fab_daily.setClickable(true);
                    fab_monthly.setClickable(true);
                    daily.setVisibility(View.VISIBLE);
                    weekly.setVisibility(View.VISIBLE);
                    monthly.setVisibility(View.VISIBLE);
                    isopen = true;
                }
            }

        });

        fab_daily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isopen) {
                    fab_daily.startAnimation(fabclosed);
                    fab_weekly.startAnimation(fabclosed);
                    fab_monthly.startAnimation(fabclosed);
                    fab.startAnimation(fabRanticlockwise);
                    fab_weekly.setClickable(false);
                    fab_daily.setClickable(false);
                    fab_monthly.setClickable(false);
                    daily.setVisibility(View.INVISIBLE);
                    weekly.setVisibility(View.INVISIBLE);
                    monthly.setVisibility(View.INVISIBLE);
                    isopen = false;

                } else {
                    fab_daily.startAnimation(fabopen);
                    fab_weekly.startAnimation(fabopen);
                    fab_monthly.startAnimation(fabopen);
                    fab.startAnimation(fabRclockwise);
                    fab_weekly.setClickable(true);
                    fab_daily.setClickable(true);
                    fab_monthly.setClickable(true);
                    daily.setVisibility(View.VISIBLE);
                    weekly.setVisibility(View.VISIBLE);
                    monthly.setVisibility(View.VISIBLE);
                    isopen = true;
                }

            }
        });


        fab_weekly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isopen) {
                    fab_daily.startAnimation(fabclosed);
                    fab_weekly.startAnimation(fabclosed);
                    fab_monthly.startAnimation(fabclosed);
                    fab.startAnimation(fabRanticlockwise);
                    fab_weekly.setClickable(false);
                    fab_daily.setClickable(false);
                    fab_monthly.setClickable(false);
                    daily.setVisibility(View.INVISIBLE);
                    weekly.setVisibility(View.INVISIBLE);
                    monthly.setVisibility(View.INVISIBLE);
                    isopen = false;

                } else {
                    fab_daily.startAnimation(fabopen);
                    fab_weekly.startAnimation(fabopen);
                    fab_monthly.startAnimation(fabopen);
                    fab.startAnimation(fabRclockwise);
                    fab_weekly.setClickable(true);
                    fab_daily.setClickable(true);
                    fab_monthly.setClickable(true);
                    daily.setVisibility(View.VISIBLE);
                    weekly.setVisibility(View.VISIBLE);
                    monthly.setVisibility(View.VISIBLE);
                    isopen = true;
                }

            }
        });

        fab_monthly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isopen) {
                    fab_daily.startAnimation(fabclosed);
                    fab_weekly.startAnimation(fabclosed);
                    fab_monthly.startAnimation(fabclosed);
                    fab.startAnimation(fabRanticlockwise);
                    fab_weekly.setClickable(false);
                    fab_daily.setClickable(false);
                    fab_monthly.setClickable(false);
                    daily.setVisibility(View.INVISIBLE);
                    weekly.setVisibility(View.INVISIBLE);
                    monthly.setVisibility(View.INVISIBLE);
                    isopen = false;

                } else {
                    fab_daily.startAnimation(fabopen);
                    fab_weekly.startAnimation(fabopen);
                    fab_monthly.startAnimation(fabopen);
                    fab.startAnimation(fabRclockwise);
                    fab_weekly.setClickable(true);
                    fab_daily.setClickable(true);
                    fab_monthly.setClickable(true);
                    daily.setVisibility(View.VISIBLE);
                    weekly.setVisibility(View.VISIBLE);
                    monthly.setVisibility(View.VISIBLE);
                    isopen = true;
                }

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /*if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, AppUsageStatisticsFragment.newInstance())
                    .commit();

        }*/
        if (savedInstanceState == null){ Start appCategory=new Start();
        FragmentManager manager=getSupportFragmentManager();
        manager.beginTransaction().replace(
                R.id.Relative_layout,
                appCategory,
                appCategory.getTag()

        ).commit();}



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Start appCategory=new Start();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(
                    R.id.Relative_layout,
                    appCategory,
                    appCategory.getTag()

            ).commit();


        } else if (id == R.id.nav_appusage) {
            AppUsageStatisticsFragment appUsageStatisticsFragment = new AppUsageStatisticsFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(
                    R.id.Relative_layout,
                    appUsageStatisticsFragment,
                    appUsageStatisticsFragment.getTag()

            ).commit();


        } else if (id == R.id.nav_setting) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);


        } else if (id == R.id.nav_usagefeed) {
            BlankFragment appCategory=new BlankFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(
                    R.id.Relative_layout,
                    appCategory,
                    appCategory.getTag()

            ).commit();

        } else if (id == R.id.nav_about) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
