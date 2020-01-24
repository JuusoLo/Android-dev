//package com.example.android_task1;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.BaseAdapter;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ListAdapter extends RecyclerView.Adapter<ListAdapterr.GridItemViewHolder> {
//
//    private Context context;
//    private List<Contact> mItemList;
//    private AdapterView.OnItemClickListener mOnItemClickListener;
//
//
//    public ListAdapter(Context context, List<Contact> mItemList) {
//        this.context = context;
//        this.mItemList = mItemList;
//    }
//
//
//
//    @Override
//    public GridItemViewHolder onCreateViewHolder(ViewGroup parent, int position) {
//        View itemView = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
//        return new GridItemViewHolder(itemView, this);
//    }
//
//    @Override
//    public void onBindViewHolder(GridItemViewHolder holder, int position) {
//        Detail items = mItemList.get(position);
//        holder.mTitle.setText(items.getName());
//        holder.mPosition.setText("" + items.getPosition());
//    }
//
//
//    @Override
//    public int getItemCount() {
//        return mItemList.size();
//    }
//
//    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
//        this.mOnItemClickListener = onItemClickListener;
//    }
//
//    private void onItemHolderClick(GridItemViewHolder itemHolder) {
//        if (mOnItemClickListener != null) {
//            mOnItemClickListener.onItemClick(null, itemHolder.itemView,
//                    itemHolder.getAdapterPosition(), itemHolder.getItemId());
//        }
//    }
//
//
//    public class GridItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        public TextView mTitle, mPosition;
//        public ListAdapter mAdapter;
//
//        public GridItemViewHolder(View itemView, ListAdapter mAdapter) {
//            super(itemView);
//            this.mAdapter = mAdapter;
//            mTitle = (TextView) itemView.findViewById(R.id.check_contacts);
//            mPosition = (TextView) itemView.findViewById(R.id.item_position);
//            itemView.setOnClickListener(this);
//        }
//
//        @Override
//        public void onClick(View v) {
//            mAdapter.onItemHolderClick(this);
//        }
//    }
//}
