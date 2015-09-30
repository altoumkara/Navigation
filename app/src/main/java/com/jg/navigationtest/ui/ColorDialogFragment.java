package com.jg.navigationtest.ui;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import com.jg.navigationtest.R;
import com.jg.navigationtest.utility.Constants;
import com.jg.navigationtest.utility.Util;
import com.larswerkman.holocolorpicker.ColorPicker;

public class ColorDialogFragment extends DialogFragment {
    public static final String TAG = "ColorDialogFragment";

    /**
     * color picker object
     */
    private ColorPicker mColorPicker;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getting reference to color picker object
        mColorPicker = new ColorPicker(getActivity());

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    /**
     * This method will get called after the onCreate and onCreateView() of the fragment.
     * It will allow user to pick the videos he wants to merger together
     * Instead of (or in addition to) implementing onCreateView(LayoutInflater, ViewGroup, Bundle)
     * to generate the view hierarchy inside of a dialog, you may implement onCreateDialog(Bundle)
     * to create your own custom Dialog object.
     * We are using this method to
     *
     * @param savedInstanceState
     * @return
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //create the dialogBox
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //setting the title of the dialogBox
        builder.setTitle("COLOR PICKER");
        //setting the view of our dialog box to our color picker
        builder.setView(mColorPicker);


        //cancel button on the dialog box
        builder.setNegativeButton(R.string.cancelDialogText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        //ok button on the dialog box
        builder.setPositiveButton(R.string.okDialogText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //save the color to our sharepreference
                Util.saveToSharePreference(getActivity().getApplicationContext(), Constants.CURRENT_COLOR, mColorPicker.getColor());
            }
        });


        //NOW BUILD THE ACTUAL DIALOG BOX
        Dialog dialog = builder.create();

        return dialog;

    }

}
