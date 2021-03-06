package ogdh.nitp.bbt;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class settings_activity extends AppCompatActivity implements View.OnClickListener{

    TextView settings_title, submit_btn;
    EditText phn1, phn2, phn3;
    SharedPreferences Pref;
    SharedPreferences.Editor Editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_activity);
        settings_title = (TextView) findViewById(R.id.settings_title);
        Typeface jackson = Typeface.createFromAsset(getAssets(), "fonts/Jackson-Regular.ttf");
        settings_title.setTypeface(jackson);
        submit_btn = (TextView) findViewById(R.id.submit_btn);
        submit_btn.setOnClickListener(this);
        Typeface aloha = Typeface.createFromAsset(getAssets(), "fonts/Aloha.otf");
        submit_btn.setTypeface(aloha);
        Pref = getSharedPreferences("bbt", MODE_PRIVATE);
        Editor = Pref.edit();
        phn1 = (EditText) findViewById(R.id.phn_num_1);
        phn1.setText(Pref.getString("phn_1", "0"));
        phn2 = (EditText) findViewById(R.id.phn_num_2);
        phn2.setText(Pref.getString("phn_2", "0"));
        phn3 = (EditText) findViewById(R.id.phn_num_3);
        phn3.setText(Pref.getString("phn_3", "0"));
        Log.e("check", "working");
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.submit_btn)
        {
            String num1 = phn1.getText().toString();
            Editor.putString("phn_1", num1);
            Log.e("check","first : "+Pref.getString("phn_1","0"));
            String num2 = phn2.getText().toString();
            Editor.putString("phn_2",num2);
            Log.e("check","second : "+Pref.getString("phn_2","0"));
            String num3 = phn3.getText().toString();
            Editor.putString("phn_3",num3);
            Log.e("check","third : "+Pref.getString("phn_3","0"));
            Editor.commit();
        }
    }

}
