package tech.zafrani.companionforpubg.adapters;


import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.models.News;
import tech.zafrani.companionforpubg.models.NewsItem;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsItemViewHolder>{
    private News news = new News();

    public void addNewsItem(@NonNull final NewsItem newsItem) {
        news.add(newsItem);
    }

    @Override
    public NewsItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_news, parent, false);
        return new NewsItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsItemViewHolder holder, int position) {
        final NewsItem newsItem = news.get(position);
        holder.bind(newsItem);
    }

    @Override
    public int getItemCount() {
        return news == null ? 0 : news.size();
    }


    public class NewsItemViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgImageView;
        private final TextView titleTextView;
        private final TextView typeTextView;
        private final TextView dateTextView;
        private final TextView descriptionTextView;

        public NewsItemViewHolder(@NonNull final View itemView) {
            super(itemView);
            imgImageView = (ImageView) itemView.findViewById(R.id.row_item_image);
            titleTextView = (TextView) itemView.findViewById(R.id.row_item_title);
            typeTextView = (TextView) itemView.findViewById(R.id.row_item_type);
            dateTextView = (TextView) itemView.findViewById(R.id.row_item_date);
            descriptionTextView = (TextView) itemView.findViewById(R.id.row_item_description);

        }


        public void bind(final NewsItem newsItem) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(@NonNull final View view) {
                    final Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( newsItem.getLinkSrc()));
                    view.getContext().startActivity(browse);
                }
            });
            Picasso.with(itemView.getContext())
                    .load(newsItem.getImgSrc())
                    .fit()
                    .centerCrop()
                    .into(imgImageView);
            titleTextView.setText(newsItem.getTitle());
            typeTextView.setText(newsItem.getType());
            dateTextView.setText(newsItem.getDate());
            descriptionTextView.setText(newsItem.getDescription());
        }

    }
}
