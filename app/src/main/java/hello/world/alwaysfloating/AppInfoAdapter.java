package hello.world.alwaysfloating;

import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AppInfoAdapter extends BaseAdapter {

    private List<ApplicationInfo> mInfos;

    public AppInfoAdapter(List<ApplicationInfo> data) {
        mInfos = data;
    }
    @Override
    public int getCount() {
        return mInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return mInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            holder.imageView = (ImageView)convertView.findViewById(R.id.icon_img);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        ApplicationInfo info = mInfos.get(position);
        Drawable icon = info.loadIcon(parent.getContext().getPackageManager());
        holder.imageView.setImageDrawable(icon);

        return convertView;
    }
}
class ViewHolder {
    ImageView imageView;
}