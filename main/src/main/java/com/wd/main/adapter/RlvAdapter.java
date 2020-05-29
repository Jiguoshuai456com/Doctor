package com.wd.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.main.CeActivity;
import com.wd.main.R;
import com.wd.main.R2;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author:周盟棋
 * Description:
 */
public class RlvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final int typeone = 0;
    final int typetwo = 1;

    Context context;

    public RlvAdapter(CeActivity context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = null;
        switch (getItemViewType(i)) {

            case typeone:
                view = LayoutInflater.from(context).inflate(R.layout.primary_service, null);
                return new PrimaryServiceViewHolder(view);
            case typetwo:
                view = LayoutInflater.from(context).inflate(R.layout.my_information, null);
                return new MyInformationViewHolder(view);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == typeone) {
            return typeone;
        } else {
            return typetwo;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (getItemViewType(i)){
            case typeone:

                final PrimaryServiceViewHolder viewHolder1 = (PrimaryServiceViewHolder) viewHolder;
                final RecyclerView primaryServiceRlv = viewHolder1.primaryServiceRlv;
                primaryServiceRlv.setLayoutManager(new LinearLayoutManager(context));
                viewHolder1.primaryServiceRlv.setAdapter(new ItemAdapter(context));
                break;
            case typetwo:
                final MyInformationViewHolder viewHolder2 = (MyInformationViewHolder) viewHolder;
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class PrimaryServiceViewHolder extends RecyclerView.ViewHolder {

        @BindView(R2.id.primary_service_rlv)
        RecyclerView primaryServiceRlv;

        public PrimaryServiceViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class MyInformationViewHolder extends RecyclerView.ViewHolder {

        @BindView(R2.id.my_information_iv)
        SimpleDraweeView myInformationIv;
        @BindView(R2.id.my_information_name)
        TextView myInformationName;
        @BindView(R2.id.my_information_hospital)
        TextView myInformationHospital;
        @BindView(R2.id.my_information_doctor)
        TextView myInformationDoctor;
        @BindView(R2.id.my_information_branch)
        TextView myInformationBranch;
        @BindView(R2.id.my_information_rl)
        RelativeLayout myInformationRl;

        public MyInformationViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
