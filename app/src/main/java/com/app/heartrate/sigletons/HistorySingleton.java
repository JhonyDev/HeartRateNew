package com.app.heartrate.sigletons;

import com.app.heartrate.mvvm.capsules.response.HistoryPojo;

public class HistorySingleton {
    private static HistoryPojo instance;

    public static HistoryPojo getInstance() {
        if (instance == null)
            instance = new HistoryPojo();
        return instance;
    }

    public static void setInstance(HistoryPojo historyPojo) {
        instance = historyPojo;
    }

}
