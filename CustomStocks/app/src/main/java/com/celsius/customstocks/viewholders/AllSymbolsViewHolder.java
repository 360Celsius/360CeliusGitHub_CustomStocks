package com.celsius.customstocks.viewholders;




import android.view.View;
import android.widget.TextView;

import com.celsius.customstocks.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AllSymbolsViewHolder extends RecyclerView.ViewHolder {

    public TextView symbol;
    public TextView symbolName;
    public TextView symbolType;


    public AllSymbolsViewHolder(@NonNull View itemView) {
        super(itemView);
        symbol = (TextView) itemView.findViewById(R.id.symbol);
        symbolName = (TextView) itemView.findViewById(R.id.symbol_name);
        symbolType = (TextView) itemView.findViewById(R.id.symbol_type);
    }
}
