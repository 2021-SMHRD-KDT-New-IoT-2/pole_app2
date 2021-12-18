//package com.example.projectfile.Controller;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.TextView;
//
//import com.example.projectfile.Model.List2VO;
//import com.example.projectfile.Model.ListVO;
//import com.example.projectfile.R;
//
//import java.util.ArrayList;
//
//public class List2_Adapter extends BaseAdapter {
//    public ArrayList<List2VO> listViewItemList = new ArrayList<List2VO>();
//
//    public List2_Adapter(){
//
//    }
//
//    @Override
//    public int getCount() {
//        return listViewItemList.size();
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        final int pos = position;
//        final Context context = parent.getContext();
//
//        if(convertView==null){
//            LayoutInflater inflater = (LayoutInflater)
//                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = inflater.inflate(R.layout.item, parent, false);
//        }
//
//        //추가수정시 건들부분
//        TextView id = (TextView) convertView.findViewById(R.id.id);
//        TextView location = (TextView) convertView.findViewById(R.id.location);
//        TextView transformers = (TextView) convertView.findViewById(R.id.transformers);
//        TextView manager = (TextView) convertView.findViewById(R.id.manager);
//
//        List2VO listViewItem = listViewItemList.get(position);
//
//        id.setText(listViewItem.getId());
//        location.setText(listViewItem.getLocation());
//        transformers.setText(listViewItem.getTransformers());
//        manager.setText(listViewItem.getManager());
//
////        LinearLayout cmdArea = convertView.findViewById(R.id.cmdArea);
////        cmdArea.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Toast.makeText(v.getContext(), listViewItemList.get(pos).getContent(), Toast.LENGTH_SHORT).show();
////            }
////        });
//
//        return convertView;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return listViewItemList.get(position);
//    }
//
//    //여기도
//    public void addItem(String id, String location, String transformers, String manager){
//        List2VO item = new List2VO();
//
//        item.setId(id);
//        item.setLocation(location);
//        item.setTransformers(transformers);
//        item.setManager(manager);
//
//        listViewItemList.add(item);
//    }
//
//}
