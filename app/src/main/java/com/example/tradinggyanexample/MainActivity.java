package com.example.tradinggyanexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.example.tradinggyanexample.activity.MyActivity;
import com.example.tradinggyanexample.fragment.LoginFragment;
import com.example.tradinggyanexample.ui.ContactFragment;
import com.example.tradinggyanexample.ui.HomeFragment;
import com.example.tradinggyanexample.ui.RaiseaticketFragment;
import com.example.tradinggyanexample.ui.TradingFragment;
import com.example.tradinggyanexample.ui.disclaimer.DisclaimerFragment;
import com.example.tradinggyanexample.ui.knowledgecenter.KnowledgeFragment;
import com.example.tradinggyanexample.ui.myprofile.MyProfileFragment;
import com.example.tradinggyanexample.ui.notification.NotificationFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import static com.example.tradinggyanexample.activity.MyActivity.appPreference;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.nav_logout:
                        logout();
                        break;

                    case R.id.nav_home:
                        toolbar.setTitle("Home");
                        getSupportFragmentManager()
                                .beginTransaction()
                                .addToBackStack(null)
                                .replace(R.id.nav_host_fragment, new HomeFragment())
                                .commit();
                        break;

                    case R.id.nav_trading:
                        toolbar.setTitle("Trading");
                        getSupportFragmentManager()
                                .beginTransaction()
                                .addToBackStack(null)

                                .replace(R.id.nav_host_fragment, new TradingFragment())
                                .commit();
                        break;

                    case R.id.nav_knowledge:
                        toolbar.setTitle("Knowledge");
                        getSupportFragmentManager()
                                .beginTransaction()
                                .addToBackStack(null)

                                .replace(R.id.nav_host_fragment, new KnowledgeFragment())
                                .commit();
                        break;

                    case R.id.nav_notification:
                        toolbar.setTitle("Notification");
                        getSupportFragmentManager()
                                .beginTransaction()
                                .addToBackStack(null)

                                .replace(R.id.nav_host_fragment, new NotificationFragment())
                                .commit();
                        break;

                    case R.id.nav_myprofile:
                        toolbar.setTitle("My Profile");
                        getSupportFragmentManager()
                                .beginTransaction()
                                .addToBackStack(null)

                                .replace(R.id.nav_host_fragment, new MyProfileFragment())
                                .commit();
                        break;

                    case R.id.nav_contact:
                        toolbar.setTitle("Contact");
                        getSupportFragmentManager()
                                .beginTransaction()
                                .addToBackStack(null)

                                .replace(R.id.nav_host_fragment, new ContactFragment())
                                .commit();
                        break;

                    case R.id.nav_raiseaticket:
                        toolbar.setTitle("Raiseticket");
                        getSupportFragmentManager()
                                .beginTransaction()
                                .addToBackStack(null)

                                .replace(R.id.nav_host_fragment, new RaiseaticketFragment())
                                .commit();
                        break;

                    case R.id.nav_disclaimer:
                        toolbar.setTitle("Disclaimer");
                        getSupportFragmentManager()
                                .beginTransaction()

                                .addToBackStack(null)
                                .replace(R.id.nav_host_fragment, new DisclaimerFragment())
                                .commit();
                        break;

                    case R.id.nav_community:
                        Toast.makeText(MainActivity.this, "Community", Toast.LENGTH_SHORT).show();
                        break;


                }
                if (item.getItemId() == 1) {
                    drawer.openDrawer(GravityCompat.START);
                } else
                    drawer.closeDrawer(GravityCompat.START);
                return false;
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    public void logout() {
        appPreference.setLoginStatus(false);
        appPreference.setDisplayName("Name");
        appPreference.setDisplayEmail("Email");
        appPreference.setCreDate("DATE");
        Intent intent=new Intent(getApplicationContext(), MyActivity.class);
        startActivity(intent);
      /*  getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new LoginFragment())
                .commit();*/
    }
}
