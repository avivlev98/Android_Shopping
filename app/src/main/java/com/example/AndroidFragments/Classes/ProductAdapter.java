package com.example.AndroidFragments.Classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.AndroidFragments.Classes.Product;
import com.example.AndroidFragments.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private List<Product> itemList;

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        public TextView itemName, itemPrice, itemQuantity;
        public Button addButton, removeButton;

        public ProductViewHolder(View view) {
            super(view);
            itemName = view.findViewById(R.id.textViewItemName);
            itemPrice = view.findViewById(R.id.textViewPrice);
            itemQuantity = view.findViewById(R.id.textViewQuantity);
            addButton = view.findViewById(R.id.buttonAdd);
            removeButton = view.findViewById(R.id.buttonRemove);
        }
    }

    public ProductAdapter(List<Product> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductViewHolder holder, int position) {
        final Product item = itemList.get(position);
        holder.itemName.setText(item.getName());
        holder.itemPrice.setText("Price: $" + String.format("%.2f", item.getPrice()));
        holder.itemQuantity.setText("Quantity: " + item.getQuantity());

        holder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement add functionality
                int quantity = item.getQuantity();
                quantity++;
                item.setQuantity(quantity);
                holder.itemQuantity.setText("Quantity: " + quantity);
            }
        });

        holder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement remove functionality
                int quantity = item.getQuantity();
                if (quantity > 0) {
                    quantity--;
                    item.setQuantity(quantity);
                    holder.itemQuantity.setText("Quantity: " + quantity);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
