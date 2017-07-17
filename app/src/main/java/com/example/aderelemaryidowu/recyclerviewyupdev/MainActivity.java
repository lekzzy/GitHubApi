package com.example.aderelemaryidowu.recyclerviewyupdev;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    RecyclerView mRecyclerView;
    RecyclerViewAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    String [] f_name, d_name;
    int [] img_res = {R.drawable.baby_driver, R.drawable.batman, R.drawable.batman_forever,R.drawable.beauty_and_the_beast,
                      R.drawable.first_daughter, R.drawable.ghost_busters, R.drawable.john_wick2, R.drawable.justice_league_dark,
                    R.drawable.la_la_land, R.drawable.michael_clayton, R.drawable.outbreak, R.drawable.power_rangers,
    R.drawable.first_daughter, R.drawable.the_interview, R.drawable.rough_night, R.drawable.the_saint};
    ArrayList<DataProvider> arrayList = new ArrayList<DataProvider>();

    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        f_name = getResources().getStringArray(R.array.film_names);
        d_name = getResources().getStringArray(R.array.directory_names);
        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        int i = 0;
        for(String name : f_name)
        {
            DataProvider dataProvider = new DataProvider(img_res[i], name, d_name[i]);
            arrayList.add(dataProvider);
            i++;
        }
        mAdapter = new RecyclerViewAdapter(arrayList, this);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        ArrayList<DataProvider> mArrayList = new ArrayList<>();
        for(DataProvider dataProvider : arrayList)
        {
            String name = dataProvider.getFilmName();
            if(name.contains(newText))
            {
                mArrayList.add(dataProvider);
            }
        }
        mAdapter.searchFilter(mArrayList);
        return true;
    }
}
