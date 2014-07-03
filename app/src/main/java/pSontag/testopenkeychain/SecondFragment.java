package pSontag.testopenkeychain;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

import com.haibison.android.lockpattern.*;

/**
 * Created by Max on 27.06.2014.
 */
public class SecondFragment extends DialogFragment {
    Button cmdOk;
    EditText pw1,
             pw2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LockPatternFragment lpf = new LockPatternFragment();
        View view = inflater.inflate(R.layout.fragment_second_fragment, null);
        cmdOk = (Button) view.findViewById(R.id.cmdOk);
        pw1 = (EditText)view.findViewById(R.id.pw1);
        pw2 = (EditText)view.findViewById(R.id.pw2);
        cmdOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPassword(v);
            }
        });
        return view;
    }

    public void setPassword(View view) {
        String value1 = pw1.getText().toString().trim();
        String value2 = pw2.getText().toString().trim();
        if (value1.isEmpty() || value2.isEmpty()) {
            Toast.makeText(getActivity().getApplicationContext(), "Both PasswordFields are required!", Toast.LENGTH_SHORT).show();
        } else if (!value1.equals(value2)) {
            Toast.makeText(getActivity().getApplicationContext(), "Passwords do not match!", Toast.LENGTH_SHORT).show();
        } else {
            System.out.println(stringToSha256(value1));
        }
    }

    public static String stringToSha256(String pw) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(pw.getBytes());

            byte[] digest = md.digest();
            BigInteger bi = new BigInteger(1, digest);
            return String.format((Locale) null,
                    "%0" + (digest.length * 2) + "x", bi).toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            // never catch this
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return"";
        } /*catch (UnsupportedEncodingException e) {
            // never catch this
            return "";
        }*/
    }

}
