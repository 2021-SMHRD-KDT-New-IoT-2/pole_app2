/*
package com.example.projectfile.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.projectfile.Model.Pole_infoVO;
import com.example.projectfile.R;

import java.util.ArrayList;

public class Pole_Adapter extends BaseAdapter {

    // 리스트뷰에 넣어줄 데이터를 보관하는 변수
    private ArrayList<Pole_infoVO> items = new ArrayList<Pole_infoVO>();

    // ArrayList에 데이터를 저장하는 메소드
    public void addItem(String pole_code, String pole_office, String pole_addr){
        Pole_infoVO item = new Pole_infoVO(pole_code, pole_office, pole_addr);
        items.add(item);
    };

    //현재 어댑터 안의 데이터 개수를 알아내는 메소드
    @Override
    public int getCount() {return items.size(); }

    //요청한 위치의 데이터를 돌려주는 메소드
    @Override
    public Object getItem(int position) {return items.get(position); }

    //해당 데이터의 아이디 값을 돌려주는 메소드(거의 사용안함)
    @Override
    public long getItemId(int position) {return position;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 현재 어플에대한 화면정보 가져오기
        Context context = parent.getContext();
        // view에다가 (listview) 우리가 만든 xml을 적용시키기
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.pole_info_list,parent,false);
        }

        TextView tv_pole_code = convertView.findViewById(R.id.tv_pole_code_L);
        TextView tv_pole_office = convertView.findViewById(R.id.tv_pole_office_L);
        TextView tv_pole_addr = convertView.findViewById(R.id.tv_pole_addr_L);


        Pole_infoVO item = items.get(position);

        tv_pole_code.setText(item.getPole_code());
        tv_pole_office.setText(item.getPole_office());
        tv_pole_addr.setText(item.getPole_addr());


        return convertView;
    }



}
*/
