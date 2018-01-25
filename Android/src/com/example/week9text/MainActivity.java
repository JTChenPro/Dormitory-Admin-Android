package com.example.week9text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity  
{  
	Handler handler=new Handler(); 
	int i=0;
    int[] imageIds = new int[]  
    {  
        R.drawable.b1 , R.drawable.b2 , R.drawable.b3   
        , R.drawable.b4 , R.drawable.b5 , R.drawable.b6  
        , R.drawable.b7 , R.drawable.b8 , R.drawable.b9   
    };  
    int[] imageSwitcherIds = new int[]  
    	    {  
    		R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d
    		,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h
    	    }; 
    @Override  
    public void onCreate(Bundle savedInstanceState)  
    {  
        super.onCreate(savedInstanceState);  
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Intent intent=this.getIntent();
        setContentView(R.layout.activity_main);  
        TextView t=(TextView)findViewById(R.id.idshow);
        String a=intent.getStringExtra("id").toString();
        t.setText(String.valueOf(a));
        
        
        //创建一个List对象，List对象的元素是Map  
        List<Map<String, Object>> listItems   
            = new ArrayList<Map<String, Object>>();  
        for (int i = 0; i < imageIds.length; i++)  
        {  
            Map<String, Object> listItem = new HashMap<String, Object>();  
            listItem.put("image" , imageIds[i]);  
            listItems.add(listItem);  
        }  
        //获取显示图片的ImageSwitcher  
        final ImageSwitcher switcher = (ImageSwitcher)  
            findViewById(R.id.switcher);  
        //设置图片更换的动画效果  
        switcher.setInAnimation(AnimationUtils.loadAnimation(this,  
            android.R.anim.fade_in));  
        switcher.setOutAnimation(AnimationUtils.loadAnimation(this,  
            android.R.anim.fade_out));  
        //为ImageSwitcher设置图片切换的动画效果  
        switcher.setFactory(new ViewFactory()  
        {  
            @Override  
            public View makeView()  
            {  
                ImageView imageView = new ImageView(MainActivity.this);  
                imageView.setBackgroundColor(0xff0000);  
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);  
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(  
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));  
                return imageView;  
            }  
        });
        switcher.setImageResource(R.drawable.a);
         
        Runnable runnable=new Runnable() {  
            @Override  
            public void run() {  
                // TODO Auto-generated method stub  
                //要做的事情  
            	switcher.setImageResource(imageSwitcherIds[i]);
            	i++;
            	if(i==8)
            		i=0;
                handler.postDelayed(this, 1000);  
            }  
        };
        handler.postDelayed(runnable, 1000);
        //创建一个SimpleAdapter  
        SimpleAdapter simpleAdapter = new SimpleAdapter(this  
            , listItems   
            //使用/layout/cell.xml文件作为界面布局  
            , R.layout.gridview_layout 
            , new String[]{"image"}  
            , new int[]{R.id.image1});  
        GridView grid = (GridView)findViewById(R.id.grid01);  
        //为GridView设置Adapter  
        grid.setAdapter(simpleAdapter);  
        //添加列表项被选中的监听器  
        grid.setOnItemSelectedListener(new OnItemSelectedListener()  
        {  
            @Override  
            public void onItemSelected(AdapterView<?> parent, View view,   
                int position , long id)  
            {  
                //显示当前被选中的图片  
                switcher.setImageResource(imageIds[position % imageIds.length]);  
            }  
            @Override  
            public void onNothingSelected(AdapterView<?> parent){}              
        });  
        //添加列表项被单击的监听器  
        grid.setOnItemClickListener(new OnItemClickListener()  
        {  
            @Override  
            public void onItemClick(AdapterView<?> parent  
                , View view, int position, long id)  
            {  
                //显示被单击的图片的图片  
             //   switcher.setImageResource(imageIds[position % imageIds.length]);  
            	Intent  intent = new Intent();
            	intent.setClass(MainActivity.this, ExpandableListViewTest.class);
            	startActivity(intent);
            }  
        });  
    }  
}  