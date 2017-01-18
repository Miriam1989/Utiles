package com.utiles.qacg.utiles.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.utiles.qacg.utiles.R;
import com.utiles.qacg.utiles.interfaces.ListUserCallBacks;
import com.utiles.qacg.utiles.models.Utiles;
import com.utiles.qacg.utiles.view.ListUserActivity;

import java.util.List;

public class UtilsAdapter extends RecyclerView.Adapter<UtilsAdapter.UtilsViewHolder> {

    private final Context context;
    private final List<Utiles> listUtils;
    private ListUserCallBacks mListUserCallback;


    public UtilsAdapter(Context context, List<Utiles> listUtils, ListUserCallBacks mListUserCallback) {
        this.context = context;
        this.listUtils = listUtils;
        this.mListUserCallback = mListUserCallback;

    }


    @Override
    public UtilsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_utils, parent, false);
        return new UtilsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UtilsViewHolder holder, int position) {
        holder.bindViewHeader(listUtils.get(position));

    }

    @Override
    public int getItemCount() {
        return listUtils.size();
    }

    protected class UtilsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Utiles utiles;
        private final ImageView iv_circle;
        private final ImageView iv_article;
        private final TextView tv_nameArticle;
        private RelativeLayout rl_content;



        public UtilsViewHolder(View itemView) {
            super(itemView);
            iv_circle = (ImageView) itemView.findViewById(R.id.iv_circle);
            iv_article = (ImageView) itemView.findViewById(R.id.iv_article);
            tv_nameArticle = (TextView) itemView.findViewById(R.id.tv_nameArticle);
            rl_content = (RelativeLayout) itemView.findViewById(R.id.rl_content);
            rl_content.setOnClickListener(this);
        }

        public void bindViewHeader(Utiles utiles) {
            this.utiles = utiles;
            //if (utiles ==  ){
                iv_circle.setImageResource(R.drawable.ic_verde);
                iv_article.setImageResource(R.drawable.ic_pencil);
                tv_nameArticle.setText(utiles.getName());
            }


        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.rl_content:
                    mListUserCallback.callIntent(utiles.getId());
                    break;
            }


        }
    }
}