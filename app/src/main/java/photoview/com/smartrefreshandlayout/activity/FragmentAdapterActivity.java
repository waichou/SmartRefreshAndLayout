package photoview.com.smartrefreshandlayout.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.Bundler;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import photoview.com.smartrefreshandlayout.R;
import photoview.com.smartrefreshandlayout.fragment.PageFragment;

/**
 * 参考：https://www.jianshu.com/p/1fef849fd1eb
 */
public class FragmentAdapterActivity extends AppCompatActivity {

    private FragmentPagerItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //第一种适配器-FragmentAdapter
        adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("标签一", PageFragment.class)
                .add("标签二", PageFragment.class)
                .add("标签三",PageFragment.class,new Bundler().putString("content", "x123").get())//通过Bundlder就是利用setArgument的方式传递的初始化参数
                .add(FragmentPagerItem.of("标签四", PageFragment.class))
                .create());

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(viewPager);

        //滑动到的监听器需要设置到viewPagerTab上面
        viewPagerTab.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(FragmentAdapterActivity.this, "current item's position is "+ position, Toast.LENGTH_SHORT).show();

                PageFragment page = (PageFragment) adapter.getPage(position);
                View fragmentRootView = page.getView();
                if (fragmentRootView instanceof TextView){
                    TextView tv = (TextView) fragmentRootView;
                    System.out.println("获取child fragment rootview content is " + tv.getText().toString());
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
