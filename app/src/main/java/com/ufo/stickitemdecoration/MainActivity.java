package com.ufo.stickitemdecoration;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ufo.dwstickdecoration.DWStickItemDecoration;

import java.util.ArrayList;
import java.util.List;
/**
 * 日期:2018/3/14 
 * 
 * 作者:xudiwei
 * 
 * 描述:
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        final List<DataBean> mList = getList();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Adapter adapter = new Adapter(this, mList);

        DWStickItemDecoration decoration = new DWStickItemDecoration(this) {
            @Override
            protected boolean isShowItemLabel(int position) {
                return mList.get(position).isShowLable();
            }

            @Override
            protected String getItemLabelStr(int position) {
                return mList.get(position).getSpell();
            }
        };

        //设置标签颜色
//        decoration.setLabelColor(Color.DKGRAY);
        //设置标签高度
//        decoration.setLabelHeight(30);
        //设置标签字体颜色
//        decoration.setTextColor(Color.RED);
        //设置标签字体大小
//        decoration.setTextSize(50);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setAdapter(adapter);

    }

    private List<DataBean> getList() {
        List<DataBean> list = new ArrayList<>();
        list.add(new DataBean("阿狗", true, "A"));
        list.add(new DataBean("安智", false, "A"));
        list.add(new DataBean("爱", false, "A"));
        list.add(new DataBean("操", true, "C"));
        list.add(new DataBean("成成", false, "C"));
        list.add(new DataBean("陈百", false, "C"));
        list.add(new DataBean("陈百2", false, "C"));
        list.add(new DataBean("陈百3", false, "C"));
        list.add(new DataBean("陈百34", false, "C"));
        list.add(new DataBean("陈百345", false, "C"));
        list.add(new DataBean("家家", true, "J"));
        list.add(new DataBean("叫叫", false, "J"));
        list.add(new DataBean("杰杰", false, "J"));
        list.add(new DataBean("杰杰1", false, "J"));
        list.add(new DataBean("杰杰2", false, "J"));
        list.add(new DataBean("杰杰3", false, "J"));
        list.add(new DataBean("杰杰4", false, "J"));
        list.add(new DataBean("科", true, "K"));
        list.add(new DataBean("开门", false, "K"));
        list.add(new DataBean("阿凯", false, "K"));
        list.add(new DataBean("烟", true, "Y"));
        list.add(new DataBean("烟1", false, "Y"));
        list.add(new DataBean("烟2", false, "Y"));
        list.add(new DataBean("烟3", false, "Y"));
        list.add(new DataBean("烟4", false, "Y"));
        list.add(new DataBean("造4", true, "Z"));
        list.add(new DataBean("智4", false, "Z"));
        return list;

    }


}
