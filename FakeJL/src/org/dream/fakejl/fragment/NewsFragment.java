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
 * 资讯Fragment
 * @author Administrator
 *
 */
public class NewsFragment extends Fragment {
	private List<Fragment> data;
	/**
	 * Tab标题
	 */
	//,"版本更新" 
	private static final String[] TITLE = new String[] { "最新", "国内新闻", "外服新闻"};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_news, container, false);
		ViewPager pager = (ViewPager) view.findViewById(R.id.pager);

		NewsFragmentItemLastest newsFragmentItemLastest = new NewsFragmentItemLastest();
		NewsFragmentItemInternal newsFragmentItemInternal = new NewsFragmentItemInternal();
		NewsFragmentItemExternal meFragment = new NewsFragmentItemExternal();
		
		data = new ArrayList<Fragment>();
		data.add(newsFragmentItemLastest);
		data.add(newsFragmentItemInternal);
		data.add(meFragment);

		pager.setAdapter(new TabPageIndicatorAdapter(getChildFragmentManager()));
		TabPageIndicator tabPageIndicator = (TabPageIndicator) view
				.findViewById(R.id.indicator);
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
