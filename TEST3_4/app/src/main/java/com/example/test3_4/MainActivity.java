package com.example.test3_4;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    String[] names = {"One", "Two", "Three", "Four"};
    HashMap<View, Boolean> vis;
    int selected_items = 0;
    ActionMode am;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vis = new HashMap<>();

        ListView lv_3 = findViewById(R.id.mylist);
        ArrayList<HashMap<String, Object>> lst = new ArrayList<>();
        for (int i = 0; i <= 3; i++)
        {
            HashMap<String, Object> mp = new HashMap<>();
            mp.put("textname", names[i]);
            mp.put("pic", R.drawable.apple);
            lst.add(mp);
        }

        SimpleAdapter sa = new SimpleAdapter(this,lst,R.layout.login,new String[]{"textname","pic"},new int[]{R.id.textname,R.id.pic});
        lv_3.setAdapter(sa);
    }

    public void click_select(View V)
    {
        if (am == null)
            am = startActionMode(callback);

        LinearLayout ll = (LinearLayout) V;
        if (vis.get(V) == null || !vis.get(V))
        {
            ll.setBackgroundColor(Color.GREEN);
            vis.put(V, true);
            selected_items++;
        }
        else
        {
            ll.setBackgroundColor(Color.WHITE);
            vis.put(V, false);
            selected_items--;
        }
        callback.onActionItemClicked(am, null);

    }

    ActionMode.Callback callback = new ActionMode.Callback()
    {

        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu)
        {
            getMenuInflater().inflate(R.menu.menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu)
        {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem)
        {
            actionMode.setTitle(selected_items + " selected");
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode)
        {

        }
    };

}

