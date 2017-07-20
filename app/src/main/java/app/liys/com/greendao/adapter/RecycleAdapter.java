package app.liys.com.greendao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liys.com.gen.User;

import java.util.ArrayList;
import java.util.List;

import app.liys.com.greendao.R;

/**
 * Created by liys
 * @time 2017-07-19.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.CommViewHolder> implements View.OnClickListener {
    private Context context;
    private List<User> datas = new ArrayList<User>();
    public RecycleAdapter(Context context, List<User> datas) {
        this.context = context;
        this.datas = datas;
    }
    public RecycleAdapter(Context context) {
        this.context = context;
    }
    @Override
    public CommViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_item_layout, null);
        CommViewHolder commViewHolder = new CommViewHolder(view);
        view.setOnClickListener(this);
        return commViewHolder;
    }

    @Override
    public void onBindViewHolder(CommViewHolder holder, int position) {
        holder.itemView.setTag(datas.get(position));
        holder.tvName.setText(datas.get(position).getName());
        holder.tvNum.setText(datas.get(position).getStuNum()+"");
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        if(datas == null){
            return 0;
        }else {
            return datas.size();
        }
    }
    public void setDatas(List<User> datas){
        if(this.datas.size() >0){
            this.datas.clear();
        }
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        if(onItemClickListener != null){
            onItemClickListener.onItemClick(view, (User) view.getTag());
        }
    }

    public class CommViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvNum;

        public CommViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvNum = itemView.findViewById(R.id.tv_num);
        }
    }
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public  interface OnItemClickListener {
        void onItemClick(View view , User user);
    }
}
