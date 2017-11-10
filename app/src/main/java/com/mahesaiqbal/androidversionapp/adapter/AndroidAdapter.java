package com.mahesaiqbal.androidversionapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mahesaiqbal.androidversionapp.Android;
import com.mahesaiqbal.androidversionapp.CustomOnItemClickListener;
import com.mahesaiqbal.androidversionapp.DetailActivity;
import com.mahesaiqbal.androidversionapp.R;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

/**
 * Created by mahesaiqbal on 11/8/2017.
 */

public class AndroidAdapter extends RecyclerView.Adapter<AndroidAdapter.AndroidViewHolder> {

    private ArrayList<Android> listAndroid;
    private Context context;

    public AndroidAdapter(Context context) {

        this.context = context;

    }

    public ArrayList<Android> getListAndroid() {

        return listAndroid;

    }

    public void setListAndroid(ArrayList<Android> listAndroid) {

        this.listAndroid = listAndroid;

    }

    @Override
    public AndroidViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_android,
                parent, false);

        AndroidViewHolder viewHolder = new AndroidViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(AndroidViewHolder holder, int position) {

        final Android android = getListAndroid().get(position);

        holder.androidName.setText(android.getName());
        holder.androidVersion.setText(android.getVersion());

        holder.btnDetail.setOnClickListener(new CustomOnItemClickListener(position,
                new CustomOnItemClickListener.OnItemClickCallback() {

                    @Override
                    public void onItemClicked(View view, int position) {

                        /*Toast.makeText(context, "Favorite " + getListAndroid().get(position)
                                .getName(), Toast.LENGTH_SHORT).show();*/

                        Intent detail = new Intent(context, DetailActivity.class);
                        detail.putExtra("Name", android.getName());
                        detail.putExtra("Version", android.getVersion());
                        detail.putExtra("Photo", android.getPhoto());
                        detail.putExtra("Description", android.getDescription());
                        context.startActivity(detail);

                    }

                }));

        holder.btnShare.setOnClickListener(new CustomOnItemClickListener(position,
                new CustomOnItemClickListener.OnItemClickCallback() {

                    @Override
                    public void onItemClicked(View view, int position) {

                        /*Toast.makeText(context, "Share " + getListAndroid().get(position)
                                .getName(), Toast.LENGTH_SHORT).show();*/

                        Intent share = new Intent(Intent.ACTION_SEND);
                        share.setType("text/plain");
                        String shareBodyText = "Your sharing message goes here";
                        share.putExtra(Intent.EXTRA_SUBJECT, "Subject/Title");
                        share.putExtra(Intent.EXTRA_TEXT, shareBodyText);
                        context.startActivity(Intent.createChooser(share, "Choose sharing method"));

                    }

                }));

        Glide.with(context)
                .load(android.getPhoto())
                .override(350, 450)
                .into(holder.imgAndroid);

    }

    @Override
    public int getItemCount() {
        return getListAndroid().size();
    }

    public class AndroidViewHolder extends RecyclerView.ViewHolder {

        ImageView imgAndroid;
        TextView androidName, androidVersion;
        Button btnShare, btnDetail;

        public AndroidViewHolder(View itemView) {

            super(itemView);

            imgAndroid = (ImageView)itemView.findViewById(R.id.img_android);
            androidName = (TextView)itemView.findViewById(R.id.android_name);
            androidVersion = (TextView)itemView.findViewById(R.id.android_version);
            btnShare = (Button)itemView.findViewById(R.id.btn_share);
            btnDetail = (Button)itemView.findViewById(R.id.btn_detail);

        }

    }

}
