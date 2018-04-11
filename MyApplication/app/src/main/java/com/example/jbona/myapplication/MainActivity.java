package com.example.jbona.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;


/**
 * This app displays a quiz which one you click the submit button grades your performance.
 * Author Juan Bona
 */
public class MainActivity extends AppCompatActivity {

    int numCorrect = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when the submit button is clicked.
     */
    public void submit(View view) {
        numCorrect = 0;
        //Check if question 1 is correct and increment numCorrect variable
        //For it to be correct 3 checkboxes have to be enabled
        numCorrect += checkQuestion1(view);

        //Check if question 2 is correct and increment numCorrect variable
        //For this question to be correct radio button one needs to be enabled
        numCorrect += checkQuestion2(view);

        //Check if question 3 is correct and increment numCorrect variable
        //For this question to be correct user input must match exactly ScrollView not ignoring case
        numCorrect += checkQuestion3(view);

        //Check if question 4 is correct and increment numCorrect variable
        //For this to be correct only two check boxes enabled 1 & 3
        numCorrect += checkQuestion4(view);

        //Check if question 5 is correct and increment numCorrect variable
        //For this question to be correct radio button 1 must be enabled
        numCorrect += checkQuestion5(view);


        // Display the order summary on the screen
        displayResults();
    }


    /**
     * This method is called when the clear button is clicked and is used to clear the forms.
     */
    public void clearForm(View view) {
        //Clear Form Code
        numCorrect = 0;
    }

    /**
     * This method is called to evaluate if the question is answered correctly. If correct then return 1 if incorrect return 0.
     *
     * @return int
     */
    public int checkQuestion1(View view) {
        CheckBox checkBoxOne = (CheckBox) findViewById(R.id.answerOneOne);
        CheckBox checkBoxTwo = (CheckBox) findViewById(R.id.answerOneTwo);
        CheckBox checkBoxThree = (CheckBox) findViewById(R.id.answerOneThree);
        CheckBox checkBoxFour = (CheckBox) findViewById(R.id.answerOneFour);

        boolean correctAnswerOne = checkBoxOne.isChecked();
        boolean incorrectAnswerTwo = checkBoxTwo.isChecked();
        boolean correctAnswerThree = checkBoxThree.isChecked();
        boolean correctAnswerFour = checkBoxFour.isChecked();

        if (incorrectAnswerTwo) {
            return 0;
        }
        if (correctAnswerOne) {
            if (correctAnswerThree) {
                if (correctAnswerFour) {
                    return 1;
                }
            }
        }
        return 0;
    }

    /**
     * This method is called to evaluate if the question is answered correctly. If correct then return 1 if incorrect return 0.
     *
     * @return int
     */
    public int checkQuestion2(View view) {
        RadioButton answerQuestionTwo = (RadioButton) findViewById(R.id.answerTwoOne);
        boolean correctAnswer = answerQuestionTwo.isChecked();
        if (correctAnswer) {
            return 1;
        }
        return 0;
    }

    /**
     * This method is called to evaluate if the question is answered correctly. If correct then return 1 if incorrect return 0.
     * It does this using String comparison
     *
     * @return int
     */
    public int checkQuestion3(View view) {
        EditText answerField = (EditText) findViewById(R.id.answerThreeOne);
        Editable nameEditable = answerField.getText();
        String answer = nameEditable.toString();

        if (answer.equalsIgnoreCase("ScrollView")) {
            return 1;
        }
        return 0;

    }

    /**
     * This method is called to evaluate if the question is answered correctly. If correct then return 1 if incorrect return 0.
     *
     * @return int
     */
    public int checkQuestion4(View view) {
        CheckBox checkBoxOne = (CheckBox) findViewById(R.id.answerFourOne);
        CheckBox checkBoxTwo = (CheckBox) findViewById(R.id.answerFourTwo);
        CheckBox checkBoxThree = (CheckBox) findViewById(R.id.answerFourThree);
        CheckBox checkBoxFour = (CheckBox) findViewById(R.id.answerFourFour);

        boolean correctAnswerOne = checkBoxOne.isChecked();
        boolean incorrectAnswerTwo = checkBoxTwo.isChecked();
        boolean correctAnswerThree = checkBoxThree.isChecked();
        boolean incorrectAnswerFour = checkBoxFour.isChecked();

        if (incorrectAnswerTwo) {
            return 0;
        }
        if (incorrectAnswerFour) {
            return 0;
        }
        if (correctAnswerOne) {
            if (correctAnswerThree) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * This method is called to evaluate if the question is answered correctly. If correct then return 1 if incorrect return 0.
     *
     * @return int
     */
    public int checkQuestion5(View view) {
        RadioButton answerQuestionFive = (RadioButton) findViewById(R.id.answerFiveOne);
        boolean correctAnswer = answerQuestionFive.isChecked();
        if (correctAnswer) {
            return 1;
        }
        return 0;
    }

    /**
     * This method displays the results of the quiz app in a toast action
     */
    private void displayResults() {
        //TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        //quantityTextView.setText("" + numberOfCoffees);
        //Log.i("Number right",numCorrect+"");
        Context context = getApplicationContext();
        CharSequence text = "You got " + numCorrect + "correct.";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}