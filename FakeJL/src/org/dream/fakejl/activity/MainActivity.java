package org.dream.fakejl.activity;

import org.dream.fakejl.R;
import org.dream.fakejl.fragment.NewsFragment;
import org.dream.fakejl.fragment.VideoFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

// 实现OnClickListener，监听点击事件
public class MainActivity extends FragmentActivity implements OnClickListener {
	private View selectedView;

	private ImageView imgNews;
	private ImageView imgVideo;
	private ImageView imgData;
	private ImageView imgProfession;
	private ImageView imgMore;

	private FragmentManager fragmentManager;
	private FragmentTransaction fragmentTransaction;
	private NewsFragment newsFragment;
	private VideoFragment videoFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		fragmentManager = getSupportFragmentManager();
		imgNews = (ImageView) findViewById(R.id.img_news);
		imgVideo = (ImageView) findViewById(R.id.img_video);
		imgProfession = (ImageView) findViewById(R.id.img_profession);
		imgData = (ImageView) findViewById(R.id.img_data);
		imgMore = (ImageView) findViewById(R.id.img_more);

		// 给图片注册点击事件监听器
		imgNews.setOnClickListener(this);
		imgVideo.setOnClickListener(this);
		imgProfession.setOnClickListener(this);
		imgData.setOnClickListener(this);
		imgMore.setOnClickListener(this);
		initView();
	}
	
	public void initView(){
		fragmentTransaction = fragmentManager.beginTransaction();
		hideFragments(fragmentTransaction);
		newsFragment = new NewsFragment();
		fragmentTransaction.add(R.id.fragment, newsFragment);
		fragmentTransaction.commit();
		Log.d("output", "add-news");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// 所有图片置为未选中
		imgNews.setImageResource(R.drawable.tab_btn_nor1);
		imgVideo.setImageResource(R.drawable.tab_btn_nor2);
		imgProfession.setImageResource(R.drawable.tab_btn_nor3);
		imgData.setImageResource(R.drawable.tab_btn_nor4);
		imgMore.setImageResource(R.drawable.tab_btn_nor5);

		fragmentTransaction = fragmentManager.beginTransaction();
		hideFragments(fragmentTransaction);
		// 根据点击的图片设置
		switch (v.getId()) {
		case R.id.img_news:
			imgNews.setImageResource(R.drawable.tab_btn_sel1);

			if (selectedView != null && selectedView.getId() == R.id.img_news) {
				return;
			}
			selectedView = imgNews;
			if(newsFragment==null){
				newsFragment = new NewsFragment();
				fragmentTransaction.add(R.id.fragment, newsFragment);
				Log.d("output", "replace-news");
			}else{
				fragmentTransaction.show(newsFragment);
				Log.d("output", "show-news");
			}
			fragmentTransaction.commit();
			break;
		case R.id.img_video:
			imgVideo.setImageResource(R.drawable.tab_btn_sel2);
			if (selectedView != null && selectedView.getId() == R.id.img_video) {
				return;
			}
			selectedView = imgVideo;
			if(videoFragment==null){
				videoFragment=new VideoFragment();
				// add加入
				fragmentTransaction.add(R.id.fragment, videoFragment);
				Log.d("output", "replace-video");
			}else{
				fragmentTransaction.show(videoFragment);
				Log.d("output", "show-video");
			}
			
			fragmentTransaction.commit();
			break;
		case R.id.img_profession:
			imgProfession.setImageResource(R.drawable.tab_btn_sel3);
			if (selectedView != null
					&& selectedView.getId() == R.id.img_profession) {
				return;
			}
			break;
		case R.id.img_data:
			imgData.setImageResource(R.drawable.tab_btn_sel4);
			if (selectedView != null && selectedView.getId() == R.id.img_data) {
				return;
			}
			break;
		case R.id.img_more:
			imgMore.setImageResource(R.drawable.tab_btn_sel5);
			if (selectedView != null && selectedView.getId() == R.id.img_more) {
				return;
			}
			break;
		}
	}
	/** 
     * 将所有的Fragment都置为隐藏状态。 
     *  
     * @param transaction 
     *            用于对Fragment执行操作的事务 
     */  
    private void hideFragments(FragmentTransaction transaction) {  
        if (newsFragment != null) { 
            transaction.hide(newsFragment);  
        }  
        if (videoFragment != null) {  
            transaction.hide(videoFragment);  
        }   
    }  

}
