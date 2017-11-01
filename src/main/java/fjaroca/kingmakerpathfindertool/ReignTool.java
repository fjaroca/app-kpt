package fjaroca.kingmakerpathfindertool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ReignTool extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reign_tool);
    }

    public void newReign(View view) {
        Intent intent = new Intent(this, NewReign.class);
        startActivity(intent);
    }

    public void modifyReign(View view) {
        Intent intent = new Intent(this, ModifyReign.class);
        startActivity(intent);
    }
}
