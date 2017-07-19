package app.liys.com.greendao.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.liys.com.gen.User;
import com.liys.com.gen.UserDao;
import com.liys.com.utils.DaoManager;

import java.util.List;

import app.liys.com.greendao.R;
import app.liys.com.greendao.adapter.RecycleAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =findViewById(R.id.listview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));
        RecycleAdapter recycleAdapter = new RecycleAdapter(this);
        recyclerView.setAdapter(recycleAdapter);

        UserDao userDao = DaoManager.getInstance().getDaoSession().getUserDao();
        for(int i= 0;i<10;i++){
            userDao.insert(new User((long) i,"小屁孩",i+"岁"));
        }
        for(int i= 10;i<20;i++){
            userDao.insert(new User((long) i,"小皮妞",i+"岁"));
        }
        List<User> users = userDao.loadAll();
        recycleAdapter.setDatas(users);
    }
}
