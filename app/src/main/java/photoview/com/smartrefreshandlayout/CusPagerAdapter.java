package photoview.com.smartrefreshandlayout;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouwei on 2018/8/30.
 */

public class CusPagerAdapter extends PagerAdapter {

    private List<ImageView> images = null;
    private String[] titleList = null;

    public CusPagerAdapter(List<ImageView> listImageList,String[] title){
        if (listImageList == null){
            listImageList = new ArrayList<>();
        }
        this.images = listImageList;
        this.titleList = title;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (titleList == null || titleList.length == 0){
            return "";
        }
        return titleList[position];
    }

    // 获取要滑动的控件的数量，在这里我们以滑动的广告栏为例，那么这里就应该是展示的广告图片的ImageView数量
    @Override
    public int getCount() {
        return images.size();
    }

    // 来判断显示的是否是同一张图片，这里我们将两个参数相比较返回即可
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    // PagerAdapter只缓存三张要显示的图片，如果滑动的图片超出了缓存的范围，就会调用这个方法，将图片销毁
    @Override
    public void destroyItem(ViewGroup view, int position, Object object) {
        view.removeView(images.get(position));
    }

    // 当要显示的图片可以进行缓存的时候，会调用这个方法进行显示图片的初始化，我们将要显示的ImageView加入到ViewGroup中，然后作为返回值返回即可
    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        view.addView(images.get(position));
        return images.get(position);
    }

}
