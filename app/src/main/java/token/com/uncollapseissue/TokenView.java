package token.com.uncollapseissue;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tokenautocomplete.TokenCompleteTextView;

/**
 * Created by joemaher on 22/08/16.
 */
public class TokenView extends TokenCompleteTextView<TokenObject> {

    public TokenView(Context context) {
        super(context);
    }

    public TokenView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TokenView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected View getViewForObject(TokenObject object) {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        TextView view = (TextView) layoutInflater.inflate(R.layout.view_token, (ViewGroup) getParent(), false);
        view.setText(object.getText());

        return view;
    }

    @Override
    protected TokenObject defaultObject(String completionText) {
        return new TokenObject("Default");
    }
}
