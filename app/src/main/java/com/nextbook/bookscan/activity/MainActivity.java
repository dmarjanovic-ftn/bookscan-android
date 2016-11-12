package com.nextbook.bookscan.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.nextbook.bookscan.R;
import com.nextbook.bookscan.fragment.HomeFragment_;
import com.nextbook.bookscan.fragment.MyBooksFragment_;
import com.nextbook.bookscan.fragment.ScanBookFragment_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @ViewById
    Toolbar toolbar;

    @ViewById
    DrawerLayout drawerLayout;

    @ViewById
    NavigationView navigationView;

    @ViewById
    FrameLayout frame;

    @AfterViews
    void setToolbar() {
        setSupportActionBar(toolbar);
    }

    @AfterViews
    void setDrawer() {
        // FIXME Better implementation
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        // FIXME Better implementation and comment this code
        final int fragmentId = item.getItemId();

        navigationView.setCheckedItem(fragmentId);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame, getFragmentById(fragmentId))
                .commit();

        drawerLayout.closeDrawer(GravityCompat.START);

        return false;
    }

    private Fragment getFragmentById(int fragmentId) {
        switch (fragmentId) {
            case R.id.home:
                return HomeFragment_.builder().build();
            case R.id.scan:
                return ScanBookFragment_.builder().build();
            case R.id.my_books:
                return MyBooksFragment_.builder().build();
            default:
                throw new IllegalArgumentException("No com.nextbook.bookscan.fragment with id " + fragmentId);
        }
    }
}
