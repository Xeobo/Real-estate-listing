package com.rt_rk.vzbiljic.pkiapp.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.rt_rk.vzbiljic.pkiapp.R;
import com.rt_rk.vzbiljic.pkiapp.datasource.PropertyDataSource;

/**
 * Created by vzbiljic on 8.3.17..
 */

public class SpinerPagerAdapter extends PagerAdapter {
    private LayoutInflater inflater;
    private Context ctx;


    public  SpinerPagerAdapter(Context ctx){
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return PropertyDataSource.getInstance().getDescription().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;

    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(R.layout.swipe,container,false);

        ImageView imageView = (ImageView) v.findViewById(R.id.sliderImage);

        imageView.setImageResource(PropertyDataSource.getInstance().get(position).getImage());

        container.addView(v);
        return v;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.invalidate();
    }
}
