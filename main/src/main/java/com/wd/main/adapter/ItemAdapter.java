package com.wd.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.wd.main.R;
import com.wd.main.R2;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author:周盟棋
 * Description:
 */
public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final int typeone = 0;
    final int typetwo = 1;

    Context context;


    public ItemAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;
        switch (getItemViewType(i)) {
            case typeone:
                view = LayoutInflater.from(context).inflate(R.layout.inquiry_item, null);
                return new InquiryViewHolder(view);
            case typetwo:
                view = LayoutInflater.from(context).inflate(R.layout.answer_questions_item, null);
                return new AnswerQuestions(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (getItemViewType(i)) {
            case typeone:
                final InquiryViewHolder viewHolder1 = (InquiryViewHolder) viewHolder;
                break;
            case typetwo:
                final AnswerQuestions viewHolder2 = (AnswerQuestions) viewHolder;
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return typeone;
        } else {
            return typetwo;
        }
    }


    @Override
    public int getItemCount() {
        return 2;
    }

    class InquiryViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.inquiry_rl)
        RelativeLayout inquiryRl;

        public InquiryViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class AnswerQuestions extends RecyclerView.ViewHolder {

        @BindView(R2.id.answer_questions_rl)
        RelativeLayout answerQuestionsRl;
        public AnswerQuestions(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
