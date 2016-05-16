package hu.expanda.testlib.testlibrary;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Encsi on 2015.04.17..
 */
public final class dbClient  {
    String sql = "CREATE TABLE LOG(id INTEGER PRIMARY KEY,type TEXT,value TEXT,status INTEGER,dcreate DATETIME,dsync DATETIME);";
    private static ArrayList<String> result = null;
    private static dbHelper db = null;

    public dbClient (Context c) {
        if (db==null)  db = new dbHelper(c,this.sql);
    }


    public static  ArrayList<String> Query(String... params) {
        Log.d(testlib.class.getName(), "testlib: dbClient.Query() called. sql:" + params[0]);
        ArrayList<String> res = db.Query(params[0]);
        db.closeDB();
        return  res;

    }

    public static  void Exec(String... params) {
        db.Exec(params[0]);
        db.closeDB();
    }


}
