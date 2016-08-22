package token.com.uncollapseissue;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by joemaher on 22/08/16.
 */
public class TokenObjectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final ArrayList<TokenObject> mAdapterData;
    private final TokenSelectedListener mTokenSelectedListener;

    public TokenObjectAdapter(ArrayList<TokenObject> data, TokenSelectedListener listener) {
        mAdapterData = data;
        mTokenSelectedListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return TokenObjectWidget.create(LayoutInflater.from(parent.getContext()), parent, mTokenSelectedListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TokenObjectWidget) holder).bind(mAdapterData.get(position));
    }

    @Override
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        super.onViewRecycled(holder);
        ((TokenObjectWidget) holder).recycle();
    }

    @Override
    public int getItemCount() {
        return mAdapterData.size();
    }

    interface TokenSelectedListener {
        void onTokenSelected(TokenObject tokenObject);
        void onTokenUnselected(TokenObject tokenObject);
    }
}
