package e.user.uts.sql;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import e.user.uts.R;
import e.user.uts.model.TemanUser;

/*
    tgl pengerjaan  : 11-Mei-2020
    Nim             : 10117104
    Nama            : Aditya Suheryana
    Kelas           : IF-3 / AKB-3
 */

public class DatabaseAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<TemanUser> items;

    public DatabaseAdapter(Activity activity, List<TemanUser> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);

        TextView id = (TextView) convertView.findViewById(R.id.id);
        TextView nim = (TextView) convertView.findViewById(R.id.nim);
        TextView nama = (TextView) convertView.findViewById(R.id.nama);
        TextView kelas = (TextView) convertView.findViewById(R.id.kelas);
        TextView telp = (TextView) convertView.findViewById(R.id.telp);
        TextView email = (TextView) convertView.findViewById(R.id.email);
        TextView instagram = (TextView) convertView.findViewById(R.id.instagram);

        TemanUser data = items.get(position);

        id.setText(data.getId());
        nim.setText(data.getNim());
        nama.setText(data.getNama());
        kelas.setText(data.getKelas());
        telp.setText(data.getTelp());
        email.setText(data.getEmail());
        instagram.setText(data.getInstagram());

        return convertView;
    }
}