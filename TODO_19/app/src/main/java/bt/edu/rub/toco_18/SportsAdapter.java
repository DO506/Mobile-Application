package bt.edu.rub.toco_18;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.ViewHolder> {
    private ArrayList<Sports> mSportsData;
    private Context mContext;


    SportsAdapter(Context context,ArrayList<Sports> SportsData){
        this.mSportsData = SportsData;
        this.mContext = context;
    }

    @NonNull
    @Override
    public SportsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SportsAdapter.ViewHolder holder, int position) {
        Sports currentSport =mSportsData.get(position);
        holder.bindTo(currentSport);
    }

    @Override
    public int getItemCount() {
        return mSportsData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageButton mSportImage;

        public ViewHolder( View itemView) {
            super(itemView);

            mTitleText = (TextView)itemView.findViewById(R.id.Title);
            mInfoText = (TextView)itemView.findViewById(R.id.subTitle);
            mSportImage = (ImageButton)itemView.findViewById(R.id.sportsImage);
            //itemView.setOnClickListener(this);

        }
        void bindTo(Sports currentSport){
            mTitleText.setText(currentSport.getTitle());
            mInfoText.setText(currentSport.getInfo());
            Glide.with(mContext).load(currentSport.getImageResources()).into(mSportImage);
        }
    }
}
