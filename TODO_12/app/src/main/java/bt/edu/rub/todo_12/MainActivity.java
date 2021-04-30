package bt.edu.rub.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    public void Froyo(View view) {
        displayToast(getString(R.string.froyo_order));
    }

    public void Icecream(View view) {
        displayToast(getString(R.string.iceCream_order));
    }

    public void Donut(View view) {
        displayToast(getString(R.string.donut_order));
    }

    public void telphone(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:17407441"));
        startActivity(intent);
    }
}