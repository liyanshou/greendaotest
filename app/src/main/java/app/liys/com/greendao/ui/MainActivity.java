package app.liys.com.greendao.ui;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.liys.com.gen.User;
import com.liys.com.gen.UserDao;
import com.liys.com.utils.DaoManager;

import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import app.liys.com.greendao.R;
import app.liys.com.greendao.adapter.RecycleAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private UserDao userDao;
    private RecycleAdapter recycleAdapter;
    private RecyclerView recyclerView;
    private EditText input;
    private TextView add,query_button;
    private SwipeRefreshLayout swipeRefreshLayout;
    LinearLayoutManager linearLayoutManager;
    int lastVisibleItemPosition;
    int firstVisibleItemPosition;
    int itemCount;
    int childCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =findViewById(R.id.listview);
        input = findViewById(R.id.input_name_info);
        add = findViewById(R.id.button);
        query_button = findViewById(R.id.query_button);
        query_button.setOnClickListener(this);
        swipeRefreshLayout = ((SwipeRefreshLayout) findViewById(R.id.swipRefreshlistview));
        add.setOnClickListener(this);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recycleAdapter = new RecycleAdapter(this);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },5000);
            }
        });
        recycleAdapter.setOnItemClickListener(new RecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, User user) {
                userDao.delete(user);
                Toast.makeText(MainActivity.this, "位置"+user.getName(), Toast.LENGTH_SHORT).show();
                setData();
            }
        });
        recyclerView.setAdapter(recycleAdapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                itemCount = linearLayoutManager.getItemCount();
                Log.i("lys_recyclerView","itemCount="+itemCount);
                childCount = recyclerView.getChildCount();
                Log.i("lys_recyclerView","childCount="+childCount);
            }
        });
        userDao = DaoManager.getInstance().getDaoSession().getUserDao();

        userDao.deleteAll();
        for(int i= 0;i<10;i++){
            userDao.insert(new User((long) i,"小屁孩",i+"岁"));
        }
        for(int i= 10;i<20;i++){
            userDao.insert(new User((long) i,"小皮妞",i+"岁"));
        }
        setData();
    }
    public void setData(){
        List<User> users = userDao.loadAll();
        recycleAdapter.setDatas(users);
    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.query_button:
                QueryBuilder<User> queryBuilder = userDao.queryBuilder().where(UserDao.Properties.StuNum.between(2,10));
                Query<User> build = queryBuilder.build();
                List<User> list = build.list();
                for(User user:list){
                    Long key = userDao.getKey(user);
                    Log.wtf("lys_recyclerView","name="+user.getName()+ "age="+user.getAge()+" key ="+key);
                }
//                String[] allColumns = userDao.getAllColumns();
//
//                for(String s:allColumns){
//                    Log.wtf("lys_recyclerView",s);
//                }
                break;
            case R.id.button:
                String string = input.getText().toString();
                userDao.insertOrReplace(new User((long) 111,string,111+"岁"));
                setData();
                break;
        }

    }
}
