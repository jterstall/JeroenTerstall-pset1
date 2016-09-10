// PSET 1
// Mr. Potato Head
// Jeroen Terstall
// 10766030

package terstall.jeroenterstall_pset1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import java.util.Arrays;

public class PotatoHead extends AppCompatActivity
{
    // Key to store visibilities when orientation changes
    private static final String ALL_VISIBILITIES = "all_visibilities";
    // Amount of body parts of Mr. Potato Head
    private static final int BODY_PARTS = 10;
    // Id's of the images used and the corresponding checkboxes
    // can be extended by adding a new id in both arrays
    private static final int [] images = {R.id.ears_image, R.id.nose_image, R.id.mouth_image, R.id.glasses_image,
            R.id.mustache_image, R.id.eyes_image, R.id.arms_image, R.id.shoes_image, R.id.hat_image, R.id.eyebrows_image};
    private static final int [] checkboxes = {R.id.ears_check, R.id.nose_check, R.id.mouth_check, R.id.glasses_check,
            R.id.mustache_check, R.id.eyes_check, R.id.arms_check, R.id.shoes_check, R.id.hat_check, R.id.eyebrows_check};
    // Array initialization to store visibilities of the images in
    private int [] visibilities;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potato_head);
        // Check if there is a saved instance state from before the orientation changed
        if(savedInstanceState != null)
        {
            // If that is the case
            // Retrieve saved state of the image visibilities and set the corresponding visibilities
            visibilities = savedInstanceState.getIntArray(ALL_VISIBILITIES);
            setVisibilities(visibilities);
        }
        else
        {
            // If not
            // Use default values for visibilities
            visibilities = new int[BODY_PARTS];
            Arrays.fill(visibilities, View.INVISIBLE);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        // Saves the array with the visibilities in case of destroying the current activity
        savedInstanceState.putIntArray(ALL_VISIBILITIES, visibilities);
    }

    // Set the visibilities according to the stored visibilities
    private void setVisibilities(int [] visibilities)
    {
        for(int i = 0; i<BODY_PARTS; i++)
        {
            ImageView imageview = (ImageView) findViewById(images[i]);
            imageview.setVisibility(visibilities[i]);
        }
    }

    // Activity if a checkbox is clicked
    public void changeVisibility(View view)
    {
        // Find out if the checkbox is unchecked or checked
        boolean checked = ((CheckBox) view).isChecked();
        // Initialize variables
        int checkbox_id;
        int view_id = view.getId();
        // Loop over all body parts, check which is clicked and set visibility accordingly
        for (int i = 0; i<BODY_PARTS; i++)
        {
            checkbox_id = checkboxes[i];
            if(checkbox_id == view_id)
            {
                ImageView imageview = (ImageView) findViewById(images[i]);
                if(checked)
                {
                    imageview.setVisibility(View.VISIBLE);
                    visibilities[i] = View.VISIBLE;
                }
                else
                {
                    imageview.setVisibility(View.INVISIBLE);
                    visibilities[i] = View.INVISIBLE;
                }
                break;
            }

        }
    }
}