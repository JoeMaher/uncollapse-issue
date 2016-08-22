package token.com.uncollapseissue;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

/**
 * Created by joemaher on 22/08/16.
 */
public class TokenObjectWidget extends RecyclerView.ViewHolder {

    private final TextView mTextView;
    private final TokenObjectAdapter.TokenSelectedListener mTokenSelectedListener;
    private final CheckBox mCheckbox;

    public TokenObjectWidget(View itemView, TokenObjectAdapter.TokenSelectedListener listener) {
        super(itemView);
        mTextView = (TextView) itemView.findViewById(R.id.text);
        mCheckbox = (CheckBox) itemView.findViewById(R.id.checkbox);
        mTokenSelectedListener = listener;
    }

    public static TokenObjectWidget create(LayoutInflater inflater, ViewGroup parent, TokenObjectAdapter.TokenSelectedListener listener){
        return new TokenObjectWidget(inflater.inflate(R.layout.widget_token, parent, false), listener);
    }

    public void bind(final TokenObject tokenObject){

        if (mTextView != null){
            mTextView.setText(tokenObject.getText());
        }

        if (mCheckbox != null){
            mCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    if (isChecked){
                        mTokenSelectedListener.onTokenSelected(tokenObject);
                    } else {
                        mTokenSelectedListener.onTokenUnselected(tokenObject);
                    }
                }
            });
        }
    }

    public void recycle(){

        if (mTextView != null){
            mTextView.setText("");
        }

        if (mCheckbox != null){
            mCheckbox.setOnCheckedChangeListener(null);
        }
    }
}
