package se.android.samsebetourist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Countries extends AppCompatActivity {

        List<String> listik = new ArrayList<>();
        RecyclerView recyclerCountries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);


        fillCountriesTank();
        recyclerCountries = findViewById(R.id.recycler_countries);
        recyclerCountries.setLayoutManager(new LinearLayoutManager(this));

        // создаем адаптер
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_countries);
        DataAdapter adapter = new DataAdapter(this, listik);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);


    }


    private void fillCountriesTank(){
        listik.add("Russia");
        listik.add("Germany");
        listik.add("Spanish");
        listik.add("Spanish");
        listik.add("Spanish");
        listik.add("Spanish");
        listik.add("Spanish");
        listik.add("Spanish");
        listik.add("Spanish");
        listik.add("Spanish");
        listik.add("Spanish");
        listik.add("Spanish");
    }



}
