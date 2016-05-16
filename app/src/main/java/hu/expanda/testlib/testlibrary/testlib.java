package hu.expanda.testlib.testlibrary;

/**
 * Created by kende on 2016. 04. 27..
 */
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class testlib  {


        public testlib() {

            Log.d(testlib.class.getName(), "testlib: constructor called.");
        }

        public void doSomething() {
            Log.d(testlib.class.getName(), "testlib: doSomething() called.");
        }
        public String getResult(ViewGroup layout) {/* Context context, String message */
            String name = "Button5";
            View b = layout.findViewWithTag(name);
            String buttonText = ((Button)b).getText().toString();
            Log.d(testlib.class.getName(), "testlib: getResult() called. Button5Text:"+buttonText);
            ((Button)b).setText("Teszt");
            buttonText = ((Button)b).getText().toString();

            name = "ButtonClose";
            b = layout.findViewWithTag(name);
            buttonText = ((Button)b).getText().toString();
            Log.d(testlib.class.getName(), "testlib: getResult() called. ButtonClose:"+buttonText);
            ((Button)b).setText("Exit");
            buttonText = ((Button)b).getText().toString();

            return buttonText;
        }

        public String setMantisTitle(ViewGroup layout, String... params){
            String name = "pcikkval_bvalaszt";
            String newTitle = params[0];
            View b = layout.findViewWithTag(name);
            ((Button)b).setText(newTitle);
            return newTitle;
        }
        public ArrayList<String> liteQuery(ViewGroup layout,  String... params) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            dbClient dbc = new dbClient(layout.getContext());
            String sql = "insert into log (value) values('teszt')";
            dbc.Exec(sql);
            sql = "select ID,VALUE from LOG order by id";

            Log.d(testlib.class.getName(), "testlib: liteQuery() called. dbc!=null:"+(dbc!=null));
            ArrayList<String> res = dbc.Query(sql);
            Log.d(testlib.class.getName(), "testlib: liteQuery() called. res:"+(res!=null));
            if (res!=null) Log.d(testlib.class.getName(), "testlib: liteQuery() called. sql:"+sql+" result:"+res.toString());
            return res;






        }



}
