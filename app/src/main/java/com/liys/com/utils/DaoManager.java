package com.liys.com.utils;

import com.liys.com.gen.DaoMaster;
import com.liys.com.gen.DaoSession;
import com.liys.com.gen.DevOpenHelperUpgrade;

/**
 * Created by liys
 * @time 2017-07-19.
 */

public class DaoManager {
    DaoSession daoSession;
    DaoMaster daoMaster;
    static DaoManager daoManager;
    public static DaoManager getInstance(){
        if(daoManager == null){
            synchronized (DaoManager.class){
                if(daoManager == null){
                    daoManager = new DaoManager();
                }
            }
        }
        return daoManager;
    }

    public DaoManager() {
        getDaoMaster();
        getDaoSession();
    }

    public DaoMaster getDaoMaster(){
        if(daoMaster == null){
            DevOpenHelperUpgrade devOpenHelper= new DevOpenHelperUpgrade(LyApplication.getLyApplication(),"Ly_test.db");
            daoMaster= new DaoMaster(devOpenHelper.getWritableDatabase());
        }
        return daoMaster;
    }


    public DaoSession getDaoSession(){
        if(daoSession == null){
            if(daoMaster == null){
                getDaoMaster();
            }
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }
}
