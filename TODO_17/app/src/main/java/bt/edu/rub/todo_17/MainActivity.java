package bt.edu.rub.todo_17;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int mScore1;
    private int mScore2;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.night_mode){
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    private TextView mTextScore1;
    private TextView mTextScore2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextScore1 = findViewById(R.id.score_1);
        mTextScore2 = findViewById(R.id.score_2);
    }

    public void Increase_score(View view) {
        int viewID = view.getId();
        switch (viewID){
            case R.id.increaseTeam1:
                mScore1++;
                mTextScore1.setText(String.valueOf(mScore1));
                break;

            case R.id.increaseTeam2:
                mScore2++;
                mTextScore2.setText(String.valueOf(mScore2));
                break;
        }
    }

    public void Decrease_score(View view) {
        int viewID = view.getId();
        switch (viewID){
            case R.id.decreaseTeam1:
                mScore1--;
                mTextScore1.setText(String.valueOf(mScore1));
                break;

            case R.id.decreaseTeam2:
                mScore2--;
                mTextScore2.setText(String.valueOf(mScore2));
                break;
        }
    }
}