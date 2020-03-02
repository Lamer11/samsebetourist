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
            case "Германия" :
                break;
            case "Испания" :
                objectAudios.add(new ObjectAudio(nameCountry, "Башни Серранос"));
                objectAudios.add(new ObjectAudio(nameCountry, "Валенсия1 Церковь святого Николая"));
                objectAudios.add(new ObjectAudio(nameCountry, "Валенсия2"));
                objectAudios.add(new ObjectAudio(nameCountry, "Маркиза де ла скала"));
                objectAudios.add(new ObjectAudio(nameCountry, "Монастырь дель Кармен"));
                break;
            case "Португалия" :
                break;
            case "Россия" :
                objectAudios.add(new ObjectAudio(nameCountry, "дворец правительства"));
                break;
            case "Чехия" :
                break;
            case "test" :
                objectAudios.add(new ObjectAudio(nameCountry, "simpletext"));
                objectAudios.add(new ObjectAudio(nameCountry, "myphoto"));
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
