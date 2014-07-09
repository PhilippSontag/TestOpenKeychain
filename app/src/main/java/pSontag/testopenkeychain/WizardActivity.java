package pSontag.testopenkeychain;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Toast;

import com.haibison.android.lockpattern.LockPatternFragment;

public class WizardActivity extends FragmentActivity
        implements pSontag.testopenkeychain.SelectMethods.OnFragmentInteractionListener, pSontag.testopenkeychain.Passphrase.OnFragmentInteractionListener, pSontag.testopenkeychain.NFC.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pSontag.testopenkeychain.SelectMethods selectMethods = new pSontag.testopenkeychain.SelectMethods();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragmentContainer, selectMethods).addToBackStack(null).commit();
        setContentView(R.layout.activity_wizard);
    }



    public void dosomething(View view){
        pSontag.testopenkeychain.Passphrase passphrase = new pSontag.testopenkeychain.Passphrase();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, passphrase).addToBackStack(null).commit();

    }

    public void writeNFC(View view){

        pSontag.testopenkeychain.NFC nfc = new pSontag.testopenkeychain.NFC();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, nfc).addToBackStack(null).commit();
        //Zeig,dass du hier bist
        Context context = getApplicationContext();
        Toast.makeText(context, "Got here", Toast.LENGTH_SHORT).show();
    }

    public void setLockpattern(View view) {
        LockPatternFragment lpf = new LockPatternFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, lpf).addToBackStack(null).commit();
        Context context = getApplicationContext();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    public void cancel(View view) {
        this.finish();
    }
}
