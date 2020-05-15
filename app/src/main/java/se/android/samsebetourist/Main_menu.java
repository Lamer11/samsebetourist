package se.android.samsebetourist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class Main_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    // Обработчики кнопок
    public void iconHome(View view){
        Toast toast = Toast.makeText(getApplicationContext(),
                "Кнопка iconHome!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0); // в центре экрана
        toast.show();
    }

    public void iconTour(View view){
        Toast toast = Toast.makeText(getApplicationContext(),
                "Кнопка iconTour!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0); // в центре экрана
        toast.show();
    }

    public void iconMaps(View view){
        Toast toast = Toast.makeText(getApplicationContext(),
                "Кнопка iconMaps!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0); // в центре экрана
        toast.show();
    }

    public void iconCamera(View view){
        Toast toast = Toast.makeText(getApplicationContext(),
                "Кнопка iconCamera!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0); // в центре экрана
        toast.show();
    }


}
