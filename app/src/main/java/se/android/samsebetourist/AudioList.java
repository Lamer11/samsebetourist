package se.android.samsebetourist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class AudioList extends AppCompatActivity {

    TextView t1, t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_list);

        t1 = (TextView) findViewById(R.id.textView);
        t2 = (TextView) findViewById(R.id.textView2);

        Bundle passedValue = getIntent().getExtras(); // получаем переданные значения в переменную типа Bundle
        String nameCountry = passedValue.get("nameCountry").toString(); // По ключу "nameCountry" получаем значение

        t2.setText(nameCountry);

    }
}
