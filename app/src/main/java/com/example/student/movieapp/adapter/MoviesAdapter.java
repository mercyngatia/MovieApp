package com.example.student.movieapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.student.movieapp.R;
import com.example.student.movieapp.models.Movie;
import com.example.student.movieapp.models.MovieResult;
import com.example.student.movieapp.models.Result;

import java.util.List;

/**
 * This class is responsibler for styling items in the RecyclerView
 * Created by USER on 7/15/2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<Result> moviesList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;
        public ImageView posterImageView;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            posterImageView = (ImageView) view.findViewById(R.id.image_view_poster);
        }
    }


    public MoviesAdapter(List<Result> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()) //fills the layout
                .inflate(R.layout.movie_list_row, parent, false); //what layout are you inflating
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) { //gets whataever in the movielist and send it to the view
        Result movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.posterImageView.setImageResource(Integer.parseInt(movie.getMovie_image()));
        holder.genre.setText(movie.getOverview());
        holder.year.setText(movie.getReleaseDate());

        Glide.with(context).load("http://image.tmdb.org/t/p/w500")
                .into(holder.posterImageView);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
