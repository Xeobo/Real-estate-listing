package com.rt_rk.vzbiljic.pkiapp.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rt_rk.vzbiljic.pkiapp.R;
import com.rt_rk.vzbiljic.pkiapp.utils.PropertyDataSource;

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
        return PropertyDataSource.getInstance().getNames().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (LinearLayout)object;

    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(R.layout.swipe,container,false);

        ImageView imageView = (ImageView) v.findViewById(R.id.sliderImage);

        imageView.setImageResource(PropertyDataSource.getInstance().get(position).getImage());

        Log.i("SpinnerPagerAdapter", "instantiateItem");

        container.addView(v);
        return v;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.invalidate();
    }
}
