package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class MovieDetail extends AppCompatActivity {

    ImageView ivRate;
    TextView tvTitle, tvYear, tvGenre, tvWatched, tvTheatre, tvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        tvTitle = findViewById(R.id.textViewTitle);
        tvYear = findViewById(R.id.textViewYearRelease);
        tvGenre = findViewById(R.id.textViewMovieGenre);
        tvWatched = findViewById(R.id.textViewWatchedOn);
        tvTheatre = findViewById(R.id.textViewTheatre);
        tvDesc = findViewById(R.id.textViewDescription);
        ivRate = findViewById(R.id.imageViewRating);

        Intent intentReceived = getIntent();
        String title = intentReceived.getStringExtra("title");
        String year = intentReceived.getStringExtra("year");
        String rate = intentReceived.getStringExtra("rated");
        String genre = intentReceived.getStringExtra("genre");
        String watched_on = intentReceived.getStringExtra("watched");
        String theatre = intentReceived.getStringExtra("theatre");
        String description = intentReceived.getStringExtra("desc");
        Log.d("year", year+".");

        tvTitle.setText(title);
        tvYear.setText(year);
        tvGenre.setText(genre);
        tvTheatre.setText("In Theatre: " + theatre);
        tvWatched.setText("Watch on: " + watched_on);
        tvDesc.setText(description);

        if (rate.equalsIgnoreCase("g")){
            ivRate.setImageResource(R.drawable.rating_g);
        } else if (rate.equalsIgnoreCase("pg")){
            ivRate.setImageResource(R.drawable.rating_pg);
        } else if (rate.equalsIgnoreCase("pg13")){
            ivRate.setImageResource(R.drawable.rating_pg13);
        } else if (rate.equalsIgnoreCase("nc16")){
            ivRate.setImageResource(R.drawable.rating_nc16);
        } else if (rate.equalsIgnoreCase("m18")){
            ivRate.setImageResource(R.drawable.rating_m18);
        } else {
            ivRate.setImageResource(R.drawable.rating_r21);
        }
    }
}
