package com.liys.com.gen;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.greenrobot.greendao.database.Database;

/**
 * Created by liys
 * @time 2017-07-20.
 */

public class DevOpenHelperUpgrade extends DaoMaster.OpenHelper {
    public DevOpenHelperUpgrade(Context context, String name) {
        super(context, name);
    }

    public DevOpenHelperUpgrade(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        //做数据库升级的处理
        if (oldVersion < 7) {
            //增加一个字段
//            db.execSQL("ALTER TABLE USER ADD is_stu BIT NOT NULL DEFAULT 0");
            //增加表
            DaoMaster.createAllTables(db,true);
        }
    }
}
