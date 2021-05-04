package bt.edu.rub.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Order extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView Mmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Mmessage = findViewById(R.id.textView8);

        Intent intent = getIntent();
        String msg = intent.getStringExtra(MainActivity.EXTRA_MESSAGES);
        Mmessage.setText(msg);

        Spinner spinner = findViewById(R.id.spinner);

        if(spinner != null){
            spinner.setOnItemSelectedListener(this);

        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinnerLL, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }


}
    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    public void DiverRadioButton(View view) {
        Boolean checked = ((RadioButton)view).isChecked();

        switch (view.getId()){
            case R.id.radioButton:
                displayToast("Same day");
                break;

            case R.id.radioButton2:
                displayToast("Next day");
                break;

            case R.id.radioButton3:
                displayToast("Pick up");
                break;

            default:
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String Spinner_Message = parent.getItemAtPosition(position).toString();
        displayToast(Spinner_Message);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}