package token.com.uncollapseissue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.security.SecureRandom;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TokenObjectAdapter.TokenSelectedListener {

    private TokenView mTokenView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTokenView = (TokenView) findViewById(R.id.token_view);
        TokenObjectAdapter adapter = new TokenObjectAdapter(generateData(), this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        findViewById(R.id.recycler_view).requestFocus();
    }

    private ArrayList<TokenObject> generateData(){

        ArrayList<TokenObject> data = new ArrayList<>();

        for (int i = 0; i < 20; i++){
            data.add(new TokenObject(generateRandomString()));
        }

        return data;
    }

    private String generateRandomString(){

        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(20);

        for( int i = 0; i < 10; i++ ){
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        }

        return sb.toString();
    }

    @Override
    public void onTokenSelected(TokenObject tokenObject) {
        mTokenView.addObject(tokenObject);
    }

    @Override
    public void onTokenUnselected(TokenObject tokenObject) {
        mTokenView.removeObject(tokenObject);
    }
}
