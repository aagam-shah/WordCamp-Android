package org.wordcamp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import org.wordcamp.adapters.NotificationAdapter;
import org.wordcamp.db.DBCommunicator;
import org.wordcamp.objects.Notif;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aagam on 14/4/15.
 */
public class NotificationFragment extends Fragment {

    public BaseActivity baseActivity;

    public List<Notif> list;

    public ListView notifList;

    public NotificationAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseActivity = (BaseActivity) getActivity();
        if(baseActivity.communicator==null){
            baseActivity.communicator = new DBCommunicator(baseActivity);
            baseActivity.communicator.start();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_navdrawer, container);
        notifList = (ListView) v.findViewById(R.id.notifList);
        list = baseActivity.communicator.getAllNotifs();
        notifList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("item", "click" + position);
            }
        });

        adapter = new NotificationAdapter(getActivity(), list);
        notifList.setAdapter(adapter);
        return v;
    }
}
