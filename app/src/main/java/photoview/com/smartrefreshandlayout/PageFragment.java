package photoview.com.smartrefreshandlayout;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by zhouwei on 2018/8/29.
 */

public class PageFragment extends Fragment {

    private Context mContext;

    //不用通过此方法来传递初始化参数，而是通过.add("标签三",PageFragment.class,new Bundler().putString("content", "x123").get())
//    public static PageFragment getInstance(String content){
//        PageFragment  pageFragment = new PageFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString("content",content);
//        pageFragment.setArguments(bundle);
//        return pageFragment;
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        TextView view = new TextView(mContext);
        view.setTextSize(30);

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        view.setGravity(Gravity.CENTER);
        view.setLayoutParams(layoutParams);

        if (bundle != null) {
            view.setText(bundle.getString("content"));
        }
        return view;
    }
}
