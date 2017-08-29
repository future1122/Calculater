package damon.com.caculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private MyClickListener myListener;
    private TextView show;
    private Button btn_0,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,
            btn_8,btn_9,btn_minus,btn_plus,btn_division,btn_multiply
            ,btn_point,btn_equal,btn_CE,btn_C,btn_BACK;
    private StringBuilder stringBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stringBuilder = new StringBuilder("");
        findComp();
        myListener = new MyClickListener(show);
        setListener();
    }

    private void setListener() {
        btn_0.setOnClickListener(myListener);
        btn_1.setOnClickListener(myListener);
        btn_2.setOnClickListener(myListener);
        btn_3.setOnClickListener(myListener);
        btn_4.setOnClickListener(myListener);
        btn_5.setOnClickListener(myListener);
        btn_6.setOnClickListener(myListener);
        btn_7.setOnClickListener(myListener);
        btn_8.setOnClickListener(myListener);
        btn_9.setOnClickListener(myListener);
        btn_point.setOnClickListener(myListener);
        btn_plus.setOnClickListener(myListener);
        btn_minus.setOnClickListener(myListener);
        btn_BACK.setOnClickListener(myListener);
        btn_C.setOnClickListener(myListener);
        btn_CE.setOnClickListener(myListener);
        btn_multiply.setOnClickListener(myListener);
        btn_equal.setOnClickListener(myListener);
    }

    private void findComp() {
        show = (TextView) findViewById(R.id.show);
        btn_0 = (Button)findViewById(R.id.btn_0);
        btn_1 = (Button)findViewById(R.id.btn_1);
        btn_2 = (Button)findViewById(R.id.btn_2);
        btn_3 = (Button)findViewById(R.id.btn_3);
        btn_4 = (Button)findViewById(R.id.btn_4);
        btn_5 = (Button)findViewById(R.id.btn_5);
        btn_6 = (Button)findViewById(R.id.btn_6);
        btn_7 = (Button)findViewById(R.id.btn_7);
        btn_8 = (Button)findViewById(R.id.btn_8);
        btn_9 = (Button)findViewById(R.id.btn_9);
        btn_minus = (Button)findViewById(R.id.btn_minus);
        btn_plus = (Button)findViewById(R.id.btn_plus);
        btn_division = (Button)findViewById(R.id.btn_division);
        btn_multiply = (Button)findViewById(R.id.btn_multiply);
        btn_equal = (Button)findViewById(R.id.btn_equal);
        btn_point = (Button)findViewById(R.id.btn_point);
        btn_C = (Button)findViewById(R.id.btn_C);
        btn_CE = (Button)findViewById(R.id.btn_CE);
        btn_BACK = (Button)findViewById(R.id.btn_BACK);
    }
}
