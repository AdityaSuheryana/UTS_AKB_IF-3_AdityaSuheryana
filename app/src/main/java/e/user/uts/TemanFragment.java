package e.user.uts;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import e.user.uts.model.TemanUser;
import e.user.uts.presenter.FormVP;
import e.user.uts.sql.DatabaseAdapter;
import e.user.uts.sql.DatabaseHelper;


/*
    tgl pengerjaan  : 11-Mei-2020
    Nim             : 10117104
    Nama            : Aditya Suheryana
    Kelas           : IF-3 / AKB-3
 */

public class TemanFragment extends Fragment {


    ListView listView;
    private FormVP.Presenter presenter;
    private TextView textView;
    List<TemanUser> itemList = new ArrayList<TemanUser>();
    DatabaseAdapter adapter;
    AlertDialog.Builder dialog;
    DatabaseHelper SQLite = new DatabaseHelper(getActivity());

    public static final String TAG_ID = "id";
    public static final String TAG_NIM = "nim";
    public static final String TAG_NAMA = "nama";
    public static final String TAG_KELAS = "kelas";
    public static final String TAG_TELP = "telp";
    public static final String TAG_EMAIL = "email";
    public static final String TAG_INSTAGRAM = "instagram";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragment_daftarteman = inflater.inflate(R.layout.fragment_daftar_teman, container, false);

        SQLite = new DatabaseHelper(getActivity().getApplicationContext());

        FloatingActionButton floatingActionButton = (FloatingActionButton) fragment_daftarteman.findViewById(R.id.add);
        listView = (ListView) fragment_daftarteman.findViewById(R.id.list_view);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Form.class);
                startActivity(intent);
            }
        });

        adapter = new DatabaseAdapter(getActivity(), itemList);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, View view, final int position, long id) {
                final String idx = itemList.get(position).getId();
                final String nim = itemList.get(position).getNim();
                final String nama = itemList.get(position).getNama();
                final String kelas = itemList.get(position).getKelas();
                final String telp = itemList.get(position).getTelp();
                final String email = itemList.get(position).getEmail();
                final String instagram = itemList.get(position).getInstagram();


                final CharSequence[] dialogitem = {"Edit", "Delete"};
                dialog = new AlertDialog.Builder(getActivity());
                dialog.setCancelable(true);
                dialog.setItems(dialogitem, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                Intent intent = new Intent(getActivity(), Form.class);
                                intent.putExtra(TAG_ID, idx);
                                intent.putExtra(TAG_NIM, nim);
                                intent.putExtra(TAG_NAMA, nama);
                                intent.putExtra(TAG_KELAS, kelas);
                                intent.putExtra(TAG_TELP, telp);
                                intent.putExtra(TAG_EMAIL, email);
                                intent.putExtra(TAG_INSTAGRAM, instagram);
                                startActivity(intent);
                                break;
                            case 1:
                                Toast.makeText(getContext(), nama+" Berhasil di hapus ", Toast.LENGTH_SHORT).show();
                                SQLite.delete(Integer.parseInt(idx));
                                itemList.clear();
                                getAllData();
                                break;
                        }
                    }
                }).show();
                return false;
            }
        });
        getAllData();
        return fragment_daftarteman;
    }

    public void getAllData(){
        ArrayList<HashMap<String, String>> row = SQLite.getAllData();

        for (int i = 0; i < row.size(); i++){
            String id = row.get(i).get(TAG_ID);
            String nim = row.get(i).get(TAG_NIM);
            String nama = row.get(i).get(TAG_NAMA);
            String kelas = row.get(i).get(TAG_KELAS);
            String telp = row.get(i).get(TAG_TELP);
            String email = row.get(i).get(TAG_EMAIL);
            String instagram = row.get(i).get(TAG_INSTAGRAM);

            TemanUser data = new TemanUser();

            data.setId(id);
            data.setNim(nim);
            data.setNama(nama);
            data.setKelas(kelas);
            data.setTelp(telp);
            data.setEmail(email);
            data.setInstagram(instagram);

            itemList.add(data);

        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
        itemList.clear();
        getAllData();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
    }}
