package com.example.student.movieapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.student.movieapp.DetailActivity;
import com.example.student.movieapp.MainActivity;
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

//    private List<Result> moviesList;
//    Private String posterPath = "image.tmdb.org/t/pw500";

    private Context mContext;
    private List<Movie> moviesList;


    public MoviesAdapter(Context mContext, List<Movie> movieList) {
        this.mContext = mContext;
        this.moviesList = movieList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()) //fills the layout
                .inflate(R.layout.movie_card, viewGroup, false); //what layout are you inflating
    return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MoviesAdapter.MyViewHolder viewHolder, int i) { //gets whataever in the movielist and send it to the view
        viewHolder.title.setText(moviesList.get(i).getOriginalTitle());
        String vote =Double.toString(moviesList.get(i).getVoteAverage());
        viewHolder.userrating.setText(vote);

// use glide to show images

        Glide.with(mContext)
                .load(moviesList.get(i).getPosterPath())
//              .placeholder(R.drawable.load);
                .into(viewHolder.thumbnail);

        //Add onClickListener

//        Glide.with(mContext)
//                .load(posterpath+movie.getPosterPath())
//                .into(holder.posterImageView);
//

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, userrating;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            userrating = (TextView) view.findViewById(R.id.userrating);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
//            posterImageView = (ImageView) view.findViewById(R.id.image_view_poster);

            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){
                        Movie clickedDtaItem = moviesList.get(pos);
                        Intent intent = new Intent(mContext, DetailActivity.class);
                        intent.putExtra("original_title", moviesList.get(pos).getOriginalTitle());
                        intent.putExtra("poster_path", moviesList.get(pos).getPosterPath());
                        intent.putExtra("overview", moviesList.get(pos).getOverview());
                        intent.putExtra("vote_average", Double.toString(moviesList.get(pos).getVoteAverage()));
                        intent.putExtra("release_date", moviesList.get(pos).getReleaseDate());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                        Toast.makeText(v.getContext(), "You clicked" + clickedDtaItem.getOriginalTitle(), Toast.LENGTH_SHORT).show();

                    }

                }
            });


        }
    }
}
//    }


//    public MoviesAdapter(List<Result> moviesList) {
//        this.moviesList = moviesList;
//    }
//
//
//
//    @Override
//    public void onBindViewHolder(MyViewHolder holder, int i) { //gets whataever in the movielist and send it to the view
//        Movie movie = moviesList.get(position);
//        holder.title.setText(movie.getTitle());
//        holder.posterImageView.setImageResource(Integer.parseInt(movie.getMovie_image()));
//        holder.genre.setText(movie.getOverview());
//        holder.year.setText(movie.getReleaseDate());
//
//        Glide.with(context).load("http://image.tmdb.org/t/p/w500")
//                .into(holder.posterImageView);
//    }
//
//
