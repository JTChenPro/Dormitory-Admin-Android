package com.example.week9text;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ExpandableListViewTest extends Activity  
{  
    @Override  
    public void onCreate(Bundle savedInstanceState)  
    {  
        super.onCreate(savedInstanceState);  
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.list_layout);  
        //创建一个BaseExpandableListAdapter对象  
        ExpandableListAdapter adapter = new BaseExpandableListAdapter()  
        {  
            int[][] logos = new int[][]  
            {  
                {R.drawable.b1,R.drawable.b1,R.drawable.b1,R.drawable.b1},
                {R.drawable.b2,R.drawable.b2,R.drawable.b2,R.drawable.b2},  
                {R.drawable.b3,R.drawable.b3,R.drawable.b3 }
            };  
            private String[] CDs = new String[]  
                { "5A317", "5A318", "5A319"
//            		,"北京","上海","浙江","江苏","广西","西藏","山东"
            		};  
            private String[][] songs = new String[][]  
            {   
                { "陈锦涛", "王时威", "苏愈益", "路基县" },  
                { "张三", "李斯", "望物", "兵役" },  
                { "自傲", "趁啊是" , "这中山" }
//                ,  
//                { "北京" },  
//                { "上海" },  
//                { "杭州" },  
//                { "南京"},  
//                { "桂林"},  
//                { "拉萨"},  
//                { "青岛"},  
//                { "青岛"} 
            };  
            //获取指定组位置、指定子列表项处的子列表项数据  
            @Override  
            public Object getChild(int groupPosition, int childPosition)  
            {  
                return songs[groupPosition][childPosition];  
            }  
            @Override  
            public long getChildId(int groupPosition, int childPosition)  
            {  
                return childPosition;  
            }  
            @Override  
            public int getChildrenCount(int groupPosition)  
            {  
                return songs[groupPosition].length;  
            }  
            private TextView getTextView()  
            {  
                //用于实现条目的虚拟列表的基类. 这里的列表没有空间的定义。 例如，该类的子类可以以网格的形式、走马灯的形式显示，或者作为堆栈等等  
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(  
                        ViewGroup.LayoutParams.FILL_PARENT, 64);  //设置宽和高   
                TextView textView = new TextView(ExpandableListViewTest.this);  
                textView.setLayoutParams(lp);  
                textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);  
                textView.setPadding(36, 0, 0, 0);  
                textView.setTextSize(20);  
                return textView;  
            }  
            //该方法决定每个子选项的外观  
            @Override  
            public View getChildView(int groupPosition, int childPosition,  
                    boolean isLastChild, View convertView, ViewGroup parent)  
            {  
                  
               
                LinearLayout ll = new LinearLayout(ExpandableListViewTest.this);  
                ll.setOrientation(0);  
                ImageView logo = new ImageView(ExpandableListViewTest.this);  
                logo.setImageResource(logos[groupPosition][childPosition]);  
                ll.addView(logo);  
                TextView textView = getTextView();            
                textView.setText(" "+getChild(groupPosition, childPosition).toString());                
                ll.addView(textView);             
                return ll;  
            }  
            //获取指定组位置处的组数据  
            @Override  
            public Object getGroup(int groupPosition)  
            {  
                return CDs[groupPosition];  
            }  
            @Override  
            public int getGroupCount()  
            {  
                return CDs.length;  
            }  
            @Override  
            public long getGroupId(int groupPosition)  
            {  
                return groupPosition;  
            }  
            //该方法决定每个组选项的外观  
            @Override  
            public View getGroupView(int groupPosition, boolean isExpanded,  
                    View convertView, ViewGroup parent)  
            {  
                LinearLayout ll = new LinearLayout(ExpandableListViewTest.this);  
                ll.setOrientation(0);  
                ImageView logo = new ImageView(ExpandableListViewTest.this);  
 //               logo.setImageResource(logos[groupPosition]);  
//                ll.addView(logo);  
                TextView textView = getTextView();  
                textView.setText(getGroup(groupPosition).toString());                 
                ll.addView(textView);             
                return ll;  
            }  
            @Override  
            public boolean isChildSelectable(int groupPosition, int childPosition)  
            {  
                return true;  
            }  
            @Override  
            public boolean hasStableIds()  
            {  
                return true;  
            }
			
        };  
        ExpandableListView expandListView = (ExpandableListView)  
            findViewById(R.id.list);  
        expandListView.setAdapter(adapter);  
    }  
}  