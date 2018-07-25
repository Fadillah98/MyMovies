package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvMovies;
    ArrayList<Movies> alMovies;
    CustomAdapter caMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovies = findViewById(R.id.listViewMovies);
        alMovies = new ArrayList<>();

        Movies movie1 = new Movies("The Avengers", "2012 - ", "pg13", "Action | Sci-Fi", "15-11-2014",
                "Golden Village - Bishan",
                "Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.");
        Movies movie2 = new Movies("Planes", "2013 - ", "pg", "Animation | Comedy", "15,5,2015", "Cathay - AMK Hub",
                "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.");
        alMovies.add(movie1);
        alMovies.add(movie2);
        caMovies = new CustomAdapter(this, R.layout.movies_item, alMovies);
        lvMovies.setAdapter(caMovies);

        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView < ? > adapter, View view,int position, long arg){

                Intent intent = new Intent((getBaseContext()), MovieDetail.class);
                Movies currentItem = alMovies.get(position);
                intent.putExtra("title", currentItem.getTitle());
                intent.putExtra("year", currentItem.getYear());
                intent.putExtra("rated", currentItem.getRated());
                intent.putExtra("genre", currentItem.getGenre());
                intent.putExtra("watched", currentItem.getWatched_on());
                intent.putExtra("theatre", currentItem.getIn_theatre());
                intent.putExtra("desc", currentItem.getDescription());
                startActivity(intent);
            }
        });

    }
}
