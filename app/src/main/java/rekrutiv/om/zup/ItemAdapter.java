package rekrutiv.om.zup;

import android.content.Context;

import android.graphics.drawable.LayerDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import java.util.ArrayList;



public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ExampleViewHolder> {
    private Context mContext;
    private ArrayList<Item> mList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public ItemAdapter(Context context, ArrayList<Item> exampleList) {
        mContext = context;
        mList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        Item currentItem = mList.get(position);


        String Client_name = currentItem.getClient_name();
        String  Id= currentItem.getId();
        String Client_reaction = currentItem.getClient_reaction();
        String Date = currentItem.getDate();
        //String Client_contacts=currentItem.getClient_contacts();
        LayerDrawable stars = (LayerDrawable) holder.mrateBar.getProgressDrawable();


        holder.mId.setText(String.valueOf(Id));
        holder.mName.setText(Client_name);

        holder.mDate.setText(Date);
        if(Client_reaction.equals("recall")){
            holder.mrateBar.setRating(1);
            }
        if(Client_reaction.equals("warm")){
            holder.mrateBar.setRating(2);

        }
        if(Client_reaction.equals("interested")){
            holder.mrateBar.setRating(3);

        }


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView mId;
        public RatingBar mrateBar;
        public TextView mDate;
        public TextView mName;
       // public TextView  mContacts;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            mId = itemView.findViewById(R.id.text_view_id);
            mrateBar = itemView.findViewById(R.id.rateBar);
            mDate = itemView.findViewById(R.id.text_view_data);
            mName= itemView.findViewById(R.id.text_view_name);
           //mContacts=itemView.findViewById(R.id.tv_client_contacts);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}