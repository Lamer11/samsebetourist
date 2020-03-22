package se.android.samsebetourist;


import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

import static android.os.Environment.DIRECTORY_DOWNLOADS;


public class AudioItemAdapter extends RecyclerView.Adapter<AudioItemAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<ObjectAudio> audios;
    private Context mContext;

    FirebaseStorage firebaseStorage;
    StorageReference storageReference;

    StorageReference ref;


    private long downloadID;
    Button downButtom;

    private BroadcastReceiver onDownloadComplete = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            System.out.println("================================================================================");
            System.out.println("action: " + action);
            System.out.println("================================================================================");
            //Fetching the download id received with the broadcast
            long id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
            //Checking if the received broadcast is for our enqueued download by matching download id
            if (downloadID == id) {
                //Toast.makeText(context, "Download Completed", Toast.LENGTH_SHORT).show();

                downButtom.setText("Download");
                downButtom.setEnabled(true);

                //mContext.unregisterReceiver(this); // вроде как способ тут выключать, а е в методе close() ???

            }
        }
    };


    AudioItemAdapter(Context context, List<ObjectAudio> audios) {
        this.audios = audios;
        this.inflater = LayoutInflater.from(context);
        this.mContext = context;
    }

    @Override
    public AudioItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.audio_item, parent, false);
        return new AudioItemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AudioItemAdapter.ViewHolder holder, int position) {
        ObjectAudio audio = audios.get(position);
        final String nameAudio = audio.getNameAudio(); // название аудио
        final String nameCountry = audio.getNameCountry(); // название страны
        holder.textView.setText(audio.getNameAudio());
        // Устанавливаем события на кнопки
        // Кнопка скачивания аудио
        holder.downButoon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                downButtom = (Button) view;
                download(nameCountry, nameAudio, view);
                mContext.registerReceiver(onDownloadComplete,new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));

            }
        });

        // Кнопка запуска аудио
        holder.runButoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("================================================================================");
                System.out.println(nameAudio);
                System.out.println(nameCountry);
                System.out.println("================================================================================");
                runAudio(nameCountry, nameAudio);
            }
        });


    }


    @Override
    public int getItemCount() {
        return audios.size();
    }


        public class ViewHolder extends RecyclerView.ViewHolder {
            final TextView textView;
            final Button runButoon;
            final Button downButoon;
            // final LinearLayout linearLayout; // это нужно для того, чтобы установить
            // событие например при нажатии на весь этот lianer
            ViewHolder(View view){
                super(view);
                textView = (TextView) view.findViewById(R.id.nameAudio);
                runButoon = (Button) view.findViewById(R.id.idrun);
                downButoon = (Button) view.findViewById(R.id.iddownload);
                // linearLayout = (LinearLayout) view.findViewById(R.id.linear);
            }
        }



    // Методы download и downloadFiles для загрузки файла на телефон
    public void download(String country, final String audio, final View view){
        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child(country + "/" + audio + ".wav");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                downloadFiles(mContext, audio, ".wav", DIRECTORY_DOWNLOADS, url, view);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }

    public void downloadFiles(Context context, String fileName, String fileExtension, String destinationDirectory, String url, View view){
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        Button button = (Button) view;
        DownloadManager.Request request = new DownloadManager.Request(uri);

        //request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);

        button.setText("Скачивается...");
        button.setEnabled(false);
        downloadID = downloadManager.enqueue(request);

    }

    // Метод, который запускает прослушивание онлайн
    void runAudio(String country, final String audio) {
        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child(country + "/" + audio + ".wav");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mediaPlayer.setDataSource(mContext, uri);
                    mediaPlayer.prepare();
                }catch (Exception e){
                    // Обработка ошибки
                }
                System.out.println("=======================================================================");
                System.out.println("Перед методом старт");
                System.out.println("=======================================================================");
                mediaPlayer.start();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                System.out.println("=======================================================================");
                System.out.println("Ошибка в методе runAudio(String str, String str)");
                System.out.println("=======================================================================");
            }
        });
    }




}