package com.example.marwaadel.shopowner;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.marwaadel.shopowner.model.OfferDataModel;

public class showoffers extends AppCompatActivity {
    Toolbar toolbar;
    private SearchView searchView;
    private MenuItem searchMenuItem;
    private ImageView mTitleView;
    private String mInput;
    private Toolbar mToolbar;
    OfferDataModel offer;
    offerAdapter OfferAdapter;
    GridView gridview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showoffers);
//       toolbar = (Toolbar) findViewById(R.id.toolbar);
// toolbar.setNavigationIcon(R.drawable.sidemenu);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);


        this.mToolbar = ((Toolbar) findViewById(R.id.my_toolbar));
        this.mTitleView = ((ImageView) findViewById(R.id.title));
        setSupportActionBar(this.mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        mToolbar.setNavigationIcon(R.drawable.sidemenu);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        Intent myIntent = getIntent();
        if (Intent.ACTION_SEARCH.equals(myIntent.getAction())) {
            String query = myIntent.getStringExtra(SearchManager.QUERY);

 //   gridview = (GridView) findViewById(R.id.mGridView);
//            Firebase refListName = new Firebase(Constants.FIREBASE_URL_ACTIVE_LIST);
//            Query query2 = refListName.orderByChild("Title").equalTo(query);
//            OfferAdapter=new offerAdapter (this,OfferDataModel.class,R.layout.offeritem,query2);
//            gridview.setAdapter(OfferAdapter);
            Toast.makeText(this, query, Toast.LENGTH_SHORT).show();//here imp afetr click search

        }

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (OfferAdapter != null) {
            OfferAdapter.cleanup();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_showoffers, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        SearchManager searchManger = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManger.getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }


}
