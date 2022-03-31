package com.github.chrisblutz.ece387;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Keep track of counter value (used within click listener)
    private int counter = 0;

    // Keep track of text view instance (used within click listener)
    private TextView counterText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create a relative layout to serve as the outer layout (for centering)
        RelativeLayout relativeLayout = new RelativeLayout(getApplicationContext());

        // Create a new grid layout with 1 column and 2 rows (text box and button)
        GridLayout gridLayout = new GridLayout(getApplicationContext());
        gridLayout.setColumnCount(1);
        gridLayout.setRowCount(3);

        // Create layout parameters that center the grid layout within the outer relative layout
        RelativeLayout.LayoutParams gridLayoutParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        gridLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        gridLayout.setLayoutParams(gridLayoutParams);

        // Create a label text view
        TextView labelText = new TextView(getApplicationContext());
        labelText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        labelText.setTextSize(20f);
        labelText.setText(R.string.label_text);

        // Create the text view for the counter
        counterText = new TextView(getApplicationContext());
        counterText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        counterText.setText(Integer.toString(counter));
        counterText.setTextSize(40f);

        // Create layout parameters to make the text boxes fill the parent (for text centering)
        RelativeLayout.LayoutParams textParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        // Add a bottom margin to give space between the text box and the element below
        textParams.setMargins(0, 0, 0, 100);

        // Add the layout to both text views
        labelText.setLayoutParams(textParams);
        counterText.setLayoutParams(textParams);

        // Create a button that says "Press Me!" (pulled from strings)
        Button button = new Button(getApplicationContext());
        button.setText(R.string.button_text);
        button.setTextSize(20f);
        // Add padding to make the button slightly larger (without growing text size)
        button.setPadding(200, 60, 200, 60);
        // Stop the button text being all caps
        button.setTransformationMethod(null);
        // When the button is pressed, update the counter
        button.setOnClickListener(view -> {
            // Update counter
            counter++;
            // Show counter on text box
            counterText.setText(Integer.toString(counter));
        });

        // Add text views and button to the grid layout
        gridLayout.addView(labelText);
        gridLayout.addView(counterText);
        gridLayout.addView(button);

        // Add the grid layout to the outer relative layout
        relativeLayout.addView(gridLayout);

        // Show the new layout on the screen
        setContentView(relativeLayout);
    }
}
