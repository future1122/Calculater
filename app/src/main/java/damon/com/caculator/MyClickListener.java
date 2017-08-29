package damon.com.caculator;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayDeque;

/**
 * Created by King on 2017/8/29.
 */

public class MyClickListener implements View.OnClickListener {
    private ArrayDeque<Double> nums;
    private ArrayDeque<Character> characters;
    public static boolean error = false;
    private  boolean hasPoint = false;
    public TextView show;
    public StringBuilder showStringBuilder;
    public StringBuilder numStringBuilder;
    public MyClickListener(TextView show){
        nums = new ArrayDeque<>();
        characters = new ArrayDeque<>();
        numStringBuilder = new StringBuilder("");
        showStringBuilder = new StringBuilder("");
        this.show = show;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
                numStringBuilder.append(((Button) v).getText().toString());
                showStringBuilder.append(((Button) v).getText().toString());
                Double.parseDouble(numStringBuilder.toString());
                show.setText(showStringBuilder.toString());
                break;
            case R.id.btn_point:
                if(!hasPoint){
                    numStringBuilder.append(((Button) v).getText().toString());
                    showStringBuilder.append(((Button) v).getText().toString());
                    show.setText(showStringBuilder.toString());
                    hasPoint = true;
                }
                break;
            case R.id.btn_plus:
            case R.id.btn_minus:
            case R.id.btn_multiply:
                try{
                    nums.addLast(Double.parseDouble(numStringBuilder.toString()));
                }catch (NumberFormatException e){
                    error = true;
                }
                characters.addLast(((Button) v).getText().toString().charAt(0));
                numStringBuilder.delete(0,numStringBuilder.length());
                showStringBuilder.append(((Button) v).getText().toString());
                show.setText(showStringBuilder.toString());
                hasPoint = false;
                break;
            case R.id.btn_division:
                try{
                    nums.addLast(Double.parseDouble(numStringBuilder.toString()));
                }catch (NumberFormatException e){
                    error = true;
                }
                characters.addLast(((Button) v).getText().toString().charAt(0));
                numStringBuilder.delete(0,numStringBuilder.length());
                showStringBuilder.append(((Button) v).getText().toString()+"/");
                show.setText(showStringBuilder.toString());
                hasPoint = false;
                break;
            case R.id.btn_equal:
                nums.addLast(Double.parseDouble(numStringBuilder.toString()));
                if(nums.size()>1){
                    if(nums.size()!=characters.size()+1) error = true;
                    Double result = Utils.calulate(nums,characters);
                    if(!error) show.setText(result+"");
                }
                showStringBuilder.delete(0,showStringBuilder.length());
                numStringBuilder.delete(0,numStringBuilder.length());
                nums.clear();
                characters.clear();
                hasPoint = false;
                break;
            case R.id.btn_CE:
                showStringBuilder.delete(0,showStringBuilder.length());
                numStringBuilder.delete(0,numStringBuilder.length());
                nums.clear();
                characters.clear();
                hasPoint = false;
                error = false;
                show.setText("0");
        }
        if(error){
            showStringBuilder.delete(0,showStringBuilder.length());
            numStringBuilder.delete(0,numStringBuilder.length());
            nums.clear();
            characters.clear();
            hasPoint = false;
            error = false;
            show.setText("Error");
        }
    }
}
