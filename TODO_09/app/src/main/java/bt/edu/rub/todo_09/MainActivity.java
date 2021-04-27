package bt.edu.rub.todo_09;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText editTextValue1;
    private EditText editTextValue2;
    private TextView TextViewResult;
    private Calulator mCalculator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextValue1 = findViewById(R.id.EditTextValue1);
        editTextValue2 = findViewById(R.id.EditTextValue2);
        TextViewResult = findViewById(R.id.textViewResult);
        mCalculator = new Calulator();
    }

    public void add(View view) {
        String value1 = editTextValue1.getText().toString();
        String value2 = editTextValue2.getText().toString();

        double result = mCalculator.add(Double.valueOf(value1),Double.valueOf(value2));
        TextViewResult.setText(String.valueOf(result));

    }

    public void sub(View view) {
        String value1 = editTextValue1.getText().toString();
        String value2 = editTextValue2.getText().toString();

        double result = mCalculator.sub(Double.valueOf(value1),Double.valueOf(value2));
        TextViewResult.setText(String.valueOf(result));
    }

    public void mul(View view) {
        String value1 = editTextValue1.getText().toString();
        String value2 = editTextValue2.getText().toString();

        double result = mCalculator.mul(Double.valueOf(value1),Double.valueOf(value2));
        TextViewResult.setText(String.valueOf(result));
    }

    public void div(View view) {
        String value1 = editTextValue1.getText().toString();
        String value2 = editTextValue2.getText().toString();

        double result = mCalculator.div(Double.valueOf(value1),Double.valueOf(value2));
        TextViewResult.setText(String.valueOf(result));
    }
}