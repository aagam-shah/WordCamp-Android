package org.wordcamp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.wordcamp.R;
import org.wordcamp.objects.Notif;

import java.util.List;

/**
 * Created by aagam on 14/4/15.
 */
public class NotificationAdapter extends BaseAdapter {

    private List<Notif> notifs;
    private Context ctx;
    private LayoutInflater inflater;

    public NotificationAdapter(Context ctx, List<Notif> notifs){
        this.ctx = ctx;
        this.notifs = notifs;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return notifs.size();
    }

    @Override
    public Object getItem(int position) {
        return notifs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = inflater.inflate(R.layout.item_notification,parent,false);
        }

        TextView title = (TextView) convertView.findViewById(R.id.title);
        title.setText(notifs.get(position).getTitle());
        return convertView;
    }
}
