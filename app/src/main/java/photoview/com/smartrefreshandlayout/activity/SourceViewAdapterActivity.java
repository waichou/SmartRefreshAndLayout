package photoview.com.smartrefreshandlayout.activity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.ViewPagerItem;
import com.ogaclejapan.smarttablayout.utils.ViewPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.ViewPagerItems;

import java.util.ArrayList;
import java.util.List;

import photoview.com.smartrefreshandlayout.CusPagerAdapter;
import photoview.com.smartrefreshandlayout.R;

/**
 * 参考：https://www.jianshu.com/p/1fef849fd1eb
 *
 * ViewAdapter目前来将适合做一些固定的界面展示
 *
 */
public class SourceViewAdapterActivity extends AppCompatActivity {

    private CusPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //第二种适配器-ViewAdapter
        List<ImageView> list = new ArrayList<>();
        int[] imgId  = {R.drawable.z1,R.drawable.z2,R.drawable.z3};
        for (int i = 0; i <imgId.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageBitmap(BitmapFactory.decodeResource(getResources(),imgId[i]));
            list.add(imageView);
        }

        String[] titleList = new String[]{"标签a","标签b","标签C"};
        adapter = new CusPagerAdapter(list,titleList);

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
                Toast.makeText(SourceViewAdapterActivity.this, "current item's position is "+ position, Toast.LENGTH_SHORT).show();

//                View fragmentRootView = adapter.getPage(position);
//                if (fragmentRootView instanceof TextView){
//                    TextView tv = (TextView) fragmentRootView;
//                    System.out.println("获取child fragment rootview content is " + tv.getText().toString());
//                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
