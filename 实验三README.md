实验三 ui组件

一、

代码：

MainActivity.java

```
package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private String[] names=new String[]{"Lion","Tiger","Monkey","Dog","Cat","elephant"};
    private int [] imageIds=new int[]{R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};      //外部图片

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Map<String,Object>> listItems=new ArrayList<>();
        for(int i=0;i<names.length;i++){
            Map<String,Object>listItem=new HashMap<>();
            listItem.put("animalname",names[i]);
            listItem.put("pic",imageIds[i]);//图片
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,R.layout.simple_item,new String[]{"animalname","pic"},new int[]{R.id.animalname,R.id.pic});
        ListView list = findViewById(R.id.mylist);
        list.setAdapter(simpleAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("-CRAZYIT-", names[position] + "selected");
                Toast toast = Toast.makeText(MainActivity.this, names[position], Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        }
}

```

simple_item.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="horizontal"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/textview"
    tools:context=".MainActivity">
    <TextView
        android:id="@+id/animalname"
        android:layout_width="300dp"
        android:layout_height="78dp"
        android:paddingLeft="10dp"/>
<!--        android:textColor="@color/textview"-->

    <ImageView
        android:id="@+id/pic"
        android:layout_width="110dp"
        android:layout_height="75dp"
        android:padding="10dp"/>
</LinearLayout>
```

colors.xml

```
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="colorPrimary">#6200EE</color>
    <color name="colorPrimaryDark">#3700B3</color>
    <color name="colorAccent">#03DAC5</color>
</resources>
```

textview.xml

```
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:state_selected="true" android:color="#FF66FF" />
    <item android:state_focused="true" android:color="#FF66FF" />
    <item android:state_pressed="true" android:color="#FF66FF" />
    <item android:color="#ffffff" />
</selector>
```

主界面图片
![image]()


点击后会变色



点击后下方会出现含该名字的弹窗



二、

代码：

MainActivity.java

```
package com.example.test3_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

import static androidx.core.os.LocaleListCompat.create;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
    }

    public void customView(View source) {
        TableLayout loginForm = (TableLayout) getLayoutInflater().inflate(R.layout.login, null);

        new AlertDialog.Builder(this)
                .setIcon(R.drawable.apppic)
                .setView(loginForm)
                .setPositiveButton("sign in", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

        }
    })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })

                .create().show();
    }
}
```

login.xml

```
<?xml version="1.0" encoding="utf-8"?>
<TableLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical">

    <TableRow
        android:layout_width="wrap_content"
        android:layout_height="match_parent">

        <ImageView
            android:id="@+id/imageView"
            android:layout_width="400dp"
            android:layout_height="match_parent"
            app:srcCompat="@drawable/apppic" />
    </TableRow>

    <TableRow
        android:layout_width="wrap_content"
        android:layout_height="34dp">

        <EditText
            android:id="@+id/TextPersonName"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:ems="10"
            android:hint="Username"
            android:inputType="textPersonName" />
    </TableRow>

    <TableRow
        android:layout_width="wrap_content"
        android:layout_height="match_parent">

        <EditText
            android:id="@+id/TextPassword"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:hint="Password"
            android:ems="10"
            android:inputType="textPassword"
            />
    </TableRow>
</TableLayout>

```

layout.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="match_parent"
android:layout_height="match_parent">
<Button
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:text="button"
    android:onClick="customView">

</Button>
</LinearLayout>
```

主界面有一按钮



点击后进入对话框



点击后会出现输入键盘





三、

代码：

MainActivity.java

```
package com.example.test3_3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 定义“字体大小”菜单项的标识
    private static final int FONT_10 = 0x111;
    private static final int FONT_16 = 0x114;
    private static final int FONT_20 = 0x115;
    // 定义“普通菜单项”的标识
    private static final int PLAIN_ITEM = 0x11b;
    // 定义“字体颜色”菜单项的标识
    private static final int FONT_RED = 0x116;
    private static final int FONT_BLACK = 0x118;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        text = findViewById(R.id.txt);
    }
    // 当用户单击MENU键时触发该方法
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // -------------向menu中添加“字体大小”的子菜单-------------
        SubMenu fontMenu = menu.addSubMenu("字体大小");


        // 设置菜单头的标题
        fontMenu.setHeaderTitle("选择字体大小");
        fontMenu.add(0, FONT_10, 0, "10号字体");
        fontMenu.add(0, FONT_16, 0, "16号字体");
        fontMenu.add(0, FONT_20, 0, "20号字体");
        // -------------向menu中添加“普通菜单项”-------------
        menu.add(0, PLAIN_ITEM, 0, "普通菜单项");
        // -------------向menu中添加“字体颜色”的子菜单-------------
        SubMenu colorMenu = menu.addSubMenu("字体颜色");

        // 设置菜单头的图标

        // 设置菜单头的标题
        colorMenu.setHeaderTitle("选择文字颜色");
        colorMenu.add(0, FONT_RED, 0, "红色");
        colorMenu.add(0, FONT_BLACK, 0, "黑色");
        return super.onCreateOptionsMenu(menu);
    }
    // 选项菜单的菜单项被单击后的回调方法
    @Override
    public boolean onOptionsItemSelected(MenuItem mi)
    {
        // 判断单击的是哪个菜单项，并有针对性地做出响应
        switch (mi.getItemId())
        {
            case FONT_10: text.setTextSize(10 * 2);	break;

            case FONT_16: text.setTextSize(16 * 2); break;
            case FONT_20: text.setTextSize(20 * 2); break;
            case FONT_RED: text.setTextColor(Color.RED); break;
            case FONT_BLACK: text.setTextColor(Color.BLACK); break;
            case PLAIN_ITEM:
                Toast.makeText(MainActivity.this,
                        "您单击了普通菜单项", Toast.LENGTH_SHORT)
                        .show();
                break;
        }
        return true;
    }
}
```

layout.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <TextView
        android:id="@+id/txt"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="用于测试的内容"></TextView>
</LinearLayout>

```

主界面



点击菜单后出现选项菜单



点击字体大小



点击普通菜单项后下方出现对话框



点击字体颜色
