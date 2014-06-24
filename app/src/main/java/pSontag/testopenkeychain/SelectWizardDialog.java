package pSontag.testopenkeychain;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by pSontag on 24/06/14.
 */
public class SelectWizardDialog extends DialogFragment{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.title_unlock_method)
                .setItems(R.array.unlock_methods, new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){

                    }
                });

        return builder.create();
    }
}
