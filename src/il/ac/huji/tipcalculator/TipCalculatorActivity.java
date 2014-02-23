package il.ac.huji.tipcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.app.Activity;

public class TipCalculatorActivity extends Activity {
	private static final int PERCENTAGE = 12;
	
	private String getResourceString(int id) {
		return this.getResources().getString(id);
	}
	
	private void setTipResultsAmount(double amount) {
        TextView txtResults = (TextView)(this.findViewById(R.id.txtTipResult));
        txtResults.setText(String.format(getResourceString(
        		R.string.txtTipResult), 
				getResourceString(R.string.txtCurrencySymbol), amount));
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        
        // Reset the Tip Results' text
        setTipResultsAmount(0);
    }
    
    /** Called when the user touches the button */
    public void calculateTip(View view) {
    	double bill, tip;
    	EditText billAmount = (EditText)findViewById(R.id.edtBillAmount);
    	
    	// Check input
    	if(billAmount.getText().toString().isEmpty()) {
    		billAmount.setError("Bill amount is required!");
    		return;
    	}
    	
    	bill = Double.parseDouble(billAmount.getText().toString());
    	tip = bill * PERCENTAGE / 100.0;
    	if (((CheckBox)findViewById(R.id.chkRound)).isChecked()) {
    		tip = Math.round(tip);
    	}
    	setTipResultsAmount(tip);
    }

}
