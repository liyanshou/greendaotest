package app.liys.com.greendao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liys.com.gen.User;

import java.util.List;

import app.liys.com.greendao.R;

/**
 * Created by liys
 * @time 2017-07-19.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.CommViewHolder> {
    private Context context;
    private List<User> datas;
    public RecycleAdapter(Context context, List<User> datas) {
        this.context = context;
        this.datas = datas;
    }
    public RecycleAdapter(Context context) {
        this.context = context;
    }
    @Override
    public CommViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CommViewHolder commViewHolder = new CommViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_item_layout, null));

        return commViewHolder;
    }

    @Override
    public void onBindViewHolder(CommViewHolder holder, int position) {
        holder.tvName.setText(datas.get(position).getName());
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
        this.datas.clear();
        this.datas = datas;
        notifyDataSetChanged();
    }
    public class CommViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvNum;

        public CommViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvNum = itemView.findViewById(R.id.tv_num);
        }
    }
}
