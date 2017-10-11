package com.example.android.popularmovies;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class TrailerAdapter extends RecyclerView.Adapter<TrailerAdapter.TrailerViewHolder> {

    ArrayList<Trailer> mTrailers;
    Context mContext;


    public TrailerAdapter(Context context, ArrayList<Trailer> trailers) {
        mContext = context;
        mTrailers = trailers;
    }

    @Override
    public TrailerAdapter.TrailerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LinearLayout itemView = (LinearLayout) LayoutInflater.from(mContext)
                .inflate(R.layout.trailer_list_item, null, false);
        TrailerViewHolder trailerViewHolder = new TrailerViewHolder(itemView);
        return trailerViewHolder;
    }

    @Override
    public void onBindViewHolder(TrailerAdapter.TrailerViewHolder holder, final int position) {
        holder.mTrailerNameTextView.setText(mTrailers.get(position).getTrailerName());
        holder.mTrailerNumberTextView.setText(String.valueOf(position + 1));
        holder.mImageButtonForPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                String trailerUrlString = "https://www.youtube.com/watch?v=" + mTrailers.get(position).getTrailerKey();
                intent.setData(Uri.parse(trailerUrlString));
                if (intent.resolveActivity(mContext.getPackageManager()) != null) {
                    mContext.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mTrailers != null) {
            return mTrailers.size();
        } else {
            return 0;
        }
    }

    public class TrailerViewHolder extends RecyclerView.ViewHolder {
        TextView mTrailerNumberTextView;
        TextView mTrailerNameTextView;
        ImageButton mImageButtonForPlayer;

        public TrailerViewHolder(View itemView) {
            super(itemView);
            mTrailerNumberTextView = (TextView) itemView.findViewById(R.id.trailer_number);
            mTrailerNameTextView = (TextView) itemView.findViewById(R.id.trailer_name_textview);
            mImageButtonForPlayer = (ImageButton) itemView.findViewById(R.id.trailer_player_icon);
        }
    }
}
