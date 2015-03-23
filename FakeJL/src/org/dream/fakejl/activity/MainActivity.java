package org.dream.fakejl.activity;

import org.dream.fakejl.R;
import org.dream.fakejl.fragment.NewsFragment;
import org.dream.fakejl.fragment.VideoFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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

	NewsFragment newsFragment = new NewsFragment();
	VideoFragment videoFragment = new VideoFragment();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

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

		FragmentManager fragmentManager = getSupportFragmentManager();

		// 根据点击的图片设置
		switch (v.getId()) {
		case R.id.img_news:
			imgNews.setImageResource(R.drawable.tab_btn_sel1);

			if (selectedView != null && selectedView.getId() == R.id.img_news) {
				return;
			}
			selectedView = imgNews;
			FragmentTransaction fragmentTransaction = fragmentManager
					.beginTransaction();
			fragmentTransaction.replace(R.id.fragment, newsFragment);
			fragmentTransaction.commit();
			break;
		case R.id.img_video:
			imgVideo.setImageResource(R.drawable.tab_btn_sel2);
			if (selectedView != null && selectedView.getId() == R.id.img_video) {
				return;
			}
			selectedView = imgVideo;
			FragmentTransaction fragmentTransaction2 = fragmentManager
					.beginTransaction();
			fragmentTransaction2.replace(R.id.fragment, videoFragment);
			fragmentTransaction2.commit();
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

}
