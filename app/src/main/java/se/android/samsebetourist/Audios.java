package se.android.samsebetourist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class Audios extends AppCompatActivity {

    List<ObjectAudio> objectAudios = new ArrayList<>();
    RecyclerView recyclerAudios;
    String nameCountry; // выбранная страна

    // Подключаемся к нашим данным в Cloud Storage
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audios);

        // Тут идет передача информации с предыдущей активити
        Bundle passedValue = getIntent().getExtras(); // получаем переданные значения в переменную типа Bundle
        nameCountry = passedValue.get("nameCountry").toString(); // По ключу "nameCountry" получаем значение


        addObjectAudio(); // заполняем переменную с массивом ObjectAudio
        recyclerAudios = findViewById(R.id.recycler_audios);
        recyclerAudios.setLayoutManager(new LinearLayoutManager(this));

        // Создаем адаптер
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_audios);
        AudioItemAdapter adapter = new AudioItemAdapter(this, objectAudios);
        // Устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
    }



    private void addObjectAudio(){
        switch (nameCountry){
            case "ГЕРМАНИЯ" :
                break;
            case "ИСПАНИЯ" :
                objectAudios.add(new ObjectAudio("Башни Серранос.wav", 0, 0));
                objectAudios.add(new ObjectAudio("Валенсия1 Церковь святого Николая.wav", 0, 0));
                objectAudios.add(new ObjectAudio("Валенсия2.wav", 0, 0));
                objectAudios.add(new ObjectAudio("Маркиза де ла скала.wav", 0, 0));
                objectAudios.add(new ObjectAudio("Монастырь дель Кармен.wav", 0, 0));
                break;
            case "ПОРТУГАЛИЯ" :
                break;
            case "РОССИЯ" :
                objectAudios.add(new ObjectAudio("дворец правительства.wav", 0, 0));
                break;
            case "ЧЕХИЯ" :
                break;
        }

    }

    /*
        Хардкодим данные аудио
        Германия
        Испания
        Португалия
        Россия
        Чехия

        Данные в папках:
        Испания
            Башни Серранос.wav
            Валенсия1 Церковь святого Николая.wav
            Валенсия2.wav
            Маркиза де ла скала.wav
            Монастырь дель Кармен.wav

        Россия
            дворец правительства.wav
     */


}
