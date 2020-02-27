package se.android.samsebetourist;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class Audiofiles extends AppCompatActivity {

    TextView country, namefile;
    Button down;

    FirebaseStorage firebaseStorage;
    StorageReference storageReference;

    StorageReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audiofiles);

        country = (TextView) findViewById(R.id.country);
        namefile = (TextView) findViewById(R.id.namefiles);
        down = findViewById(R.id.button);
        down.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                download();
            }
        });

        Bundle passedValue = getIntent().getExtras(); // получаем переданные значения в переменную типа Bundle
        String nameCountry = passedValue.get("nameCountry").toString(); // По ключу "nameCountry" получаем значение
        country.setText(nameCountry);
    }

    public void download(){
        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("audiofiles/Базилика девы.wav");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                downloadFiles(Audiofiles.this, "bazilic", ".wav", DIRECTORY_DOWNLOADS, url);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }

    public void downloadFiles(Context context, String fileName, String fileExtension, String destinationDirectory, String url){
            DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
            Uri uri = Uri.parse(url);
            DownloadManager.Request request = new DownloadManager.Request(uri);

            //request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION);
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);

            downloadManager.enqueue(request);
    }
}
