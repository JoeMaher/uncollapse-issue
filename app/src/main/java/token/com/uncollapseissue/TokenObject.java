package token.com.uncollapseissue;

/**
 * Created by joemaher on 22/08/16.
 */
public class TokenObject {

    private String mText;

    public TokenObject(String text) {
        mText = text;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }
}
