package org.dream.fakejl.fragment;

import java.util.ArrayList;
import java.util.List;

import org.dream.fakejl.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viewpagerindicator.TabPageIndicator;

/**
 * 视频Fragment
 * 
 * @author Administrator
 * 
 */
public class VideoFragment extends Fragment {
	private List<Fragment> data;
	/**
	 * Tab标题
	 */
	//, "PVP","系列", "解说"
	private static final String[] TITLE = new String[] { "最新", "职业" };

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_video, container, false);
		ViewPager pager = (ViewPager) view.findViewById(R.id.video_pager);

		VideoFragmentItemLastest videoFragmentItemLastest = new VideoFragmentItemLastest();
		VideoFragmentItemProfession videoFragmentItemProfession = new VideoFragmentItemProfession();

		data = new ArrayList<Fragment>();
		data.add(videoFragmentItemLastest);
		data.add(videoFragmentItemProfession);

		pager.setAdapter(new TabPageIndicatorAdapter(getChildFragmentManager()));
		TabPageIndicator tabPageIndicator = (TabPageIndicator) view
				.findViewById(R.id.video_indicator);
		tabPageIndicator.setViewPager(pager);

		return view;
	}

	/**
	 * ViewPager适配器
	 * 
	 * @author len
	 * 
	 */
	class TabPageIndicatorAdapter extends FragmentPagerAdapter {

		public TabPageIndicatorAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return data.get(position);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return TITLE[position % TITLE.length];
		}

		@Override
		public int getCount() {
			return TITLE.length;
		}
	}

}
