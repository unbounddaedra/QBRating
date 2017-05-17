package william.neit.qbrating;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtTD;
    private EditText txtInter;
    private EditText txtYards;
    private EditText txtCom;
    private EditText txtAtem;
    private TextView lblResult;
    private Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        txtTD = (EditText) findViewById(R.id.txtTD);
        txtInter = (EditText) findViewById(R.id.txtInter);
        txtYards = (EditText) findViewById(R.id.txtYards);
        txtCom = (EditText) findViewById(R.id.txtCom);
        txtAtem = (EditText) findViewById(R.id.txtAtem);
        lblResult = (TextView) findViewById(R.id.lblResult);

        Button btnCalc = (Button) findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String touchdown =  txtTD.getText().toString();
                String interceptions =  txtInter.getText().toString();
                String yards =  txtYards.getText().toString();
                String coms =  txtCom.getText().toString();
                String atems =  txtAtem.getText().toString();

                double resultA = ((Double.parseDouble(coms)/Double.parseDouble(atems) * 100) - 30) / 20;

                double resultB = ((Double.parseDouble(touchdown)/Double.parseDouble(atems))*100)/5;

                double resultC = (9.5 -(Double.parseDouble(interceptions)/Double.parseDouble(atems)*100))/4;

                double resultD = ((Double.parseDouble(yards)/Double.parseDouble(atems)-3)/4);

                //lblResult = Double.toString((resultA + resultB + resultC + resultD)/0.06);

                double finalAnswer;

                lblResult.setText(Double.toString((resultA + resultB + resultC + resultD)/0.06));



            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
