package com.demo_staggered.pulkit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.demo_staggered.pulkit.adapters.StaggeredAdapter;
import com.demo_staggered.pulkit.models.ItemObjects;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public RecyclerView recycler_view;
    public StaggeredAdapter staggeredAdapter;
    public ArrayList<ItemObjects> staggeredList = new ArrayList<>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findIds();
        init();
    }
    
    private void findIds() {
        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);
    }

    private void init() {

        recycler_view.setLayoutManager(new StaggeredGridLayoutManager(3,1));

        getListItemData();
        setAdapter();
    }

    private void setAdapter() {

        staggeredAdapter = new StaggeredAdapter(getApplicationContext(), staggeredList, new StaggeredAdapter.onClickListener() {
            @Override
            public void onClickButton(int position, int view, ItemObjects product) {
                
            }
        });
        recycler_view.setAdapter(staggeredAdapter);
    }

    private void getListItemData(){
        
        /*List of items*/
        staggeredList.add(new ItemObjects("Alkane", R.drawable.one));
        staggeredList.add(new ItemObjects("Ethane", R.drawable.two));
        staggeredList.add(new ItemObjects("Alkyne", R.drawable.three));
        staggeredList.add(new ItemObjects("Benzene", R.drawable.four));
        staggeredList.add(new ItemObjects("Amide", R.drawable.one));
        staggeredList.add(new ItemObjects("Amino Acid", R.drawable.two));
        staggeredList.add(new ItemObjects("Phenol", R.drawable.three));
        staggeredList.add(new ItemObjects("Carbonxylic", R.drawable.four));
        staggeredList.add(new ItemObjects("Nitril", R.drawable.one));
        staggeredList.add(new ItemObjects("Ether", R.drawable.two));
        staggeredList.add(new ItemObjects("Ester", R.drawable.three));
        staggeredList.add(new ItemObjects("Alcohol", R.drawable.four));
        
    }
        
}
