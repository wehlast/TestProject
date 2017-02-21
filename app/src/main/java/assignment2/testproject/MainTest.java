package assignment2.testproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.*;
import java.util.Random;

import static assignment2.testproject.R.id.submit;
import static assignment2.testproject.R.id.textView6;
import static assignment2.testproject.R.id.textView5;
import static assignment2.testproject.R.id.visible;

public class MainTest extends AppCompatActivity {
    int random;
    EditText answer;
    List<Integer> intlist = new ArrayList<Integer>();
    List<Integer> intlistans = new ArrayList<Integer>();
    List<Integer> totalint = new ArrayList<Integer>();
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Random r = new Random();
        for(int i = 0; i < 7; i++){
            random = r.nextInt(9); // [0, 9] + 0 => [0, 9]
            intlist.add(random);
        }

        TextView next = new TextView(this);
        next = (TextView)findViewById(textView5);
        next.setText(String.valueOf(intlist));
        final TextView finalNext = next;
        next.postDelayed(new Runnable() {
            @Override
            public void run() {
                finalNext.setVisibility(View.INVISIBLE);
            }
        }, 5000);

        //EditText answer = new EditText(this);
        answer = (EditText)findViewById(R.id.ans);
       /*
        */
        final TextView[] next2 = {new TextView(this)};
        submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        String ans1 = answer.getText().toString();
                        Scanner scanner = new Scanner(ans1);
                        while (scanner.hasNextInt()) {
                            intlistans.add(scanner.nextInt());
                        }
                        int total = 0;
                        for (Integer i : intlist) { // assuming list is of type List<Integer>
                            total = 10*total + i;
                        }
                        totalint.add(total);

                        if (totalint.equals(intlistans)){

                            next2[0] = (TextView)findViewById(textView6);
                            next2[0].setText("Correct");
                            }else{
                            next2[0] = (TextView)findViewById(textView6);
                            next2[0].setText("The correct answer was: " + (String.valueOf(intlist)) + " you answered: "+ (String.valueOf(intlistans)));

                        }
                    }
                });


    }

}
