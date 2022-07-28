package sg.edu.rp.c346.id21001096.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Movies> moviesList;

    public CustomAdapter(@NonNull Context context, int resource, ArrayList<Movies> objects) {
        super(context, resource, objects);

        this.parent_context = context;
        this.layout_id = resource;
        this.moviesList = objects;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView name = rowView.findViewById(R.id.name);
        TextView year = rowView.findViewById(R.id.year);
        TextView rating = rowView.findViewById(R.id.rating);

        Movies currentVersion = moviesList.get(position);

        //Set values to the TextView to display the corresponding information
        name.setText(currentVersion.getTitle());
        year.setText(currentVersion.getMovieYear());

        return rowView;
    }

}



