package bt.edu.rub.todo_25;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    dbHelper myDd;
    EditText firstName,secondName,itw202Marks,idNumber;
    Button add_btn,view_btn,update_btn,delete_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.firstName);
        secondName = findViewById(R.id.SecondName);
        itw202Marks = findViewById(R.id.marks);
        idNumber = findViewById(R.id.idNumber);
        add_btn = findViewById(R.id.add_button);
        view_btn = findViewById(R.id.viewAll_button);
        update_btn = findViewById(R.id.update_button);
        delete_btn= findViewById(R.id.delete_button);

        myDd = new dbHelper(this);

    }

    public void AddData(View view) {
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDd.insertData(idNumber.getText().toString(),
                        firstName.getText().toString(),
                        secondName.getText().toString(),
                        itw202Marks.getText().toString());
                if(isInserted == true){
                    Toast.makeText(MainActivity.this,"Data inserted" ,Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this,"Data not inserted" ,Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void ViewAll(View view) {
        view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDd.getAllData();
                if(res.getCount() == 0){
                    showMessage("Error","Nothing Found");
                    return;
                }
                StringBuilder buffer = new StringBuilder();
                while (res.moveToNext()){
                    buffer.append("Student Id : "+ res.getString(0)+"\n");
                    buffer.append("First Name : "+ res.getString(1)+"\n");
                    buffer.append("Second Name : "+ res.getString(2)+"\n");
                    buffer.append("ITW202 Marks  : "+ res.getString(3)+"\n\n");
                }
                showMessage("List of Students",buffer.toString());
            }
        });
    }
    private void showMessage(String title ,String Message){
        AlertDialog.Builder builder =  new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public void Update(View view) {
        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate = myDd.updateData(idNumber.getText().toString(),
                        firstName.getText().toString(),
                        secondName.getText().toString(),
                        itw202Marks.getText().toString());

                if(isUpdate == true){
                    Toast.makeText(MainActivity.this,"Data updated" ,Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this,"Data not updated" ,Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void delete(View view) {
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer isDelete = myDd.deleteData(idNumber.getText().toString());

                if( isDelete > 0){
                    Toast.makeText(MainActivity.this,"Data Deleted" ,Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this,"Data not Deleted" ,Toast.LENGTH_SHORT).show();


            }
        });
    }
}