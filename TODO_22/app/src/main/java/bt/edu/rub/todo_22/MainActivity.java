package bt.edu.rub.todo_22;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {
    private EditText mEditText;
    private TextView mTitleText;
    private TextView mAuthorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.textInput);
        mTitleText = findViewById(R.id.titleText);
        mAuthorText = findViewById(R.id.authorText);
    }

    public void searchBook(View view) {
        String queryString = mEditText.getText().toString();
        new FetchBook(mTitleText,mAuthorText).execute(queryString);

        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        if (inputManager != null ) {
            inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }

    }


}