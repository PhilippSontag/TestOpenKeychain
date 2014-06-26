package pSontag.testopenkeychain;


import android.net.Uri;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

public class MainActivity extends FragmentActivity implements PassphraseDialogFragment.OnFragmentInteractionListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void selectMethod(View view){
        DialogFragment selectWizard = new SelectWizardDialog();
        selectWizard.show(getSupportFragmentManager(), "selectWizard");
/*
        PassphraseDialogFragment blub = new PassphraseDialogFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout, blub);
        transaction.addToBackStack(null);
        transaction.commit();*/
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
