package com.example.projectfile.Controller;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.example.projectfile.Model.Pole_infoVO;
import com.example.projectfile.R;
import com.example.projectfile.View.Pole_detail;
/*import com.example.projectfile.View.MainActivity;*/

import java.util.ArrayList;
import java.util.List;

public class SearchableAdapter extends BaseAdapter implements Filterable {

    private List<Pole_infoVO>originalData = null;
    private List<Pole_infoVO>filteredData = null;
    private LayoutInflater mInflater;
    private ItemFilter mFilter = new ItemFilter();
    private TextView tv_pole_code_L, tv_pole_office_L, tv_pole_addr_L, tv_transformer_yn_L, tv_pole_com_L
            ,tv_pole_high_L, tv_pole_down_L ,tv_pole_level_L;

    // 웹통신에 필요한 3가지
    // Server로 요청하는 객체
    private RequestQueue queue;
    // Server로 요청시 필요한 정보를 담는 객체
    private StringRequest stringRequest;
    // client를 판별하는 값
    private String TAG = "main";

    public SearchableAdapter(Context context, List<Pole_infoVO> data) {
        this.filteredData = data ;
        this.originalData = data ;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return filteredData.size();
    }

    public Object getItem(int position) {
        return filteredData.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        /*// A ViewHolder keeps references to children views to avoid unnecessary calls
        // to findViewById() on each row.
        ViewHolder holder;

        // When convertView is not null, we can reuse it directly, there is no need
        // to reinflate it. We only inflate a new View when the convertView supplied
        // by ListView is null.
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null);

            // Creates a ViewHolder and store references to the two children views
            // we want to bind data to.
            holder = new ViewHolder();
            holder.text = convertView.findViewById(R.id.pole_listview);

            // Bind the data efficiently with the holder.

            convertView.setTag(holder);
        } else {
            // Get the ViewHolder back to get fast access to the TextView
            // and the ImageView.
            holder = (ViewHolder) convertView.getTag();
        }

        // If weren't re-ordering this you could rely on what you set last time
        holder.text.setText((CharSequence) filteredData.get(position));*/
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.pole_info_list, parent, false);
        }

        tv_pole_code_L = convertView.findViewById(R.id.tv_pole_code_L);
        tv_pole_office_L = convertView.findViewById(R.id.tv_pole_office_L);
        tv_pole_addr_L = convertView.findViewById(R.id.tv_pole_addr_L);
        tv_transformer_yn_L = convertView.findViewById(R.id.tv_transformer_yn_L);
        tv_pole_com_L = convertView.findViewById(R.id.tv_pole_com_L);
        tv_pole_high_L = convertView.findViewById(R.id.tv_pole_high_L);
        tv_pole_down_L = convertView.findViewById(R.id.tv_pole_down_L);
        tv_pole_level_L = convertView.findViewById(R.id.tv_pole_level_L);


        //pole_infoVO listViewItem = originalData.get(position);
        Pole_infoVO listViewItem = filteredData.get(position);

        tv_pole_code_L.setText(listViewItem.getPole_code());
        tv_pole_office_L.setText(listViewItem.getPole_office());
        tv_pole_addr_L.setText(listViewItem.getPole_addr());
        tv_transformer_yn_L.setText(listViewItem.getTransformer_yn());
        tv_pole_com_L.setText(listViewItem.getPole_com());
        tv_pole_high_L.setText(listViewItem.getPole_high());
        tv_pole_down_L.setText(listViewItem.getPole_down());
        tv_pole_level_L.setText(listViewItem.getPole_level());


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Context context = parent.getContext();

                Intent intent = new Intent(context, Pole_detail.class);

                intent.putExtra("pole_code",filteredData.get(position).getPole_code());
                intent.putExtra("pole_height",filteredData.get(position).getPole_height());
                intent.putExtra("pole_addr",filteredData.get(position).getPole_addr());
                intent.putExtra("pole_date",filteredData.get(position).getPole_date());
                intent.putExtra("emp_id",filteredData.get(position).getEmp_id());
                intent.putExtra("transformer_yn",filteredData.get(position).getTransformer_yn());
                intent.putExtra("pole_com",filteredData.get(position).getPole_com());
                intent.putExtra("pole_high",filteredData.get(position).getPole_high());
                intent.putExtra("pole_down",filteredData.get(position).getPole_down());
                intent.putExtra("pole_comment",filteredData.get(position).getPole_comment());
                intent.putExtra("pole_eday",filteredData.get(position).getPole_eday());
                intent.putExtra("pole_level",filteredData.get(position).getPole_level());
                intent.putExtra("pole_office",filteredData.get(position).getPole_office());
                context.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));




                Log.d("TAG", "onClick: " + filteredData.get(position));


            }
        });

        return convertView;
    }



    static class ViewHolder {
        TextView text;
    }

    public Filter getFilter() {
        return mFilter;
    }

    private class ItemFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            String filterString = constraint.toString().toLowerCase();

            FilterResults results = new FilterResults();

            final List<Pole_infoVO> list = originalData;

            int count = list.size();
            final ArrayList<Pole_infoVO> list1 = new ArrayList<Pole_infoVO>(count);

            Pole_infoVO filterableVO ;

            for (int i = 0; i < count; i++) {
                filterableVO = list.get(i);
                if (filterableVO.getPole_code().contains(filterString)) {
                    list1.add(filterableVO);
                }
            }

            results.values = list1;
            results.count = list1.size();

            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredData = (ArrayList<Pole_infoVO>) results.values;
            notifyDataSetChanged();
        }

    }
    public void addItem(String pole_code, String mac_code, String pole_height, String pole_addr, String pole_date, String emp_id, String transformer_yn, String pole_com, String pole_high, String pole_down, String pole_comment, String pole_eday, String pole_level, String pole_office) {
        Pole_infoVO item = new Pole_infoVO();

        item.setPole_code(pole_code);
        item.setPole_office(pole_office);
        item.setPole_addr(pole_addr);
        item.setPole_height(pole_height);
        item.setPole_date(pole_date);
        item.setEmp_id(emp_id);
        item.setTransformer_yn(transformer_yn);
        item.setPole_com(pole_com);
        item.setPole_high(pole_high);
        item.setPole_down(pole_down);
        item.setPole_comment(pole_comment);
        item.setPole_eday(pole_eday);
        item.setPole_level(pole_level);



        originalData.add(item);
    }
    public void addItem(Pole_infoVO vo) {
  /*      Pole_infoVO item = new Pole_infoVO();

        item.setPole_code(vo.getPole_code());
        item.setPole_office(vo.getPole_office());
        item.setPole_addr(vo.getPole_addr());*/

        originalData.add(vo);
    }
}
