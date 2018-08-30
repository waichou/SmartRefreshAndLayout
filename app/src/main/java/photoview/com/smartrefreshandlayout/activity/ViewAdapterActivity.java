package photoview.com.smartrefreshandlayout.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.ViewPagerItem;
import com.ogaclejapan.smarttablayout.utils.ViewPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.ViewPagerItems;

import photoview.com.smartrefreshandlayout.R;

/**
 * 参考：https://www.jianshu.com/p/1fef849fd1eb
 *
 * ViewAdapter目前来将适合做一些固定的界面展示
 *
 */
public class ViewAdapterActivity extends AppCompatActivity {

    private ViewPagerItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //第二种适配器-ViewAdapter
        adapter = new ViewPagerItemAdapter(ViewPagerItems.with(this)
                .add("标签1", R.layout.view_adpater_layout)
                .add(ViewPagerItem.of("标签2", R.layout.view_adpater_layout2))
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
                Toast.makeText(ViewAdapterActivity.this, "current item's position is "+ position, Toast.LENGTH_SHORT).show();

                View fragmentRootView = adapter.getPage(position);
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
