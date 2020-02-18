package se.android.samsebetourist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Countries extends AppCompatActivity {

    List<String> countries = new ArrayList<>();
    RecyclerView recyclerCountries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        fillCountriesTank();
        recyclerCountries = findViewById(R.id.recycler_countries);
        recyclerCountries.setLayoutManager(new LinearLayoutManager(this));

        // Создаем адаптер
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_countries);
        DataAdapter adapter = new DataAdapter(this, countries);
        // Устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);

    }

    private void fillCountriesTank(){
        countries.add("ИСПАНИЯ");
        countries.add("ПОРТУГАЛИЯ");
        countries.add("ГЕРМАНИЯ");
        countries.add("РОССИЯ");
        countries.add("ЧЕХИЯ");
        countries.add("Test1");
        countries.add("Test2");
        countries.add("Test3");
        countries.add("Test4");
        countries.add("Test5");
        countries.add("Test6");
        countries.add("Test7");
        countries.add("Test8");
        countries.add("Test9");


    }



}
