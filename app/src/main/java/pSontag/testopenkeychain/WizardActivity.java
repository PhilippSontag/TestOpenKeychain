package pSontag.testopenkeychain;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

public class WizardActivity extends FragmentActivity
        implements SelectMethods.OnFragmentInteractionListener, Passphrase.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SelectMethods selectMethods = new SelectMethods();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragmentContainer, selectMethods).addToBackStack(null).commit();
        setContentView(R.layout.activity_wizard);
    }



    public void dosomething(View view){
        Passphrase passphrase = new Passphrase();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, passphrase).addToBackStack(null).commit();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
