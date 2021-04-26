package bt.edu.rub.todo_08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String LOG_Tag = "bt.edu.rub.todo_08";
    private EditText  editTextBrowser;
    private EditText  editTextLocation;
    private EditText  editTextShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextBrowser = findViewById(R.id.editText_Browser);
        editTextLocation = findViewById(R.id.editText_Location);
        editTextShare = findViewById(R.id.editText_share);
    }

    public void Browser(View view) {
        String txt = editTextBrowser.getText().toString();
        Uri URL = Uri.parse(txt);
        Intent obj = new Intent(Intent.ACTION_VIEW,URL);

        if(obj.resolveActivity(getPackageManager()) != null){
            startActivity(obj);
        }
        else
            Log.d("Implicit Intent ", "error in open URL");

    }

    public void Location(View view) {
        String txt = editTextLocation.getText().toString();
        Uri URL = Uri.parse("geo:0,0=?q"+txt);
        Intent obj = new Intent(Intent.ACTION_VIEW,URL);

        if(obj.resolveActivity(getPackageManager()) != null){
            startActivity(obj);
        }
        else
            Log.d("Implicit Intent ", "error in open URL");
    }

    public void Share(View view) {
        String txt = editTextShare.getText().toString();
        String MimeType = "Text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(MimeType)
                .setChooserTitle("share this text with :")
                .setText(txt)
                .startChooser();

    }
}