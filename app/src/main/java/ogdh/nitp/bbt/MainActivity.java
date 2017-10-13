package ogdh.nitp.bbt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.telephony.SmsManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView sosbtn;
    TextView heading, settings;
    SharedPreferences Pref;
    String txt = "dummy";
    Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sosbtn = (ImageView)findViewById(R.id.sosButton);
        sosbtn.setOnClickListener(this);
        heading = (TextView)findViewById(R.id.heading);
        settings = (TextView)findViewById(R.id.settings);
        settings.setOnClickListener(this);
        Typeface jackson = Typeface.createFromAsset(getAssets(), "fonts/Jackson-Regular.ttf");
        settings.setTypeface(jackson);
        Typeface overspray = Typeface.createFromAsset(getAssets(), "fonts/Overspray.ttf");
        heading.setTypeface(overspray);
        Pref = getSharedPreferences("bbt", MODE_PRIVATE);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.sosButton)
        {
            Log.e("check","first : "+Pref.getString("phn_1","0"));
            sendSMS(Pref.getString("phn_1","0"), txt, location);
            Log.e("check","second : "+Pref.getString("phn_2","0"));
            sendSMS(Pref.getString("phn_2","0"), txt, location);
            Log.e("check","third : "+Pref.getString("phn_3","0"));
            sendSMS(Pref.getString("phn_3","0"), txt, location);

        }
        if (view.getId() == R.id.settings)
        {
            Intent setting_page = new Intent(view.getContext(), settings_activity.class);
            startActivityForResult(setting_page, 0);
        }
    }

    private void sendSMS(String phoneNumber, String txt, Location myLocation) {
        SmsManager sms = SmsManager.getDefault();
        StringBuffer smsBody = new StringBuffer();
        smsBody.append("http://maps.google.com?q=");
        //smsBody.append(myLocation.getLatitude());
        //smsBody.append(",");
        //smsBody.append(myLocation.getLongitude());
        sms.sendTextMessage(phoneNumber, null, smsBody.toString(), null, null);
    }
}
