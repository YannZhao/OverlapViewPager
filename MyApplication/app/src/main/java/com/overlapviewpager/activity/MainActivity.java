package com.overlapviewpager.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.ImageView;

import com.overlapviewpager.R;
import com.overlapviewpager.widget.OverlapViewPager;

public class MainActivity extends AppCompatActivity {

	OverlapViewPager viewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageView pageOne = new ImageView(this);
		pageOne.setImageResource(R.drawable.page_one);
		ImageView pageTwo = new ImageView(this);
		pageTwo.setImageResource(R.drawable.page_two);
		ImageView pageThree = new ImageView(this);
		pageThree.setImageResource(R.drawable.page_three);
		viewPager = (OverlapViewPager) findViewById(R.id.overlap_view_pager);
		ImageView[] views = new ImageView[] { pageOne, pageTwo, pageThree };
		viewPager.addViews(views);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && viewPager.getCurrentFront() != OverlapViewPager.PAGE_MIDDLE) {
			viewPager.resetPages();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
