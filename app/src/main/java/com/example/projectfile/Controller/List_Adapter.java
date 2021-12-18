package com.example.projectfile.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectfile.Model.ListVO;
import com.example.projectfile.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class List_Adapter extends BaseAdapter {

//    private TextView number;
//    private TextView business;
//    private TextView location;

    public ArrayList<ListVO> listViewItemList = new ArrayList<ListVO>();

    public List_Adapter(){

    }

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item, parent, false);
        }

        //추가수정시 건들부분
        TextView number = (TextView) convertView.findViewById(R.id.number);
        TextView business = (TextView) convertView.findViewById(R.id.business);
        TextView location = (TextView) convertView.findViewById(R.id.location);

        ListVO listViewItem = listViewItemList.get(position);

        number.setText(listViewItem.getNumber());
        business.setText(listViewItem.getBusiness());
        location.setText(listViewItem.getLocation());

//        LinearLayout cmdArea = convertView.findViewById(R.id.cmdArea);
//        cmdArea.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(v.getContext(), listViewItemList.get(pos).getContent(), Toast.LENGTH_SHORT).show();
//            }
//        });

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    //여기도
    public void addItem(String number, String business, String location){
        ListVO item = new ListVO();

        item.setNumber(number);
        item.setBusiness(business);
        item.setLocation(location);

        listViewItemList.add(item);
    }

}


