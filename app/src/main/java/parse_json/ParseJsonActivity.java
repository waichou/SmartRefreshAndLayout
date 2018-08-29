package parse_json;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.fastjson.gson.utils.utils.GsonUtils;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.Bundler;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import photoview.com.smartrefreshandlayout.PageFragment;
import photoview.com.smartrefreshandlayout.R;

public class ParseJsonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parse_layout);

    }

    public void getElementValueClick(View view) {
        String json = "{\"username\":\"zhangsan\",\"age\":28}";

        String username = GsonUtils.getNoteJsonString(json, "username");
        Toast.makeText(this, "username=" + username, Toast.LENGTH_SHORT).show();
    }
}
