package com.demo_staggered.pulkit.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo_staggered.pulkit.R;
import com.demo_staggered.pulkit.models.ItemObjects;

import java.util.List;

public class StaggeredAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ItemObjects> productList;
    private onClickListener onClickListener;
    private Context context;

    public interface onClickListener {
        void onClickButton(int position, int view, ItemObjects product);
    }

    public StaggeredAdapter(Context context, List<ItemObjects> productList, onClickListener onClickListener) {
        this.context = context;
        this.productList = productList;
        this.onClickListener = onClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_list_tems, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        ViewHolder holder = (ViewHolder) viewHolder;

        holder.countryName.setText(productList.get(position).getName());
        holder.countryPhoto.setImageResource(productList.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView countryName;
        private ImageView countryPhoto;

        public ViewHolder(View itemView) {
            super(itemView);

            countryName = itemView.findViewById(R.id.country_name);
            countryPhoto = itemView.findViewById(R.id.country_photo);

        }

        @Override
        public void onClick(View view) {
            onClickListener.onClickButton(getLayoutPosition(), view.getId(), productList.get(getLayoutPosition()));
        }
    }


}
