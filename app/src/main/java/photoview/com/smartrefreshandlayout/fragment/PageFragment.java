package photoview.com.smartrefreshandlayout.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;

/**
 * Created by zhouwei on 2018/8/29.
 */

public class PageFragment extends Fragment implements View.OnClickListener{

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
        view.setClickable(true);
        view.setOnClickListener(this);

        if (bundle != null) {
            if (!TextUtils.isEmpty(bundle.getString("content")))
                view.setText(bundle.getString("content"));
            else
                view.setText("Text Content is " + FragmentPagerItem.getPosition(getArguments()));
        }
        return view;
    }

    @Override
    public void onClick(View v) {
        //注意：可在fragment内部获取到当前fragment的下标位置
        int position = FragmentPagerItem.getPosition(getArguments());
        Toast.makeText(mContext, "获取到当前Fragment的位置：" + position, Toast.LENGTH_SHORT).show();
    }
}
