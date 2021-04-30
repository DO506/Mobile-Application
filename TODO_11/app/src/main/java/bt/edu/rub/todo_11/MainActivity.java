package bt.edu.rub.todo_11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private String Colors[] = {"black","white","pink","brown","light_orange","capri","green","purple"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.helloworld);

    }

    public void changecolor(View view) {
        Random random = new Random();
        String ColorName = Colors[random.nextInt(7)];

        int colorRessouces = getResources().getIdentifier(ColorName,"color",getApplicationContext().getPackageName());
        int colorResult = ContextCompat.getColor(this,colorRessouces);
        mTextView.setTextColor(colorResult);

    }
}
