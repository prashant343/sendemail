package iotapps.sendemail;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_activity);



        //simple button
        Button startBtn = (Button) findViewById(R.id.composeEmail);
        startBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                composeEmail();
            }
        });

    }




    protected void composeEmail() {
        Log.i("Send email", "");
        String[] TO = {""};
        String[] CC = {""};



        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "subject ....");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "text here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("mail sent", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "Some problem in Mail client.", Toast.LENGTH_SHORT).show();
        }
    }




}
