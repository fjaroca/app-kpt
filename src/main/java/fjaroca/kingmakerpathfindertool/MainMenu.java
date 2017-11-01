package fjaroca.kingmakerpathfindertool;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void turnCalc(View view) {
        Intent intent = new Intent(this, TurnCalc.class);
        startActivity(intent);
    }

    public void reignTool(View view) {
        Intent intent = new Intent(this, ReignTool.class);
        startActivity(intent);
    }

    public void mapTool(View view) {
        Intent intent = new Intent(this, MapTool.class);
        startActivity(intent);
    }

    public void calendar(View view) {
        Intent intent = new Intent(this, Calendar.class);
        startActivity(intent);
    }
}
