package fjaroca.kingmakerpathfindertool;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class NewReign extends AppCompatActivity {

    private static final int ALIGNMENT_BASE_BONUS = 2;
    private static final int INITIAL_TREASURY = 50;
    private static final int INITIAL_UNREST = 0;
    private static final int INITIAL_SPECIAL_RESOURCES = 0;

    Integer stabilityValue = 0;
    Integer economyValue = 0;
    Integer loyaltyValue = 0;

    private EditText reignName, campaignName;
    private SeekBar sizeReign;
    private TextView sizeReignNumber, controlDC, population, stabilityNumber,
            economyNumber, loyaltyNumber, unrestNumber, consumption, treasury,
            specialResourcesNumber;
    private Spinner alignmentReign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_reign);

        reignName = (EditText) findViewById(R.id.reignName);
        campaignName = (EditText) findViewById(R.id.campaignName);
        sizeReign = (SeekBar) findViewById(R.id.sizeReign);
        sizeReignNumber = (TextView) findViewById(R.id.sizeReignNumber);
        controlDC = (TextView) findViewById(R.id.controlDC);
        population = (TextView) findViewById(R.id.population);
        stabilityNumber = (TextView) findViewById(R.id.stabilityNumber);
        economyNumber = (TextView) findViewById(R.id.economyNumber);
        loyaltyNumber = (TextView) findViewById(R.id.loyaltyNumber);
        unrestNumber = (TextView) findViewById(R.id.unrestNumber);
        consumption = (TextView) findViewById(R.id.consumption);
        treasury = (TextView) findViewById(R.id.treasury);
        specialResourcesNumber = (TextView) findViewById(R.id.specialResourcesNumber);
        alignmentReign = (Spinner) findViewById(R.id.alignmentReign);

        setUpSpinner(alignmentReign);
        getAlignment(alignmentReign);
        getSeekBar(sizeReign, sizeReignNumber);
        calculateInitialTreasury();
        calculateInitialUnrest();
        calculateInitialSpecialResources();

    }

    public void setUpSpinner(Spinner spinner) {

        Resources res = getResources();
        String[] alignmentReignValues = res.getStringArray(R.array.alignment_reign_values);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.alignment_reign_values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void getAlignment (Spinner spinner) {

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int alignmentID = (int) parent.getItemIdAtPosition(position);
                switch (alignmentID) {
                    case 0 :
                        stabilityValue = 0;
                        economyValue = ALIGNMENT_BASE_BONUS;
                        loyaltyValue = ALIGNMENT_BASE_BONUS;
                        break;
                    case 1 :
                        stabilityValue = ALIGNMENT_BASE_BONUS;
                        economyValue = 0;
                        loyaltyValue = ALIGNMENT_BASE_BONUS;
                        break;
                    case 2 :
                        stabilityValue = 0;
                        economyValue = 0;
                        loyaltyValue = ALIGNMENT_BASE_BONUS*2;
                        break;
                    case 3 :
                        stabilityValue = ALIGNMENT_BASE_BONUS;
                        economyValue = ALIGNMENT_BASE_BONUS;
                        loyaltyValue = 0;
                        break;
                    case 4 :
                        stabilityValue = ALIGNMENT_BASE_BONUS*2;
                        economyValue = 0;
                        loyaltyValue = 0;
                        break;
                    case 5 :
                        stabilityValue = ALIGNMENT_BASE_BONUS;
                        economyValue = 0;
                        loyaltyValue = ALIGNMENT_BASE_BONUS;
                        break;
                    case 6 :
                        stabilityValue = 0;
                        economyValue = ALIGNMENT_BASE_BONUS*2;
                        loyaltyValue = 0;
                        break;
                    case 7 :
                        stabilityValue = ALIGNMENT_BASE_BONUS;
                        economyValue = ALIGNMENT_BASE_BONUS;
                        loyaltyValue = 0;
                        break;
                    case 8 :
                        stabilityValue = 0;
                        economyValue = ALIGNMENT_BASE_BONUS;
                        loyaltyValue = ALIGNMENT_BASE_BONUS;
                        break;
                    default:
                        stabilityValue = 0;
                        economyValue = 0;
                        loyaltyValue = 0;
                        break;
                }
                stabilityNumber.setText(String.valueOf(stabilityValue));
                economyNumber.setText(String.valueOf(economyValue));
                loyaltyNumber.setText(String.valueOf(loyaltyValue));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void getSeekBar(SeekBar seekBar, final TextView textView) {

        final String controlDCText = controlDC.getText().toString();
        final String populationText = population.getText().toString();
        final String consumptionText = consumption.getText().toString();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText(String.valueOf(progress));
                calculateControlDC(controlDCText);
                calculatePopulation(populationText);
                calculateInitialConsumption(sizeReignNumber, consumptionText);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calculateControlDC (String controlDCText) {

        int controlDCSize = Integer.parseInt(sizeReignNumber.getText().toString())+ 20;
        controlDC.setText( controlDCText + " : " + controlDCSize);
    }

    public void calculatePopulation (String populationText) {

        int populationSize = Integer.parseInt(sizeReignNumber.getText().toString())*250;
        population.setText( populationText + " : " + populationSize);
    }

    public void calculateInitialTreasury () {

        treasury.setText(treasury.getText().toString() + " : " + INITIAL_TREASURY + " PC");
    }

    public void calculateInitialUnrest () {

        unrestNumber.setText(String.valueOf(INITIAL_UNREST));
    }

    public void calculateInitialConsumption (TextView textView, String consumptionText) {
        consumption.setText(consumptionText + " : " + textView.getText().toString());
    }

    public void calculateInitialSpecialResources () {

        specialResourcesNumber.setText(String.valueOf(INITIAL_SPECIAL_RESOURCES));
    }

    public void leadershipReign(View view) {
        Intent intent = new Intent(this, LeadershipReign.class);
        startActivity(intent);
    }
}
