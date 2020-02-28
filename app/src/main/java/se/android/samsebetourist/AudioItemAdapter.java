package se.android.samsebetourist;


import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
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

import java.util.List;

import static android.os.Environment.DIRECTORY_DOWNLOADS;


public class AudioItemAdapter extends RecyclerView.Adapter<AudioItemAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<ObjectAudio> audios;
    private Context mContext;

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
        final String nameAudio = audio.getNameAudio();
        holder.textView.setText(audio.getNameAudio());
        // Устанавливаем события на кнопки
        holder.downButoon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // here must be someone
                System.out.println("================================================================================");
                System.out.println(nameAudio);
                System.out.println("================================================================================");
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
            final LinearLayout linearLayout;
            ViewHolder(View view){
                super(view);
                textView = (TextView) view.findViewById(R.id.nameAudio);
                runButoon = (Button) view.findViewById(R.id.idrun);
                downButoon = (Button) view.findViewById(R.id.iddownload);
                linearLayout = (LinearLayout) view.findViewById(R.id.linear);
            }
        }






}