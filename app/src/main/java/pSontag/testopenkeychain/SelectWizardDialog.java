package pSontag.testopenkeychain;

import android.app.AlertDialog;
import android.app.Dialog;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by pSontag on 24/06/14.
 */
public class SelectWizardDialog extends DialogFragment implements PassphraseDialogFragment.OnFragmentInteractionListener{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

      /*  */

        builder.setView(inflater.inflate(R.layout.dialog_layout, null));
        /*builder.setTitle(R.string.title_unlock_method)
                .setItems(R.array.unlock_methods, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        if (which == 0) {
                            PassphraseDialogFragment blub = new PassphraseDialogFragment();
                            FragmentTransaction transaction = getFragmentManager().beginTransaction();
                            transaction.replace(R.id.framelayout, blub);
                            transaction.addToBackStack(null);
                            transaction.commit();
                        }
                    }
                });*/
        Dialog blub = builder.create();
        WizardFragment wizardFragment = new WizardFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, wizardFragment).addToBackStack(null).commit();
        return blub;
    }



    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
