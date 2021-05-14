package bt.edu.rub.toco_18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<Sports> mSportsData;
    private SportsAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mSportsData = new ArrayList<>();

        mAdapter = new SportsAdapter(this,mSportsData);
        mRecyclerView.setAdapter(mAdapter);

        initializeData();

    }

    private void initializeData() {
        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.sport_images);
        String[] sportsList = getResources().getStringArray(R.array.sports_title);
        String[] sportsInfo = getResources().getStringArray(R.array.sports_info);

        mSportsData.clear();

        for(int i=0;i<sportsList.length;i++){
            mSportsData.add(new Sports(sportsList[i],sportsInfo[i],sportsImageResources.getResourceId(i,0)));
        }
        mAdapter.notifyDataSetChanged();
        sportsImageResources.recycle();
    }
}