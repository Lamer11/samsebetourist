package se.android.samsebetourist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void openCountries(View view){

        Intent intent = new Intent(this, Countries.class);
        startActivity(intent);

    }


    public void openCountries2(View view){

        Intent intent = new Intent(this, Countries2.class);
        startActivity(intent);

    }
}
