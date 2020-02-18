package se.android.samsebetourist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


public class DataAdapter2 extends RecyclerView.Adapter<DataAdapter2.ViewHolder> {

    private LayoutInflater inflater;
    private List<ObjectCountry> countries;

    DataAdapter2(Context context, List<ObjectCountry> countries) {
        this.countries = countries;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public DataAdapter2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.activity_list_countries2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter2.ViewHolder holder, int position) {
        ObjectCountry country = countries.get(position);
        holder.imageView.setImageResource(country.getImage());
        holder.nameView.setText(country.getName());
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView nameView;
        ViewHolder(View view){
            super(view);
            imageView = (ImageView)view.findViewById(R.id.image);
            nameView = (TextView) view.findViewById(R.id.name);
        }
    }
}