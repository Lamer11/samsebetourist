package se.android.samsebetourist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Countries extends AppCompatActivity {

    List<ObjectCountry> objectCountries = new ArrayList<>();
    RecyclerView recyclerCountries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        addObjectCountry();
        recyclerCountries = findViewById(R.id.recycler_countries);
        recyclerCountries.setLayoutManager(new LinearLayoutManager(this));

        // Создаем адаптер
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_countries);
        DataAdapter adapter2 = new DataAdapter(this, objectCountries);
        // Устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter2);
    }

    private void addObjectCountry(){
        objectCountries.add(new ObjectCountry("ИСПАНИЯ", R.drawable.image2));
        objectCountries.add(new ObjectCountry("ПОРТУГАЛИЯ", R.drawable.image3));
        objectCountries.add(new ObjectCountry("ГЕРМАНИЯ", R.drawable.image4));
        objectCountries.add(new ObjectCountry("РОССИЯ", R.drawable.image5));
        objectCountries.add(new ObjectCountry("ЧЕХИЯ", R.drawable.image6));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // Тут можно определить логику что необходимо сделать, если
        // пользователь нажал на системную кнопку "назад".
        // Toast.makeText(this, "Countries", Toast.LENGTH_SHORT).show();
    }

}
