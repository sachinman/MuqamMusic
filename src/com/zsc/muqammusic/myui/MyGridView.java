package com.zsc.muqammusic.myui;

import java.util.ArrayList;
import com.zsc.muqammusic.R;
import com.zsc.muqammusic.model.WordButton;
import com.zsc.muqammusic.util.Util;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

public class MyGridView extends GridView{
    public final static int COUNTS_WORDS = 24;
	
	private ArrayList<WordButton> mArrayList = new ArrayList<WordButton>();

	private MyGridAdapter mAdapter;
	
	private Context mContext;

	public MyGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		mContext = context;
		mAdapter = new MyGridAdapter();
		this.setAdapter(mAdapter);
	}
	
	public void updateData(ArrayList<WordButton> list) {
		mArrayList = list;	
		// ������������Դ
		setAdapter(mAdapter);
	}

	class MyGridAdapter extends BaseAdapter {
		public int getCount() {
			return mArrayList.size();
		}

		public Object getItem(int pos) {
			return mArrayList.get(pos);
		}

		public long getItemId(int pos) {
			return pos;
		}

		public View getView(int pos, View v, ViewGroup p) {
			WordButton holder;
			
			if (v == null) {
				v = Util.getView(mContext, R.layout.self_ui_gridview_item);
				
				holder = mArrayList.get(pos);
				
				holder.mIndex = pos;
				holder.mViewButton = (Button)v.findViewById(R.id.item_btn);
				
				v.setTag(holder);
			} else {
				holder = (WordButton)v.getTag();
			}
			
			holder.mViewButton.setText(holder.mWordString);
			
			return v;
		}
	}
}