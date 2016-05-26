package com.oc.rss.jeuxde;


import android.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by combo on 25/05/16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private final List<Pair<String, String>> characters = Arrays.asList(
            Pair.create("Lyra Belacqua", "Brave, curious, and crafty, she has benn prophesied by the witxhes to help the balance of life"),
            Pair.create("Pantalaimon", "Lyra's daemon, nicknamed Pan."),
            Pair.create("Roger Pärslon", "Lyra's friend"),
            Pair.create("Lord Asriel", "Lyra's uncle"),
            Pair.create("Marisa Coulter", "Intelligent and beautifull, but extremely ruthless and callous"),
            Pair.create("Iorek Byrnison", "Armoured bear, rightful king of the panserbjorne. Reduced to a slave of the human village Trollesund."),
            Pair.create("Serafina Pekkala", "Witch who cosely follows Lyra on her traveles."),
            Pair.create("Lee Scoresby", "Texan aeronaut who transports Lyra in his balloon. Good friend with Iorek Byrnison."),
            Pair.create("Ma Costa", "Gyptian woman whose son, Billy costa is abducted by the \"Gobblers\"."),
            Pair.create("John Faa", "The king of all gyptian people")
    );

    @Override
    public int getItemCount() {
        return characters.size();
    }

    @Override  // crée la méthode ViewHolder entrée comme paramètre par défaut en haut dans la déclaration de la classe
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_cell, parent, false);
        return new MyViewHolder(view);
    }

    @Override  // Applique une donée à une view
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Pair<String, String> pair = characters.get(position);
        holder.display(pair);
    }

    // classe MyViewHolder
    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView description;

        private Pair<String, String> currentPair;

        // constructeur
        public MyViewHolder(final View itemView) {
            super(itemView);

            name = ((TextView) itemView.findViewById(R.id.name));
            description = ((TextView) itemView.findViewById(R.id.description));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new AlertDialog.Builder(itemView.getContext())
                            .setTitle(currentPair.first)
                            .setMessage(currentPair.second)
                            .show();
                }
            });
        }

        public void display(Pair<String , String > pair) {
            currentPair= pair;
            name.setText(pair.first);
            description.setText(pair.second);
        }
    }
}
