package se.android.samsebetourist;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<ObjectCountry> countries;
    private Context mContext;

    DataAdapter(Context context, List<ObjectCountry> countries) {
        this.countries = countries;
        this.inflater = LayoutInflater.from(context);
        this.mContext = context;
    }
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.activity_list_countries, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        ObjectCountry country = countries.get(position);
        final String nameCountry = country.getName();
        holder.imageView.setImageResource(country.getImage());
        holder.nameView.setText(country.getName());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, AudioList.class);
                // передача объекта с ключом "nameCountry" и значением country.getName();
                intent.putExtra("nameCountry", nameCountry);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView nameView;
        final LinearLayout linearLayout;
        ViewHolder(View view){
            super(view);
            imageView = (ImageView)view.findViewById(R.id.image);
            nameView = (TextView) view.findViewById(R.id.name);
            linearLayout = (LinearLayout) view.findViewById(R.id.linear);
        }
    }
}