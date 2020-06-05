package com.musicplayce.poker.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.musicplayce.poker.R;
import com.musicplayce.poker.model.Card;

public class CardViewHolder extends RecyclerView.ViewHolder {

    private TextView tvValue;
    private ImageView ivSuit;

    public CardViewHolder(@NonNull View itemView) {
        super(itemView);

        tvValue = itemView.findViewById(R.id.tv_value);
        ivSuit = itemView.findViewById(R.id.iv_suit);
    }

    public void setCard(Context context, Card card) {
        switch (card.getSuit()) {
            case CLUBS:
                ivSuit.setImageDrawable(context.getDrawable(R.drawable.ic_clubs));
                break;

            case DIAMONDS:
                ivSuit.setImageDrawable(context.getDrawable(R.drawable.ic_diamonds));
                break;

            case HEARTS:
                ivSuit.setImageDrawable(context.getDrawable(R.drawable.ic_hearts));
                break;

            case SPADES:
                ivSuit.setImageDrawable(context.getDrawable(R.drawable.ic_spades));
                break;
        }

        tvValue.setText(card.getValue().getText());
    }
}
