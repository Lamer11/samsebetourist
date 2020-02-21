package se.android.samsebetourist;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class Audiofiles extends AppCompatActivity {

    TextView country, namefile;

    private StorageReference mStorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audiofiles);

        mStorageRef = FirebaseStorage.getInstance().getReference(); //ссылаемся на хранилище
        //StorageReference forestRef = mStorageRef.child("audiofiles/Базилика дева.wav"); // ссылаемся на конкретный файл
        StorageReference forestRef = mStorageRef.child("audiofiles/text.txt"); // ссылаемся на конкретный файл


        System.out.println("==============================================================================================");
        System.out.println(forestRef.getName());
        // скачиваем файл на устройство локальным файлом
        final File localFile;
        try {
            localFile = File.createTempFile("test11", "txt");
//              localFile = File.createTempFile("test11", "wav");
//              localFile = File.createTempFile("test11", "txt");
            forestRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    // Local temp file has been created
                    System.out.println("Must be downloaded");
                    System.out.println("getAbsolutePath(): " + localFile.getAbsolutePath());
                    System.out.println("getName(): " + localFile.getName());
                    System.out.println("getAbsoluteFile(): " + localFile.getAbsoluteFile());
                    System.out.println("length: " + localFile.length());
                    final String directoryDownloads = Environment.DIRECTORY_DOWNLOADS;
                    System.out.println("directoryDownloads: " + directoryDownloads);

                    Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                    
                }

            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    // Handle any errors
                    System.out.println("erroe occured!!!");
                }
            });


        } catch (IOException e) {
            System.out.println("error into block try catch");
        }

        System.out.println("name2: " + forestRef.getName());
        System.out.println("==============================================================================================");

        country = (TextView) findViewById(R.id.country);
        namefile = (TextView) findViewById(R.id.namefiles);

        Bundle passedValue = getIntent().getExtras(); // получаем переданные значения в переменную типа Bundle
        String nameCountry = passedValue.get("nameCountry").toString(); // По ключу "nameCountry" получаем значение

        country.setText(nameCountry);

    }
}
