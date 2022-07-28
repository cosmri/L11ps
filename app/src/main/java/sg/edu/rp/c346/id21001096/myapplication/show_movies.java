package sg.edu.rp.c346.id21001096.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class show_movies extends AppCompatActivity {


    Button btnPG13;
    Spinner spnMovieRatings;
    ListView lvMovies;
    ArrayList<Movie> alMovies;
    ArrayAdapter<Movie> aaMovies;
    CustomAdapter caMovies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_movies);

        btnPG13 = findViewById(R.id.buttonPG13);
        lvMovies = findViewById(R.id.listViewMovies);
        spnMovieRatings = findViewById(R.id.spinnerMovieRatings);

        alMovies = new ArrayList<Movie>();

        aaMovies = new ArrayAdapter<Movie>(this, android.R.layout.simple_list_item_1, alMovies);

        caMovies = new CustomAdapter(this, R.layout.row, alMovies);

        lvMovies.setAdapter(caMovies);

        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(ShowListActivity.this,
                        ModifyActivity.class);
                Movie data = alMovies.get(position);
                i.putExtra("data", data);
                startActivity(i);
            }
        });

        spnMovieRatings.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                DBHelper dbh = new DBHelper(ShowListActivity.this);
                String movieRating = spnMovieRatings.getSelectedItem().toString();
                alMovies.clear();
                alMovies.addAll(dbh.getAllSongsByRating(movieRating));
                caMovies.notifyDataSetChanged();

                ArrayList<String> alYear = new ArrayList<>();

                for (int a = 0; a < alMovies.size(); a++) {
                    for (int x = 0; x < alYear.size(); x++) {
                        String yearItem = alMovies.get(x).getRating() + "";
                        if (alYear.get(x) != yearItem) {
                            alYear.add(alMovies.get(x).getYear() + "");
                        }
                    }
                }

                alMovies.clear();
                alMovies.addAll(dbh.getAllSongsByRating(movieRating));
                caMovies.notifyDataSetChanged();

                switch (i) {
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnPG13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbh = new DBHelper(ShowListActivity.this);

                alMovies.clear();
                alMovies.addAll(dbh.getAllPG13Movies());
                caMovies.notifyDataSetChanged();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        DBHelper dbh = new DBHelper(ShowListActivity.this);
        alMovies.clear();
        alMovies.addAll(dbh.getAllMovies());
        caMovies.notifyDataSetChanged();
        lvMovies.performClick();
    }
}
