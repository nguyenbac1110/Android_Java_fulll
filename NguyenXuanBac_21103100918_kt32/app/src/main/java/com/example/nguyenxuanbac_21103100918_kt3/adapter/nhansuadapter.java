package com.example.nguyenxuanbac_21103100918_kt3.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nguyenxuanbac_21103100918_kt3.R;
import com.example.nguyenxuanbac_21103100918_kt3.dao.nhansudao;
import com.example.nguyenxuanbac_21103100918_kt3.model.nhansu;

import java.util.ArrayList;

public class nhansuadapter extends RecyclerView.Adapter<nhansuadapter.viewholder>{
    private final Context context;
    private final ArrayList<nhansu> list;
    nhansu sv;
    nhansudao nsdao;

    public nhansuadapter(Context context, ArrayList<nhansu> list) {
        this.context = context;
        this.list = list;
        nsdao = new nhansudao(context);
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ns, null);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        sv = list.get(position);
        holder.txtma.setText("Mã: " + list.get(position).getMans_0918());
        holder.txtten.setText("Tên: "+list.get(position).getHoten_0918());
        holder.txttuoi.setText("Luong: "+list.get(position).getLuong_0918());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView txtma,txtten,txttuoi;
        CardView crdns;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            txtma = itemView.findViewById(R.id.txtma);
            txtten = itemView.findViewById(R.id.txtten);
            txttuoi = itemView.findViewById(R.id.txttuoi);
            crdns = itemView.findViewById(R.id.crdns);
//            crdns.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View view) {
//                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
//                    builder.setMessage("Bạn có chắc chắn muốn xóa nhân sự này?");
//                    builder.setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            if (nsdao.delete(sv.getManv_0918())) {
//                                list.clear();
//                                list.addAll(nsdao.selectAll());
//                                notifyDataSetChanged();
//                                Toast.makeText(context, "Đã xóa", Toast.LENGTH_SHORT).show();
//                            } else {
//                                Toast.makeText(context, "xóa fail", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
//                    builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                        }
//                    });
//                    builder.show();
//
//                    return true;
//                }
  //          });
        }
    }
}
