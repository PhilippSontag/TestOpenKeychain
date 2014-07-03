package pSontag.testopenkeychain;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;


public class SelectDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.fragment_select_dialog, null));

        builder.setTitle(R.string.title_unlock_method)
                .setItems(R.array.unlock_methods, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
//                                Intent intentCreatePattern = new Intent(LockPatternActivity.ACTION_CREATE_PATTERN, null, this, LockPatternActivity.class);
//                                startActivityForResult(intentCreatePattern, REQ_CREATE_PATTERN);
//                                Settings.Security.setAutoSavePattern(this, true);
//                                PassphraseFragment pf = new PassphraseFragment();
//                                pf.show(getFragmentManager(), null);
                                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                                transaction.replace(R.id.framelayout, new SecondFragment());
                                transaction.addToBackStack(null);
                                transaction.commit();
                                break;
                            case 1:
                                SecondFragment sf = new SecondFragment();
                                sf.show(getFragmentManager(), null);
                                break;
                        }
                    }
                });
        return builder.create();
    }



//    @Override
//    public void onFragmentInteraction(Uri uri) {
//
//    }

}