package com.marvin.testproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * ┏┓　   ┏┓
 * ┏┛┻━━━━━┛┻━┓
 * ┃　　　　   ┃
 * ┃　━　━　   ┃
 * ████━████   ┃
 * ┃　　　　   ┃
 * ┃　 ┻　    ┃
 * ┗━┓      ┏━┛
 * 　┃      ┃
 * 　┃ 0BUG ┗━━━┓
 * 　┃0Error     ┣┓
 * 　┃0Warning   ┏┛
 * 　┗┓┓┏━┳┓┏┛ ━
 * 　　┃┫┫ ┃┫┫
 * 　　┗┻┛ ┗┻┛
 * Created by clz on 2019/7/12
 */
public class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private Context mContext;
    List<FruitBean> mFruitBeans;
    private OnItemClickListener mOnItemClickListener;

    public DataAdapter(Context context, List<FruitBean> fruitBeans) {
        this.mContext = context;
        this.mFruitBeans = fruitBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, null);
        ViewHolder viewHolder = new ViewHolder(view);
//        viewHolder.tv_item.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//        viewHolder.iv_item.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).tv_item.setText(mFruitBeans.get(position).getFruit());
            ((ViewHolder) holder).tv_item.setTag(position);
            ((ViewHolder) holder).iv_item.setTag(position);
        }
    }

    @Override
    public int getItemCount() {
        return mFruitBeans.size();
    }

    @Override
    public void onClick(View v) {
       int position = (int) v.getTag();
        if (mOnItemClickListener != null) {
            switch (v.getId()) {
                case R.id.tv_item:
                    mOnItemClickListener.setItemClick(v, 0, position);
                    break;
                case R.id.iv_item:
                    mOnItemClickListener.setItemClick(v, 1, position);
                    break;
                default:
                    break;

            }
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_item;
        TextView tv_item;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_item = itemView.findViewById(R.id.iv_item);
            tv_item = itemView.findViewById(R.id.tv_item);
            iv_item.setOnClickListener(DataAdapter.this);
            tv_item.setOnClickListener(DataAdapter.this);

        }
    }

    public interface OnItemClickListener {
        void setItemClick(View view, int tag, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }
}
