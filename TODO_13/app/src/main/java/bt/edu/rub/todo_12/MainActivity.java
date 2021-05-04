package bt.edu.rub.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGES ="bt.edu.rub.todo_12.EXTRA_MESSAGES";
    public String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    public void Froyo(View view) {
        msg="You ordered Froyo";
        displayToast(msg);
    }

    public void Icecream(View view) {
        msg="You ordered Ice cream";
        displayToast(msg);
    }

    public void Donut(View view) {
        msg="You ordered Donut";
        displayToast(msg);
    }

    public void telphone(View view) {
        Intent intent = new Intent(MainActivity.this,Order.class);
        intent.putExtra(EXTRA_MESSAGES,msg);
        startActivity(intent);
    }
}